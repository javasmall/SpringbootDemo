package com.thymleaf.firstdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstdemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void test()
    {
        String t1="666";
        String t2=t1;
        System.out.println(t1);
        t2="555";
        System.out.println(t1);
        exchange(t1);
        System.out.println(t1);
        exchange(t2);
        System.out.println(t1);
    }
    public void exchange(String st)
    {
        st="9999";
    }

}
