import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* ASDLKFJSAD;LKFJSAD;LKJFSAD;LKFJDSA;LFKJ
* */

public class username extends JFrame
{
    //Variables to be used in all functions
    private JButton startbtn;
    private JLabel greet;
    private JTextField username;
    static String user1;

    public username(){
        user1 = new String();
        startbtn = new JButton("Start");
        greet = new JLabel("<html> Welcome to Ants GUI <br/>Enter your name</html>");
        username = new JTextField();
        username.setPreferredSize((new Dimension(100,20)));


        // add components
        add(greet);
        add(username);

        // Action: get username when user press start button
        ActionListener whatsmyname = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1 = username.getText();
                System.out.println(user1);  // print user input on terminal
            }
        };
        startbtn.addActionListener(whatsmyname);


        // add action to button
        startbtn.addActionListener(actionEvent -> new VideoMenu(user1));
        add(startbtn);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static String nameReturn(){
        return user1;
    } //returns username

}
