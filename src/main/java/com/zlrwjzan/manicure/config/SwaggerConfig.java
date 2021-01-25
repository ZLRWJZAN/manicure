package com.zlrwjzan.manicure.config;

import com.zlrwjzan.manicure.common.config.BaseSwaggerConfig;
import com.zlrwjzan.manicure.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.zlrwjzan.manicure.modules")
                .title("manicure项目骨架")
                .description("manicure项目骨架相关接口文档")
                .contactName("zlrwjzan")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
