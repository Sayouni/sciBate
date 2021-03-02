package com.sci.da.main.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket createFrontRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.sci.da.front"))
                .paths(PathSelectors.any()).build().groupName("前台");
    }

    @Bean
    public Docket createBackGroundRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.sci.da.background"))
                .paths(PathSelectors.any()).build().groupName("后台");
    }

    /**
     * api文档的详细信息函数,注意这里的注解引用的是哪个     *     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SCI在线期刊投稿系统")
                .version("1.0")
                .description("Restful风格API")
                .build();
    }

}
