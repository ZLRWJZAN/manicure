package com.zlrwjzan.manicure.config;

import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.zlrwjzan.manicure.modules.us.service.ManicureResourceService;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffService;
import com.zlrwjzan.manicure.modules.us.service.ManicureUserService;
import com.zlrwjzan.manicure.security.component.DynamicSecurityService;
import com.zlrwjzan.manicure.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * mall-security模块相关配置
 * Created by macro on 2019/11/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MallSecurityConfig extends SecurityConfig {

    @Autowired
    private ManicureStaffService manicureStaffService;
    @Autowired
    private ManicureResourceService manicureResourceService;
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return phone -> manicureStaffService.loadUserByUsername(phone);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<ManicureResource> resourceList = manicureResourceService.list();
                for (ManicureResource resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
