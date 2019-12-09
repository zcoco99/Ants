import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/*
The TalkServlet class is used to establish a connection with the
servlet and to submit the ant data to the servlet using POST
*/

public class TalkServlet {
    private static ArrayList<ArrayList<Integer>> antData;

    static void makeGetRequest(){
        try {
            URL myURL = new URL("http://localhost:8080/AntsServlet/mainpage");
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");

            BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void postSubmit(){
        SubmitData submitData = new SubmitData();
        Gson gson = new Gson();
        String jsonString = gson.toJson(submitData);
        byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);

        HttpURLConnection conn = null;
        try{
            URL myURL = new URL("http://localhost:8080/AntsServlet/mainpage");
            conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            conn.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(body,0,body.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void postFBData(){
        //next button clicked
        HttpURLConnection conn = null;
        try{
            URL myURL = new URL("http://localhost:8080/AntsServlet/FBpage");
            conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            conn.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //send current videoID and frame to server
        FBData sendFBData = new FBData();
        sendFBData.setFrameID(1);
        sendFBData.setVideoID("Video FBData");
        Gson sendGson = new Gson();
        String jsonString = sendGson.toJson(sendFBData);
        byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);

        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(body,0,body.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //get videoID and frame from server
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String inputLine;
            while((inputLine = bufferedReader.readLine()) != null) {
                Gson inputGson = new Gson();
                FBData dataFB = inputGson.fromJson(inputLine, FBData.class);
                System.out.println("Ant data:");
                System.out.println(dataFB.getAntData());
                System.out.println("Video ID:");
                System.out.println(dataFB.getVideoID());
                System.out.println("Frame ID:");
                System.out.println(dataFB.getFrameID());
                System.out.println("Image Byte:");
                System.out.println(dataFB.getImageByte());
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void postXianData(){
        String videoID = "vid_1";
        byte[] body = videoID.getBytes(StandardCharsets.UTF_8);

        HttpURLConnection conn = null;
        try{
            //change URL to correct page
            URL myURL = new URL("http://localhost:8080/AntsServlet/landingpage");
            conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            conn.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(body,0,body.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String inputLine;
            while((inputLine = bufferedReader.readLine()) != null) {
                Gson inputGson = new Gson();
                LandingData landingData = inputGson.fromJson(inputLine, LandingData.class);
                System.out.println("Ant data:");
                System.out.println(landingData.getAntData());
                System.out.println("Video ID:");
                System.out.println(landingData.getVideoID());
                System.out.println("Frame ID:");
                System.out.println(landingData.getFrameID());
                System.out.println("Image Byte:");
                System.out.println(landingData.getImageByte());
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    static void postInit(){

        String initString = "Hi init page";
        byte[] body = initString.getBytes(StandardCharsets.UTF_8);

        ArrayList<InitData> initDataArrayList = new ArrayList<InitData>();

        HttpURLConnection conn = null;
        try{
            //change URL to correct page
            URL myURL = new URL("http://localhost:8080/AntsServlet/init");
            conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            conn.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(body,0,body.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String inputLine;
            while((inputLine = bufferedReader.readLine()) != null) {

                Gson inputGson = new Gson();
                initDataArrayList = inputGson.fromJson(inputLine, ArrayList.class);
            }

            System.out.println(initDataArrayList);

            System.out.println(initDataArrayList.get(0).getVideoID());

            System.out.println("test1");

            for(InitData i : initDataArrayList){
                i.printInitData();
            }



            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    public TalkServlet(){
        //postSubmit();
        //postFBData();
    }
}
