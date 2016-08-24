package br.com.ecarrara.neom.testdata.nearearthobjects;

import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.CloseApproachDataJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.MissDistanceJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;

public class NEO2015RC {

    public static NearEarthObjectJsonEntity buildNearEarthObjectEntity() {
        MissDistanceJsonEntity neo2015rcMissDistanceData =
                new MissDistanceJsonEntity();
        neo2015rcMissDistanceData.setAstronomical("0.0269024393");
        neo2015rcMissDistanceData.setLunar("10.46504879");
        neo2015rcMissDistanceData.setKilometers("4024547.75");
        neo2015rcMissDistanceData.setMiles("2500738");

        CloseApproachDataJsonEntity neo2015rcClosedApproachData =
                new CloseApproachDataJsonEntity();
        neo2015rcClosedApproachData.setOrbitingBody("Earth");
        neo2015rcClosedApproachData.setMissDistance(neo2015rcMissDistanceData);

        NearEarthObjectJsonEntity nearEarthObjectJsonEntity = new NearEarthObjectJsonEntity();
        nearEarthObjectJsonEntity.setName("(2015 RC)");
        nearEarthObjectJsonEntity.setIsPotentiallyHazardousAsteroid(false);
        List<CloseApproachDataJsonEntity> closeApproachDataJsonEntities = new ArrayList<>();
        closeApproachDataJsonEntities.add(neo2015rcClosedApproachData);
        nearEarthObjectJsonEntity.setCloseApproachData(closeApproachDataJsonEntities);

        return nearEarthObjectJsonEntity;
    }

}
