
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
//import org.json.*;
// import java.io.*;
// import java.lang.*;

public class SpotifyMain {

  	//static HashMap<String, String> new_artists = new HashMap<String, String>();
    static String CLIENTId = "42f6854dd8ed4408a4ad3a7b52303250";
    static String CLIENTSECREt = "90cf7eab479e4773945085484f3c2df4";
    static String refresh = "AQAzBYsvuKvMUj9bwTlghZal_d07EO9HHW4rblI-_aypVs31vJ89qdcHwwTmi0jfVJhQop9frRtilFFrFGaEU8-zdf9blr71qP8-BIWOzvgLxGY6pZi1ZGZWOSDqG7GrDmo";


  public SpotifyMain(){


  }




	

  public static String refresh() {

    String token = "";
    try {

      String url_refresh = "https://accounts.spotify.com/api/token?grant_type=refresh_token&refresh_token=AQAzBYsvuKvMUj9bwTlghZal_d07EO9HHW4rblI-_aypVs31vJ89qdcHwwTmi0jfVJhQop9frRtilFFrFGaEU8-zdf9blr71qP8-BIWOzvgLxGY6pZi1ZGZWOSDqG7GrDmo" + "&client_id=" + CLIENTId + "&client_secret=" + CLIENTSECREt;

      URL refresh_url = new URL(url_refresh);
      HttpURLConnection refresh_connection = (HttpURLConnection) refresh_url.openConnection();
      refresh_connection.setDoOutput(true);
      refresh_connection.setRequestMethod("POST");
      refresh_connection.setFixedLengthStreamingMode(0);
      refresh_connection.connect();
      BufferedReader br = new BufferedReader(new InputStreamReader((refresh_connection.getInputStream())));

      String output2 = "";

      String output;

      while ((output = br.readLine()) != null) {
        output2 += output;
      }
      token = output2.substring(17, output2.substring(17).indexOf('"') + 17);
      System.out.println(token);
      return token;
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return token;
  }

  public static void main(String[] args) {

    //String x = new refresh();

    System.out.println(refresh());

    //String w = playlistExtractor("5y9AXqJGIfei7r9oS9syYR?si=yFE0PtVATLS3sdLqmV5zBQ", refresh());

    //String x = playlistExtractor("55qG0AR6HJZDi0GrPgDy52");

    //       try {https://open.spotify.com/playlist/
    //
    //
    // } catch (MalformedURLException e) {
    //     e.printStackTrace();
    // } catch (IOException e) {
    //     e.printStackTrace();
    // }

    //
    // URL u = new URL("https://api.spotify.com/v1/me/");//top/tracks?time_range=short_term&limit=5");
    // HttpURLConnection conn4 = (HttpURLConnection) u.openConnection();
    // conn4.setDoOutput(true);
    // conn4.setRequestMethod("GET");
    // conn4.setRequestProperty("Accept", "application/json");
    // conn4.setRequestProperty("Authorization", "Bearer " + token);
    //
    // BufferedReader br2 = new BufferedReader(new InputStreamReader((conn4.getInputStream())));
    //
    // String output3;
    // System.out.println(u);
    // System.out.println("Output from Server .... \n");
    // while ((output3 = br2.readLine()) != null) {
    //     System.out.println(output3);
    // }
    //
    //
    //
    //
    //
    //
    // URL uq = new URL("https://dsa-app.herokuapp.com/v1/rec?id=4sydngGHk4bcNePUKfRgbH&auth=BQCqLD9goem2aEtktlZKuBJRE3EYQ2KVyapYp-zAO7neQuqwTfHSfswRZJBJm0e9_HcuFHb6vzJk3-9GIhIM14dcrV3el7BMnn_Pu5xJzH_HMFh2CojSsCYBmov4HF705lVkKjVnf0SmnnKnjNbPDE91YvEN5INNVEaVkEKYv0_DbLeCe7WGqWjWNwOLRcXj-qI6HEk9CDAb8ppJX6yqXRZEXHWxa8IWyCbvSHuaS1u_Z49dZZAUQ_ai4pCtIzI4WCC4iE9e3EDuANBzIl0qpWTJ8sk");//top/tracks?time_range=short_term&limit=5");
    // HttpURLConnection conn45 = (HttpURLConnection) uq.openConnection();
    // conn45.setDoOutput(true);
    // conn45.setRequestMethod("GET");
    // BufferedReader br25 = new BufferedReader(new InputStreamReader((conn45.getInputStream())));
    //
    // String output35;
    // System.out.println(u);
    // System.out.println("Output from Server .... \n");
    // while ((output35 = br25.readLine()) != null) {
    //     System.out.println(output35);
    // }

    //conn.disconnect();

  }

}
