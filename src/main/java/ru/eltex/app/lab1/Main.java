package ru.eltex.app.lab1;

import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab2.ShoppingCart;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /**
         *  программа работает от аргумента, в зависимости от вида представления(чай или кофе)
         */

        Scanner scanner = new Scanner(System.in);
        Credentials user = new Credentials("Анна","Старкова","Сергеевна","annastarko@yandex.com");
        System.out.println("\nМеню:\n1.Телефон\n2.Смартфон\n3.Планшет\n");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Введите желаемое кол-во товара: ");
            int Object1 = scanner.nextInt();
            Phone[] phone = new Phone[Object1];
            for (int i = 0; i < Object1; i++) {
                phone[i] = new Phone();
                phone[i].create();
                phone[i].read();
            }
            ShoppingCart cart = new ShoppingCart();
            for (int i = 0; i < Object1; i++) {
                cart.add(phone[i]);
            }
            System.out.println("\nКол-во товара: " + Products.CounterObject);
            System.out.println("\n1. Оформить заказ\n2. Выход");
            int choiсe2 = scanner.nextInt();
            if (choiсe2 == 1) {
                Orders orders = new Orders();
                orders.offer(cart, user);
                Thread.sleep(10);
                orders.checkTime();
                orders.show();
                System.out.println("Проверка: " + cart.isExistsUUID(phone[0].getUUID()));
            }
        }
        if (choice == 2) {
            System.out.println("Введите желаемое кол-во товара: ");
            int Object2 = scanner.nextInt();
            Smartphone[] smartphone = new Smartphone[Object2];
            for (int i = 0; i < Object2; i++) {
                smartphone[i] = new Smartphone();
                smartphone[i].create();
                smartphone[i].read();
            }
            ShoppingCart cart = new ShoppingCart();
            for (int i = 0; i < Object2; i++) {
                cart.add(smartphone[i]);
            }
            System.out.println("\nКол-во объектов: " + Products.CounterObject);
            System.out.println("\n1.Оформить заказ\n2.Выход");
            int choice2 = scanner.nextInt();
            if (choice2 == 1) {
                Orders orders = new Orders();
                orders.offer(cart, user);
                Thread.sleep(10);
                orders.checkTime();
                orders.show();
                System.out.println("Проверка: " + cart.isExistsUUID(smartphone[0].getUUID()));
            }
        }
        if (choice == 3) {
            System.out.println("Введите желаемое кол-во товара: ");
            int Object3 = scanner.nextInt();
            TheTablet[] TheTablet = new TheTablet[Object3];
            for (int i = 0; i < Object3; i++) {
                TheTablet[i] = new TheTablet();
                TheTablet[i].create();
                TheTablet[i].read();
            }
            ShoppingCart cart = new ShoppingCart();
            for (int i = 0; i < Object3; i++) {
                cart.add(TheTablet[i]);
            }
            System.out.println("\nКол-во объектов: " + Products.CounterObject);
            System.out.println("\n1.Оформить заказ\n2.Выход");
            int choice3 = scanner.nextInt();
            if (choice3 == 1) {
                Orders orders = new Orders();
                orders.offer(cart, user);
                Thread.sleep(10);
                orders.checkTime();
                orders.show();
                System.out.println("Проверка: " + cart.isExistsUUID(TheTablet[0].getUUID()));
            } else {
                return;
            }
        }

    }
}