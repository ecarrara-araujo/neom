package br.com.ecarrara.neom.testdata.nearearthobjects;

import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.CloseApproachDataJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.MissDistanceJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;

public class NEO2015RG2 {

    public static NearEarthObjectJsonEntity buildNearEarthObjectEntity() {
        MissDistanceJsonEntity neo2015rcMissDistanceData =
                new MissDistanceJsonEntity();
        neo2015rcMissDistanceData.setAstronomical("0.016383252");
        neo2015rcMissDistanceData.setLunar("6.3730845451");
        neo2015rcMissDistanceData.setKilometers("2450899.5");
        neo2015rcMissDistanceData.setMiles("1522918.375");

        CloseApproachDataJsonEntity neo2015rcClosedApproachData =
                new CloseApproachDataJsonEntity();
        neo2015rcClosedApproachData.setOrbitingBody("Earth");
        neo2015rcClosedApproachData.setMissDistance(neo2015rcMissDistanceData);

        NearEarthObjectJsonEntity nearEarthObjectJsonEntity = new NearEarthObjectJsonEntity();
        nearEarthObjectJsonEntity.setName("(2015 RG2)");
        nearEarthObjectJsonEntity.setIsPotentiallyHazardousAsteroid(false);
        List<CloseApproachDataJsonEntity> closeApproachDataJsonEntities = new ArrayList<>();
        closeApproachDataJsonEntities.add(neo2015rcClosedApproachData);
        nearEarthObjectJsonEntity.setCloseApproachData(closeApproachDataJsonEntities);

        return nearEarthObjectJsonEntity;
    }

}
