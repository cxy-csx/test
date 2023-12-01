package com.csx.cxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


        LocalDate now = LocalDate.now();
//        String string = now.toString();
//        System.out.println(string);
//        System.out.println(now + " 00:00:00");

    }

}
