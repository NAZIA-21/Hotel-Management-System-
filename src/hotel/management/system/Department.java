package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JLabel l1, l2;
    JTable table;
    JButton back;
    
    Department(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //Department label
        l1= new JLabel("Department");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        //Budget label
        l2= new JLabel("Budget");
        l2.setBounds(360, 10, 100, 20);
        add(l2);
        
        table = new JTable(); // (data, headers)
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        //back button
        back = new JButton("BACK");
        back.setBounds(280, 400, 120, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        setBounds(400, 200, 700, 480);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new Reception();
     }
    
    public static void main (String[] args){
        new Department();
        
    }
    
}
