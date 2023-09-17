package com.genhang.main;

import com.genhang.utils.HammingUtils;
import com.genhang.utils.IOUtils;
import com.genhang.utils.SimHashUtils;
import org.junit.Test;

public class MainTest {
    @Test
    public void origAndAllTest(){
        String[] str = new String[6];
        str[0] = IOUtils.read("src/main/resources/orig.txt");
        str[1] = IOUtils.read("src/main/resources/orig_0.8_add.txt");
        str[2] = IOUtils.read("src/main/resources/orig_0.8_del.txt");
        str[3] = IOUtils.read("src/main/resources/orig_0.8_dis_1.txt");
        str[4] = IOUtils.read("src/main/resources/orig_0.8_dis_10.txt");
        str[5] = IOUtils.read("src/main/resources/orig_0.8_dis_15.txt");
        String ansFileName = "src/main/resources/ansAll.txt";
        for(int i = 0; i <= 5; i++){
            double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str[0]), SimHashUtils.getSimHash(str[i]));
            IOUtils.write(ans, ansFileName);
        }
    }

    @Test
    public void origAndOrigTest(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig.txt");
        String ansFileName = "src/main/resources/ansOrigAndOrigTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        IOUtils.write(ans, ansFileName);
    }

    @Test
    public void origAndAddTest(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig_0.8_add.txt");
        String ansFileName = "src/main/resources/ansOrigAndAddTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        IOUtils.write(ans, ansFileName);
    }

    @Test
    public void origAndDelTest(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig_0.8_del.txt");
        String ansFileName = "src/main/resources/ansOrigAndDelTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        IOUtils.write(ans, ansFileName);
    }

    @Test
    public void origAndDis1Test(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig_0.8_dis_1.txt");
        String ansFileName = "src/main/resources/ansOrigAndDis1Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        IOUtils.write(ans, ansFileName);
    }

    @Test
    public void origAndDis10Test(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig_0.8_dis_10.txt");
        String ansFileName = "src/main/resources/ansOrigAndDis10Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        IOUtils.write(ans, ansFileName);
    }

    @Test
    public void origAndDis15Test(){
        String str0 = IOUtils.read("src/main/resources/orig.txt");
        String str1 = IOUtils.read("src/main/resources/orig_0.8_dis_15.txt");
        String ansFileName = "src/main/resources/ansOrigAndDis15Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        IOUtils.write(ans,ansFileName);
    }
}

