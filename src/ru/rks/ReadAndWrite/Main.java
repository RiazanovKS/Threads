package ru.rks.ReadAndWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс многопоточно считывает данные из двух текстовых файлов и записывает в результирующий файл.
 */
public class Main {
    static final String WAY_TO_FILE_1 = "D:\\Work\\Threads\\src\\ru\\rks\\ReadAndWrite\\Document1.txt";
    static final String WAY_TO_FILE_2 = "D:\\Work\\Threads\\src\\ru\\rks\\ReadAndWrite\\Document2.txt";
    static final String WAY_TO_FILE_OUTPUT = "D:\\Work\\Threads\\src\\ru\\rks\\ReadAndWrite\\Result.txt";
    public static void main(String[] args) throws InterruptedException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(WAY_TO_FILE_OUTPUT))) {
            ReaderAndWriter thread1 = new ReaderAndWriter(WAY_TO_FILE_1, bufferedWriter);
            ReaderAndWriter thread2 = new ReaderAndWriter(WAY_TO_FILE_2, bufferedWriter);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
