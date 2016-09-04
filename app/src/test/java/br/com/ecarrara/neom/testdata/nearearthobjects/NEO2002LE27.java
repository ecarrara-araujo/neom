package br.com.ecarrara.neom.testdata.nearearthobjects;

import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.CloseApproachDataJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.MissDistanceJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;

public class NEO2002LE27 {

    public static NearEarthObjectJsonEntity buildNearEarthObjectEntity() {
        MissDistanceJsonEntity neo2015rcMissDistanceData =
                new MissDistanceJsonEntity();
        neo2015rcMissDistanceData.setAstronomical("0.4981688399");
        neo2015rcMissDistanceData.setLunar("193.7876739502");
        neo2015rcMissDistanceData.setKilometers("74525000");
        neo2015rcMissDistanceData.setMiles("46307684");

        CloseApproachDataJsonEntity neo2015rcClosedApproachData =
                new CloseApproachDataJsonEntity();
        neo2015rcClosedApproachData.setOrbitingBody("Earth");
        neo2015rcClosedApproachData.setMissDistance(neo2015rcMissDistanceData);

        NearEarthObjectJsonEntity nearEarthObjectJsonEntity = new NearEarthObjectJsonEntity();
        nearEarthObjectJsonEntity.setName("440012 (2002 LE27)");
        nearEarthObjectJsonEntity.setIsPotentiallyHazardousAsteroid(false);
        List<CloseApproachDataJsonEntity> closeApproachDataJsonEntities = new ArrayList<>();
        closeApproachDataJsonEntities.add(neo2015rcClosedApproachData);
        nearEarthObjectJsonEntity.setCloseApproachData(closeApproachDataJsonEntities);

        return nearEarthObjectJsonEntity;
    }

}
