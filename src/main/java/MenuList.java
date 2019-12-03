import javax.swing.*;
import java.awt.*;

// GridbagLayout for 4 video thumbnails
public class MenuList extends JPanel{
    JPanel menupan;
    GridLayout vidlist; //video list
    JButton vid1, vid2, vid3, vid4;

    public MenuList(){
        menupan = new JPanel();
        vidlist = new GridLayout(2,2);
        vid1 = new JButton("video 1");
        vid2 = new JButton("video 2");
        vid3 = new JButton("video 3");
        vid4 = new JButton("video 4");

        menupan.add(vid1);
        menupan.add(vid2);
        menupan.add(vid3);
        menupan.add(vid4);
        menupan.setSize(200,200);




    }

}
