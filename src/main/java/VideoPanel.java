import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Objects;
import java.util.TimerTask;

public class VideoPanel extends JPanel {
    private static int[] frameID;
    private static JLabel picLabel;

    public VideoPanel(){
        setBackground(Color.black);
        setPreferredSize(new Dimension(200,100));
        setLayout(new BorderLayout());

        frameID = new int[2];
        frameID[0] = 1;
        frameID[1] = 1;

        picLabel = new JLabel();

        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                //System.out.println("Executed...");
                removeAll();
                loadFrame();
            }
        }, 500,500);

    }
    private void loadFrame() {

        //Initializing arrays to hold two path names
        String[] file_name = new String[frameID.length];
        String[] path = new String[frameID.length];
        ImageIcon[] pic = new ImageIcon[frameID.length];

        //1st image
        file_name[0]=String.format("%05d",frameID[0]);
        path[0]="./vid_1/" + file_name[0] + ".png";
        pic[0] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path[0])));

        //2nd image
        file_name[1]=String.format("%05d",frameID[1]);
        path[1]="./vid_1/" + file_name[1] + ".png";
        pic[1] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path[1])));

        //Overlay images
        BufferedImage overlay = new BufferedImage(pic[0].getIconWidth(), pic[1].getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = overlay.createGraphics();

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.drawImage(pic[0].getImage(), 0, 0, this);

        g.drawImage(pic[1].getImage(), 0, 0, this);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.99f));

        //Scaling overlaid images
        Image scaling = overlay.getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT);
        ImageIcon scaledImage = new ImageIcon(scaling);

        picLabel = new JLabel(scaledImage);
        add(picLabel);
        revalidate();
        repaint();
    }

    public void getPrevFrame(){

       frameID[1]=frameID[0];

       if(frameID[0]>1) {
           frameID[0] = frameID[0]-1;
       }
    }

    public void getNextFrame(){

        frameID[0]=frameID[1];

        if(frameID[1]<20) {
            frameID[1] = frameID[1] + 1;
        }

    };
}
