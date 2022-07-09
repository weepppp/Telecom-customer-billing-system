package com.tang.telecom.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.telecom.entity.Bill;
import com.tang.telecom.service.BillService;
import com.tang.telecom.units.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @author weepppp 2022/7/7 18:32
 **/
@RestController
@RequestMapping("/bill/")
public class BillController {


    @Autowired
    BillService billService;

    @GetMapping("/get")
    public ModelAndView getAllBill(String pageNum,Model model) {
        ModelAndView modelAndView = new ModelAndView("billModel");
        Integer pageNum1;
        if (pageNum == null || "".equals(pageNum)) {
            pageNum1 = 1;
        } else {
            pageNum1 = Integer.parseInt(pageNum);
        }
        Integer pageSize = 2;
        PageHelper.startPage(pageNum1,pageSize);
        List<Bill> allBill = billService.getAllBill();
        PageInfo<Bill> pageUtils = new PageInfo<Bill>(allBill);
        model.addAttribute("bill",allBill);
        model.addAttribute("page",pageUtils);
        return modelAndView;
    }

    // 多参数查询
    @GetMapping("/search")
    public ModelAndView getAllByCallNumber(String callNamber, String calledNamber) {
        List<Bill> billList =  billService.getAllByCallNumber(callNamber,calledNamber);
        if (billList.size()>0 && billList!=null){
            ModelAndView mv = new ModelAndView("billModel");
            mv.addObject("bill",billList);
            return mv;
        }
        return null;
    }

    @PostMapping("/insert")
    public R insertBill(@RequestBody Bill bill){
        if (billService.insertBill(bill)){
            return R.ok("添加成功",bill);
        }
        return R.error("添加失败");
    }
}
