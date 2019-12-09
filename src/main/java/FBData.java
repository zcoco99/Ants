import java.util.ArrayList;

public class FBData {
    private ArrayList<ArrayList<Integer>> antData;
    private String videoID;
    private int frameID;
    private byte [] imageByte;

    public ArrayList<ArrayList<Integer>> getAntData() {
        return antData;
    }

    public String getVideoID(){
        return videoID;
    }

    public int getFrameID(){
        return frameID;
    }

    public byte [] getImageByte(){return this.imageByte;}

    public void setVideoID(String videoID){
        this.videoID = videoID;
    }

    public void setFrameID(int frameID){
        this.frameID = frameID;
    }

    public void setImageByte(byte [] imageByteInput){this.imageByte = imageByteInput;}

}
