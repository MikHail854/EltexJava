package ru.eltex.app.lab5;


import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;

import java.util.UUID;

/**
 * интерфейс для хранения заказов
 */

public interface IOrder {
    /**
     * чтение из файла по id
     *
     * @param id идентификатор по которому ищется
     * @return возвращает Order
     */
    Order readById(UUID id);

    /**
     * чтение из файла по id
     *
     *  @param order заказ, который будет записан
     */

    void saveById(Order order);

    /**
     * чтение в файл всех объектов
     *
     * @return возвращает Orders
     */
    Orders readAll();

    /**
     * сохранение в файл всех объектов
     *
     * @param orders заказы которые будут записаны
     */
    void saveAll(Orders orders);
}
