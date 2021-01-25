package com.zlrwjzan.manicure.modules.us.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlrwjzan.manicure.domain.AdminUserDetails;
import com.zlrwjzan.manicure.modules.us.dto.ManicureStaffParam;
import com.zlrwjzan.manicure.modules.us.mapper.ManicureResourceMapper;
import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.zlrwjzan.manicure.modules.us.model.ManicureStaff;
import com.zlrwjzan.manicure.modules.us.mapper.ManicureStaffMapper;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffCacheService;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@Service
public class ManicureStaffServiceImpl extends ServiceImpl<ManicureStaffMapper, ManicureStaff> implements ManicureStaffService {

    @Autowired
    private ManicureStaffCacheService manicureStaffCacheService;

    @Autowired
    private ManicureResourceMapper manicureResourceMapper;

    @Override
    public UserDetails loadUserByUsername(String phone) {
        //获取用户信息
        ManicureStaff admin = getAdminByUsername(phone);
        if (admin != null) {
            List<ManicureResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public ManicureStaff getAdminByUsername(String phone) {
        ManicureStaff admin = manicureStaffCacheService.getAdmin(phone);
        if(admin!=null) return  admin;
        QueryWrapper<ManicureStaff> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ManicureStaff::getPhone,phone);
        List<ManicureStaff> adminList = list(wrapper);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            manicureStaffCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }


    @Override
    public List<ManicureResource> getResourceList(String staffId) {
        List<ManicureResource> resourceList = manicureStaffCacheService.getResourceList(staffId);
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        resourceList = manicureResourceMapper.getResourceList(staffId);
        if(CollUtil.isNotEmpty(resourceList)){
            manicureStaffCacheService.setResourceList(staffId,resourceList);
        }
        return resourceList;
    }

    @Override
    public ManicureStaff register(ManicureStaffParam manicureStaffParam) {
        ManicureStaff manicureStaff = new ManicureStaff();
        BeanUtils.copyProperties(manicureStaffParam,manicureStaff);
        QueryWrapper<ManicureStaff> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ManicureStaff::getPhone,manicureStaff.getPhone());
        List<ManicureStaff> list = list(wrapper);
        if(list.size()>0){
            return null;
        }
        baseMapper.insert(manicureStaff);
        return manicureStaff;
    }
}
