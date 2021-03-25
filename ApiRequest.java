import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class ApiRequest {


  public ApiRequest(){

  }


  public static void main(String[] args){
    try {
    System.out.println("hello");
    String rawData = "id=10";
    String type = "application/json";
    //String encodedData = URLEncoder.encode( rawData, "UTF-8" );
    URL u = new URL("https://api.spotify.com/v1/tracks?ids=3n3Ppam7vgaVa1iaRUc9Lp%2C3twNvmDtFQtAd5gMKedhLD&market=Es");
    HttpURLConnection conn = (HttpURLConnection) u.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("GET");
    conn.setRequestProperty( "Accept", type );
    conn.setRequestProperty( "Authorization", "Bearer BQBXfrZvR3TjmtvXV22roKKYC_0V6yywTxH_vAP-UFS2nqqxULxCJPk1Tf2flxj5HQD1NghwheiXVs59M8LCQh5pP0HYv2Oh-ZIHLmcUox7FI55xJNuolyuL2Z85oT0n68dy5AYCFhao5n65QmvIOwsvMaGtJvZT7ODMiLUbWwIE7021QQS8UDJLuqEm1irfvL3CmAt-S8cwuPxvJUyM9gtH0RQ5FOYvV8VmKtx3YUoLrHzhTrtS6YU6GcWISodIYix6EMYrfHQQCRyYMXg" );
  //  conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));

    // Object os = conn.getContent();
    // System.out.println(conn.toString());

      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

      String output;
      System.out.println("Output from Server .... \n");
      while ((output = br.readLine()) != null) {
          System.out.println(output);
      }
      conn.disconnect();

  } catch (MalformedURLException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  }


  }
}
