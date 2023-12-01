package com.csx.cxy;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestNull {


    @Test
    public void test(){

        PageParam page = new PageParam();
        page.setPageSize(1);
        page.setPageNum(10);

        int pageNum = Optional.ofNullable(page.getPageNum()).orElse(1);
        int pageSize = Optional.ofNullable(page.getPageSize()).orElse(10);


        Object object = new Object();
        Object o = Optional.ofNullable(object).orElseThrow(() -> new RuntimeException("对象不能为空"));
        System.out.println(o);


    }
}
