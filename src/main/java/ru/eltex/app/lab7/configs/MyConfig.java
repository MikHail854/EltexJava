package ru.eltex.app.lab7.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab2.ShoppingCart;

@Configuration
public class MyConfig {
    @Bean("Orders")
    public Orders<Order> getOrders(){
        return new Orders<Order>();
    }

    @Bean("Credentials")
    public Credentials getCredentials(){
        return new Credentials("Mikhail", "Chigurov", "Evgen'evich", "vip.moneta95@mail.ru");
    }

    @Bean("Cart1")
    public ShoppingCart<Products> getShoppingCart1(){
        return new ShoppingCart<Products>();
    }

    @Bean("Cart2")
    public ShoppingCart<Products> getShoppingCart2(){
        return new ShoppingCart<Products>();
    }
}
