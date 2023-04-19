/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author tonya
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

public class ProjectClass {
    public String fetchResponseFromAPI() throws IOException {
        try {
            // create URL object for the API endpoint
            URL url = new URL("https://ebay-sold-items-api.herokuapp.com/findCompletedItems");

            // create a connection object for the URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // set the request method and headers
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            // create the request body
            String requestBody = "{\"keywords\":\"iPhone\",\"excluded_keywords\":\"locked cracked case box read LCD face\",\"max_search_results\":\"240\",\"category_id\":\"9355\",\"remove_outliers\":true,\"site_id\":\"0\",\"aspects\":[{\"name\":\"Model\",\"value\":\"Apple iPhone X\"},{\"name\":\"LH_ItemCondition\",\"value\":\"3000\"},{\"name\":\"Network\",\"value\":\"Unlocked\"},{\"name\":\"Storage Capacity\",\"value\":\"256 GB\"}]}";

            // send the request body
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            os.close();

            // read the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // return the response
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String fetchAverageSellingPrice() throws IOException {
        return fetchResponseFromAPI();
    }
}
