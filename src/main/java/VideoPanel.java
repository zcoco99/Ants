import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Objects;

public class VideoPanel extends JPanel {
    private static int frameID;
    private ImageIcon pic;
    private static JLabel picLabel;

    public VideoPanel(){
        setBackground(Color.black);
        setPreferredSize(new Dimension(700,500));
        setLayout(new BorderLayout());

        /*GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;*/

        //Initializing file name of frames
        frameID=1;
        String file_name=String.format("%05d",frameID);
        String path="./vid_1/" + file_name + ".png";

        System.out.println(getHeight());
        //System.out.println(getBounds().height);

        ImageIcon pic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));
        Image img = pic.getImage();//.getScaledInstance((int)getPreferredSize().getWidth(),(int)getPreferredSize().getHeight(),Image.SCALE_SMOOTH);
        //BufferedImage bi = new BufferedImage(img.getWidth(this),img.getHeight(this),BufferedImage.TYPE_INT_ARGB);
        //Graphics g = bi.createGraphics();
        //g.drawImage(img,0,0,this);
        ImageIcon scaledImage = new ImageIcon(img);
        picLabel = new JLabel(scaledImage);
        //picLabel.setSize(getWidth(),getHeight());
        add(picLabel);
    }
    private void pathName() {
        String file_name=String.format("%05d",frameID);
        String path="./vid_1/" + file_name + ".png";
        System.out.println(path);
        ImageIcon pic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));
        System.out.println(getHeight());
        Image img = pic.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(img);
        picLabel = new JLabel(scaledImage);
        add(picLabel);
        revalidate();
        repaint();
    }

    public void getPrevFrame(){
        remove(picLabel);
        if(frameID>50) {
            frameID = frameID - 50;
        }
        pathName();
    }

    public void getNextFrame(){
        remove(picLabel);
        frameID=frameID+50;
        pathName();
    };
}
