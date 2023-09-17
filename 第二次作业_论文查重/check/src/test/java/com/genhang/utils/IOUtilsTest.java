package com.genhang.utils;

import org.junit.Test;

public class IOUtilsTest {
    @Test
    public void readTest() {
        // 路径存在，正常读取
        String str = IOUtils.read("src/main/resources/orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void writeTest() {
        // 路径存在，正常写入
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            IOUtils.write(elem[i], "src/main/resources/ans.txt");
        }
    }

    @Test
    public void readFailTest() {
        // 路径不存在，读取失败
        String str = IOUtils.read("src/main/resources/none.txt");
    }

    @Test
    public void writeFailTest() {
        // 路径错误，写入失败
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            IOUtils.write(elem[i], "src/main/resources/ans.txt");
        }
    }
}
