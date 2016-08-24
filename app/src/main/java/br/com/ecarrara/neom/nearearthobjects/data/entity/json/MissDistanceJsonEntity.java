
package br.com.ecarrara.neom.nearearthobjects.data.entity.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MissDistanceJsonEntity {

    @SerializedName("astronomical")
    @Expose
    private String astronomical;
    @SerializedName("lunar")
    @Expose
    private String lunar;
    @SerializedName("kilometers")
    @Expose
    private String kilometers;
    @SerializedName("miles")
    @Expose
    private String miles;

    /**
     *
     * @return
     *     The astronomical
     */
    public String getAstronomical() {
        return astronomical;
    }

    /**
     *
     * @param astronomical
     *     The astronomical
     */
    public void setAstronomical(String astronomical) {
        this.astronomical = astronomical;
    }

    /**
     *
     * @return
     *     The lunar
     */
    public String getLunar() {
        return lunar;
    }

    /**
     *
     * @param lunar
     *     The lunar
     */
    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    /**
     *
     * @return
     *     The kilometers
     */
    public String getKilometers() {
        return kilometers;
    }

    /**
     *
     * @param kilometers
     *     The kilometers
     */
    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    /**
     *
     * @return
     *     The miles
     */
    public String getMiles() {
        return miles;
    }

    /**
     *
     * @param miles
     *     The miles
     */
    public void setMiles(String miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissDistanceJsonEntity that = (MissDistanceJsonEntity) o;

        if (!astronomical.equals(that.astronomical)) return false;
        if (!lunar.equals(that.lunar)) return false;
        if (!kilometers.equals(that.kilometers)) return false;
        return miles.equals(that.miles);

    }

    @Override
    public int hashCode() {
        int result = astronomical.hashCode();
        result = 31 * result + lunar.hashCode();
        result = 31 * result + kilometers.hashCode();
        result = 31 * result + miles.hashCode();
        return result;
    }
}