package com.tang.telecom.controller;
import com.tang.telecom.entity.Account;
import com.tang.telecom.service.AccountService;
import com.tang.telecom.units.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author weepppp 2022/7/6 22:53
 **/
@RestController
@RequestMapping("/account/")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/get")
    public ModelAndView getAccount() {
        ModelAndView modelAndView = new ModelAndView("accountModel");
        modelAndView.addObject("account", accountService.getAccount());
        return modelAndView;
    }

    @PostMapping("/insert")
    public R insertAccount(@RequestBody Account account){
        if (accountService.insertAccount(account)){
            return R.ok("添加成功",account);
        }
        return R.error("添加失败");
    }

    @PutMapping("/update")
    public R updateAccount(@RequestBody Account account){
        if (accountService.updateAccount(account)){
            return R.ok("修改成功",account);
        }
        return R.error("修改失败");
    }

    @DeleteMapping("/delete/{aid}")
    public R deleteCustomer(@PathVariable String aid){
        if (accountService.deleteAccount(aid)){
            return R.ok("删除成功");
        }
        return  R.error("删除失败");
    }
}
