package ru.eltex.app.lab4;

import ru.eltex.app.lab2.Orders;

/**
 * Делает проверку коллекции и проверяет заказы по статусу "в ожидании"
 * Если заказ обнаружен в этом состоянии, то меняется статус заказа на состояние "обработан"
 */
public class CheckTime extends ACheck {

    public CheckTime(Orders<?> orders){
        super(orders);
    }

    public CheckTime(Orders<?> orders, long pause){
        super(orders);
        this.pause = pause;
    }

    /**
     * Остановка работы потока
     */
    public void off() {
        this.fRun = false;
    }
    public void run(){
        while (fRun){
            synchronized (orders) {
                getOrders().checkTime();
                getOrders().show();
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
