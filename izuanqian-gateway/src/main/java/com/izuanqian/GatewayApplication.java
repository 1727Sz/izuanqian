package com.izuanqian;

import com.izuanqian.filter.Filter;
import com.izuanqian.filter.SignFilter;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public Filter filter() {
        return new Filter();
    }

    @Bean
    public SignFilter signFilter() {
        return new SignFilter();
    }

    /**
     * support http(:80) -> https(:8443)
     *
     * @return
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcat
                = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {

                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection securityCollection = new SecurityCollection();
                securityCollection.addPattern("/*");
                securityConstraint.addCollection(securityCollection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(
                new Connector("org.apache.coyote.http11.Http11NioProtocol") {{
                    setScheme("http");
                    setPort(80);
                    setSecure(false);
                    setRedirectPort(443);
                }});
        return tomcat;
    }
}
