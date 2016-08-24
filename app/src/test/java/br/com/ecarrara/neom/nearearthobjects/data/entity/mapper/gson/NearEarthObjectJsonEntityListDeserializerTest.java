package br.com.ecarrara.neom.nearearthobjects.data.entity.mapper.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntityList;
import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectsJsonServiceResponse;
import br.com.ecarrara.neom.testdata.nearearthobjectlists.TestNearEarthObjectListWithOneNearEarthObject;
import br.com.ecarrara.neom.testdata.nearearthobjectlists.TestNearEarthObjectListWithTwoNearEarthObjects;
import br.com.ecarrara.neom.testdata.nearearthobjectlists.TestNearEarthObjectListWithThreeNearEarthObjects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NearEarthObjectJsonEntityListDeserializerTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TestNearEarthObjectListWithOneNearEarthObject.getJson(),
                        TestNearEarthObjectListWithOneNearEarthObject.TEST_RESPONSE},
                {TestNearEarthObjectListWithTwoNearEarthObjects.getJson(),
                        TestNearEarthObjectListWithTwoNearEarthObjects.TEST_RESPONSE},
                {TestNearEarthObjectListWithThreeNearEarthObjects.getJson(),
                        TestNearEarthObjectListWithThreeNearEarthObjects.TEST_RESPONSE}
        });
    }

    private NearEarthObjectsJsonServiceResponse expectedParsedObject;
    private String jsonServiceResponseToDeserialize;
    private static Gson gson;

    public NearEarthObjectJsonEntityListDeserializerTest(
            String jsonServiceResponseToDeserialize,
            NearEarthObjectsJsonServiceResponse expectedResultingParsedObject) {

        this.jsonServiceResponseToDeserialize = jsonServiceResponseToDeserialize;
        this.expectedParsedObject = expectedResultingParsedObject;

    }

    @BeforeClass
    public static void setUp() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(
                NearEarthObjectJsonEntityList.class,
                new NearEarthObjectListDeserializer()
        );
        gson = gsonBuilder
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Test
    public void testNearEarthObjectsSuccessfulDeserialization() {
        NearEarthObjectJsonEntityList nearEarthObjectList = gson.fromJson(
                this.jsonServiceResponseToDeserialize,
                NearEarthObjectJsonEntityList.class
        );

        assertThat(nearEarthObjectList, is(this.expectedParsedObject.getNearEarthObjectList()));

    }

}