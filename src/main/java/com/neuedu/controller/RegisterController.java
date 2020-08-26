package com.neuedu.controller;


import com.neuedu.pojo.Register;
import com.neuedu.service.IRegisterService;
import com.neuedu.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 诊疗信息 前端控制器
 * </p>
 *
 * @author jshand
 * @since 2020-08-25
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    IRegisterService registerService;


    @PostMapping("/regist")
    CommonResult regist(Register register){
        return CommonResult.success(registerService.add(register));
    }





}
