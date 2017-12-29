package ru.rks.Races;

/**
 * Класс, демонстрирующий динамическое изменение приоритетов двух потоков.
 *
 * @author Рязанов К.С.
 */

public class Catching {
    final static int COUNT_OF_STEPS = 5000;
    static final int TIME_OF_SLEEP = 10;
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        Racer racer = new Racer();
        racer.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        racer.start();
        for (int i = 0; i < COUNT_OF_STEPS; i++) {
            if (i == 1000) {
                racer.setPriority(Thread.MIN_PRIORITY);
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            try {
                Thread.sleep(TIME_OF_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

