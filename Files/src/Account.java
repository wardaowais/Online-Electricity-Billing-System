/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */



import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class Account extends JFrame implements ActionListener {

    JPanel p1;
    JTextField tU, tN, tM, tP;
    Choice c1;
    JButton b1, b2;

  Account() {
        setBounds(600, 250, 700, 400);
        p1 = new JPanel();
        p1.setBounds(30, 30, 650, 300);
        p1.setLayout(null);
        p1.setBackground(Color.GRAY);
        p1.setForeground(new Color(34, 139, 34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 50, 100, 20);
        p1.add(l1);

        tU = new JTextField();
        tU.setBounds(260, 50, 150, 20);
        p1.add(tU);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(100, 90, 100, 20);
        p1.add(l2);

        tN = new JTextField();
        tN.setBounds(260, 90, 150, 20);
        p1.add(tN);

        JLabel l3 = new JLabel("Password");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(100, 130, 100, 20);
        p1.add(l3);

        tP = new JTextField();
        tP.setBounds(260, 130, 150, 20);
        p1.add(tP);

        JLabel l4 = new JLabel("Create Account As");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(100, 170, 140, 20);
        p1.add(l4);

        JLabel l5 = new JLabel("Meter Number");
        l5.setForeground(Color.DARK_GRAY);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(100, 210, 100, 20);
        l5.setVisible(false);
        p1.add(l5);

        tM = new JTextField();
        tM.setBounds(260, 210, 150, 20);
        tM.setVisible(false);
        p1.add(tM);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(260, 170, 150, 20);
        p1.add(c1);

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = c1.getSelectedItem();
                if (user.equals("Customer")) {
                    l5.setVisible(true);
                    tM.setVisible(true);
                } else {
                    l5.setVisible(false);
                    tM.setVisible(false);
                }
            }
        });

        b1 = new JButton("Create");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140, 290, 120, 30);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 290, 120, 30);
        b2.addActionListener(this);
        p1.add(b2);
//
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                
                

                String username = tU.getText();
                String name = tN.getText();
                String password = tP.getText();
                String user = c1.getSelectedItem();
                String meter = tM.getText();
                File myfile = new File("UserInfo.txt");
                myfile.createNewFile();
                FileWriter o = new FileWriter("UserInfo.txt",true);
                if(user=="Customer"){
                    o.write(username+" "+password+" "+user+" "+meter+" ");
                }
                else{
                    o.write(username+" "+password+" "+user);
                }
                o.close();
                
               

                /*Conn c = new Conn();
                String str = null;
                if(user.equals("Admin")){
                    str = "insert into login values('"+meter+"', '"+username+"', '"+name+"', '"+password+"', '"+user+"')";
                }else{
                    str = "update login set username = '"+username+"', name = '"+name+"', password = '"+password+"', user = '"+user+"' where meter_no = '"+tM.getText()+"'";
                }*/
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                //this.setVisible(false);
               // new Login().setVisible(true);
            } catch (Exception e) {

            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            //new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Account().setVisible(true);
        
    }
}