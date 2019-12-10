package panels;

import data_transfer.FBData;
import data_transfer.TalkServlet;
import panels.ButtonPanel;

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
The panels.VideoPanel class is a JPanel that is used to display the frames of the
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
    private FBData dataFB;

    public VideoPanel(){
        //System.out.println("Video panel constructor called");
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
        //System.out.println("loadFrame() called");
        /*ImageIcon[] pic = new ImageIcon[frameID.length];

        pic[0] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./vid_1/" + String.format("%05d",frameID[0]) + ".png")));
        pic[1] = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./vid_1/" + String.format("%05d",frameID[1]) + ".png")));
        */

        BufferedImage inputImage = convertImageByte();
        /*BufferedImage inputImage2 = new BufferedImage(inputImage, BufferedImage.TYPE_INT_ARGB);
        System.out.println("Input image:");
        System.out.println(inputImage);
        data_transfer.TalkServlet.setFBState(false);*/

        /*BufferedImage inputImage=new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        byte[] imageBytes = ((DataBufferByte) inputImage.getData().getDataBuffer()).getData();
        System.out.println(imageBytes);*/

        /*BufferedImage overlay = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = overlay.createGraphics();

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        g.drawImage(inputImage,0,0,this);

        g.drawImage(inputImage,0,0,this);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.99f));*/

        //System.out.println(getWidth());
        //Graphics2D g = inputImage.createGraphics();
        //g.drawImage(inputImage,0,0,this);
        //ImageIcon scaledImage = new ImageIcon(inputImage);//.getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));


        //JLabel picLabel = new JLabel(scaledImage);
        //add(picLabel);
        revalidate();
        repaint();
    }

    public BufferedImage convertImageByte(){
        //System.out.println("convert() called");
        BufferedImage bImage = null;
        //if(data_transfer.TalkServlet.getFBState()){
            dataFB = TalkServlet.getFBData();
            //System.out.println("VidPanel: ");
            //System.out.println(Arrays.toString(dataFB.getImageByte()));
            ByteArrayInputStream bis = new ByteArrayInputStream(dataFB.getImageByte());
            try {
                bImage = ImageIO.read(bis);
                /*ImageIO.write(bImage,"png",new File("testpicture.png"));
                System.out.println("Image created");*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        //}
        return bImage;
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
