package com.huowolf;

import org.junit.Test;

import java.util.Random;

/**
 * Created by huowolf on 2018/11/7.
 */
public class CommonTest {

    @Test
    public void test(){
        Random random  = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}
