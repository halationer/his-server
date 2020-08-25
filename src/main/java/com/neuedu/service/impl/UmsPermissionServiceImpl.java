package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.UmsPermission;
import com.neuedu.mapper.UmsPermissionMapper;
import com.neuedu.pojo.UmsUser;
import com.neuedu.service.IUmsPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2020-08-19
 */
@Service
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission> implements IUmsPermissionService {
    @Override
    public Object list(UmsPermission umsPermission) {
        QueryWrapper<UmsPermission> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",0);
        IPage<UmsPermission> page = this.page(new Page<>(umsPermission.getPageNo(),umsPermission.getPageSize()),wrapper);
        List<UmsPermission> list = page.getRecords();
        for(UmsPermission permission : list) {
            getChildren(permission);
        }
        return page;
    }

    @Override
    public boolean add(UmsPermission umsPermission) {
        QueryWrapper<UmsPermission> wrapper = new QueryWrapper<>();
        wrapper.eq("name",umsPermission.getName());
        UmsPermission query = this.getOne(wrapper);
        if(query == null )
            return this.save(umsPermission);
        return false;
    }
    /**
     * 参数为父权限对象
     * 通过父权限获取子权限
     *
     * */
    private void getChildren(UmsPermission umsPermission) {
        QueryWrapper<UmsPermission> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",umsPermission.getId());
        List<UmsPermission> list = this.list(wrapper);
        for(UmsPermission permission : list) {
            if(permission.getType() != 0) {
                getChildren(permission);
            }
        }
        umsPermission.setChildren(list);
    }


}
