package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable table;
    JLabel l1, l2, l3, l4, l5,l6, l7, l8;
    JButton back;
    
    CustomerInfo(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        //Document label
        l1= new JLabel("Document");
        l1.setBounds(3, 10, 100, 20);
        add(l1);
        
        //Number label
        l2= new JLabel("Number");
        l2.setBounds(150, 10, 100, 20);
        add(l2);
        
        //name label
        l3= new JLabel("Name");
        l3.setBounds(290, 10, 100, 20);
        add(l3);
        
        //Gender label
        l4= new JLabel("Gender");
        l4.setBounds(405, 10, 100, 20);
        add(l4);
        
        //Country label
        l5= new JLabel("Country");
        l5.setBounds(540, 10, 100, 20);
        add(l5);
        
        //room label
        l6= new JLabel("Room Number");
        l6.setBounds(640, 10, 100, 20);
        add(l6);
        
        //checkinTime label
        l7= new JLabel("Checkin Time");
        l7.setBounds(770, 10, 100, 20);
        add(l7);
        
        //deposit label
        l7= new JLabel("Deposit");
        l7.setBounds(900, 10, 100, 20);
        add(l7);
         
        
        table = new JTable(); // (data, headers)
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer");
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
        new CustomerInfo();
        
    }
    
}
