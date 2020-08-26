package com.neuedu.service.impl;

import com.neuedu.pojo.Register;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.IRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.util.HisConstants;
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

    /**
     * 挂号
     * @param register
     * @return
     */
    @Override
    public boolean add(Register register) {

        register.setStatus(HisConstants.REGISTER_REGIST); //默认添加的数据为已挂号状态
        return this.save(register);
    }
}
