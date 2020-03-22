package com.example.brookesnutrition;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.brookesnutrition.ui.main.frag2.connection;


public class Food {
    private double calories;
    private double grams;
    private String name;




    public Food(String n){
        this.name = n;


    }

    public String getName(){
        return name;
    }

    public double getGrams(){
        return grams;
    }

    public Double getCalories(){
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://trackapi.nutritionix.com/v2/natural/nutrients");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setReadTimeout(10000);
                    connection.setConnectTimeout(15000);
                    connection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into “PUT”, “GET”, “DELETE” etc.
                    connection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    connection.setRequestProperty("x-app-id", "4e39bb2f");
                    connection.setRequestProperty("x-app-key", "0146ee08a7830b6a5afc79213bd8a0ba");
                    connection.connect();



                    JSONObject jsonObject3 = new JSONObject();
                    jsonObject3.put("query", name);
                    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                    wr.writeBytes(jsonObject3.toString());
                    wr.flush();
                    wr.close();
                    String json_response = "";
                    InputStreamReader in = new InputStreamReader(connection.getInputStream());
                    BufferedReader br = new BufferedReader(in);
                    String text2 = "";
                    while ((text2 = br.readLine()) != null) {
                        json_response += text2;
                    }
                    in.close();

                    JSONObject nutrition2 = new JSONObject(json_response);
                    JSONArray x = nutrition2.getJSONArray("foods");
                    String strcal = x.getJSONObject(0).getString("nf_calories");
                    calories = Double.parseDouble(strcal);







                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                finally{
                    connection.disconnect();
                }


            }


        });
        thread2.start();
        return calories;



    }
    public void setGrams(double g){
        this.grams = g;
    }
}
