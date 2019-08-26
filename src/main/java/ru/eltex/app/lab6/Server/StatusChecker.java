package ru.eltex.app.lab6.Server;

import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab4.ACheck;

import java.net.Socket;

/**
 * Поток проверяет статус заказа
 */
public class StatusChecker  extends ACheck {
    Socket socket;

    public StatusChecker(Orders orders) {
        super(orders);
    }

    public StatusChecker(Orders orders, Socket socket, long pause) {
        super(orders);
        this.pause = pause;
        this.socket = socket;
    }
    public void off() {
        this.fRun = false;
    }

    @Override
    public void run() {
        while (fRun) {
            synchronized (orders) {
                getOrders().StatusAlert();

            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
