import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField tf1;
    JTextField pf2;
    JButton b1, b2, b3;
    JPanel p1, p2, p3, p4;
    Choice c1;

    Login() {

        //Creating j frame:
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        setSize(640, 300);
        setLocation(600, 300);

        //username:
        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        tf1 = new JTextField(15);
        tf1.setBounds(400, 20, 150, 20);
        add(tf1);

        //Password
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);
        pf2 = new JTextField(15);
        pf2.setBounds(400, 60, 150, 20);
        add(pf2);

        //logging as:
        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        add(l4);
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400, 100, 150, 20);
        add(c1);

        //login button 
        b1 = new JButton("Login");
        b1.setBounds(330, 160, 100, 20);
        add(b1);

        //cancel button 
        b2 = new JButton("Cancel");
        b2.setBounds(450, 160, 100, 20);
        add(b2);

        //Signup button 
        b3 = new JButton("Signup");
        b3.setBounds(380, 200, 130, 20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        //setting jframe visiblity:
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            try {
                String userName = tf1.getText();
                String password = pf2.getText();

                File myfile = new File("User.txt");
                Scanner sc = new Scanner(myfile);
                while (sc.hasNextLine()) {
                    String data = sc.next();
                    String[] myWork = data.split(",");
                    if (myWork[0].equalsIgnoreCase(userName)) {
                        if(myWork[1].equalsIgnoreCase(password)){
                        
                        JOptionPane.showMessageDialog(null, "Login Success fully ");
                       
                        }
                     else if(myWork[0]!=userName) {
                        
                        JOptionPane.showMessageDialog(null, "Invalid account plaese sign up");
                    }
                    }

                }

            } catch (IOException e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            //new Splash();
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new CreateAccount().setVisible(true);
        }
    }

    public static void main(String[] args) {
        Login o = new Login();
    }

}
