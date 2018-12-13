package com.java.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件的创建删除和重命名
 */
public class FileCreateDeleteRename {

    public static void main(String[] args) {
        try {

            File file = new File("io.txt");
            //创建
            boolean status = file.createNewFile();
            System.out.println("status = " + status);
            //重命名
            File newFile = new File("FileIO.txt");
            boolean renamed = file.renameTo(newFile);
            if (renamed) System.out.println("renamed to FileIO.txt");
            //删除
            boolean delete = newFile.delete();
            System.out.println("delete = " + delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
