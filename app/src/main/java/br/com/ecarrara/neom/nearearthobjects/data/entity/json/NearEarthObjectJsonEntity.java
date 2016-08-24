package br.com.ecarrara.neom.nearearthobjects.data.entity.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NearEarthObjectJsonEntity {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("is_potentially_hazardous_asteroid")
    @Expose
    private Boolean isPotentiallyHazardousAsteroid;

    @SerializedName("close_approach_data")
    @Expose
    private List<CloseApproachDataJsonEntity> closeApproachData = new ArrayList<>();

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The isPotentiallyHazardousAsteroid
     */
    public Boolean getIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    /**
     *
     * @param isPotentiallyHazardousAsteroid
     *     The is_potentially_hazardous_asteroid
     */
    public void setIsPotentiallyHazardousAsteroid(Boolean isPotentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
    }

    /**
     *
     * @return
     *     The closeApproachData
     */
    public List<CloseApproachDataJsonEntity> getCloseApproachData() {
        return closeApproachData;
    }

    /**
     *
     * @param closeApproachData
     *     The close_approach_data
     */
    public void setCloseApproachData(List<CloseApproachDataJsonEntity> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NearEarthObjectJsonEntity that = (NearEarthObjectJsonEntity) o;

        if (!name.equals(that.name)) return false;
        if (!isPotentiallyHazardousAsteroid.equals(that.isPotentiallyHazardousAsteroid))
            return false;
        return closeApproachData.equals(that.closeApproachData);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + isPotentiallyHazardousAsteroid.hashCode();
        result = 31 * result + closeApproachData.hashCode();
        return result;
    }
}
