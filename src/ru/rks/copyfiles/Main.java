package ru.rks.copyfiles;

public class Main {
    public static void main(String[] args) {
        CopyFile thread1 = new CopyFile("D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document1.txt");
        CopyFile thread2 = new CopyFile("D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document2.txt");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
