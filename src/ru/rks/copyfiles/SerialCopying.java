package ru.rks.copyfiles;

/**
 * Класс осуществляет последовательное многопоточное копирование текствовых файлов.
 *
 * @author Рязанов К.С.
 */
public class SerialCopying {
    private static final String WAY_TO_FILE_OUT_1="D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document1.txt";
    private static final String WAY_TO_FILE_OUT_2="D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\Document2.txt";
    private static final String WAY_TO_FILE_INPUT ="D:\\Work\\Threads\\src\\ru\\rks\\copyfiles\\FileInput.txt";
    public static void main(String[] args) throws InterruptedException {
        CopyFile thread1 = new CopyFile(WAY_TO_FILE_OUT_1,WAY_TO_FILE_INPUT);
        CopyFile thread2 = new CopyFile(WAY_TO_FILE_OUT_2,WAY_TO_FILE_INPUT);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}
