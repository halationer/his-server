package com.neuedu.service;

import com.neuedu.pojo.Register;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 诊疗信息 服务类
 * </p>
 *
 * @author jshand
 * @since 2020-08-25
 */
public interface IRegisterService extends IService<Register> {

    boolean add(Register register);
}
