package org.example;


public class Main {
    public static void main(String[] args) {

        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (true) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timer.setDaemon(true);

        timer.start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                int randomNum = (int) (Math.random() * 1_000_000_000);
                boolean isGuess = false;
                while (!isGuess) {
                    int num = (int) (Math.random() * 1_000_000_000);
                    if (num == randomNum) {
                        System.out.println("num = " + randomNum);
                        isGuess = true;
                    }
                }
            }
        }).start();
    }
}