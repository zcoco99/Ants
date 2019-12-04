import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Objects;

public class VideoPanel extends JPanel {
    private static int frameID;
    private ImageIcon pic;
    private static JLabel picLabel;

    public VideoPanel(){
        setBackground(Color.black);
        setSize(800,700);
        frameID=1;
        String file_name=String.format("%05d",frameID);
        String path="./vid_1/" + file_name + ".png";
        ImageIcon pic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));
        Image img = pic.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(img);
        picLabel = new JLabel(scaledImage);
        add(picLabel);
    }

    public void getNextFrame(){
        remove(picLabel);
        frameID=frameID+50;
        String file_name=String.format("%05d",frameID);
        String path="./vid_1/" + file_name + ".png";
        System.out.println(path);
        ImageIcon pic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));
        Image img = pic.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(img);
        picLabel = new JLabel(scaledImage);
        add(picLabel);
        revalidate();
        repaint();
    };
}
