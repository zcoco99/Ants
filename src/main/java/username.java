import javax.swing.*;
import java.awt.*;

public class username extends JFrame
{
    //Variables to be used in all functions
    JTextField namefield;
    JButton startbtn;
    JLabel greet;
    JTextPane user1;

    public username(){
        namefield = new JTextField(20);
        startbtn = new JButton("Start");
        greet = new JLabel("<html>Enter your name</html>");
        user1 = new JTextPane();

        // add components
        add(greet);
        add(namefield);

        //add(user1);

        // anonymous inner class of ActionListener
        /* ActionListener startAction = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                String name1 = namefield.getText();
                user1.setText("Welcome "+name1);
                new homeframe();
            }
        }; */

        // add actions for button
        startbtn.addActionListener(actionEvent -> new VideoMenu());
        add(startbtn);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
