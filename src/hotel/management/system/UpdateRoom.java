package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice cCustomer;
    JTextField tfRoom, tfAvailable, tfStatus;
    JButton check, update, back;
    
    UpdateRoom(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //heading
        JLabel heading= new JLabel("Update Room Status");
        heading.setFont(new Font("Tahoma" , Font.PLAIN, 25));
        heading.setBounds(30, 20, 250, 30);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //id
        JLabel lbId= new JLabel("Cutomer Id");
        lbId.setBounds(30, 80, 100, 20);
        add(lbId);
        
        cCustomer= new Choice();
        cCustomer.setBounds(200, 80, 170, 25);
        add(cCustomer);
        
        try{
            
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery(" select * from customer");
            while(rs.next()){
                cCustomer.add(rs.getString("number"));
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        //room label
        JLabel lbRoom= new JLabel("Room Number");
        lbRoom.setBounds(30, 130, 100, 20);
        add(lbRoom);
        
        tfRoom= new JTextField();
        tfRoom.setBounds(200, 130, 170, 25);
        add(tfRoom);
        
        //availabilit label
        JLabel lbAvailablility= new JLabel("Availability");
        lbAvailablility.setBounds(30, 180, 100, 20);
        add(lbAvailablility);
        
        tfAvailable= new JTextField();
        tfAvailable.setBounds(200, 180, 170, 25);
        add(tfAvailable);
        
        
        //status  label
        JLabel lbStatus= new JLabel("Cleaning Status");
        lbStatus.setBounds(30, 230, 100, 20);
        add(lbStatus);
        
        tfStatus= new JTextField();
        tfStatus.setBounds(200, 230, 170, 25);
        add(tfStatus);
        
        
        //check button
        check = new JButton("CHECK");
        check.setBounds(30, 300, 100, 33 );
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        check.addActionListener(this);
        add(check);
        
        //update button
        update = new JButton("UPDATE");
        update.setBounds(150, 300, 100, 33 );
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        update.addActionListener(this);
        add(update);
        
        
        //back button
        back = new JButton("BACK");
        back.setBounds(270, 300, 100, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        //adding image 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2= i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new  ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        
        setBounds(300, 200, 980, 450);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== check){
            
            String id= cCustomer.getSelectedItem();
            String query= "select * from customer where number = '"+id+"'";
            try{
                Conn c= new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    tfRoom.setText(rs.getString("room"));  
                }
                
                ResultSet rs2= c.s.executeQuery("select * from room where roomNo ='"+tfRoom.getText()+"'");
                while(rs2.next()){
                   tfAvailable.setText(rs2.getString("availibility"));
                   tfStatus.setText(rs2.getString("cleaningStatus"));
                }
                
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource()== update){
            
            String number= cCustomer.getSelectedItem();
            String room= tfRoom.getText();
            String available= tfAvailable.getText();
            String status= tfStatus.getText();
            
            try{
                Conn c= new Conn();
                c.s.executeUpdate("update room set availibility = '"+available+"' , cleaningStatus= '"+status+"' where roomNo = '"+room+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
                setVisible(false);
                 new Reception();
        
               
            } catch(Exception e){
                e.printStackTrace();
            }
            
            
        } else{
            setVisible(false);
            new Reception();
        }
        
    }
    
    public static void main (String[] args){
        new UpdateRoom();
   }
}
