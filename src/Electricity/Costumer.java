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
import javax.swing.*;

public class Costumer extends JFrame implements ActionListener {

    JButton ja, jl, jh, je, jb, jv, jbi, jg, jc, jm, jp;
    JLabel l1, l2, l3;

    Costumer() {

        super("Electricity Billing System");

        //title 
        l2 = new JLabel("COSTUMER");
        l2.setBounds(410, 40, 600, 60);
        l2.setFont(new Font("Bodoni MT Black", Font.ITALIC, 50));
        l2.setForeground(Color.white);
        add(l2);

        //SIGN UP 
        ja = new JButton("Sign Up ");
        ja.setBounds(970, 40, 100, 30);
        add(ja);
        ja.setBackground(Color.gray);
        ja.setForeground(Color.white);

        //Sign in
        jl = new JButton("Sign In");
        jl.setBounds(1090, 40, 100, 30);
        add(jl);
        jl.setBackground(Color.gray);
        jl.setForeground(Color.white);

        //Home 
        jh = new JButton("Home");
        jh.setBounds(1210, 40, 100, 30);
        add(jh);
        jh.setBackground(Color.gray);
        jh.setForeground(Color.white);

        //Exit
        je = new JButton("Exit");
        je.setBounds(1200, 620, 100, 30);
        add(je);
        je.setBackground(Color.red);
        je.setForeground(Color.black);

        //Back
        jb = new JButton("Back");
        jb.setBounds(1080, 620, 100, 30);
        add(jb);
        jb.setBackground(Color.black);
        jb.setForeground(Color.white);

        //View Information
        jv = new JButton("View Informations ");
        jv.setBounds(70, 190, 200, 38);
        add(jv);
        jv.setBackground(new Color(24, 73, 70));
        jv.setForeground(Color.white);
        jv.setFont(new Font("Lucida Sans", Font.ITALIC, 18));

        //Bill details
        jbi = new JButton("Bill Details");
        jbi.setBounds(70, 290, 200, 38);
        add(jbi);
        jbi.setBackground(new Color(24, 73, 70));
        jbi.setForeground(Color.white);
        jbi.setFont(new Font("Lucida Sans", Font.ITALIC, 18));

        //Geanerate bill  229, 225, 165
        jg = new JButton("Generate bill");
        jg.setBounds(70, 390, 200, 38);
        add(jg);
        jg.setBackground(new Color(24, 73, 70));
        jg.setForeground(Color.white);
        jg.setFont(new Font("Lucida Sans", Font.ITALIC, 18));

        //Meter Detail 
        jm = new JButton("Meter Details");
        jm.setBounds(320, 190, 200, 38);
        add(jm);
        jm.setBackground(new Color(24, 73, 70));
        jm.setForeground(Color.white);
        jm.setFont(new Font("Lucida Sans", Font.ITALIC, 18));

        //Complain
        jc = new JButton("Admit complain");
        jc.setBounds(320, 290, 200, 38);
        add(jc);
        jc.setBackground(new Color(24, 73, 70));
        jc.setForeground(Color.white);
        jc.setFont(new Font("Lucida Sans", Font.ITALIC, 18));

        //Pay bill
        jp = new JButton("Pay Bill");
        jp.setBounds(320, 390, 200, 38);
        add(jp);
        jp.setBackground(new Color(24, 73, 70));
        jp.setForeground(Color.white);
        jp.setFont(new Font("Lucida Sans", Font.ITALIC, 18));

        //lable 
        l2 = new JLabel("This Project Is Presented By ");
        l2.setFont(new Font("Dialog", Font.ITALIC, 30));
        l2.setForeground(Color.white);
        l2.setBounds(50, 560, 800, 60);
        add(l2);

        l3 = new JLabel("JINNAH UNIVERSITY ENGINEER");
        l3.setFont(new Font("Dialog", Font.ITALIC, 30));
        l3.setForeground(Color.white);
        l3.setBounds(300, 600, 500, 90);
        add(l3);

        /* Adding background image */
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/cos10.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1500, 780, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);

        //set size and visiiblity
        setVisible(true);
        setSize(1500, 800);

        ja.addActionListener(this);
        jl.addActionListener(this);
        je.addActionListener(this);
        jh.addActionListener(this);
        jb.addActionListener(this);

        jv.addActionListener(this);
        jc.addActionListener(this);
        jbi.addActionListener(this);
        jp.addActionListener(this);
        jg.addActionListener(this);
        jm.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jl) {
            //sign in
            new Login().setVisible(true);
        } else if (e.getSource() == je) {
            //exit
            this.dispose();

        } else if (e.getSource() == ja) {
            //sign up
            new Account().setVisible(true);
        } else if (e.getSource() == jb) {
            //back
            new Project().setVisible(true);
        } else if (e.getSource() == jh) {
            //home
            new Project().setVisible(true);
        } else if (e.getSource() == jv) {
            //view info
            new ViewInformation("").setVisible(true);
        } else if (e.getSource() == jbi) {
            //bill info
           new BillDetails().setVisible(true);
        } else if (e.getSource() == jg) {
            //generate
            new GenerateBill().setVisible(true);
        } else if (e.getSource() == jm) {
            //meter
            new MeterDetails().setVisible(true);
        } else if (e.getSource() == jp) {
            //payment
            new Payment().setVisible(true);
        } else if (e.getSource() == jc) {
            //complain
            new Complain().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Costumer().setVisible(true);
    }

}
