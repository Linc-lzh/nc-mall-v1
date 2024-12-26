package com.tulingxueyuan.mall;

import cn.hutool.crypto.digest.BCrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @author Linc
 * @since 2024-12-26
 */
@SpringBootApplication
public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
        //System.out.println(BCrypt.hashpw("123456"));
    }

}
