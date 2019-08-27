package ru.eltex.app.lab2;

import ru.eltex.app.lab1.Products;

import java.io.Serializable;
import java.util.*;

/**
 * «корзина» класс коллекция
 *
 * @param <T> extends Products
 */

public class ShoppingCart <T extends Products> implements Serializable {
    private UUID id;//id
   // private int id;//id
    private LinkedList<T> cart;//Коллекция для хранения объектов в классе «корзина»
    private HashSet<UUID> uuids;//Коллекция для хранения и поиска уникальных идентификаторов

    public ShoppingCart(){
        //this.cart = Collections.synchronizedList(new LinkedList<T>());
       // this.cart = Collections.synchronizedList(new ArrayList<T>());
        this.id = UUID.randomUUID();
        this.cart = new LinkedList<>();
        this.uuids = new HashSet<>();
    }

    /**
     * метод добавления объекта из коллекции
     *
     * @param products
     */

    public /*boolean*/void add(T products){
        cart.add(products);
        uuids.add(products.getUUID());
        //return this.cart.add(products);
    }

    /**
     * метод удаления объекта из коллекции
     *
     * @param products
     */
    void delete(T products){
        this.cart.remove(products);
    }

    /**
     * функция вывода
     */
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

    /*public int getId(){
        return id;
    }*/

    public void showShort(){
        for (T val: cart){
            System.out.println(val.name+"("+val.price+")");
        }
    }
    /**
     * функция поиска по индефикатору
     *
     * @param id id который проверяем
     * @return есть ли id в коллекции
     */
    public boolean isExistsUUID(UUID id){
        return uuids.contains(id);
    }

}
