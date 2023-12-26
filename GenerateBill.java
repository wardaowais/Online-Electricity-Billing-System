package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class GenerateBill extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextArea t1;
    JButton b1;
    Choice c2;
    JPanel p1;

    GenerateBill() {

        setSize(500, 900);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        b1= new JButton("Generate Bill");

        l2 = new JLabel();
        c2 = new Choice();

        try {
            FileReader n = new FileReader("meter.txt");
            BufferedReader br = new BufferedReader(n);
            String line;
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                int len = value.length;
                for (int i = 0; i < len; i++) {
                    c2.add(value[i]);

                }
                add(c2);

            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        t1 = new JTextArea(50, 15);
        t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Meter\n\n");
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif", Font.ITALIC, 18));

        b1.addActionListener(this);
        

        p1.add(b1);
        p1.add(l2);
        p1.add(c2);
        add(p1, "North");

        add(jsp, "Center");
       



        setLocation(750, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
           

            try {

                FileReader fr = new FileReader("costumerDetails.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                String m = c2.getSelectedItem();
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");

                    if (m.equalsIgnoreCase(values[0])) {
                        //0..meter 1. name 2. address 3. state 4. city 5.email 6. phone 7. meter_location 8. meter_type 9.phase_code 10. bill_type 11.days 12. unit 13. month ;            

                        t1.setText("\tWASAF Power Limited\nELECTRICITY BILL FOR THE MONTH OF " + values[13] + " ,2022\n\n\n");
                        t1.append("\n    Customer Name:" + values[1]);
                        t1.append("\n    Meter Number:  " + values[0]);
                        t1.append("\n    Address:            " + values[2]);
                        t1.append("\n    State:                 " + values[3]);
                        t1.append("\n    City:                   " + values[4]);
                        t1.append("\n    Email:                " + values[5]);
                        t1.append("\n    Phone Number  " + values[6]);
                        t1.append("\n-------------------------------------------------------------");
                        t1.append("\n");
                        t1.append("\n    Meter Location:" + values[7]);
                        t1.append("\n    Meter Type:      " + values[8]);
                        t1.append("\n    Phase Code:    " + values[10]);
                        t1.append("\n    Bill Type:         " + values[10]);
                        t1.append("\n    Days:               " + values[11]);
                        t1.append("\n");
                        t1.append("---------------------------------------------------------------");
                        t1.append("\n\n");

                        t1.append("\n Cost per Unit:             Rs " + "100");
                        t1.append("\n Service Charge:            Rs " + "500");
                        t1.append("\n Service Tax:               Rs " + "300");
                        t1.append("\n Fixed Tax:                 Rs " + "1000");
                        t1.append("\n");
                        int costperunit=100;
                        int unit = Integer.valueOf(values[12]);
                        double charges = unit*costperunit;
                        double total=charges+300+500+1000;
                        t1.append("\n    Units Consumed:\t" + values[12]);
                        t1.append("\n    Total Charges :\t" + charges);
                        t1.append("\n---------------------------------------------------------------");
                        t1.append("\n    TOTAL PAYABLE :\t" +total);

                    }
                }
            }
        

       
    catch(IOException e){
            e.printStackTrace();
        }
        }
    }
    public static void main(String[] args) {
        new GenerateBill().setVisible(true);
    }
}




