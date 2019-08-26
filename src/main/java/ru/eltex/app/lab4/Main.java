package ru.eltex.app.lab4;

import ru.eltex.app.lab2.Orders;

public class Main {
    public static void main(String[] args) /*throws InterruptedException*/ {

        Orders orders = new Orders();

        Thread gen1 = new Thread(new Generator(orders));
        Thread gen2 = new Thread(new Generator(orders));
        Thread gen3 = new Thread(new Generator(orders));

        gen1.start();
        gen2.start();
        gen3.start();

        Thread checkTime = new Thread(new CheckTime(orders, 3000));
        Thread checkDone = new Thread(new CheckDone(orders, 3000));
        checkTime.start();
        checkDone.start();
    }
}
