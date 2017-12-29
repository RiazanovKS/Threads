package ru.rks.copyfiles;

import java.io.*;

/**
 * Класс копирует содержимое одного текстового файла в другой текстовый файл.
 *
 * @author Рязанов К.С.
 */

public class CopyFile extends Thread {
    private String wayToFileOutput;
    private String wayToFileInput;

    public CopyFile(String wayToFileOutput,String wayToFileInput) {
        this.wayToFileOutput = wayToFileOutput;
        this.wayToFileInput= wayToFileInput;
    }

    @Override
    public void run() {
        final long before=System.currentTimeMillis();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(wayToFileOutput));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(wayToFileInput))) {
            String string;
            while ((string = bufferedReader.readLine()) != null){
                bufferedWriter.write(string+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long after = System.currentTimeMillis();
        System.out.println("time delta: " + (after-before) + " ms");
    }
}

