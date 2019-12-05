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
        antData = VideoPanel.antDataReturn();       //gets the ArrayList antData from VideoPanel
        //videoID = videoIDReturn();
        //frameID = frameIDReturn();
    }
}
