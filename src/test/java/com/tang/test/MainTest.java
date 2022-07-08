package com.tang.test;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.math.BigDecimal;

/**
 * @author weepppp 2022/7/7 23:48
 **/
public class MainTest {
    public static void main(String[] args) {

        Md5Hash md5Hash2 = new Md5Hash("456", "zhaosi", 1024);
        System.out.println(md5Hash2);
    }
}
