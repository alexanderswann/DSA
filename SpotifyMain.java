import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.lang.*;



public class SpotifyMain {

    static final String CLIENTID = "42f6854dd8ed4408a4ad3a7b52303250";
    static final String CLIENTSECRET = "90cf7eab479e4773945085484f3c2df4";
    static final String CLIENTIDQ = "NDJmNjg1NGRkOGVkNDQwOGE0YWQzYTdiNTIzMDMyNTA=";
    static final String CLIENTSECREQ = ":OTBjZjdlYWI0NzllNDc3Mzk0NTA4NTQ4NGYzYzJkZjQ=";
    static final String REDIRECTURL = "https://www.spotify.com/us/home/";
    static final String scopes = "%2cugc-image-upload%2cuser-read-recently-played%2cuser-top-read%2cuser-read-playback-position%2cuser-read-playback-state%2cuser-modify-playback-state%2cuser-read-currently-playing%2capp-remote-control%2cstreaming%2cplaylist-modify-public%2cplaylist-modify-private%2cplaylist-read-private%2cplaylist-read-collaborative%2cuser-follow-modify%2cuser-follow-read%2cuser-library-modify%2cuser-library-read%2c";
    static final String refresh = "AQAzBYsvuKvMUj9bwTlghZal_d07EO9HHW4rblI-_aypVs31vJ89qdcHwwTmi0jfVJhQop9frRtilFFrFGaEU8-zdf9blr71qP8-BIWOzvgLxGY6pZi1ZGZWOSDqG7GrDmo";

    public static void main(String[] args) {
        try {
            String url_auth =
                "https://accounts.spotify.com/authorize?" +
                "client_id=" + CLIENTID + "&" +
                "response_type=code&" +
                "redirect_uri=" + REDIRECTURL + "&scope=user-read-private%2cuser-read-email" + scopes + "&state=34fFs29kd09";

            String code;

            String url_code = "https://accounts.spotify.com/api/token?grant_type=authorization_code" + "&code=" + "AQCYpxlzwxtpiPpGE08Uk307T2wH0sZ8qLMNi_owGzSe2FFAVxN3jycnLOPHlGJyI_emdsho_b8EN-UxKZg32JL9MQRaavxjqqZY4dSLv5ebBKl-vBiYivxVi7v39DIE9mR7Aq6NvaoGjT0PGyKnPp-Un6XHw0nu_cHPRh4j1OUU79CIs-ldFQt1kASpn1kkX9bTB9rpLH4CyMzqY9rcmXMbyM-cKmVbbnhHVGpWbnxUpzwSEUpZ4CddFyB5l7htwgV0KrlUT0SbC-GXZ-zLb5_5UPCENPBtKaUtHFnCgGSvQ_qqvvjEbkoQRRbVj3fUE8ZyX2Gab4cB_rhefJAijOqSVIDQvCmjY2RbIowtGXDohJ1hgAtzybNC8NZGhYzzZj_eMq5Hmof06HQSrMOFhYZBR3Iu32zd3Gw6dZetPq9hw-pm4Sy5mUL9yqv3qKYEiTMloTFQ-eKQd88rDCa5wocT0ksbCvDgfkgxH_ENP22X6Xhc8gsgIa1VDsZOxtw0hShQw1YbpF284f-rAoHcUm-OzYZyE2mZ1dJ4cNXZz-FFez146JgRRs0PZIc2lyeZkehHOuPFCaUbO7UrdwmlTSEHjrhxootsgblCRA09fNOXR6tajL9Ku9RkzptY5avNG7YpFEP-V6xEsUjjkbxS0Z57LybQj4T_FtK1V4W8N0gCbaoHSgn0bfi_zobN9QD9N1D7bIIbO-YrrvxgMmpoZ1UbuWDCHQ" + "&redirect_uri=" + REDIRECTURL + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET;

            String url_refresh = "https://accounts.spotify.com/api/token?grant_type=refresh_token&refresh_token=AQAzBYsvuKvMUj9bwTlghZal_d07EO9HHW4rblI-_aypVs31vJ89qdcHwwTmi0jfVJhQop9frRtilFFrFGaEU8-zdf9blr71qP8-BIWOzvgLxGY6pZi1ZGZWOSDqG7GrDmo" + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET;

            System.out.println(url_auth);

            URL url = new URL(url_auth);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            URL url2 = new URL(url_code);
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
            conn2.setDoOutput(true);
            conn2.setRequestMethod("POST");
            conn2.setFixedLengthStreamingMode(0);

            conn2.connect();

            System.out.println(url2);




            URL url3 = new URL(url_refresh);
            HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
            conn3.setDoOutput(true);
            conn3.setRequestMethod("POST");
            conn3.setFixedLengthStreamingMode(0);
            //

            conn3.connect();


            String cash = conn3.getResponseMessage();
            System.out.println(cash);
            BufferedReader br = new BufferedReader(new InputStreamReader((conn3.getInputStream())));

            String output2 = "";
            String token = "";
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                output2 += output;
            }
            System.out.println(output2);

            token = output2.substring(17, output2.substring(17).indexOf('"') + 17);
            System.out.println(token);

            URL u = new URL("https://api.spotify.com/v1/me/");//top/tracks?time_range=short_term&limit=5");
            HttpURLConnection conn4 = (HttpURLConnection) u.openConnection();
            conn4.setDoOutput(true);
            conn4.setRequestMethod("GET");
            conn4.setRequestProperty("Accept", "application/json");
            conn4.setRequestProperty("Authorization", "Bearer " + token);

            BufferedReader br2 = new BufferedReader(new InputStreamReader((conn4.getInputStream())));

            String output3;
            System.out.println(u);
            System.out.println("Output from Server .... \n");
            while ((output3 = br2.readLine()) != null) {
                System.out.println(output3);
            }

            URL uq = new URL("https://dsa-app.herokuapp.com/v1/rec?id=4sydngGHk4bcNePUKfRgbH&auth=BQCqLD9goem2aEtktlZKuBJRE3EYQ2KVyapYp-zAO7neQuqwTfHSfswRZJBJm0e9_HcuFHb6vzJk3-9GIhIM14dcrV3el7BMnn_Pu5xJzH_HMFh2CojSsCYBmov4HF705lVkKjVnf0SmnnKnjNbPDE91YvEN5INNVEaVkEKYv0_DbLeCe7WGqWjWNwOLRcXj-qI6HEk9CDAb8ppJX6yqXRZEXHWxa8IWyCbvSHuaS1u_Z49dZZAUQ_ai4pCtIzI4WCC4iE9e3EDuANBzIl0qpWTJ8sk");//top/tracks?time_range=short_term&limit=5");
            HttpURLConnection conn45 = (HttpURLConnection) uq.openConnection();
            conn45.setDoOutput(true);
            conn45.setRequestMethod("GET");


            BufferedReader br25 = new BufferedReader(new InputStreamReader((conn45.getInputStream())));

            String output35;
            System.out.println(u);
            System.out.println("Output from Server .... \n");
            while ((output35 = br25.readLine()) != null) {
                System.out.println(output35);
            }

            //conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
