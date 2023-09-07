package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        String urlString = "https://api.zippopotam.us/us/33162";
        int responseCode = 0;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        httpURLConnection= (HttpURLConnection) url.openConnection();
        responseCode=httpURLConnection.getResponseCode();
        try{
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder apiData=new StringBuilder();
            String str="";
            while((str=bufferedReader.readLine())!=null){
                apiData.append(str);
            }
            bufferedReader.close();
            System.out.println(apiData);
        }catch(Exception e){

        }
    }
}