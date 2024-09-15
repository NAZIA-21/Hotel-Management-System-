package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickUpServices extends JFrame implements ActionListener {
    
    JTable table;
    JLabel l1, l2, l3, l4, l5 , l6, l7, l8;
    Choice carType;
    JButton submit, back;
    
    PickUpServices(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading= new JLabel("Pick Up Services");
        heading.setFont(new Font("Tahoma" , Font.PLAIN, 20));
        heading.setBounds(400, 30, 200, 30);
        add(heading);
        
        //type od car label
        JLabel lblCarType= new JLabel("Type Of Car");
        lblCarType.setBounds(50, 100, 100, 20);
        add(lblCarType);
        
        
        carType = new Choice();
        carType.setBounds(180, 100, 100, 25);
        carType.setBackground(Color.WHITE);
        add(carType);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from driver");
            while(rs.next()){
                carType.add(rs.getString("brand"));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        //Name label
        l1= new JLabel("Name");
        l1.setBounds(20, 170, 100, 20);
        add(l1);
        
        //Age label
        l2= new JLabel("Age");
        l2.setBounds(170, 170, 100, 20);
        add(l2);
        
        //Gender label
        l3= new JLabel("Gender");
        l3.setBounds(290, 170, 100, 20);
        add(l3);
        
        //Company label
        l4= new JLabel("Company");
        l4.setBounds(410, 170, 100, 20);
        add(l4);
        
        //Brand label
        l5= new JLabel("Brand");
        l5.setBounds(540, 170, 100, 20);
        add(l5);
        
        //availability label
        l6= new JLabel("Availability");
        l6.setBounds(660, 170, 100, 20);
        add(l6);
        
        //Phone Number label
        l7= new JLabel("Phone Number");
        l7.setBounds(770, 170, 100, 20);
        add(l7);
        
        //Location label
        l8= new JLabel("Location");
        l8.setBounds(910, 170, 100, 20);
        add(l8);
        
        
        
        table = new JTable(); // (data, headers)
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from driver");
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
    
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()== submit){
             
            String query= "select * from driver where brand = '"+carType.getSelectedItem()+"'";
                 
             
             try{
                 
                 Conn conn = new Conn();
                 ResultSet rs;
                
                rs= conn.s.executeQuery(query);
                 
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
        
        new PickUpServices();
        
    }
}
