package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener {
    
    JTable table;
    JLabel l1, l2, l3, l4, l5;
    JButton back;
    
    Room(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        ImageIcon i1= new ImageIcon (ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2= i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        
        //room no. label
        l1= new JLabel("Room Number");
        l1.setBounds(3, 10, 100, 20);
        add(l1);
        
        //Availability label
        l2= new JLabel("Availability");
        l2.setBounds(118, 10, 100, 20);
        add(l2);
        
        //Status label
        l3= new JLabel("Status");
        l3.setBounds(225, 10, 100, 20);
        add(l3);
        
        //bedType label
        l4= new JLabel("Bed Type");
        l4.setBounds(315, 10, 100, 20);
        add(l4);
        
        //Price label
        l5= new JLabel("Price");
        l5.setBounds(430, 10, 100, 20);
        add(l5);
        
        
        
        table = new JTable(); // (data, headers)
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        //back button
        back = new JButton("BACK");
        back.setBounds(200, 500, 120, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new Reception();
     }
    
    public static void main (String[] args){
        new Room();
        
    }
    
}
