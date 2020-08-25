package com.neuedu.service.impl;

import com.neuedu.pojo.Register;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.IRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 诊疗信息 服务实现类
 * </p>
 *
 * @author jshand
 * @since 2020-08-25
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements IRegisterService {

}
