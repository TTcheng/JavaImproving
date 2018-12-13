package com.java.io;


import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        try {
            File file = new File("FileReadWrite.txt");
            rwByFileStream(file);
            rwByBufferedStream(file);
            rwByStreamWriterAndReader(file);
            rwByFileWriterAndReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rwByFileStream(File file) throws IOException {
        //write
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("FileOutputStream write hello".getBytes());
        fos.close();
        //read
        FileInputStream fis = new FileInputStream(file);
        System.out.println("========FileInputStream Read=========");
        byte[] inputs = new byte[1024];
        while (fis.read(inputs) != -1) {
            System.out.println(new String(inputs));
        }
        fis.close();
    }

    public static void rwByBufferedStream(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("BufferedOutputStream write hello".getBytes());
        bos.close();
        fos.close();
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        System.out.println("========BufferedInputStream Read=========");

        byte[] inputs = new byte[1024];
        while (bis.read(inputs) != -1) {
            System.out.println(new String(inputs));
        }
        bis.close();
        fis.close();
    }

    public static void rwByFileWriterAndReader(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write("FileWriter write hello");
        fw.close();

        FileReader fr = new FileReader(file);
        System.out.println("========FileReader Read=========");
        char[] chars = new char[1024];
        while (fr.read(chars)!=-1){
            System.out.println(new String(chars));
        }
        fr.close();
    }

    public static void rwByStreamWriterAndReader(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("OutputStreamWriter write hello");
        osw.close();
        fos.close();

        System.out.println("========InputStreamReader Read=========");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isw = new InputStreamReader(fis);
        char[] chars = new char[1024];
        while (isw.read(chars)!=-1){
            System.out.println(new String(chars));
        }
        isw.close();
        fis.close();
    }

}
