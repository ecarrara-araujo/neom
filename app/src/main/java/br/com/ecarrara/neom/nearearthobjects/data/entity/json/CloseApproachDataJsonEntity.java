
package br.com.ecarrara.neom.nearearthobjects.data.entity.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloseApproachDataJsonEntity {

    @Expose
    private MissDistanceJsonEntity missDistance;
    @SerializedName("orbiting_body")
    @Expose
    private String orbitingBody;

    /**
     *
     * @return
     *     The missDistance
     */
    public MissDistanceJsonEntity getMissDistance() {
        return missDistance;
    }

    /**
     *
     * @param missDistance
     *     The miss_distance
     */
    public void setMissDistance(MissDistanceJsonEntity missDistance) {
        this.missDistance = missDistance;
    }

    /**
     *
     * @return
     *     The orbitingBody
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     *
     * @param orbitingBody
     *     The orbiting_body
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CloseApproachDataJsonEntity that = (CloseApproachDataJsonEntity) o;

        if (!missDistance.equals(that.missDistance)) return false;
        return orbitingBody.equals(that.orbitingBody);

    }

    @Override
    public int hashCode() {
        int result = missDistance.hashCode();
        result = 31 * result + orbitingBody.hashCode();
        return result;
    }
}