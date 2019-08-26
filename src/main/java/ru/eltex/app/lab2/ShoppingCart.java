package ru.eltex.app.lab2;

import ru.eltex.app.lab1.Products;

import java.io.Serializable;
import java.util.*;

/**
 * Класс коллекция
 *
 * @param <T> extends Products
 */

public class ShoppingCart <T extends Products> implements Serializable {
    private UUID id;//id
    private List<T> cart;//Коллекция для хранения объектов в классе «корзина»
    private Set<UUID> uuids;//Коллекция для хранения и поиска уникальных идентификаторов

    public ShoppingCart(){
        //this.cart = Collections.synchronizedList(new LinkedList<T>());
       // this.cart = Collections.synchronizedList(new ArrayList<T>());
        this.id = UUID.randomUUID();
        this.cart = new ArrayList<>();
        this.uuids = new HashSet<>();
    }

    public boolean add(T products){
        uuids.add(products.getUUID());
        return this.cart.add(products);
    }

    void delete(T products){
        this.cart.remove(products);
    }

    public void show(){
        for (T val: cart){
            val.read();
        }
        //cart.get(1).read();
       // System.out.println(cart.get(1));
    }
    public UUID getId() {
        return id;
    }

    public void showShort(){
        for (T val: cart){
            System.out.println(val.name+"("+val.price+")");
        }
    }

    public boolean isExistsUUID(UUID id){
        return uuids.contains(id);
    }

}
