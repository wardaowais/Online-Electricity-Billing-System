/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Payment extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5, l6,l7,l12,l13,l14;
    JTextField l17,l11,l16;
    Choice l15;
    JTextArea l21;
    JButton b1,b2;
    String meter;
    Payment(){
        this.meter = meter;
        setLayout(null);
       
        setBounds(300, 100, 900, 600);
           getContentPane().setBackground(new Color(250, 247, 159));
        
        JLabel title = new JLabel("Bill Payment");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        add(title);
        
        l1 = new JLabel("Meter No");
        l1.setBounds(35, 80, 200, 20);
        add(l1);
        
         l11 = new JTextField();
        l11.setBounds(300, 80, 150, 20);
        add(l11);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(35, 140, 200, 20);
        add(l2);
        
         l12 = new JLabel("");
        l12.setBounds(300, 140, 150, 20);
        add(l12);
        
        l3 = new JLabel("Unit Consumed");
        l3.setBounds(35, 200, 200, 20);
        add(l3);
        
        l13= new JLabel("");
        l13.setBounds(300, 200, 150, 20);
        add(l13);
        
        
        l4 = new JLabel("Total Bill");
        l4.setBounds(35, 260, 200, 20);
        add(l4);
        
        l14 = new JLabel("");
        l14.setBounds(300, 260, 150, 20);
        add(l14);
        
        l5 = new JLabel("Pay Through");
        l5.setBounds(35, 320, 200, 20);
       
        add(l5);
        
        l15= new Choice();
        l15.setBounds(300, 320, 150, 20);
        l15.add("");
        l15.add("Cash");
        l15.add("Debit");
        add(l15);
        
        l6 = new JLabel("Amount");
        l6.setBounds(35, 380, 200, 20);
        add(l6);
        
        l16 = new JTextField();
        l16.setBounds(300, 380, 150, 20);
        l16.setForeground(Color.RED);
        add(l16);
        
        l7 = new JLabel("Account Number");
        l7.setBounds(35,440,200,20);
        add(l7);
        l7.setVisible(false);
        
        l17 = new JTextField();
        l17.setBounds(300,440,150,20);
        add(l17);
        l17.setVisible(false);
        
     
        
        
        l15.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String meter=l11.getText();
                if(l15.getSelectedItem()=="Cash"){
                   try{
                       FileReader fr = new FileReader("CostumerDetails.txt");
                       BufferedReader br = new BufferedReader(fr);
                       String line;
                       while((line=br.readLine())!=null){
                           String[] values= line.split(",");
                           if(meter.equalsIgnoreCase(values[0])){
 //0..meter 1. name 2. address 3. state 4. city 5.email 6. phone 7. meter_location 8. meter_type 9.phase_code 10. bill_type 11.days 12. unit 13. month ;            

                               l12.setText(values[1]);
                               l13.setText(values[12]);
                               double totalbill= ((Integer.valueOf(values[12]))*30)+300+1000+500;
                               l14.setText(String.valueOf(totalbill));
                               
                       }
                           }
                       }catch(IOException e){
                      e.getStackTrace();
                       }
                }
                       
           
                else if(l15.getSelectedItem()=="Debit"){
                    l17.setVisible(true);
                    l7.setVisible(true);
                   try{
                       FileReader fr = new FileReader("CostumerDetails.txt");
                       BufferedReader br = new BufferedReader(fr);
                       String line;
                       while((line=br.readLine())!=null){
                           String[] values= line.split(",");
                           if(meter.equalsIgnoreCase(values[0])){
 //0..meter 1. name 2. address 3. state 4. city 5.email 6. phone 7. meter_location 8. meter_type 9.phase_code 10. bill_type 11.days 12. unit 13. month ;            

                               l12.setText(values[1]);
                               l13.setText(values[12]);
                               double totalbill= ((Integer.valueOf(values[12]))*30)+300+1000+500;
                               l14.setText(String.valueOf(totalbill));
                               
                       }
                           }
                       }catch(IOException e){
                      e.getStackTrace();
                       }
                 
                    
                }
                
        }});
        
        b1 = new JButton("Pay");
        b1.setBounds(100, 500, 100, 25);
        add(b1);
        b2 = new JButton("Back");
        b2.setBounds(230, 500, 100, 25);
        add(b2);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
       
        l21 = new JTextArea();
        l21.setBounds(490, 230, 360, 340);
        add(l21);
        l21.setText("\n=======WASAF POWER LIMITED=======\n\n                **Your Bill Receipt**");
        l21.setFont(new Font("Cambria",Font.BOLD,18));
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/pay.jpg"));
        Image i3 = ic.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel li = new JLabel(icc3);
        li.setBounds(490, 12, 360, 200);
        add(li);

        
        
                
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            l21.append("\n\n    Meter Number:-   "+l11.getText()+"\n    Name:-   "+l12.getText()+"\n    Unit:-  "+l13.getText()+"\n    TotalBill:-    "+l14.getText()+"\n    Pay Through:-   "+l15.getSelectedItem()+"\n    Amount:-   "+l16.getText()+"\n\n  Thankyou From WASAF Power Limited " );
            try{
               /* File o = new File("payment.txt");
                o.createNewFile();*/
                FileWriter wri = new FileWriter("payment.txt");
                wri.write(l11.getText()+","+l12.getText()+","+l13.getText()+","+l14.getText()+","+l15.getSelectedItem()+","+l16.getText()+","+l17.getText());
                wri.close();
                
            }catch(IOException e){
                System.out.println(e);}
        }else if(ae.getSource()== b2){
            this.setVisible(false);
        }        
    }
    
       
    public static void main(String[] args){
        new Payment().setVisible(true);
    }
}
