package com.izuanqian.apidoc;

import com.izuanqian.apidoc.version.V440;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by sanlion on 17-3-3.
 */
@Configuration
@EnableSwagger2
public class ApiDocCfg {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ilive.name")
                .select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build()
                .apiInfo(new ApiInfo(
                        "title",
                        "description",
                        "0.0.1",
                        "http://www.myquanqwei.com/",
                        new Contact("", "", ""),
                        "",
                        ""))
                ;
    }

    @Bean
    public Docket v4_4_0() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("440")
                .select().apis(RequestHandlerSelectors.withMethodAnnotation(V440.class)).build()
                .apiInfo(new ApiInfo(
                        "440 ilive",
                        "yixie xiao gai dong, fuck",
                        "0.0.1",
                        "http://www.myquanqwei.com/",
                        new Contact("sanlion.do", "https://github.com/sanlion/", "sanlion@vip.qq.com"),
                        "apache 2.0",
                        ""))
                ;
    }
}
