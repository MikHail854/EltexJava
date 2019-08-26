package ru.eltex.app.lab4;

import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Orders;

//abstract public class ACheck implements Runnable {
abstract public class ACheck extends Thread {


    public boolean fRun = true;
    public long pause = 1000;
    public boolean fWaiting = true;

    public Credentials user;
    public Orders orders;


    public ACheck(Orders orders){
        this.orders = orders;
    }

    public ACheck(Credentials user, Orders orders) {
        this.user = user;
        this.orders = orders;
    }


    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

}
