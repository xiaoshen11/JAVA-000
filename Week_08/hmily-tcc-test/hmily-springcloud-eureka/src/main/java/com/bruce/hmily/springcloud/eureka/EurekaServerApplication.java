package com.bruce.hmily.springcloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * The type Eureka server application.
 *
 * @author bruce
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication.class).run(args);
    }

}
