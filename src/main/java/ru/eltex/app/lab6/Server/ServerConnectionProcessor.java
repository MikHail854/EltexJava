package ru.eltex.app.lab6.Server;

import ru.eltex.app.lab2.Orders;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Класс для работы в потоке для принятия заказов по TCP
 */

public class ServerConnectionProcessor extends Thread{

    private Socket socket;//сокет соединения
    private Orders<?> orders;//заказы

    public ServerConnectionProcessor(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            //плучает запрос
            ObjectInputStream inputStream = new ObjectInputStream(dis);
            Orders new_orders = (Orders) inputStream.readObject();
            orders = new_orders;
            orders.show();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Thread StatusChecker = new Thread(new StatusChecker(orders, socket, 1000));
        StatusChecker.start();
    }
}
