package ru.eltex.app.lab5;

import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;

import java.io.*;
import java.util.UUID;

/**
 * класс ManagerOrderFile для хранения закозов в виде двоичного файла
 */


public final class ManagerOrderFile extends AManageOrder {

    public static final String BIN_PATH = "/home/mikhail/IdeaProjects/JavaLabVar2/target/binary.bin";

    ManagerOrderFile() {
        target = new File(BIN_PATH);
    }

    @Override
    public Order readById(UUID id) {
        Order order = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(BIN_PATH))) {
            if (!target.exists()) {
                return null;
            } else {
                order = (Order) objectInputStream.readObject();
                if (!order.getUUID().equals(id)) {
                    order = null;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveById(Order order) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(BIN_PATH))) {
            if (target.exists()) {
                objectOutputStream.writeObject(order);
            } else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Orders orders = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(BIN_PATH))) {
            if (!target.exists()) {
                return null;
            }
            orders = (Orders) objectInputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream((BIN_PATH)))) {
            if (target.exists()) {
                objectOutputStream.writeObject(orders);
                objectOutputStream.flush();
            } else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
