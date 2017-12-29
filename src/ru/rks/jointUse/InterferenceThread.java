package ru.rks.jointUse;

public class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private static volatile int i;

    public InterferenceThread(String name, InterferenceExample checker) {
        super(name);
        this.checker = checker;
    }

    public void run() {
        System.out.println(this.getName() + " запущен");
        while (!checker.stop()) {
            increment();
        }
        System.out.println(this.getName() + " завершен");
    }

    /**
     * Метол инкрементирует значение переменной
     */
    public synchronized void  increment() {
        i++;
    }

    public int getI() {
        return i;
    }

}
