package br.com.ecarrara.neom.nearearthobjects.data.network;

import br.com.ecarrara.neom.BuildConfig;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectsJsonServiceResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApiInterface {

    String NASA_NEOWS_BASE_URL = "https://api.nasa.gov/neo/rest/v1/";
    String NASA_NEOWS_API_KEY = BuildConfig.NASA_NEOWS_API_KEY;
    String NASA_NEOWS_DATE_FORMAT = "yyyy-MM-dd";
    String QUERY_PARAMETER_API_KEY = "api_key";

    @GET("feed")
    Call<NearEarthObjectsJsonServiceResponse> nearEarthObjectBy(
            @Query("start_date") String startDate,
            @Query("end_date") String endDate
    );

}
