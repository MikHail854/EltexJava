package ru.eltex.app.lab1;

import java.util.UUID;

public class Phone extends Products{
    private String typeOfShell;

    public Phone() {
        CounterObject++;
        //id = UUID.randomUUID();
        this.name = "";
        this.model = "";
        this.numerator = 0;
        this.price = 0;
        this.firm = "";
        this.os = "";
        this.typeOfShell = "";
    }

    public Phone(/*UUID ID,*/ String name, int numerator, String model, int price, String firm, String os, String TypeOfShell) {
        //перегрузка конструктора
        CounterObject++;
       // this.id = ID;
        this.name = name;
        this.model = model;
        this.numerator = numerator;
        this.price = price;
        this.firm = firm;
        this.os = os;
        this.typeOfShell = typeOfShell;
    }

    @Override
    public void create() {
        super.create();
        RandValue val = new RandValue();
        this.name = val.RandNamePhone();
        this.typeOfShell = val.RandTypeOfShell();
    }

    @Override
    public void read() {
        super.read();
        System.out.println("Тип корпуса: " + this.typeOfShell +"\n--------------------------");

    }

  /*  @Override
    public void update() {
        super.update();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип корпуса");
        this.TypeOfShell = scanner.nextLine();
    }*/

    @Override
    public void delete() {
        super.delete();
        this.typeOfShell = "";
    }
}

