package ru.rks.jointUse;

import java.util.concurrent.atomic.AtomicInteger;



public class InterferenceExample {
    private static final int TWO_THOUSAND = 2000;
    private AtomicInteger counter = new AtomicInteger();

    public boolean stop() {
        return counter.incrementAndGet() > TWO_THOUSAND;
    }

    public void example() throws InterruptedException {
        InterferenceThread thread1 = new InterferenceThread("Поток 1", this);
        InterferenceThread thread2 = new InterferenceThread("Поток 2", this);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Ожидаем: " + TWO_THOUSAND);
        System.out.println("Получили: " + thread1.getI());
    }
}
