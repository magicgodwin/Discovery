package com.nepxion.discovery.plugin.example.service;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.nepxion.discovery.plugin.example.service.extension.MyDiscoveryListener;
import com.nepxion.discovery.plugin.example.service.extension.MyLoadBalanceListener;
import com.nepxion.discovery.plugin.example.service.extension.MyRegisterListener;
import com.nepxion.discovery.plugin.example.service.extension.MyDiscoveryEnabledAdapter;
import com.nepxion.discovery.plugin.example.service.extension.MySubscriber;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DiscoveryApplicationA1 {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "a1");

        new SpringApplicationBuilder(DiscoveryApplicationA1.class).run(args);
    }

    @Configuration
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
        }
    }

    @Bean
    public MyRegisterListener myRegisterListener() {
        return new MyRegisterListener();
    }

    @Bean
    public MyDiscoveryListener myDiscoveryListener() {
        return new MyDiscoveryListener();
    }

    @Bean
    public MyLoadBalanceListener myLoadBalanceListener() {
        return new MyLoadBalanceListener();
    }

    @Bean
    public MySubscriber mySubscriber() {
        return new MySubscriber();
    }

    @Bean
    public MyDiscoveryEnabledAdapter myDiscoveryEnabledAdapter() {
        return new MyDiscoveryEnabledAdapter();
    }
}