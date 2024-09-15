package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    Choice cCustomer;
    JTextField tfRoom, tfName, tfCheckinTime, tfPaid, tfPending;
    JButton check, update, back;
    
    UpdateCheck(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //heading
        JLabel heading= new JLabel("Update Status");
        heading.setFont(new Font("Tahoma" , Font.PLAIN, 20));
        heading.setBounds(90, 20, 200, 30);
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
        lbRoom.setBounds(30, 120, 100, 20);
        add(lbRoom);
        
        tfRoom= new JTextField();
        tfRoom.setBounds(200, 120, 170, 25);
        add(tfRoom);
        
        //name label
        JLabel lbName= new JLabel("Customer Name");
        lbName.setBounds(30, 160, 100, 20);
        add(lbName);
        
        tfName= new JTextField();
        tfName.setBounds(200, 160, 170, 25);
        add(tfName);
        
        
        //checkin time label
        JLabel lbCheckinTime= new JLabel("Checkin Time");
        lbCheckinTime.setBounds(30, 200, 100, 20);
        add(lbCheckinTime);
        
        tfCheckinTime= new JTextField();
        tfCheckinTime.setBounds(200, 200, 170, 25);
        add(tfCheckinTime);
        
        
        //Paid  label
        JLabel lbPaid= new JLabel("Paid Amount");
        lbPaid.setBounds(30, 240, 100, 20);
        add(lbPaid);
        
        tfPaid= new JTextField();
        tfPaid.setBounds(200, 240, 170, 25);
        add(tfPaid);
        
        
        //Pending  label
        JLabel lbPending= new JLabel("Pending Amount");
        lbPending.setBounds(30, 280, 100, 20);
        add(lbPending);
        
        tfPending= new JTextField();
        tfPending.setBounds(200, 280, 170, 25);
        add(tfPending);
        
        //check button
        check = new JButton("CHECK");
        check.setBounds(30, 340, 100, 33 );
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        check.addActionListener(this);
        add(check);
        
        //update button
        update = new JButton("UPDATE");
        update.setBounds(150, 340, 100, 33 );
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        update.addActionListener(this);
        add(update);
        
        
        //back button
        back = new JButton("BACK");
        back.setBounds(270, 340, 100, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        
        //adding image 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image= new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        
        setBounds(300, 200, 980, 500);
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
                    tfName.setText(rs.getString("name"));
                    tfCheckinTime.setText(rs.getString("checkinTime"));
                    tfPaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2= c.s.executeQuery("select * from room where roomNo ='"+tfRoom.getText()+"'");
                while(rs2.next()){
                    String price= rs2.getString("price");
                    int amtPaid= Integer.parseInt(price) - Integer.parseInt(tfPaid.getText());
                    tfPending.setText("" + amtPaid);
                }
                
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource()== update){
            
            String number= cCustomer.getSelectedItem();
            String room= tfRoom.getText();
            String name= tfName.getText();
            String checkinTime= tfCheckinTime.getText();
            String deposit= tfPaid.getText();
            
            try{
                Conn c= new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"' , name = '"+name+"' , checkinTime= '"+checkinTime+"' , deposit = '"+deposit+"' where number='"+number+"'");
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
        new UpdateCheck();
   }
}
