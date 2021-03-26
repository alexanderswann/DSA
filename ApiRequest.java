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
    conn.setRequestProperty( "Authorization", "Bearer AQD0zrPkvbYTXoSUs34Zxq1RTpfDsar2uEvSDOc9lEnD2LY5o3a2dbkQemmvigVFyBxIhBu4mgC36W0wxeFIykY9xkXUKWfHNTU6P92siaF_OxdpzLX-WUnzseZzvqK6wwG5TeGB7Wca5r72E39878XCoN-KYnNHBAvqRec_o8HWFflAqQ16K5Iy4KJh79MeHAomU3vXT7Tk_ZImqmppzAAjTjXOkZwb" );
  //  conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
//https://www.spotify.com/us/home/?code=AQCmBnKOxs9xNxNyjZGiqfyH6fZl3K4CC9Q5Cu5kgvT4S7ZYK21jaeqJGrJ-AVXJ5jF0ftlAHkCiw9aCJqoSr74a-fWGGEXOr6thyKsZhSluia8vs_V-6FbHzsjwa44o3r7Yh9sHoRZ9SgHCByaCVny5RddVMooPomN91SbGKch2HIxU
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
