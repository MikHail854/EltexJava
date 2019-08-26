package ru.eltex.app.lab6.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс сервера для подклбчения клиентов
 */

public class SevrerMain {
    private static final int PORTTCP = 5551; //Порт для подключения по TCP
    private static final int PORTTCP2 = 5552;

    public static void connectByTCP(int Port) {
        try (ServerSocket serverSocket = new ServerSocket(Port)) {
            while (true) {
                Socket s = serverSocket.accept();
                System.out.println("Поток создан");
                ServerConnectionProcessor p = new ServerConnectionProcessor(s);
                p.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        UDP udp = new UDP(PORTTCP, "127.0.0.255", 9991);
        udp.start();
        connectByTCP(PORTTCP);
    }
}