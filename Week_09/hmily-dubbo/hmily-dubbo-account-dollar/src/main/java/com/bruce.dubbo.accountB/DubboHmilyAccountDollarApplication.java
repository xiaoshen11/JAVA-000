
package org.dromara.hmily.demo.dubbo.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * The DubboHmilyAccountApplication.
 *
 * @author bruce
 */
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
@MapperScan("com.bruce.dubbo.dollar.mapper")
public class DubboHmilyAccountDollarApplication {

    /**
     * main.
     *
     * @param args args.
     */
    public static void main(final String[] args) {
        SpringApplication springApplication = new SpringApplication(DubboHmilyAccountApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }
}
