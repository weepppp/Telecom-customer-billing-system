package com.tang.telecom.controller;

import com.tang.telecom.entity.Phone;
import com.tang.telecom.service.PhoneService;
import com.tang.telecom.units.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author weepppp 2022/7/7 9:02
 **/
@RestController
@RequestMapping("/phone/")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @GetMapping("/get")
    public ModelAndView getPhone() {
        ModelAndView modelAndView = new ModelAndView("phoneModel");
        modelAndView.addObject("phone",phoneService.getPhone());
        return modelAndView;
    }

    @PostMapping("/insert")
    public R insertPhone(@RequestBody Phone phone){
        if (phoneService.insertPhone(phone)){
            return R.ok("添加成功",phone);
        }
        return R.error("添加失败");
    }

    @PutMapping("/update")
    public R updatePhone(@RequestBody Phone phone){
        if (phoneService.updatePhone(phone)){
            return R.ok("修改成功",phone);
        }
        return R.error("修改失败");
    }

    @DeleteMapping("/delete/{pid}")
    public R deleteCustomer(@PathVariable Long pid){
        if (phoneService.deletePhone(pid)){
            return R.ok("删除成功");
        }
        return  R.error("删除失败");
    }

}
