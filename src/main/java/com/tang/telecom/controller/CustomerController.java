package com.tang.telecom.controller;

import com.tang.telecom.entity.Customer;
import com.tang.telecom.service.CustomerService;
import com.tang.telecom.units.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author weepppp 2022/7/6 19:17
 **/
@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get")
    public ModelAndView getCustomer() {
        ModelAndView modelAndView = new ModelAndView("customerModel");
        modelAndView.addObject("customer", customerService.getCustomer());
        return modelAndView;
    }

    @PostMapping("/insert")
    public R insertCustomer(@RequestBody Customer customer){
        if (customerService.insertCustomer(customer)){
            return R.ok("添加成功",customer);
        }
        return R.error("添加失败");
    }

    @PutMapping("/update")
    public R updateCustomer(@RequestBody Customer customer){
        if (customerService.updateCustomer(customer)){
            return R.ok("修改成功",customer);
        }
        return R.error("修改失败");
    }

    @DeleteMapping("/delete/{uid}")
    public R deleteCustomer(@PathVariable Integer uid){
        if (customerService.deleteCustomer(uid)){
            return R.ok("删除成功");
        }
        return  R.error("删除失败");
    }



}
