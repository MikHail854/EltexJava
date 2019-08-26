package ru.eltex.app.lab6.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Date;

/**
 * Класс рассылающий номер порта для соединения TCP по UDP
 */
public class UDP extends Thread {
    private byte[] buffer; //байтовый массив
    private String address;
    private int localePort;
    private volatile boolean fRun;

    public UDP(Integer portTransfer, String address, int port1) {
        this.buffer = portTransfer.toString().getBytes();
        this.address = address;
        this.localePort = port1;
        this.fRun = true;
    }
    public UDP(Date date, String address, int port1) {
        this.buffer = date.toString().getBytes();
        this.address = address;
        this.localePort = port1;
        this.fRun = true;
    }
    public UDP(Date date, String address) {
        this.buffer = date.toString().getBytes();
        this.address = address;
        this.fRun = true;
    }

    /**
     * Выключение потока
     */
    public void Off(){
        fRun = false;
    }


    @Override
    public void run(){
        super.run();
        while (fRun){
            try (DatagramSocket datagram = new DatagramSocket()){
                DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(address), localePort);
                datagram.send(packet1);
            }catch (SocketException ex){
                ex.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
