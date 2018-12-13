package com.java.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ApacheCommonsIO {
    public static void main(String[] args) {
        try {
            File file = new File("commonsIo.txt");
            file.createNewFile();
            FileUtils.write(file, "Hello CommonsIo", "UTF-8");
            String fileContent = FileUtils.readFileToString(file, "UTF-8");
            System.out.println("fileContent = " + fileContent);
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
