import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/*
The VideoPanel class is a JPanel that is used to display the frames of the
video. The panel also has a mouse listener to track the coordinates of the
ant, which is then stored in an ArrayList called antData
*/

/*
Add the check for the case when button is removed, remove that from antData too
*/

public class VideoPanel extends JPanel {
    private static ArrayList<ArrayList<Integer>> antData = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> individualAntData;
    private int buttonID;
    private static int[] frameID;


    public VideoPanel(){
        System.out.println("Video panel constructor called");
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(200,113));
        setLayout(new BorderLayout());

        frameID = new int[2];
        frameID[0] = 1;
        frameID[1] = 1;

        ArrayList<Integer> init = new ArrayList<Integer>();
        init.add(0);
        antData.add(init);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                removeAll();
                loadFrame();
            }
        }, 500,500);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean flag;
                int index=0;

                int x_coordinate;
                int y_coordinate;
                x_coordinate = e.getPoint().x;
                y_coordinate = e.getPoint().y;

                individualAntData = new ArrayList<Integer>();

                if(ButtonPanel.getLastButton()!=null) {
                    buttonID = Integer.parseInt(ButtonPanel.getLastButton().getText());

                    fillIndividualAntData(individualAntData, buttonID, x_coordinate, y_coordinate);

                    flag=false;
                    for(int i=0; i<antData.size(); i++){
                        if(individualAntData.get(0) == antData.get(i).get(0)) {
                            flag=true;
                            index=i;
                        }
                    }

                    if(flag){
                        antData.set(index, individualAntData);
                    }
                    else{
                        antData.add(individualAntData);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static ArrayList<ArrayList<Integer>> getAntData() {
        //antData.remove(0);
        //antData.remove(0);
        return antData;
    }

    public void fillIndividualAntData(ArrayList<Integer> individualAntData, int buttonID, int x_coordinate, int y_coordinate){
        individualAntData.add(buttonID);
        individualAntData.add(x_coordinate);
        individualAntData.add(y_coordinate);
    }

    private void loadFrame(){
        ImageIcon[] pic = new ImageIcon[frameID.length];

        pic[0] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./vid_1/" + String.format("%05d",frameID[0]) + ".png")));
        pic[1] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./vid_1/" + String.format("%05d",frameID[1]) + ".png")));

        BufferedImage overlay = new BufferedImage(pic[0].getIconWidth(), pic[1].getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = overlay.createGraphics();

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        g.drawImage(pic[0].getImage(),0,0,this);

        g.drawImage(pic[1].getImage(),0,0,this);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.99f));

        ImageIcon scaledImage = new ImageIcon(overlay.getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));

        JLabel picLabel = new JLabel(scaledImage);
        add(picLabel);
        revalidate();
        repaint();
    }

    static void getPrevFrame(){
        frameID[1]=frameID[0];
        if(frameID[0]>1){
            frameID[0] = frameID[0]-1;
        }
    }

    static void getNextFrame(){
        frameID[0] = frameID[1];
        if(frameID[1]<20){
            frameID[1]=frameID[1]+1;
        }
    }
}
