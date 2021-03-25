import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.*;
import java.lang.*;

/*
    1) https://developer.spotify.com/dashboard/applications
*/

public class SpotifyMain {

    static final String CLIENTID = "42f6854dd8ed4408a4ad3a7b52303250";
    static final String CLIENTSECRET = "5a31444793994dc69698e047ddb8b380";
    static final String REDIRECTURL = "https://www.spotify.com/us/home/"; //whiltelisted set inside spotify

    public static void main(String[] args) {
        try {
            String url_auth =
            "https://accounts.spotify.com/authorize?"
            + "client_id="+CLIENTID+"&"
            + "response_type=code&"
            + "redirect_uri="+REDIRECTURL;

            System.out.println(url_auth);

            URL url = new URL(url_auth);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

          //  conn.setRequestProperty("Accept", "application/json");

            // if (conn.getResponseCode() != 200) {
            //     throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            // }

            // OutputStream os = conn.getOutputStream();
            // os.write(encodedData.getBytes());
            String cash = conn.getResponseMessage();
            System.out.println(cash);
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            //conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
