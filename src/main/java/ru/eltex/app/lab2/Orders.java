package ru.eltex.app.lab2;

import ru.eltex.app.lab6.Server.UDP;

import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Orders <T extends Order> implements Serializable {

    private ArrayList<T> orders;//Коллекция для хранения объектов в классе "заказы"
    private TreeMap<Date, T> dateOrder;//Коллекция для хранения объектов по времени создания

    public Orders(){
        //this.orders = Collections.synchronizedList(new ArrayList<>());
        this.orders = new ArrayList<T>();
        this.dateOrder = new TreeMap<>();
    }

    public Orders(ArrayList<T> list,TreeMap<Date, T> createTime){
        this.orders = list;
        this.dateOrder = createTime;
    }

    public void purchase(ShoppingCart cart, Credentials credentials) {
        Order order = new Order(cart, credentials);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
    }

   public List<T> getList() {
        return orders;
    }
    void add (T obj){
        this.orders.add(obj);
    }

    void detete(T obj){
        this.orders.remove(obj);
    }

   /* public void offer(ShoppingCart cart, Credentials user, InetAddress address, int port){
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
       // cart.show_short();
    }*/

    public void offer(ShoppingCart cart, Credentials credentials, InetAddress address, int port){
        Order order = new Order(cart, credentials, address, port);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
       // cart.show_short();
    }

public void offer(ShoppingCart cart, Credentials credentials, InetAddress address){
        Order order = new Order(cart, credentials, address);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
       // cart.show_short();
    }
    public void remove(String id) {
        var iter = dateOrder.values().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if (item.getUUID().toString().equals(id)) {
                iter.remove();
                orders.remove(item);
                return;
            }
        }
    }

    public void offer(ShoppingCart cart, Credentials user){
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
        // cart.show_short();
    }

    public ShoppingCart<?> getCart(String id) {
        var iter = dateOrder.values().iterator();

        while (iter.hasNext()) {
            var item = iter.next();
            if (item.getCart().getId().toString().equals(id)) {
                return item.getCart();
            }
        }
        return null;
    }

   public T find(String id) {

        var iter = dateOrder.values().iterator();
        while (iter.hasNext()) {
            var item = iter.next();
            if (id.equals(item.getUUID().toString())) {
                return item;
            }
        }
        return null;
    }


    public void checkTime(){
        synchronized (orders){
            Iterator it = orders.iterator();
            while (it.hasNext()){
                Order order = (Order) it.next();
                if(order.getStatus() == OrderStatus.WAITING &&
                        order.checkInterval(System.currentTimeMillis())){
                    order.setStatus(OrderStatus.DONE);
                    System.out.println("Проверка заказа...");
                }

            }
        }
    }
    public void StatusAlert() {
        synchronized(orders) {
            Iterator it = orders.iterator();
            while(it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.WAITING &&
                        order.checkInterval(System.currentTimeMillis())) {
                    order.setStatus(OrderStatus.DONE);
                    UDP udp = new UDP(order.getDateCreate(),"127.0.0.255", 7777);
                    udp.start();
                    System.out.println("Checking orders...");
                }
            }
        }
    }

    public void checkDone(){
        synchronized (orders){
            Iterator it = orders.iterator();
            while (it.hasNext()){
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.DONE){
                    it.remove();
                    System.out.println("Удаление заказа");
                }
            }
        }
    }

    public void show(){
        for (T order: orders){
            System.out.println("----------------------------");
            order.show();
        }
    }
}