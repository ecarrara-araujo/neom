package br.com.ecarrara.neom.nearearthobjects.data.entity.mapper.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntityList;

public class NearEarthObjectListDeserializer
        implements JsonDeserializer<NearEarthObjectJsonEntityList> {

    @Override
    public NearEarthObjectJsonEntityList deserialize(JsonElement json, Type typeOfT,
                                                     JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject rawNearEarthObjectsList = json.getAsJsonObject();
        List<NearEarthObjectJsonEntity> nearEarthObjects = new ArrayList<>();

        for (Map.Entry<String, JsonElement> entry : rawNearEarthObjectsList.entrySet()) {
            for (JsonElement nearEarthJsonElement : entry.getValue().getAsJsonArray()) {
                NearEarthObjectJsonEntity nearEarthObject =
                        context.deserialize(nearEarthJsonElement, NearEarthObjectJsonEntity.class);
                nearEarthObjects.add(nearEarthObject);
            }
        }

        return new NearEarthObjectJsonEntityList(nearEarthObjects);
    }

}
