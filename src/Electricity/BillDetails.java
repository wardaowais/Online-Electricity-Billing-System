/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class BillDetails extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField jm;
    JLabel l1,l11,l2,l12,l3,l13,l4,l14,l5,l15,l8;
    

   BillDetails() {
        setBounds(400, 100, 800, 500);
        getContentPane().setBackground(new Color(250, 247, 159));
        setLayout(null);

        JLabel title = new JLabel("YOUR BILL INFORMATION");
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
        jm.setBounds(250,140,100,20);
        add(jm);
        
        


        JLabel l3 = new JLabel("Month");
        l3.setBounds(70, 200, 100, 20);
        add(l3);

       l13 = new JLabel();
        l13.setBounds(250, 200, 100, 20);
        add(l13);

       l4 = new JLabel("Unit Consumed");
        l4.setBounds(70, 260, 100, 20);
        add(l4);

         l14 = new JLabel("");
        l14.setBounds(250, 260, 100, 20);
        add(l14);

         l5 = new JLabel("Bill Type");
        l5.setBounds(70, 320, 100, 20);
        add(l5);

        l15 = new JLabel("");
        l15.setBounds(250 ,320, 100, 20);
        add(l15);

        
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(280, 390, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton(" View Info");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150, 390, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
        
        

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(340, 70, 500, 360);
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
//0..meter 1. name 2. address 3. state 4. city 5.email 6. phone 7. meter_location 8. meter_type 9.phase_code 10. bill_type 11.days 12. unit 13. month ;            
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                if (n.equalsIgnoreCase(value[0])){
                    l11.setText(value[1]);
                    l13.setText(value[13]);
                    l14.setText(value[12]);
                    l15.setText(value[10]);
                }
               
            }

        } catch (Exception e) {
        }
 
        }
    }

    public static void main(String[] args) {
        new BillDetails().setVisible(true);
    }
}


