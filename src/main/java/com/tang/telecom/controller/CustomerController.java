package com.tang.telecom.controller;

import com.tang.telecom.entity.Customer;
import com.tang.telecom.service.CustomerService;
import com.tang.telecom.units.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author weepppp 2022/7/6 19:17
 **/
@Controller
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
}
