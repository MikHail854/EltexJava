package ru.eltex.app.lab5;

import java.io.File;

/**
 * абстрактный класс для хранения зказов
 */

abstract public class AManageOrder implements IOrder {
    protected File target; //файл для хранения и загрузки
}
