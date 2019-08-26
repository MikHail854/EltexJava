package ru.eltex.app.lab1;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public abstract class Products implements ICrudAction, Serializable {

    private UUID id;//id товара
    public String name; //имя
    public int price; // цена
    /*protected String name; //имя
    protected int price; // цена*/
    protected int numerator; // Остаток товара на складе(счетчик товаров)
    protected String firm; // фирма
    protected String model; // модель
    protected String os; // операционная система

    public static int CounterObject; // Считчик сколько было заказано товаров


    @Override
    public void create() {

        Random random = new Random();
        RandValue val = new RandValue();
        this.price = random.nextInt(1000);
        this.numerator = random.nextInt(100);
        this.firm = val.RandFirm();
        this.model = val.RandModel();
        this.os = val.RandOS();
    }

    @Override
    public void read() {
        // System.out.println("ID товара: " + ID);
        System.out.println("Название: " + this.name);
        System.out.println("Цена: " + this.price);
        System.out.println("Остаток товара на складе(счетчик товаров): " + this.numerator);
        System.out.println("Фирма: " + this.firm);
        System.out.println("Модель: " + this.model);
        System.out.println("ОС: " + this.os);
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цену товара: ");
        this.price = scanner.nextInt();
        System.out.println("Введите остаток товара на складе: ");
        this.numerator = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Введите имя товара: ");
        this.name = scanner.nextLine();
        System.out.println("Введите  фирму: ");
        this.firm = scanner.nextLine();

        System.out.println("Введите модель товара: ");
        this.model = scanner.nextLine();

        System.out.println("Введите операционную систему: ");
        this.os = scanner.next();

    }
    public UUID getId() {
        return id;
    }
    @Override
    public void delete() {
        CounterObject--;
        this.name = "";
        this.model = "";
        this.numerator = 0;
        this.price = 0;
        this.firm = "";
        this.os = "";
    }

    public UUID getUUID() {
        return id;
    }
}
