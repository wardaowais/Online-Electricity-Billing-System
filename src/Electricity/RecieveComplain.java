/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class RecieveComplain extends JFrame implements ActionListener {

    JButton b1, b2;
    JTextField jm;
    JLabel l1, l11, l2, l12, l3, l13;
    Choice c1, c2;
    JTextArea des, print;
    static String[] value;

    RecieveComplain() {
        setBounds(500, 90, 800, 500);
        getContentPane().setBackground(new Color(250, 247, 159));
        setLayout(null);

        JLabel title = new JLabel("SEE YOUR COSTUMER COMPLAIN");
        title.setBounds(220, 0, 500, 40);
        title.setFont(new Font("Rockwell", Font.PLAIN, 20));
        add(title);

        //choice of meter number
        c1 = new Choice();
        c1.setBounds(220, 80, 130, 20);
        try {
            FileReader n = new FileReader("meter.txt");
            BufferedReader br = new BufferedReader(n);
            String line;
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                int len = value.length;
                for (int i = 0; i < len; i++) {
                    c1.add(value[i]);
                    

                }
                 add(c1);

            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

       

        l11 = new JLabel("Meter Number");
        l11.setBounds(70, 80, 100, 20);
        add(l11);

      

        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(280, 390, 100, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("View Complain");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(130, 390, 130, 25);
        b2.addActionListener(this);
        add(b2);

        //Print info
        print = new JTextArea();
        print.setFont(new Font("Dialog", Font.PLAIN, 16));
        print.setBounds(410, 70, 300, 360);
        add(print);
      
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/imc.jpg"));
        Image i3 = ic.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel li = new JLabel(icc3);
        li.setBounds(45, 130, 350, 250);
        add(li);

        
            

    }            public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b2){
            
              try {
                
                FileReader o = new FileReader("complain.txt");
                BufferedReader br = new BufferedReader(o);
                String line;
                

               String m = c1.getSelectedItem();

                while ((line = br.readLine()) != null) {
                     RecieveComplain.value = line.split(",");
                    if (m.equalsIgnoreCase(value[0])) {
                        
                        print.setText("\n   *******WASAF ElECTRICITY*******"+"\n\n   YOUR COSTUMER COMPLAIN"+"\n\n  Costumer Name:-  "+value[1]+"\n\n   Meter Number:-  "+value[0]+"\n\n   Complain type:-  "+value[2]+"\n\n    Description:-"+"\n\n       "+value[3]);
                     JOptionPane.showMessageDialog(null, "Click on ok button to empty your complain panel");
                    }
                     
                   
                }
                if(value[0]!=m){
                     print.setText("null");
                     
                     
                 }
                
                    
                 
                    
              
                    
                
              

                

            } catch (Exception e) {
            }

        }
        else if(ae.getSource()==b1){
            this.setVisible(false);
        }
        
        
    }
    

            public static void main(String[] args) {
                new RecieveComplain().setVisible(true);
            }
        }
