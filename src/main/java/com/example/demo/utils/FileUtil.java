package com.example.demo.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        File inputFile = new File(filePath,fileName);
        FileOutputStream out = new FileOutputStream(inputFile);
        out.write(file);
        out.flush();
        out.close();
    }
}
