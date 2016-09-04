package br.com.ecarrara.neom.testdata.nearearthobjectserviceresponses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntityList;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectsJsonServiceResponse;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2002LE27;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015FC35;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RC;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RG2;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RH36;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RL35;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RX83;
import br.com.ecarrara.neom.testdata.nearearthobjects.NEO2015RY83;
import br.com.ecarrara.neom.utils.JsonResourceLoader;

public class TestServiceResponseFor20150907 {

    public static final NearEarthObjectsJsonServiceResponse TEST_RESPONSE;
    public static final Date TEST_REQUEST_DATE;
    static {
        TEST_RESPONSE = buildNearEarthObjectEntity();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 8, 7); // 7 of September 2015
        TEST_REQUEST_DATE = calendar.getTime();
    }

    public static String getJson() {
        String json = "";
        try {
            json = JsonResourceLoader
                    .forResource("nearearthobjectserviceresponses/TestServiceResponseFor20150907.json")
                    .getJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static NearEarthObjectsJsonServiceResponse buildNearEarthObjectEntity() {
        NearEarthObjectsJsonServiceResponse serviceResponse =
                new NearEarthObjectsJsonServiceResponse();

        NearEarthObjectJsonEntity neo2015RG2 = NEO2015RG2.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2015RL35 = NEO2015RL35.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2015RX83 = NEO2015RX83.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2015RY83 = NEO2015RY83.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2002LE27 = NEO2002LE27.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2015FC35 = NEO2015FC35.buildNearEarthObjectEntity();
        NearEarthObjectJsonEntity neo2015RH36 = NEO2015RH36.buildNearEarthObjectEntity();

        List<NearEarthObjectJsonEntity> nearEarthObjectJsonEntities = new ArrayList<>();
        nearEarthObjectJsonEntities.add(neo2015RG2);
        nearEarthObjectJsonEntities.add(neo2015RL35);
        nearEarthObjectJsonEntities.add(neo2015RX83);
        nearEarthObjectJsonEntities.add(neo2015RY83);
        nearEarthObjectJsonEntities.add(neo2002LE27);
        nearEarthObjectJsonEntities.add(neo2015FC35);
        nearEarthObjectJsonEntities.add(neo2015RH36);

        NearEarthObjectJsonEntityList nearEarthObjectJsonEntityList =
                new NearEarthObjectJsonEntityList(nearEarthObjectJsonEntities);

        serviceResponse.setNearEarthObjectList(nearEarthObjectJsonEntityList);

        return serviceResponse;
    }

}
