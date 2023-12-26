/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class ViewInformation extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField jm;
    JLabel l1,l11,l2,l12,l3,l13,l4,l14,l5,l15,l6,l16,l7,l17;
    

    ViewInformation(String meter) {
        setBounds(400, 100, 850, 700);
        getContentPane().setBackground(new Color(250, 247, 159));
        setLayout(null);

        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250, 0, 500, 40);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(70, 80, 100, 20);
        add(l1);

        l11 = new JLabel("");
        l11.setBounds(250, 80, 100, 20);
        add(l11);

        //meter 
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(70, 140, 100, 20);
        add(l2);
        
        
        //meter text Field
        jm = new JTextField("");
        jm.setBounds(170,140,100,20);
        add(jm);
        
        


        JLabel l3 = new JLabel("Address");
        l3.setBounds(70, 200, 100, 20);
        add(l3);

       l13 = new JLabel();
        l13.setBounds(250, 200, 100, 20);
        add(l13);

       l4 = new JLabel("City");
        l4.setBounds(70, 260, 100, 20);
        add(l4);

         l14 = new JLabel("");
        l14.setBounds(250, 260, 100, 20);
        add(l14);

         l5 = new JLabel("State");
        l5.setBounds(500, 80, 100, 20);
        add(l5);

        l15 = new JLabel("");
        l15.setBounds(650, 80, 100, 20);
        add(l15);

        l6 = new JLabel("Email");
        l6.setBounds(500, 140, 100, 20);
        add(l6);

       l16 = new JLabel("");
        l16.setBounds(650, 140, 150, 20);
        add(l16);

       l7 = new JLabel("Phone");
        l7.setBounds(500, 200, 100, 20);
        add(l7);

      l17 = new JLabel("");
        l17.setBounds(650, 200, 100, 20);
        add(l17);

        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 340, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton(" View Info");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(460, 340, 150, 25);
        b2.addActionListener(this);
        add(b2);
        
        
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(50, 350, 650, 300);
        add(l8);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            this.setVisible(false);
        }
        else if(ae.getSource()==b2){
           try {
            FileReader o = new FileReader("CostumerDetails.txt");
            BufferedReader br = new BufferedReader(o);
            String line;
            String n= jm.getText();
            
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                if (n.equalsIgnoreCase(value[0])) {
                    l11.setText(value[1]);
                    l13.setText(value[2]);
                    l14.setText(value[3]);
                    l15.setText(value[4]);
                    l16.setText(value[5]);
                    l17.setText(value[6]);

                }
               
            }

        } catch (Exception e) {
        }
 
        }
    }

    public static void main(String[] args) {
        new ViewInformation("").setVisible(true);
    }
}
