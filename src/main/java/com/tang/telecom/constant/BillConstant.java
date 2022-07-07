package com.tang.telecom.constant;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author weepppp 2022/7/7 19:48
 **/
public class BillConstant {

   /**
    * @功能 定义枚举类，方便常量数据的修改更新
    */

   // 供应商收费表
    public enum Fee {
        CALLED_TELECOM(0.16,"电信"),
        CALL_TELECOM(0.16,"电信"),
        CALLED_MOBILE(0.04,"移动"),
        CALLED_UNICOM(0.02,"联通"),
        CALLED_TIETONG(0.01,"铁通");
        private Double money;
        private String callType;

       Fee(Double money, String callType) {
           this.money = money;
           this.callType = callType;
       }

       public Double getMoney() {
           return money;
       }

       public void setMoney(Double money) {
           this.money = money;
       }

       public String getCallType() {
           return callType;
       }

       public void setCallType(String callType) {
           this.callType = callType;
       }
   }

    // 客户折扣表
    public enum Discount  {
        COUSTOMER_ONE(1.0,"公客"),
        COUSTOMER_TWO(0.95,"商客"),
        COUSTOMER_THREE(0.9,"大客"),
        COUSTOMER_FOUR(0.98,"专客");

        private Double cusRate;
        private String cusType;

        Discount(Double cusRate, String cusType) {
            this.cusRate = cusRate;
            this.cusType = cusType;
        }

        public Double getCusRate() {
            return cusRate;
        }

        public void setCusRate(Double cusRate) {
            this.cusRate = cusRate;
        }

        public String getCusType() {
            return cusType;
        }

        public void setCusType(String cusType) {
            this.cusType = cusType;
        }
    }


}
