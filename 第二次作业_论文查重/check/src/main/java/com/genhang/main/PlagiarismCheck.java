package com.genhang.main;

import com.genhang.utils.HammingUtils;
import com.genhang.utils.IOUtils;
import com.genhang.utils.SimHashUtils;

public class PlagiarismCheck {
    public static void main(String[] args) {
        String str0 = IOUtils.read(args[0]);
        String str1 = IOUtils.read(args[1]);
        String resultFileName = args[2];
        String simHash0 = SimHashUtils.getSimHash(str0);
        String simHash1 = SimHashUtils.getSimHash(str1);
        double similarity = HammingUtils.getSimilarity(simHash0, simHash1);
        IOUtils.write(similarity, resultFileName);
    }
}
