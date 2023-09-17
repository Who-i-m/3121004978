package com.genhang.utils;

import org.junit.Test;

public class SimHashUtilsTest {
    @Test
    public void getHashTest(){
        String[] strings = {"余华", "是", "一个", "有趣", "的", "作家"};
        for (String string : strings) {
            String stringHash = SimHashUtils.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
        }
    }

    @Test
    public void getSimHashTest(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig_0.8_add.txt");
        System.out.println(SimHashUtils.getSimHash(str0));
        System.out.println(SimHashUtils.getSimHash(str1));
    }
}
