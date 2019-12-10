import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class FBData {
    private ArrayList<ArrayList<Integer>> antData;
    private String videoID;
    private int frameID;
    private byte [] imageByte;
    private boolean fb;

    public ArrayList<ArrayList<Integer>> getAntData() {
        return antData;
    }

    public String getVideoID(){
        return videoID;
    }

    public int getFrameID(){
        return frameID;
    }

    public boolean getFB(){
        return fb;
    }

    public byte [] getImageByte(){return imageByte;}

    public void setVideoID(String videoID){
        this.videoID = videoID;
    }

    public void setFrameID(int frameID){
        this.frameID = frameID;
    }

    public void setFB(boolean fb){
        this.fb=fb;
    }

    public void setImageByte(byte [] imageByteInput){this.imageByte = imageByteInput;}
}

