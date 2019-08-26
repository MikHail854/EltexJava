package ru.eltex.app.lab5;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.OrderStatus;
import ru.eltex.app.lab2.ShoppingCart;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public final class OrderDeserializer implements JsonDeserializer<Order> {
    @Override
    public Order deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jDContext) throws JsonParseException {
            JsonObject jobject = jsonElement.getAsJsonObject();

            UUID id = UUID.fromString(jobject.get("id").getAsString());
            var status = OrderStatus.valueOf(jobject.get("status").getAsString());


            Date dateCreate = null;
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
            try {
                dateCreate = new Date(format.parse(jobject.get("dateCreate").getAsString()).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            var timeWaiting = jobject.get("timeWaiting").getAsLong();
            Type typecart = new TypeToken<ShoppingCart<Products>>() {
            }.getType();

            ShoppingCart<Products> cart=jDContext.deserialize(jobject.get("cart"), typecart);
            Credentials user = new Gson().fromJson(jobject.get("user"), Credentials.class);
            return new Order(id, status, dateCreate, timeWaiting, cart, user);
    }
}
