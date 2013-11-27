package ca.bcit.infosys.a3.server.services;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shsu on 11/25/2013.
 */
public class ParseResponseHelper {

    public static String parseResponse(final HttpResponse response) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String outputLine;

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            while ((outputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(outputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
