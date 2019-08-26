package ru.eltex.app.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;

/**
 * класс ManagerOrderJSON для хранения заказов в виде текстового файла в формат JSON
 */

public class ManagerOrderJSON extends AManageOrder {

    public static final String JSON_PATH = "/home/mikhail/IdeaProjects/JavaLabVar2/target/result.json";
    private final Gson json;

    public ManagerOrderJSON(){
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Products.class, new ProductDeserializer())
                .registerTypeAdapter(Order.class, new OrderDeserializer())
                .registerTypeAdapter(Orders.class, new OrdersDeserializer());

        json = gsonBuilder.setPrettyPrinting().create();
        target = new File(JSON_PATH);
    }

    /**
     * чтение из файла по id
     * @param id идентификатор по которому ищется
     * @return заказ, который был записан по id
     */
    @Override
    public Order readById(UUID id) {
        Order order = null;
        try (FileReader reader = new FileReader(JSON_PATH)) {
            if (!target.exists()) {
                return null;
            }
            Type type = new TypeToken<Order>(){
            }.getType();
            order = json.fromJson(reader, type);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return order;
    }

    /**
     * сохранение в файл json по id
     * @param order заказ, который будет записан
     */

    @Override
    public void saveById(Order order) {
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            if (target.exists()) {
                json.toJson(order, writer);
            }else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * чтение в файл json всех объектов
     * @return класс orders со всеми заказами
     */
    @Override
    public Orders readAll() {
        Orders orders = null;
        try (FileReader reader = new FileReader(JSON_PATH)) {
            if (!target.exists()){
                return null;
            }
            Type type = new TypeToken<Orders<Order>>(){
            }.getType();
            orders = json.fromJson(reader, type);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return orders;
    }

    /**
     * сохранение в файл json всех обхектов
     * @param orders заказы, которые будут записаны
     */

    @Override
    public void saveAll(Orders orders) {
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            if (target.exists()) {
                json.toJson(orders, writer);
            }else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
