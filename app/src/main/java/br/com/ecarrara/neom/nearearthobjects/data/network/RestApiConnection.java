package br.com.ecarrara.neom.nearearthobjects.data.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntityList;
import br.com.ecarrara.neom.nearearthobjects.data.entity.mapper.gson.NearEarthObjectListDeserializer;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiConnection {

    public static RestApiInterface connectoTo(String server) {
        RestApiConnection restApiConnection = new RestApiConnection(server);
        return restApiConnection.buildRestApiInterface();
    }

    private String serverBaseUrl;

    public RestApiConnection(String server) {
        serverBaseUrl = server;
    }

    private RestApiInterface buildRestApiInterface() {
        Retrofit retrofit = buildRetrofitClient(this.serverBaseUrl);
        return retrofit.create(RestApiInterface.class);
    }

    private Retrofit buildRetrofitClient(String serverBaseUrl) {
        return new Retrofit.Builder()
                .baseUrl(serverBaseUrl)
                .client(buildOkHttpClient())
                .addConverterFactory(buildGsonConverterFactory())
                .build();
    }

    private OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter(RestApiInterface.QUERY_PARAMETER_API_KEY,
                                RestApiInterface.NASA_NEOWS_API_KEY)
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }

    private Converter.Factory buildGsonConverterFactory() {
        Gson gson = new GsonBuilder()
                .setDateFormat(RestApiInterface.NASA_NEOWS_DATE_FORMAT)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(NearEarthObjectJsonEntityList.class,
                        new NearEarthObjectListDeserializer())
                .create();
        return GsonConverterFactory.create(gson);
    }

}
