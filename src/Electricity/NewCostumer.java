package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class NewCostumer extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l111;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    String name,
            meter,
            address,
            state,
            city,
            email,
            phone;
    JButton b1, b2;

    NewCostumer() {
        setLocation(600, 200);
        setSize(700, 500);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(250, 247, 159));

        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);

        l1 = new JLabel("Customer Name");
        l1.setBounds(100, 80, 100, 20);

        t1 = new JTextField();
        t1.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        l2.setBounds(100, 120, 100, 20);
        l111 = new JLabel();
        l111.setBounds(240, 120, 200, 20);
        p.add(l2);
        p.add(l111);
        l3 = new JLabel("Address");
        l3.setBounds(100, 160, 100, 20);
        t3 = new JTextField();
        t3.setBounds(240, 160, 200, 20);
        p.add(l3);
        p.add(t3);
        l5 = new JLabel("City");
        l5.setBounds(100, 200, 100, 20);
        t5 = new JTextField();
        t5.setBounds(240, 200, 200, 20);
        p.add(l5);
        p.add(t5);
        l4 = new JLabel("State");
        l4.setBounds(100, 240, 100, 20);
        t4 = new JTextField();
        t4.setBounds(240, 240, 200, 20);
        p.add(l4);
        p.add(t4);

        l6 = new JLabel("Email");
        l6.setBounds(100, 280, 100, 20);
        t6 = new JTextField();
        t6.setBounds(240, 280, 200, 20);
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        l7.setBounds(100, 320, 100, 20);
        t7 = new JTextField();
        t7.setBounds(240, 320, 200, 20);
        p.add(l7);
        p.add(t7);

        b1 = new JButton("Next");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());

        add(p, "Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);

        add(l8, "West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l111.setText("" + Math.abs(first));

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            name = t1.getText();
            meter = l111.getText();
            address = t3.getText();
            state = t4.getText();
            city = t5.getText();
            email = t6.getText();
            phone = t7.getText();

            try {

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                this.setVisible(false);
                new MeterInfo(meter).setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    //Inner class
    public class MeterInfo extends JFrame implements ActionListener {

        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
        Choice c1, c2, c3, c4, c5;
        JButton b1, b2;
        String meter_location, meter_type, phase_code, bill_type, days;

        MeterInfo(String m) {
            setLocation(600, 200);
            setSize(700, 500);

            JPanel p = new JPanel();
            p.setLayout(null);
            p.setBackground(new Color(250, 247, 159));

            JLabel title = new JLabel("Meter Information");
            title.setBounds(180, 10, 200, 26);
            title.setFont(new Font("Tahoma", Font.PLAIN, 24));
            p.add(title);

            l1 = new JLabel("Meter Number");
            l1.setBounds(100, 80, 100, 20);

            l11 = new JLabel(meter);
            l11.setBounds(240, 80, 200, 20);
            p.add(l1);
            p.add(l11);

            l2 = new JLabel("Meter Location");
            l2.setBounds(100, 120, 100, 20);
            c1 = new Choice();
            c1.add("Outside");
            c1.add("Inside");
            c1.setBounds(240, 120, 200, 20);
            p.add(l2);
            p.add(c1);

            l3 = new JLabel("Meter Type");
            l3.setBounds(100, 160, 100, 20);
            c2 = new Choice();
            c2.add("Electric Meter");
            c2.add("Solar Meter");
            c2.add("Smart Meter");
            c2.setBounds(240, 160, 200, 20);
            p.add(l3);
            p.add(c2);

            l5 = new JLabel("Phase Code");
            l5.setBounds(100, 200, 100, 20);
            c3 = new Choice();
            c3.add("011");
            c3.add("022");
            c3.add("033");
            c3.add("044");
            c3.add("055");
            c3.add("066");
            c3.add("077");
            c3.add("088");
            c3.add("099");
            c3.setBounds(240, 200, 200, 20);
            p.add(l5);
            p.add(c3);

            l4 = new JLabel("Bill Type");
            l4.setBounds(100, 240, 100, 20);
            c4 = new Choice();
            c4.add("Normal");
            c4.add("Industrial");
            c4.setBounds(240, 240, 200, 20);
            p.add(l4);
            p.add(c4);

            l6 = new JLabel("Days");
            l6.setBounds(100, 280, 100, 20);

            l9 = new JLabel("30 Days");
            l9.setBounds(240, 280, 200, 20);
            p.add(l6);
            p.add(l9);

            l7 = new JLabel("Note");
            l7.setBounds(100, 320, 100, 20);
            l10 = new JLabel("By Default Bill is calculated for 30 days only");
            l10.setBounds(240, 320, 300, 20);
            p.add(l7);
            p.add(l10);

            b1 = new JButton("Next");
            b1.setBounds(120, 390, 100, 25);
            b2 = new JButton("Cancel");
            b2.setBounds(250, 390, 100, 25);

            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);

            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);

            p.add(b1);
            p.add(b2);
            setLayout(new BorderLayout());

            add(p, "Center");

            ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
            Image i3 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
            ImageIcon ic2 = new ImageIcon(i3);
            l8 = new JLabel(ic2);

            add(l8, "West");
            //for changing the color of the whole Frame
            getContentPane().setBackground(Color.WHITE);

            b1.addActionListener(this);
            b2.addActionListener(this);
        }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == b1) {

                meter_location = c1.getSelectedItem();
                meter_type = c2.getSelectedItem();
                phase_code = c3.getSelectedItem();
                bill_type = c4.getSelectedItem();
                days = "30";
                try {

                    JOptionPane.showMessageDialog(null, "Meter Info Added Successfully");
                    this.setVisible(false);
                   new  RBillDetails(meter).setVisible(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (ae.getSource() == b2) {
                this.setVisible(false);
            }
        }

        public class RBillDetails extends JFrame implements ActionListener {

            JLabel l1, l2, l3, l11, l4;
            Choice c1;
            JTextField lu;
            JButton b1, b2;

            RBillDetails(String meter) {
                setLocation(600, 200);
                setSize(700, 500);

                JPanel p = new JPanel();
                p.setLayout(null);
                p.setBackground(new Color(250, 247, 159));

                JLabel title = new JLabel("BILL DETAILS");
                title.setBounds(180, 10, 200, 26);
                title.setFont(new Font("Tahoma", Font.PLAIN, 24));
                p.add(title);

                l1 = new JLabel("Meter Number");
                l1.setBounds(100, 80, 100, 20);

                l11 = new JLabel();
                l11.setBounds(240, 80, 200, 20);
                p.add(l1);
                p.add(l11);

                l2 = new JLabel("Month");
                l2.setBounds(100, 140, 100, 20);
                c1 = new Choice();
                c1.add("January");
                c1.add("Febuary");
                c1.add("March");
                c1.add("April");
                c1.add("May");
                c1.add("June");
                c1.add("July");
                c1.add("August");
                c1.add("September");
                c1.add("Octuber");
                c1.add("November");
                c1.add("December");

                c1.setBounds(240, 140, 140, 20);
                p.add(l2);
                p.add(c1);

                l3 = new JLabel("Units consumed");
                l3.setBounds(100, 200, 100, 20);
                lu = new JTextField();
                lu.setBounds(240, 200, 140, 20);
                p.add(l3);
                p.add(lu);

                b1 = new JButton("Submit");
                b1.setBounds(120, 390, 100, 25);
                b2 = new JButton("Cancel");
                b2.setBounds(250, 390, 100, 25);

                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);

                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.WHITE);

                p.add(b1);
                p.add(b2);
                setLayout(new BorderLayout());

                add(p, "Center");

                ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/billd.jpg"));
                Image i3 = ic1.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
                ImageIcon ic2 = new ImageIcon(i3);
                l4 = new JLabel(ic2);

                add(l4, "West");
                //for changing the color of the whole Frame
                getContentPane().setBackground(Color.WHITE);

                b1.addActionListener(this);
                b2.addActionListener(this);
            }

            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == b1) {
                    String unit = l11.getText();
                    String month = c1.getSelectedItem();

                    try {
                        /*File o = new File("meter.txt");
                        o.createNewFile();*/
                        FileWriter j = new FileWriter("meter.txt",true);
                        j.write(meter+",");
                        j.close();
                        FileWriter i = new FileWriter("CostumerDetails.txt", true);
                        i.write(meter + "," + name + "," + address + "," + state + "," + city + "," + email + "," + phone + "," + meter_location + "," + meter_type + "," + phase_code + "," + bill_type + "," + days + "," + unit + "," + month + "\n");
                        i.close();
                        JOptionPane.showMessageDialog(null, "Bill Details Added Successfully");
                        this.setVisible(false);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (ae.getSource() == b2) {
                    this.setVisible(false);
                }

            }
        }

    }

    public static void main(String[] args) {
        new NewCostumer().setVisible(true);

    }
}
