package com.study.company;

import com.study.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan(value = "com.study.domain.company")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    // id - SnowFlake create id
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
