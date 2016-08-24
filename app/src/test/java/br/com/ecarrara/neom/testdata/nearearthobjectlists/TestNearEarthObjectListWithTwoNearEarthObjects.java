package br.com.ecarrara.neom.testdata.nearearthobjectlists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntityList;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectsJsonServiceResponse;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RC;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015TX237;
import br.com.ecarrara.neom.utils.JsonResourceLoader;

public class TestNearEarthObjectListWithTwoNearEarthObjects {

    public static final NearEarthObjectsJsonServiceResponse TEST_RESPONSE;
    static {
        TEST_RESPONSE = buildNearEarthObjectEntity();
    }

    public static String getJson() {
        String json = "";
        try {
            json = JsonResourceLoader
                    .forResource("json/nearearthobjectslists/TestNearEarthObjectListWithTwoNearEarthObjects.json").getJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static NearEarthObjectsJsonServiceResponse buildNearEarthObjectEntity() {
        NearEarthObjectsJsonServiceResponse serviceResponse =
                new NearEarthObjectsJsonServiceResponse();

        NearEarthObjectJsonEntity neo2015rc = NEO2015RC.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2015TX237 = NEO2015TX237.buildNearEarthObjectEntity();

        List<NearEarthObjectJsonEntity> nearEarthObjectJsonEntities = new ArrayList<>();
        nearEarthObjectJsonEntities.add(neo2015rc);
        nearEarthObjectJsonEntities.add(neo2015TX237);

        NearEarthObjectJsonEntityList nearEarthObjectJsonEntityList =
                new NearEarthObjectJsonEntityList(nearEarthObjectJsonEntities);

        serviceResponse.setNearEarthObjectList(nearEarthObjectJsonEntityList);

        return serviceResponse;
    }

}
