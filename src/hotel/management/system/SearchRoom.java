package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    
    JTable table;
    JLabel l1, l2, l3, l4, l5 , lblBed;
    JComboBox cbBed;
    JButton submit, back;
    JCheckBox available;
    
    SearchRoom(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading= new JLabel("Serach For Rooms");
        heading.setFont(new Font("Tahoma" , Font.PLAIN, 20));
        heading.setBounds(400, 30, 200, 30);
        add(heading);
        
        //bed label
        JLabel lblBed= new JLabel("Bed Type");
        lblBed.setBounds(50, 100, 100, 20);
        add(lblBed);
        
        
        cbBed = new JComboBox(new String[]{"Single" , "Double"});
        cbBed.setBounds(180, 100, 100, 25);
        cbBed.setBackground(Color.WHITE);
        add(cbBed);
        
        //check box
        available = new JCheckBox("Only display Available");
        available.setBounds(600, 100, 200, 30);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        //room no. label
        l1= new JLabel("Room Number");
        l1.setBounds(50, 170, 100, 20);
        add(l1);
        
        //Availability label
        l2= new JLabel("Availability");
        l2.setBounds(240, 170, 100, 20);
        add(l2);
        
        //Status label
        l3= new JLabel("Cleaning Status");
        l3.setBounds(450, 170, 100, 20);
        add(l3);
        
        //bedType label
        l4= new JLabel("Bed Type");
        l4.setBounds(670, 170, 100, 20);
        add(l4);
        
        //Price label
        l5= new JLabel("Price");
        l5.setBounds(860, 170, 100, 20);
        add(l5);
        
        
        
        table = new JTable(); // (data, headers)
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        //submit button
        submit = new JButton("SUBMIT");
        submit.setBounds(300, 520, 120, 33 );
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        submit.addActionListener(this);
        add(submit);
        
        
        //back button
        back = new JButton("BACK");
        back.setBounds(500, 520, 120, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1002, 600);
        setVisible(true);
        
    }
    
    @Override
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()== submit){
             
            String query1= "select * from room where bedType = '"+cbBed.getSelectedItem()+"'";
            String query2= "select * from room where availibility = 'Available' AND bedType = '"+cbBed.getSelectedItem()+"'";
                 
             
             try{
                 
                 Conn conn = new Conn();
                 ResultSet rs;
                 
                 if(available.isSelected()){
                    rs= conn.s.executeQuery(query2);
                 } else{
                     rs= conn.s.executeQuery(query1);
                 }
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                 
             } catch (Exception e){
                 e.printStackTrace();
             }
             
         } else{
                setVisible(false);
                new Reception();
            }
     }
    public static void main (String[] args){
        new SearchRoom();
        
    }
}
