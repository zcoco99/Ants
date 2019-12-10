import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Username extends JFrame
{

    //Variables to be used in all functions
    private JButton startbtn;
    private JLabel greet;
    private JTextField username;
    private Font font = new Font("Comic Sans MS",NORMAL, 30);
    private VideoMenu vidMenu;
    static String user1;

    public Username(){
        user1 = new String();
        greet = new JLabel("<html> Welcome to Ants GUI <br/>Enter your name</html>");
        // greet.setFont(font);

        startbtn = new JButton("Start");
        // startbtn.setFont(font);

        username = new JTextField();
        username.setPreferredSize((new Dimension(100,20)));
        username.setFont(font);

        setLayout(new GridBagLayout());


        // Action: get username when user press start button
        ActionListener whatsmyname = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1 = username.getText();
                nameReturn(); // print user input on terminal
            }
        };

        // add components
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.FIRST_LINE_START;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx= 1;
        c.weighty= 2;
        add(greet ,c);
        greet.setHorizontalAlignment(JLabel.CENTER);  // center align JLabel header

        c.gridx = 1;
        c.gridy = 1;
        c.weightx= 1;
        c.weighty= 1;
        add(username ,c);

        c.gridx = 1;
        c.gridy = 4;
        c.weightx= 1;
        c.weighty= 1;
        add(startbtn ,c);

        // add action to button
        startbtn.addActionListener(whatsmyname); // username will be
        vidMenu = new VideoMenu();
        startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                add(vidMenu,c);
                revalidate();
                repaint();
            }
        });  // open new menu frame

        setVisible(true);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String nameReturn(){
        System.out.println(user1);
        return user1;
    } //returns username

}