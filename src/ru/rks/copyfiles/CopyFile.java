package ru.rks.copyfiles;

import java.io.*;

public class CopyFile extends Thread {
    private String wayToFileOutput;

    public CopyFile(String wayToFileOutput) {
        this.wayToFileOutput = wayToFileOutput;
    }

    @Override
    public void run() {
        final long before=System.currentTimeMillis();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(wayToFileOutput));
             BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\FileInput.txt"))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                bufferedWriter.write(string+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long after = System.currentTimeMillis();
        System.out.println("time delta: " + (after-before) + " ms");
    }
}

