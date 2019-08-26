package ru.eltex.app.lab2;
import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Date;
import java.util.UUID;

public class Order implements Serializable{

    private UUID id;
    private ShoppingCart cart;
    private Credentials user;

    private Date dateCreate;
    private long timeWaiting;
    private OrderStatus status;

    private InetAddress address;
    private int port;


    public Order(ShoppingCart Cart, Credentials User) {
        this.id = UUID.randomUUID();
        this.cart = Cart;
        this.user = User;
        this.status = OrderStatus.WAITING;

        this.dateCreate = new Date(System.currentTimeMillis());
        this.timeWaiting = 1;

        this.address = InetAddress.getLoopbackAddress();
        this.port = 0;
    }

    public Order(UUID id, OrderStatus status, Date dateCreate, long diff, ShoppingCart<?> cart, Credentials user){
        this.id = id;
        this.status = status;
        this.dateCreate = dateCreate;
        this.timeWaiting = diff;
        this.cart = cart;
        this.user = user;
    }

    public Order(ShoppingCart<?> cart, Credentials user, InetAddress address, int port) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.WAITING;
        this.dateCreate = new Date(System.currentTimeMillis());
        this.timeWaiting = 1;

        this.cart = cart;
        this.user = user;
        this.address = address;
        this.port = port;
    }
    public Order(ShoppingCart<?> cart, Credentials user, InetAddress address) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.WAITING;
        this.dateCreate = new Date(System.currentTimeMillis());
        this.timeWaiting = 1;

        this.cart = cart;
        this.user = user;
        this.address = address;
    }
    public Date getDateCreate() {
        return dateCreate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean checkInterval(long time){
        if ((dateCreate.getTime() + timeWaiting) < time){
            return true;
        } else {
            return false;
        }
    }


    public ShoppingCart<?> getCart() {
        return cart;
    }

    public Credentials getUser() {
        return user;
    }

    public void show(){
        System.out.println("Ваш заказ");
        cart.show();
        user.show();
        System.out.println("Status = " + status);
        System.out.println("Date Create = " + dateCreate);
        System.out.println("Time Waiting = " + timeWaiting);
    }
    public UUID getUUID(){
        return this.id;
    }

    public void showShort(){
        cart.showShort();
        user.showShort();
    }
}
