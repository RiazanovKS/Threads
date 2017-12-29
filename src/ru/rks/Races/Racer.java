package ru.rks.Races;

/**
 * Поток инкрементирует переменную указанное кол-во раз.
 *
 * @author Рязанов К.С.
 */
 class Racer extends Thread {
    final static int COUNT_OF_STEPS = 5000;
    final static int TIME_OF_SLEEP = 10;

    public void run(){
        for(int i=0;i<COUNT_OF_STEPS;i++){
            System.out.println("Racer - "+ i);
        try {
            Thread.sleep(TIME_OF_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}