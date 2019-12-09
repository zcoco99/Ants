import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Objects;

// GridbagLayout for 4 video thumbnails
public class MenuList extends JPanel{
    private GridBagLayout vidlist; //video list
    private JButton vid1, vid2, vid3, vid4;
    int vidID;


    public MenuList(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        vidID = 1; // default open video 1
        // ImageIcon ant1 = new ImageIcon(getClass().getClassLoader().getResource("./ant1.png"));
        //int offset =  vid1.getInsets().left;
        //vid1.setIcon(resizeIcon(ant1,vid1.getWidth()-offset,vid1.getHeight()-offset));
        //vid1 = new JButton(ant1);
        vid1 = new JButton("video 1");
        vid2 = new JButton("video 2");
        vid3 = new JButton("video 3");
        vid4 = new JButton("video 4");

        // BufferedImage ant1 = new BufferedImage(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));

        // button layout
        c.fill = GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        add(vid1 ,c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        add(vid2 ,c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx=1;
        c.weighty=1;
        add(vid3 ,c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx=1;
        c.weighty=1;
        add(vid4 ,c);

        setSize(200,200);

        // Add button actions : return videoID
        vid1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vidID = 1;
                getVidID(vidID);
            }
        });

        vid2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vidID = 2;
                getVidID(vidID);
            }
        });

        vid3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vidID = 3;
                getVidID(vidID);
            }
        });

        vid4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vidID = 4;
                getVidID(vidID);
            }
        });


    }

    public int getVidID(int vidID){
        System.out.println(vidID);
        return vidID;
    }

    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

}
