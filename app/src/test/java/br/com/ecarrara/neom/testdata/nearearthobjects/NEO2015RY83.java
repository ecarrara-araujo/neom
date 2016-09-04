package br.com.ecarrara.neom.testdata.nearearthobjects;

import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.CloseApproachDataJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.MissDistanceJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;

public class NEO2015RY83 {

    public static NearEarthObjectJsonEntity buildNearEarthObjectEntity() {
        MissDistanceJsonEntity neo2015rcMissDistanceData =
                new MissDistanceJsonEntity();
        neo2015rcMissDistanceData.setAstronomical("0.0764733268");
        neo2015rcMissDistanceData.setLunar("29.7481231689");
        neo2015rcMissDistanceData.setKilometers("11440247");
        neo2015rcMissDistanceData.setMiles("7108640");

        CloseApproachDataJsonEntity neo2015rcClosedApproachData =
                new CloseApproachDataJsonEntity();
        neo2015rcClosedApproachData.setOrbitingBody("Earth");
        neo2015rcClosedApproachData.setMissDistance(neo2015rcMissDistanceData);

        NearEarthObjectJsonEntity nearEarthObjectJsonEntity = new NearEarthObjectJsonEntity();
        nearEarthObjectJsonEntity.setName("(2015 RY83)");
        nearEarthObjectJsonEntity.setIsPotentiallyHazardousAsteroid(false);
        List<CloseApproachDataJsonEntity> closeApproachDataJsonEntities = new ArrayList<>();
        closeApproachDataJsonEntities.add(neo2015rcClosedApproachData);
        nearEarthObjectJsonEntity.setCloseApproachData(closeApproachDataJsonEntities);

        return nearEarthObjectJsonEntity;
    }

}
