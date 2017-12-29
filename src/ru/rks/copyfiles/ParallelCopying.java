package ru.rks.copyfiles;

/**
 * Класс осуществляет параллельное многопоточное копирование текстовых файлов.
 *
 * @author Рязанов К.С.
 */
public class ParallelCopying {
    private static final String WAY_TO_FILE_OUT_1="D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document1.txt";
    private static final String WAY_TO_FILE_OUT_2="D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document2.txt";
    private static final String WAY_TO_FILE_INPUT ="D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\FileInput.txt";
    public static void main(String[] args) {
        CopyFile thread1 = new CopyFile(WAY_TO_FILE_OUT_1,WAY_TO_FILE_INPUT);
        CopyFile thread2 = new CopyFile(WAY_TO_FILE_OUT_2,WAY_TO_FILE_INPUT);
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
