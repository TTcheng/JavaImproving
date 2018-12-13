package com.java.io;

import java.io.File;
import java.io.IOException;

public class FileProperties {
    public static void main(String[] args) throws IOException {
        File file = new File("testProps.txt");
        boolean newFile = file.createNewFile();
        //1、 is property
        System.out.println("==========Is Property===========");
        System.out.println("createNewFile = " + newFile);
        boolean directory = file.isDirectory();
        System.out.println("directory = " + directory);
        boolean absolute = file.isAbsolute();
        System.out.println("absolute = " + absolute);
        boolean isFile = file.isFile();
        System.out.println("isFile = " + isFile);
        boolean exists = file.exists();
        System.out.println("exists = " + exists);
        boolean hidden = file.isHidden();
        System.out.println("hidden = " + hidden);
        //2、 get property
        System.out.println("==========getProperty===========");
        String name = file.getName();
        System.out.println("name = " + name);
        File absoluteFile = file.getAbsoluteFile();
        String path = file.getPath();
        System.out.println("path = " + path);
        System.out.println("absoluteFile = " + absoluteFile);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        File canonicalFile = file.getCanonicalFile();
        System.out.println("canonicalFile = " + canonicalFile);
        String parent = file.getParent();
        System.out.println("parent = " + parent);
        String canonicalPath = file.getCanonicalPath();
        System.out.println("canonicalPath = " + canonicalPath);
        File parentFile = file.getParentFile();
        long freeSpace = file.getFreeSpace();
        System.out.println("freeSpace = " + freeSpace);
        long totalSpace = file.getTotalSpace();
        System.out.println("totalSpace = " + totalSpace);
        long usableSpace = file.getUsableSpace();
        System.out.println("usableSpace = " + usableSpace);


        boolean delete = file.delete();
        System.out.println("\ndelete = " + delete);
    }
}
