/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
package Electricity;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
       
       JButton je, jl ,ja,jb,jv,jbi,jg,jc,jm,jp;
       JLabel l1,l2,l3;
        
      Project(){
       
        super("Electricity Billing System");
        
        
        //title 
        l1= new JLabel("WELCOME TO WASAF ELECTRICITY");
        l1.setBounds(410, 4,600,50);
        l1.setFont(new Font("Algerian",Font.BOLD,30));
        l1.setForeground(new Color(135, 111, 15));
        getContentPane().setBackground(new Color(222, 197, 95));
        add(l1);
        
        //SIGN UP 
        ja = new JButton("Sign Up ");
        ja.setBounds(900,100,100,30);
        add(ja);
        
        //Sign in
        jl=new JButton("Sign In");
        jl.setBounds(1020,100,100,30);
        add(jl);
        
        
     
        
        
        
       
        
        //Exit 
        je= new JButton("Exit");
        je.setBounds(1140,100,100,30);
        add(je);
        
        
        //About 
        jb = new JButton("About Project");
        jb.setBounds(1200 ,620,130,30);
        add(jb);
        jb.setBackground(Color.gray);
        jb.setForeground(Color.white);
        
         //lable 
        l2=new JLabel("This Project Is Presented By ");
        l2.setFont(new Font("Dialog",Font.ITALIC,30));
        l2.setForeground(Color.white);
        l2.setBounds(50,560,800,60);
        add(l2);
        
        l3 = new JLabel("JINNAH UNIVERSITY ENGINEER");
        l3.setFont(new Font("Dialog",Font.ITALIC,30));
        l3.setForeground(Color.white);
        l3.setBounds(300,600,500,90);
        add(l3);
         
        
        setSize(1920,1030);
        
        
        
        /* Adding background image */
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/my.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1550, 610, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        setVisible(true);
        
        ja.addActionListener(this);
        jl.addActionListener(this);
        je.addActionListener(this);
        jb.addActionListener(this);
        
        
    }
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==jl){
              new Login().setVisible(true);
          }
          else if(e.getSource()==je){
           this.dispose();
            
              
          }
          else if(e.getSource()==ja){
              new Account().setVisible(true);
          }
          else if(e.getSource()==jb){
              new About().setVisible(true);
          }
          
        
          
      }
      public static void main(String[] args){
        new Project().setVisible(true);
    }

   
}