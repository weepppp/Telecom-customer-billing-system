package com.tang.telecom.service;

import com.tang.telecom.constant.BillConstant;
import com.tang.telecom.entity.*;
import com.tang.telecom.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weepppp 2022/7/7 18:30
 **/
@Service
public class BillService {

    @Autowired
    BillMapper billMapper;

    @Autowired
    PhoneMapper phoneMapper;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    FixedphoneMapper fixedphoneMapper;

    @Autowired
    CustomerMapper customerMapper;

    public List<Bill> getAllBill() {
        return billMapper.getAllBill();
    }


    public List<Bill> getAllByCallNumber(String callNamber, String calledNamber) {
        return billMapper.getAllByCallNumber(callNamber, calledNamber);
    }


    public boolean insertBill(Bill bill) {
        // 生成账单分为以下几步
        // 1 判断号码是否存在：只有主被双方在用户电话表中都注册过，且拨号方为电信，才能被记录
        Phone callPhone = phoneMapper.getPhoneByCall(bill.getCallNamber());
        Fixedphone byFixedPhoneNumber = fixedphoneMapper.getByFixedPhoneNumber(bill.getCallNamber());
        Phone calledByPhone = phoneMapper.getPhoneByCall(bill.getCalledNamber());
        if (callPhone == null || calledByPhone == null || (!BillConstant.Fee.CALL_TELECOM.getCallType().equals(byFixedPhoneNumber.getSupplier()))) {
            return false;
        }
        // 2 自动生成主id
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String format = simpleDateFormat.format(new Date());
        String bid = "P" + format;
        bill.setBid(bid);
        // 3 根据号码类型、客户类型及通话时长生成话费和账单
        // 主叫方只会为电信用户，被叫方可以为电信 移动 联通 铁通用户
        // 把本业务场景暂且设定为用户电话表可以登记不同供应商用户号码，费用表费用字段只统计主叫方也就是相关电信用户的消费
        // 由于主叫方为电信用户时，费用是固定的，因此不用做号码类型的判别，只需判断客户类型即可
        Account accountCallPhone = accountMapper.getAccountById(callPhone.getAid());
        Customer customerCallPhone = customerMapper.getCustomerById(accountCallPhone.getUid());
        if (customerCallPhone.getUtype().equals(BillConstant.Discount.COUSTOMER_ONE.getCusType())) {
            double fee = Integer.parseInt(bill.getCallTime()) * BillConstant.Fee.CALL_TELECOM.getMoney()
                    * BillConstant.Discount.COUSTOMER_ONE.getCusRate();
            bill.setCallFee(fee);
        } else if (customerCallPhone.getUtype().equals(BillConstant.Discount.COUSTOMER_FOUR.getCusType())) {
            double fee = Integer.parseInt(bill.getCallTime()) * BillConstant.Fee.CALL_TELECOM.getMoney()
                    * BillConstant.Discount.COUSTOMER_FOUR.getCusRate();
            bill.setCallFee(fee);
        } else if (customerCallPhone.getUtype().equals(BillConstant.Discount.COUSTOMER_THREE.getCusType())) {
            double fee = Integer.parseInt(bill.getCallTime()) * BillConstant.Fee.CALL_TELECOM.getMoney()
                    * BillConstant.Discount.COUSTOMER_THREE.getCusRate();
            bill.setCallFee(fee);
        } else {
            double fee = Integer.parseInt(bill.getCallTime()) * BillConstant.Fee.CALL_TELECOM.getMoney()
                    * BillConstant.Discount.COUSTOMER_TWO.getCusRate();
            bill.setCallFee(fee);
        }
        // 4 生成账单后，对账户表进行相应的余额扣除
        Long cost1 = accountCallPhone.getCurMonthAmount() + Math.round(bill.getCallFee());
        accountCallPhone.setCurMonthAmount(cost1);
        Long cost2 = accountCallPhone.getCostAmount() + Math.round(bill.getCallFee());
        accountCallPhone.setCostAmount(cost2);
        accountMapper.updateAccount(accountCallPhone);
        // 5 调用接口
        if (billMapper.insertBill(bill) == 1) {
            return true;
        }
        return false;
    }
}
