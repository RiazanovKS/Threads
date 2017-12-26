package ru.rks.ReadAndWrite;

import java.io.*;

/**
 * Поток считывает строки из текстового файла и записывает в результирующий файл.
 */
public class ReaderAndWriter extends Thread {
    private String wayToFileInput;
    private static volatile BufferedWriter bufferedWriter;
    public void run() {
        final long before = System.currentTimeMillis();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(wayToFileInput))) {
            String string;
            while ((string = bufferedReader.readLine())!=null){
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        final long after = System.currentTimeMillis();
        System.out.println("time delta : "+(after-before)+" ms");
    }

    ReaderAndWriter(String wayToFile, BufferedWriter bufferedWriter) {
        this.wayToFileInput = wayToFile;
        this.bufferedWriter = bufferedWriter;
    }
}
