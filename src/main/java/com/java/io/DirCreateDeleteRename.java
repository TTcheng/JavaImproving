package com.java.io;

import java.io.File;

public class DirCreateDeleteRename {

    public static void main(String[] args) {
        //创建单个目录
        File dir = new File("Dir");
        boolean mkdir = dir.mkdir();
        System.out.println("mkdir = " + mkdir);
        //创建多个目录
        File dirs = new File("Dirs/one/two/three");
        boolean mkdirs = dirs.mkdirs();
        System.out.println("mkdirs = " + mkdirs);
        //重命名
        File newDir = new File("newDir");
        boolean renameToNewDir = dir.renameTo(newDir);
        System.out.println("renameToNewDir = " + renameToNewDir);
        //删除单个  =====文件夹非空时删除失败=====
        boolean deleteNewDir = newDir.delete();
        //级联删除
        boolean deleteDir = deleteDirWithFilesInclude(dirs);
    }

    /**
     * 删除 文件夹及其内容
     * @param dir 文件夹
     */
    public static boolean deleteDirWithFilesInclude(File dir) {
        boolean status = false;
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirWithFilesInclude(file);
                status = file.delete();
            } else status = file.delete();
        }
        return status;
    }
}
