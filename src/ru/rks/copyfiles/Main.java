package ru.rks.copyfiles;

public class Main {
    public static void main(String[] args) {
        CopyFile thread1 = new CopyFile("Document1.txt");
        CopyFile thread2 = new CopyFile("Document2.txt");
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
