package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.logic.UserSession;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by shsu on 11/25/2013.
 */
public class ResultResourceTest {

    private static final String resourceURL = "http://localhost:8080/a3-server-jhou-shsu/results/";

    private static final Random random = new Random();

    private DefaultHttpClient httpClient;

    private JSONParser parser = new JSONParser();

    @Before
    public void setUp() throws Exception {
        httpClient = new DefaultHttpClient();
    }

    @Test
    public void testGetResults() throws Exception {
        final long total_quiz_taken = 3;
        final double average = 0.8;

        HttpGet getRequest = new HttpGet(resourceURL);
        getRequest.setHeader("token", UserSession.TEST_TOKEN);
        HttpResponse response = httpClient.execute(getRequest);

        try {
            Object object = parser.parse(ParseResponseHelper.parseResponse(response));
            JSONObject jsonResponseObject = (JSONObject) object;

            JSONArray jsonResultsArray = (JSONArray) jsonResponseObject.get("results");
            assertEquals(total_quiz_taken, jsonResultsArray.size());
            assertEquals(average, jsonResponseObject.get("cumulativeAverage"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveResult() throws Exception {
        final int week = 4;

        HttpPost postRequest = new HttpPost(resourceURL + week);
        postRequest.setHeader("token", UserSession.TEST_TOKEN);
        postRequest.setHeader("content-type", "application/json");

        JSONObject jsonRequestObject = new JSONObject();
        jsonRequestObject.put("score", random.nextInt(100));
        jsonRequestObject.put("totalPossibleScore", 100);

        postRequest.setEntity(new StringEntity(jsonRequestObject.toJSONString()));

        HttpResponse response = httpClient.execute(postRequest);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatusLine().getStatusCode());
    }

    @Test
    public void testGetResult() throws Exception {
        final int week = 4;

        HttpGet getRequest = new HttpGet(resourceURL + week);
        getRequest.setHeader("token", UserSession.TEST_TOKEN);
        HttpResponse response = httpClient.execute(getRequest);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusLine().getStatusCode());
    }

    @After
    public void cleanUp() throws Exception {
        httpClient.getConnectionManager().shutdown();
    }
}
