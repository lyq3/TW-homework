package com.lyq3.galaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 启动类
 * @author 卡卢比
 * @date 2018/5/20
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.lyq3.galaxy" })
public class Application {
    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }

}
