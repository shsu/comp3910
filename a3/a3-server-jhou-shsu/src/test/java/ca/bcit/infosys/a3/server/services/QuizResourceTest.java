package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.logic.UserSession;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by shsu on 11/28/2013.
 */
public class QuizResourceTest {

    private static final String resourceURL = "http://localhost:8080/a3-server-jhou-shsu/quiz/";

    private static final Random random = new Random();

    private DefaultHttpClient httpClient;

    private JSONParser parser = new JSONParser();

    @Before
    public void setUp() throws Exception {
        httpClient = new DefaultHttpClient();
    }

    @Test
    public void testGetQuizForWeek() throws Exception {

        final long week = 1;
        final long total_quiz_questions = 5;

        HttpGet getRequest = new HttpGet(resourceURL + week);
        getRequest.setHeader("token", UserSession.TEST_TOKEN);
        HttpResponse response = httpClient.execute(getRequest);

        try {
            Object object = parser.parse(ParseResponseHelper.parseResponse(response));
            JSONArray jsonResponseArray = (JSONArray) object;
            assertEquals(total_quiz_questions, jsonResponseArray.size());

            for (Object array_item : jsonResponseArray) {
                JSONObject obj = (JSONObject) array_item;
                assertEquals(week, obj.get("week"));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNextQuiz() throws Exception {

        final long week = 4;

        HttpGet getRequest = new HttpGet(resourceURL + "next");
        getRequest.setHeader("token", UserSession.TEST_TOKEN);
        HttpResponse response = httpClient.execute(getRequest);

        try {
            Object object = parser.parse(ParseResponseHelper.parseResponse(response));
            JSONArray jsonResponseArray = (JSONArray) object;

            for (Object array_item : jsonResponseArray) {
                JSONObject obj = (JSONObject) array_item;
                assertEquals(week, obj.get("week"));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @After
    public void cleanUp() throws Exception {
        httpClient.getConnectionManager().shutdown();
    }
}
