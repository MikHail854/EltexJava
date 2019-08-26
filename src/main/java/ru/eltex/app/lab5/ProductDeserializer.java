package ru.eltex.app.lab5;

import com.google.gson.*;
import ru.eltex.app.lab1.Phone;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab1.Smartphone;
import ru.eltex.app.lab1.TheTablet;

import java.lang.reflect.Type;

public class ProductDeserializer implements JsonDeserializer<Products> {

    @Override
    public Products deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jDContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.has("typeOfShell")){
            return jDContext.deserialize(jsonObject, Phone.class);
        }else if (jsonObject.has("typeSIMCard")){
            return jDContext.deserialize(jsonObject, Smartphone.class);
        }else if (jsonObject.has("videoProcessor")){
            return jDContext.deserialize(jsonObject, TheTablet.class);
        }
        return null;
    }
}
