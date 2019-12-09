import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Objects;
import java.util.TimerTask;

public class VideoPanel extends JPanel {
    private static int frameID =0;
    private ImageIcon pic;
    private static JLabel picLabel;

    public VideoPanel(){
        setBackground(Color.black);
        setPreferredSize(new Dimension(200,100));
        setLayout(new BorderLayout());

        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                //System.out.println("Executed...");
                removeAll();
                loadFrame();
            }
        }, 500,500);


    }
    private void pathName() {
        String file_name=String.format("%05d",frameID);
        String path="./vid_1/" + file_name + ".png";
        System.out.println(path);
        ImageIcon pic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));
        //System.out.println(getHeight());
        //System.out.println(getWidth());
        Image img = pic.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT);
        ImageIcon scaledImage = new ImageIcon(img);
        picLabel = new JLabel(scaledImage);
        add(picLabel);
        revalidate();
        repaint();
    }

    private void loadFrame(){
        if(frameID==0) {
            frameID = 1;
        }
        pathName();
    }
    public void getPrevFrame(){
        remove(picLabel);
        if(frameID>50) {
            frameID = frameID - 50;
        }
        //pathName();
    }

    public void getNextFrame(){
        remove(picLabel);
        if(frameID<451) {
            frameID = frameID + 50;
        }
    };
}
