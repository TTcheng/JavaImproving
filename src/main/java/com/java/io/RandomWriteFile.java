package com.java.io;

import java.io.*;

public class RandomWriteFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("randomWriteFile.txt");
        if (file.exists()) file.delete();
        MultiWriteFile multiWriteFile1 = new MultiWriteFile(file,1);
        MultiWriteFile multiWriteFile2 = new MultiWriteFile(file,2);
        MultiWriteFile multiWriteFile3 = new MultiWriteFile(file,3);
        new Thread(multiWriteFile1).start();
        new Thread(multiWriteFile2).start();
        new Thread(multiWriteFile3).start();

        Thread.sleep(10);
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[1024];
        while (-1 != fileReader.read(chars)){
            System.out.println(chars);
        }
    }
}

class MultiWriteFile implements Runnable {
    File file;
    int block;
    private int Len = 100;

    public MultiWriteFile(File file, int block) {
        this.file = file;
        this.block = block;
    }


    @Override
    public void run() {
        try {
            RandomAccessFile randomFile = new RandomAccessFile(file, "rw");
            randomFile.seek((block - 1) * Len);
            randomFile.writeBytes("This is block " + block);
            randomFile.writeBytes("\n");
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
