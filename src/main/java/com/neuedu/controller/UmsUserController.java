package com.neuedu.controller;


import com.neuedu.pojo.UmsUser;
import com.neuedu.service.IUmsUserService;
import com.neuedu.util.CommonResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyu
 * @since 2020-08-19
 */
@RestController
@RequestMapping("/ums-user")
public class UmsUserController {
    @Resource
    BCryptPasswordEncoder encoder;
    @Resource
    IUmsUserService umsUserService;
    @GetMapping("/list")
    CommonResult list(UmsUser umsUser) {
        return CommonResult.success(umsUserService.list(umsUser));
    }
    @PostMapping("/add")
    CommonResult add(UmsUser umsUser) {
        umsUser.setPassword(encoder.encode(umsUser.getPassword()));
        umsUser.setActive(1);
        if(umsUserService.add(umsUser))
            return CommonResult.success("ok");
        else
            return CommonResult.failed("用户名已经存在");
    }
    @GetMapping("/getById")
    CommonResult getById(Integer id) {
        return CommonResult.success(umsUserService.getById(id));
    }
    @PostMapping("/update")
    CommonResult update(UmsUser umsUser) {
        umsUser.setPassword(encoder.encode(umsUser.getPassword()));
        return CommonResult.success(umsUserService.updateById(umsUser));
    }
    @PostMapping("/del")
    CommonResult del(UmsUser umsUser) {
        umsUser.setActive(0);
        return CommonResult.success(umsUserService.updateById(umsUser));
    }
    @PostMapping("/batchdel")
    CommonResult batchdel(Integer[] ids) {
        return CommonResult.success(umsUserService.batchdel(ids));
    }
    @PostMapping("/back")
    CommonResult back(UmsUser umsUser) {
        umsUser.setActive(1);
        return CommonResult.success(umsUserService.updateById(umsUser));
    }
}
