package preslm.simplewebviewapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class helper_httpsGetRequest {

    public String getWebsite(String urlAddress)throws IOException {
        URL url;
        HttpURLConnection connection;

        // Create connection
        url = new URL(urlAddress);
        StringBuilder response =new StringBuilder();
        connection = (HttpURLConnection) url.openConnection();
        if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()),8192);
            String strLine;
            while((strLine =input.readLine()) != null){
                response.append(strLine);
            }
            input.close();
        }
        return response.toString();
    }
}
