package com.neuedu.service;

import com.neuedu.pojo.UmsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-08-19
 */
public interface IUmsPermissionService extends IService<UmsPermission> {
    Object list(UmsPermission umsPermission);
    boolean add(UmsPermission umsPermission);
}
