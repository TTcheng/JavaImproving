package com.java.io;

import java.io.File;

public class SetFileProperties {
    public static void main(String[] args) {
        boolean status = false;
        //可执行
        File file = new File("SetFileProps");
        status = file.setExecutable(true);
        System.out.println("setExecutable = " + status);
        status = file.setExecutable(true, true);
        System.out.println("setExecutableOwner = " + status);
        //可读
        boolean readable = file.setReadable(true);
        System.out.println("setReadable = " + readable);
        boolean readableOwner = file.setReadable(true, true);
        System.out.println("readableOwner = " + readableOwner);
        //可写
        boolean writable = file.setWritable(true);
        boolean writeUserOnly = file.setWritable(true, false);

    }
}
