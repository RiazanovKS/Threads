package ru.rks.copyfiles;

public class SerialCopying {
    public static void main(String[] args) throws InterruptedException {
        CopyFile thread1 = new CopyFile("D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document1.txt");
        CopyFile thread2 = new CopyFile("D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document2.txt");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}
