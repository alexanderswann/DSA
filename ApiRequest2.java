import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.ProtocolException;

import java.net.URL;
/*
    1) https://developer.spotify.com/dashboard/applications
*/

public class ApiRequest2 {


    static final String CLIENTID = "42f6854dd8ed4408a4ad3a7b52303250";
    static final String CLIENTSECRET = "5a31444793994dc69698e047ddb8b380";
    static final String REDIRECTURL = "http://localhost"; //whiltelisted set inside spotify
    static final String url_auth =
    "https://accounts.spotify.com/authorize?"
    + "client_id="+CLIENTID+"&"
    + "response_type=code&"
    + "redirect_uri="+REDIRECTURL + "&scope=user-read-private%20user-read-email&state=34fFs29kd09";



    public static void MyGETRequest() throws IOException {
    //URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/1");
      URL urlForGetRequest = new URL(url_auth);
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    //conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
    int responseCode = conection.getResponseCode();


    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }

}

public static void POSTRequest() throws IOException {



    final String POST_PARAMS = "{\n" + "\"userId\": 101,\r\n" +
        "    \"id\": 101,\r\n" +
        "    \"title\": \"Test Title\",\r\n" +
        "    \"body\": \"Test Body\"" + "\n}";
    System.out.println(POST_PARAMS);
    URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("userId", "a1bcdefgh");
    postConnection.setRequestProperty("Content-Type", "application/json");


    postConnection.setDoOutput(true);
    OutputStream os = postConnection.getOutputStream();
    os.write(POST_PARAMS.getBytes());
    os.flush();
    os.close();


    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());

    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();

        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}

  public static void main(String[] args) throws IOException {
    //GetAndPost.
    MyGETRequest();
    System.out.println("________");
    //POSTRequest();
    // GetAndPost.MyPOSTRequest();
}




}
