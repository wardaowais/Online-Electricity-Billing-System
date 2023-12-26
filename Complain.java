/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Complain extends JFrame implements ActionListener {

    JButton b1, b2;
    JTextField jm;
    JLabel l1, l11, l2, l12, l3, l13;
    Choice c1, c2;
    JTextArea des, print;

    Complain() {
        setBounds(400, 100, 800, 500);
        getContentPane().setBackground(new Color(250, 247, 159));
        setLayout(null);

        JLabel title = new JLabel("ADMIT YOUR COMPLAIN");
        title.setBounds(250, 0, 500, 40);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);

        //choice of complain type
        c1 = new Choice();
        c1.setBounds(220, 80, 130, 20);
        c1.add("Connection issue");
        c1.add("Payment issue");
        c1.add("Meter issue");
        c1.add("load sheading");
        add(c1);

        l11 = new JLabel("Complain type");
        l11.setBounds(70, 80, 100, 20);
        add(l11);

        //meter 
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(70, 140, 100, 20);
        add(l2);

        //meter text Field
        jm = new JTextField("");
        jm.setBounds(220, 140, 130, 20);
        add(jm);

        //Description:
        l3 = new JLabel("Description");
        l3.setBounds(70, 200, 100, 20);
        add(l3);

        des = new JTextArea();
        des.setBounds(190, 200, 160, 150);
        add(des);

        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(280, 390, 100, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Submit");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150, 390, 100, 25);
        b2.addActionListener(this);
        add(b2);

        //Print info
        print = new JTextArea();
        print.setFont(new Font("Dialog", Font.PLAIN, 16));
        print.setBounds(410, 70, 300, 360);
        add(print);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
        } else if (ae.getSource() == b2) {
            try {
                /*File myfile = new File("complain.txt");
                myfile.createNewFile();*/
                FileWriter wri = new FileWriter("complain.txt",true);
                FileReader o = new FileReader("costumerDetails.txt");
                BufferedReader br = new BufferedReader(o);
                String line;

                String n = jm.getText();
//0..meter 1. name 2. address 3. state 4. city 5.email 6. phone 7. meter_location 8. meter_type 9.phase_code 10. bill_type 11.days 12. unit 13. month ;            
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    if (n.equalsIgnoreCase(value[0])) {
                        print.setText("\n   *******WASAF ElECTRICITY*******"+"\n\n        YOUR COMPLAIN"+"\n\n  Costumer Name:-  "+value[1]+"\n\n   Meter Number:-  "+jm.getText()+"\n\n   Complain type:-  "+c1.getSelectedItem()+"\n\n    Description:-"+"\n\n       "+des.getText());
                        JOptionPane.showMessageDialog(null, "Your Complain Has Sucessfully Recieved");
                       wri.write(jm.getText()+","+value[1]+","+c1.getSelectedItem()+","+des.getText()+"\n");
                       wri.close();
                    }

                }

            } catch (Exception e) {
            }

        }
    }

    public static void main(String[] args) {
        new Complain().setVisible(true);
    }
}
