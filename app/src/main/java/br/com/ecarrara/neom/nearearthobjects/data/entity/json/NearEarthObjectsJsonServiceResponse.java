package br.com.ecarrara.neom.nearearthobjects.data.entity.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearEarthObjectsJsonServiceResponse {
    @SerializedName("near_earth_objects")
    @Expose
    private NearEarthObjectJsonEntityList nearEarthObjectList;

    /**
     *
     * @return
     *     The nearEarthObjectList
     */
    public NearEarthObjectJsonEntityList getNearEarthObjectList() {
        return nearEarthObjectList;
    }

    /**
     *
     * @param nearEarthObjectList
     *     The near_earth_objects
     */
    public void setNearEarthObjectList(NearEarthObjectJsonEntityList nearEarthObjectList) {
        this.nearEarthObjectList = nearEarthObjectList;
    }
}
