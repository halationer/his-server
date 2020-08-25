package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.mapper.UmsUserMapper;
import com.neuedu.pojo.UmsUser;
import com.neuedu.service.IUmsUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2020-08-19
 */
@Service
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements IUmsUserService {

    @Override
    public Object list(UmsUser umsUser) {
        // 如果 有name传过来 就按照name 模糊查询
        QueryWrapper<UmsUser> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(umsUser.getUsername())) {
            wrapper.like("username",umsUser.getUsername());
        }
        // 如果分页返回 IPage 如果不分页 返回 List
        if(umsUser.getWithPage() == 1) {
            return this.page(new Page<>(umsUser.getPageNo(),umsUser.getPageSize()),wrapper);
        } else {
            return this.list(wrapper);
        }

    }

    @Override
    public boolean add(UmsUser umsUser) {
        QueryWrapper<UmsUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",umsUser.getUsername());
        UmsUser query = this.getOne(wrapper);
        if(query == null )
            return this.save(umsUser);
        return false;
    }

    @Override
    public boolean batchdel(Integer[] ids) {
        List<Integer> list = new ArrayList<>(ids.length);
        Collections.addAll(list,ids);
        UmsUser user = new UmsUser();
        user.setActive(0);
        UpdateWrapper<UmsUser> wrapper = new UpdateWrapper<>();
        wrapper.in("id",list);
        return this.update(user,wrapper);
    }
}
