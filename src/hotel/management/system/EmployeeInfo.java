package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener {
    
    JTable table;
    JLabel l1, l2, l3, l4, l5,l6, l7, l8;
    JButton back;
    
    EmployeeInfo(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        //name label
        l1= new JLabel("Name");
        l1.setBounds(3, 10, 100, 20);
        add(l1);
        
        //Age label
        l2= new JLabel("Age");
        l2.setBounds(180, 10, 100, 20);
        add(l2);
        
        //Gender label
        l3= new JLabel("Gender");
        l3.setBounds(290, 10, 100, 20);
        add(l3);
        
        //Job label
        l4= new JLabel("Job");
        l4.setBounds(420, 10, 100, 20);
        add(l4);
        
        //Salary label
        l5= new JLabel("Salary");
        l5.setBounds(540, 10, 100, 20);
        add(l5);
        
        //phone label
        l6= new JLabel("Phone Number");
        l6.setBounds(640, 10, 100, 20);
        add(l6);
        
        //Email label
        l7= new JLabel("Email Id");
        l7.setBounds(770, 10, 100, 20);
        add(l7);
        
        //aadhar label
        l8= new JLabel("Aadhar Number");
        l8.setBounds(885, 10, 100, 20);
        add(l8);
        
        
        
        table = new JTable(); // (data, headers)
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from employeee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        //back button
        back = new JButton("BACK");
        back.setBounds(420, 500, 120, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new Reception();
     }
    
    public static void main (String[] args){
        new EmployeeInfo();
        
    }
    
}
