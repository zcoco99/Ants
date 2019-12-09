import java.io.Serializable;
import java.util.ArrayList;

/*
The SubmitData class is used to collect the necessary data to be sent
to the servlet
*/

public class SubmitData implements Serializable {
    private ArrayList<ArrayList<Integer>> antData;
    private String videoID;
    private int frameID;

    public SubmitData(){
        getData();
    }

    public void getData() {
        antData = VideoPanel.getAntData();       //gets the ArrayList antData from VideoPanel
        videoID = "Video Submit Data1";
        frameID = 10;
        //videoID = videoIDReturn();
        //frameID = frameIDReturn();
    }
}
