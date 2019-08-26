package ru.eltex.app.lab4;

import ru.eltex.app.lab2.Orders;

/**
 *  Поток проверяет заказы по статусу "обработан"
 *  Если заказ обнаружен в этом состоянии, заказ удаляется из списка
 */
public class CheckDone extends ACheck {

    public CheckDone(Orders<?> orders){
        super(orders);
    }

    public CheckDone(Orders orders, long pause){
        super(orders);
        this.pause = pause;
    }

    public void off(){
        this.fRun = false;
    }

    /**
     * Метод работающий в потоке
     */
    public void run(){
        while (fRun){
            synchronized (orders) {
                getOrders().checkDone();
            }
            try{
                Thread.sleep(pause);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
