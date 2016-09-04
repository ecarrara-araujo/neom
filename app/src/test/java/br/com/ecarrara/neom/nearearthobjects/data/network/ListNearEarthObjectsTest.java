package br.com.ecarrara.neom.nearearthobjects.data.network;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import br.com.ecarrara.neom.nearearthobjects.data.entity.json.NearEarthObjectJsonEntity;
import br.com.ecarrara.neom.testdata.nearearthobjectserviceresponses.TestServiceResponseFor20150907;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ListNearEarthObjectsTest {

    private List<NearEarthObjectJsonEntity> expectedNearEarthObjectJsonEntityList;
    private Date requestDate;
    private RestApi restApi;
    private MockWebServer server;

    @Before public void setUp() throws IOException {
        prepareExpectedTestData();
        server = new MockWebServer();
        server.enqueue(
                new MockResponse()
                        .setBody(TestServiceResponseFor20150907.getJson())
        );
        server.start();
        restApi = new RestApi(server.url("/").toString());
    }

    @After public void tearDown() throws IOException {
        server.shutdown();
    }

    private void prepareExpectedTestData() {
        requestDate = TestServiceResponseFor20150907.TEST_REQUEST_DATE;
        this.expectedNearEarthObjectJsonEntityList = TestServiceResponseFor20150907
                .TEST_RESPONSE.getNearEarthObjectList().getNearEarthObjects();
    }

    @Test
    public void testSuccessfulListNearEarthObjects() throws Exception {
        List<NearEarthObjectJsonEntity> nearEarthObjectJsonEntityList =
                restApi.listNearEarthObjectsFor(requestDate);

        assertThat(nearEarthObjectJsonEntityList,
                is(expectedNearEarthObjectJsonEntityList));
    }

}
