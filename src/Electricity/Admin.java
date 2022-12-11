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



public class Admin extends JFrame implements ActionListener{
      
       JButton ja,jl,jh,je,jb,jvc,jac,jg,jvcom;
       JLabel l1,l2,l3;
        
      Admin(){
       
        super("Electricity Billing System");
        
        
        //title 
        l2= new JLabel("ADMIN");
        l2.setBounds(410, 40,600,60);
        l2.setFont(new Font("Bodoni MT Black",Font.ITALIC,50));
        l2.setForeground(Color.white);
        add(l2);
        
        
        //SIGN UP 
        ja = new JButton("Sign Up ");
        ja.setBounds(970,40,100,30);
        add(ja);
         ja.setBackground(Color.gray);
        ja.setForeground(Color.white);
        
        
        
        
        //Sign in
        jl=new JButton("Sign In");
        jl.setBounds(1090,40,100,30);
        add(jl);
         jl.setBackground(Color.gray);
        jl.setForeground(Color.white);
        
        
        //Home 
        jh= new JButton("Home");
        jh.setBounds(1210,40,100,30);
        add(jh);
        jh.setBackground(Color.gray);
        jh.setForeground(Color.white);
        
        
        //Exit
        je = new JButton("Exit");
        je.setBounds(1200 ,620,100,30);
        add(je);
        je.setBackground(Color.red);
        je.setForeground(Color.black);
        
        //Back
        jb = new JButton("Back");
        jb.setBounds(1080 ,620,100,30);
        add(jb);
        jb.setBackground(Color.black);
        jb.setForeground(Color.white);
        
        
        //View Costumer
        jvc=new JButton("View Costumer ");
        jvc.setBounds(200,200,200,43);
        add(jvc);
       jvc.setBackground(new Color( 24, 73, 70));
       jvc.setForeground(Color.white);
        jvc.setFont(new Font("Lucida Sans",Font.ITALIC,20));
        
        //Add Costumer
        jac = new JButton("Add costumer");
       jac.setBounds(70,280,200,43);
        add(jac);
      jac.setBackground(new Color( 24, 73, 70));
        jac.setForeground(Color.white);
      jac.setFont(new Font("Lucida Sans",Font.ITALIC,20));
       
        
        //Geanerate bill 
        jg = new JButton("Generate bill");
        jg.setBounds(300,280,200,43);
        add(jg);
        jg.setBackground(new Color( 24, 73, 70));
        jg.setForeground(Color.white);
        jg.setFont(new Font("Lucida Sans",Font.ITALIC,20));
        
        //View Complains  
        jvcom = new JButton("View Complains");
       jvcom.setBounds(200,360,200,43);
        add(jvcom);
       jvcom.setBackground(new Color( 24, 73, 70));
      jvcom.setForeground(Color.white);
       jvcom.setFont(new Font("Lucida Sans",Font.ITALIC,20));
        
        
        
        
        
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
         
        
       
        
        
        
        /* Adding background image */
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/lp.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1500, 780, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        
        
        
        
        //set size and visiiblity
        setVisible(true);
        setSize(1500,800);
        

        
        ja.addActionListener(this);
        jl.addActionListener(this);
        je.addActionListener(this);
        jh.addActionListener(this);
        jb.addActionListener(this);
        jvc.addActionListener(this);
        jac.addActionListener(this);
        jvcom.addActionListener(this);
        jg.addActionListener(this);
    
        
        
    }
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==jl){
              new Login().setVisible(true);
          }
          else if(e.getSource()==je){
           this.dispose();
            
              
          }
          else if(e.getSource()==ja){
              //sign up
              new Account().setVisible(true);
          }
          else if(e.getSource()==jb){
              //back
              new Project().setVisible(true);
          }
          else if(e.getSource()==jh){
              //home
              new  Project().setVisible(true);
          }
          else if (e.getSource()==jvc){
              //view costumer
              new ViewInformation("").setVisible(true);
          }
          else if (e.getSource()==jac){
              //add costumer
              new NewCostumer().setVisible(true);
          }
          else if (e.getSource()==jg){
              //generate
              new GenerateBill().setVisible(true);
              
          }
          else if (e.getSource()==jvcom){
              
              //complain
              
              new RecieveComplain().setVisible(true);
          }
          
          
         
         
        
          
      }
      public static void main(String[] args){
        new Admin().setVisible(true);
    }

   
}