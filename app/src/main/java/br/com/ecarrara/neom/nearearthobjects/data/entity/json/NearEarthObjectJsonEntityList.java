package br.com.ecarrara.neom.nearearthobjects.data.entity.json;

import java.util.List;

public class NearEarthObjectJsonEntityList {

    List<NearEarthObjectJsonEntity> nearEarthObjects;

    public NearEarthObjectJsonEntityList(List<NearEarthObjectJsonEntity> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }

    public List<NearEarthObjectJsonEntity> getNearEarthObjects() {
        return nearEarthObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NearEarthObjectJsonEntityList that = (NearEarthObjectJsonEntityList) o;

        return nearEarthObjects.equals(that.nearEarthObjects);

    }

    @Override
    public int hashCode() {
        return nearEarthObjects.hashCode();
    }
}
