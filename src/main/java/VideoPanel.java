import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

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
    int buttonID;
    private static int[] frameID;
    private static JLabel picLabel;


    public VideoPanel(){
        System.out.println("Video panel constructor called");
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(200,100));
        setLayout(new BorderLayout());

        frameID = new int[2];
        frameID[0] = 1;
        frameID[1] = 1;

        //picLabel = new JLabel();

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
        //System.out.println("loadFrame() called");
        /*ImageIcon[] pic = new ImageIcon[frameID.length];

        pic[0] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./vid_1/" + String.format("%05d",frameID[0]) + ".png")));
        pic[1] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./vid_1/" + String.format("%05d",frameID[1]) + ".png")));
        */
        convertImageByte();
        /*BufferedImage inputImage = convertImageByte();

        BufferedImage overlay = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = overlay.createGraphics();

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        g.drawImage(inputImage,0,0,this);

        g.drawImage(inputImage,0,0,this);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.99f));

        ImageIcon scaledImage = new ImageIcon(overlay.getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));

        picLabel = new JLabel(scaledImage);
        add(picLabel);
        revalidate();
        repaint();*/
    }

    public /*BufferedImage*/ void convertImageByte(/*byte[] imageByte*/){
        /*System.out.println("convertImage() called");
        //System.out.println(imageByte);
        BufferedImage bImage = null;
        byte[] imageData = FBData.getImageByte();
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        try {
            bImage = ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //return bImage;
        //System.out.println("VidPanel dataFB:");
        //System.out.println(TalkServlet.getFBData().getFrameID());
        //byte[] imageByte = TalkServlet.getFBData().getImageByte();
        //System.out.println("Image byte:");
        //System.out.println(Arrays.toString(imageByte));
        if(TalkServlet.getFBState()){
            System.out.println("VidPanel: ");
            System.out.println(TalkServlet.getFBData().getFrameID());
        }
        TalkServlet.setFBState(false);
    }

    public static void getPrevFrame(){
        frameID[1]=frameID[0];
        if(frameID[0]>1){
            frameID[0] = frameID[0]-1;
        }
    }

    public static void getNextFrame(){
        frameID[0] = frameID[1];
        if(frameID[1]<20){
            frameID[1]=frameID[1]+1;
        }
    }
}
