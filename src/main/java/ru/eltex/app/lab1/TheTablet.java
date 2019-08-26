package ru.eltex.app.lab1;

import java.util.Scanner;
import java.util.UUID;

public class TheTablet extends Products{
    //планшеты
    private String videoProcessor;
    private String screenResolution;

    public TheTablet() {
        CounterObject++;
       // id = UUID.randomUUID();
        this.name = "";
        this.model = "";
        this.numerator = 0;
        this.price = 0;
        this.firm = "";
        this.os = "";
        this.videoProcessor = "";
        this.screenResolution = "";
    }

    public TheTablet(/*UUID ID,*/ String name, int numerator, String model, int price, String firm, String os, String VideoProcessor, String ScreenResolution) {
        //перегрузка конструктора
        CounterObject++;
        //this.id = ID;
        this.name = name;
        this.model = model;
        this.numerator = numerator;
        this.price = price;
        this.firm = firm;
        this.os = os;
        this.videoProcessor = VideoProcessor;
        this.screenResolution = ScreenResolution;
    }

    @Override
    public void create() {
        super.create();

        int Lenght = 10;
        RandValue val = new RandValue();
        this.name = val.RandTheTablet();

        this.videoProcessor = val.RandVideoProcessor();
        this.screenResolution = val.RandScreenResolution();
    }

    @Override
    public void read() {
        super.read();
        // System.out.println("ID товара " + this.ID);
        System.out.println("Видеопроцессор: " + this.videoProcessor);
        System.out.println("Разрешение экрана: " + this.screenResolution + "\n--------------------------");
    }

    @Override
    public void update() {
        super.update();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите видеопроцессор");
        this.videoProcessor = scanner.nextLine();
        System.out.println("Введите разрешение экрана");
        this.screenResolution = scanner.nextLine();
    }

    @Override
    public void delete() {
        super.delete();
        this.videoProcessor = "";
        this.screenResolution = "";
    }
}

