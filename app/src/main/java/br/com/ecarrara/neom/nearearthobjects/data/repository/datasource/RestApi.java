package br.com.ecarrara.neom.nearearthobjects.data.repository.datasource;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectsJsonServiceResponse;
import br.com.ecarrara.neom.nearearthobjects.data.network.RestApiConnection;
import br.com.ecarrara.neom.nearearthobjects.data.network.RestApiInterface;
import retrofit2.Call;

import static br.com.ecarrara.neom.utils.formatters.DateFormatter.formatDate;

public class RestApi {

    private RestApiInterface restApiInterface;

    public RestApi(String serverBaseUrl) {
        this.restApiInterface = RestApiConnection.connectoTo(serverBaseUrl);
    }

    public List<NearEarthObjectJsonEntity> listNearEarthObjectsFor(Date requestDate)
            throws IOException {

        List<NearEarthObjectJsonEntity> nearEarthObjectJsonEntities;

        Call<NearEarthObjectsJsonServiceResponse> call =
                restApiInterface.nearEarthObjectBy(
                        formatDate(requestDate, RestApiInterface.NASA_NEOWS_DATE_FORMAT),
                        formatDate(requestDate, RestApiInterface.NASA_NEOWS_DATE_FORMAT));

        retrofit2.Response<NearEarthObjectsJsonServiceResponse> serviceExecutionResponse =
                call.execute();

        if(serviceExecutionResponse.isSuccessful()) {
            nearEarthObjectJsonEntities =
                    serviceExecutionResponse.body().getNearEarthObjectList().getNearEarthObjects();
        } else {
            throw new RuntimeException();
        }

        return nearEarthObjectJsonEntities;
    }
}
