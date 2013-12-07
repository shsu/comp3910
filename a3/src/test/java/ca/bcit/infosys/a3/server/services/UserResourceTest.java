package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.logic.UserSession;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by shsu on 11/23/2013.
 */
public class UserResourceTest {

    private static final String resourceURL = "http://localhost:8080/a3-server-jhou-shsu/user/";

    private static final Random random = new Random();

    private DefaultHttpClient httpClient;

    private JSONParser parser = new JSONParser();

    @Before
    public void setUp() throws Exception {
        httpClient = new DefaultHttpClient();
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        HttpPost postRequest = new HttpPost(resourceURL + "authenticate");
        postRequest.setHeader("content-type", "application/json");

        JSONObject jsonRequestObject = new JSONObject();
        jsonRequestObject.put("username", "admin");
        jsonRequestObject.put("password", "admin");

        postRequest.setEntity(new StringEntity(jsonRequestObject.toJSONString()));
        HttpResponse response = httpClient.execute(postRequest);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusLine().getStatusCode());

        String token = null;

        try {
            Object object = parser.parse(ParseResponseHelper.parseResponse(response));//reusable
            JSONObject jsonResponseObject = (JSONObject) object;
            token = (String) jsonResponseObject.get("token");
            assertNotNull(token);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateUser() throws Exception {
        HttpPost postRequest = new HttpPost(resourceURL + "register");
        postRequest.setHeader("content-type", "application/json");

        String username = "user-" + random.nextInt();

        JSONObject jsonRequestObject = new JSONObject();
        jsonRequestObject.put("username", username);
        jsonRequestObject.put("password", "user");
        jsonRequestObject.put("studentNumber", "A00000000");
        jsonRequestObject.put("firstName", "user");
        jsonRequestObject.put("lastName", "user");

        postRequest.setEntity(new StringEntity(jsonRequestObject.toJSONString()));
        HttpResponse response = httpClient.execute(postRequest);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatusLine().getStatusCode());
    }

    @Test
    public void testCreateInvalidUser1() throws Exception {
        HttpPost postRequest = new HttpPost(resourceURL + "register");
        postRequest.setHeader("content-type", "application/json");

        JSONObject jsonRequestObject = new JSONObject();
        jsonRequestObject.put("username", "admin");
        jsonRequestObject.put("password", "admin");
        jsonRequestObject.put("studentNumber", "A00000000");
        jsonRequestObject.put("firstName", "admin");
        jsonRequestObject.put("lastName", "admin");

        postRequest.setEntity(new StringEntity(jsonRequestObject.toJSONString()));
        HttpResponse response = httpClient.execute(postRequest);

        assertEquals(Response.Status.CONFLICT.getStatusCode(), response.getStatusLine().getStatusCode());
    }

    @Test
    public void testCreateInvalidUser2() throws Exception {
        HttpPost postRequest = new HttpPost(resourceURL + "register");
        postRequest.setHeader("content-type", "application/json");

        JSONObject jsonRequestObject = new JSONObject();
        jsonRequestObject.put("username", "admin2");
        jsonRequestObject.put("password", "admin2");

        postRequest.setEntity(new StringEntity(jsonRequestObject.toJSONString()));
        HttpResponse response = httpClient.execute(postRequest);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatusLine().getStatusCode());
    }

    @Test
    public void testGetUser() throws Exception {
        HttpGet getRequest = new HttpGet(resourceURL + "profile");
        getRequest.setHeader("token", UserSession.TEST_TOKEN);
        HttpResponse response = httpClient.execute(getRequest);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusLine().getStatusCode());

        try {
            Object object = parser.parse(ParseResponseHelper.parseResponse(response));//reusable
            JSONObject jsonResponseObject = (JSONObject) object;
            String username = (String) jsonResponseObject.get("username");
            assertEquals("admin", username);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogout() throws Exception {
        HttpGet getRequest = new HttpGet(resourceURL + "logout");
        HttpResponse response = httpClient.execute(getRequest);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusLine().getStatusCode());
    }

    @After
    public void cleanUp() throws Exception {
        httpClient.getConnectionManager().shutdown();
    }

}
