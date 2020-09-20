package com.itheima.file;

import java.io.File;
import java.util.HashMap;

public class Demo05 {
    public static void main(String[] args) {
        File file = new File("./");
        HashMap<String, Integer> hm = new HashMap<>();
        getCount(hm, file);
        System.out.println(hm);
    }

    private static void getCount(HashMap<String, Integer> hm, File file) {
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isFile()) {
                String fileEndName = f.getName().split("\\.")[1];
                if (hm.containsKey(fileEndName)) {
                    hm.put(fileEndName, hm.get(fileEndName) + 1);
                } else {
                    hm.put(fileEndName, 1);
                }
            } else {
                getCount(hm, f);
            }
        }
    }
}
