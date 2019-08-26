package ru.eltex.app.lab4;

import ru.eltex.app.lab1.Phone;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab1.Smartphone;
import ru.eltex.app.lab1.TheTablet;
import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab2.ShoppingCart;

public class Generator extends ACheck {

    public Generator(Orders orders) {
        super(orders);
    }

    public Generator(Credentials user, Orders orders) {
        super(user, orders);
    }

    public void Waiting() {
        fWaiting = true;
    }

    public void Off() {
        fRun = false;
    }

    @Override
    public void run() {
        while (fRun) {
            int i = (int) (Math.random() * 2);
            Products[] product;

            //    Orders orders = getOrders();
            ShoppingCart cart = new ShoppingCart<>();
            synchronized (cart) {
                switch (i) {
                    case 0:
                        int p = (int) (Math.random() * 3);
                        product = new Phone[p];
                        for (int j = 0; j < p; j++) {
                            product[j] = new Phone();
                            product[j].create();
                            cart.add(product[j]);
                        }
                        break;
                    case 1:
                        int d = (int) (Math.random() * 3);
                        product = new Smartphone[d];
                        for (int k = 0; k < d; k++) {
                            product[k] = new Smartphone();
                            product[k].create();
                            cart.add(product[k]);
                        }
                    case 2:
                        int m = (int) (Math.random() * 3);
                        product = new TheTablet[m];
                        for (int t = 0; t < m; t++) {
                            product[t] = new TheTablet();
                            product[t].create();
                            cart.add(product[t]);
                        }
                }

                //Credentails user = new Credentails("Chigurov", "Mikhail", "Evgen'evich", "vip.moneta95@mail.ru");
                orders.offer(cart, user);
            }
            if (fWaiting) {
                try {
                    synchronized (this) {
                        wait();
                        fWaiting = false;
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
