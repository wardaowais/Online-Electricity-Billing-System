/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

/**
 *
 * @author lenovo
 */
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
        getContentPane().setBackground(Color.gray);
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
        c1.add("Costomer");
        c1.setBounds(400, 100, 150, 20);
        add(c1);

        //login button 
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(330, 160, 100, 20);
        add(b1);

        //cancel button 
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);

        //Signup button 
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("Signup", new ImageIcon(i4));
        b3.setBounds(380, 200, 130, 20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        
        //Side panel image:
        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        add(l3);
        
        //setting jframe visiblity:
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            try {
                String userName = tf1.getText();
                String password = pf2.getText();
                String line;
                FileReader fr = new FileReader("User.txt");
                BufferedReader br = new BufferedReader(fr);
                while ((line =br.readLine())!=null) {
                    String[] myWork = line.split(",");
                    if (myWork[0].equalsIgnoreCase(userName)) {
                        if (myWork[1].equalsIgnoreCase(password)) {

                            JOptionPane.showMessageDialog(null, "Login Success fully ");
                            if(c1.getSelectedItem()=="Costomer"){
                                new Costumer().setVisible(true);
                                this.setVisible(false);
                            }
                            else if (c1.getSelectedItem()=="Admin") 
                              {
                                  if(userName.equalsIgnoreCase("Warda")&&password.equalsIgnoreCase("0000")){
                                new Admin().setVisible(true);
                                this.setVisible(false);
                              }
                                  else{
                                                              JOptionPane.showMessageDialog(null, "Invalid Login");

                                      
                                  }
                            }
                            
                            

                        }
                        
                      
                    }
                    else{
                        if(userName!=myWork[0]){
                            

                        JOptionPane.showMessageDialog(null, "Invalid Login");
                        }
                        }
             

                }

            } catch (IOException e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new Account().setVisible(true);
        }
    }

    public static void main(String[] args) {
        Login o = new Login();
    }

}
