package com.genhang.utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class SimHashUtils {
    public static String getHash(String str){
        try{
            // 这里使用了MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }
    public static String getSimHash(String str){
        try{
            if(str.length() < 200) throw new ShortStringException("文本过短！");
        }catch (ShortStringException e){
            e.printStackTrace();
            return null;
        }
        int[] v = new int[128];
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        // hash
        int size = keywordList.size();
        int i = 0;//以i做外层循环
        for(String keyword : keywordList){
            // 2、获取hash值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) {
                // hash值可能少于128位，在低位以0补齐
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }
            }
            // 3、加权、合并
            int level = 10;
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    //System.out.println("" + level + " - (" + i + " / ( " + size + " / " + level + "))");
                    v[j] += (level - (i / (size / level)));
                } else {
                    v[j] -= (level - (i / (size / level)));
                }
            }
            i++;
        }
        // 4、降维
        String simHash = "";// 储存返回的simHash值
        for (int k : v) {
            // 从高位遍历到低位
            if (k <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;
    }
}
