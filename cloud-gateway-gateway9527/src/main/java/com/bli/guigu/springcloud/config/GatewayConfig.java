package com.bli.guigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud2020
 * @description:文档路径：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.1.RELEASE/reference/html/
 * @author: mk_passby
 * @create: 2020-08-03 23:01
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //http://news.baidu.com/guoji
        return builder.routes()
            .route("path_route_bliguigu",
                r -> r.path("/guonei")
                    .filters(f -> f.addRequestHeader("X-Request-red", "blue"))
                    .uri("http://news.baidu.com/guonei")).build();
    }
}
