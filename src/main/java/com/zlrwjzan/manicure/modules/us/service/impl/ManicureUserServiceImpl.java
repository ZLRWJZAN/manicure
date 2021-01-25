package com.zlrwjzan.manicure.modules.us.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlrwjzan.manicure.domain.AdminUserDetails;
import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.zlrwjzan.manicure.modules.us.model.ManicureStaff;
import com.zlrwjzan.manicure.modules.us.model.ManicureUser;
import com.zlrwjzan.manicure.modules.us.mapper.ManicureUserMapper;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffCacheService;
import com.zlrwjzan.manicure.modules.us.service.ManicureUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@Service
public class ManicureUserServiceImpl extends ServiceImpl<ManicureUserMapper, ManicureUser> implements ManicureUserService {

}
