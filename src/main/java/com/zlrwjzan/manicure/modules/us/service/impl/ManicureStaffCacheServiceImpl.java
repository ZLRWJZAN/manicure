package com.zlrwjzan.manicure.modules.us.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlrwjzan.manicure.common.service.RedisService;
import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.zlrwjzan.manicure.modules.us.model.ManicureStaff;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffCacheService;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台用户缓存管理Service实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class ManicureStaffCacheServiceImpl implements ManicureStaffCacheService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;


    @Override
    public void delResourceList(String staffId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + staffId;
        redisService.del(key);
    }


    @Override
    public ManicureStaff getAdmin(String phone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + phone;
        return (ManicureStaff) redisService.get(key);
    }

    @Override
    public void setAdmin(ManicureStaff admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getPhone();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<ManicureResource> getResourceList(String staffId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + staffId;
        return (List<ManicureResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(String staffId, List<ManicureResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + staffId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }
}
