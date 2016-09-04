package br.com.ecarrara.neom.testdata.nearearthobjects;

import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.CloseApproachDataJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.MissDistanceJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;

public class NEO2015RX83 {

    public static NearEarthObjectJsonEntity buildNearEarthObjectEntity() {
        MissDistanceJsonEntity neo2015rcMissDistanceData =
                new MissDistanceJsonEntity();
        neo2015rcMissDistanceData.setAstronomical("0.2895620437");
        neo2015rcMissDistanceData.setLunar("112.6396331787");
        neo2015rcMissDistanceData.setKilometers("43317864");
        neo2015rcMissDistanceData.setMiles("26916474");

        CloseApproachDataJsonEntity neo2015rcClosedApproachData =
                new CloseApproachDataJsonEntity();
        neo2015rcClosedApproachData.setOrbitingBody("Earth");
        neo2015rcClosedApproachData.setMissDistance(neo2015rcMissDistanceData);

        NearEarthObjectJsonEntity nearEarthObjectJsonEntity = new NearEarthObjectJsonEntity();
        nearEarthObjectJsonEntity.setName("(2015 RX83)");
        nearEarthObjectJsonEntity.setIsPotentiallyHazardousAsteroid(false);
        List<CloseApproachDataJsonEntity> closeApproachDataJsonEntities = new ArrayList<>();
        closeApproachDataJsonEntities.add(neo2015rcClosedApproachData);
        nearEarthObjectJsonEntity.setCloseApproachData(closeApproachDataJsonEntities);

        return nearEarthObjectJsonEntity;
    }

}
