package nc.mall.config;

import nc.mall.common.config.BaseSwaggerConfig;
import nc.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("nc.mall.modules")
                .title("nc-mall")
                .description("nc-mall项目骨架相关接口文档")
                .contactName("nc")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
