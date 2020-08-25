package com.neuedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.pojo.UmsUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-08-19
 */
public interface IUmsUserService extends IService<UmsUser> {
    Object list(UmsUser umsUser);
    boolean add(UmsUser umsUser);
    boolean batchdel(Integer[] ids);
}
