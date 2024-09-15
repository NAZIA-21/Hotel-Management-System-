package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    
    Choice cId;
    JLabel lbRoomNo, lblCheckin,  checkout;
    JButton checkOut, back;
    
    CheckOut(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading= new JLabel("Check Out");
        heading.setFont(new Font("Tahoma" , Font.PLAIN, 25));
        heading.setForeground(Color.BLUE);
        heading.setBounds(100, 20, 150, 30);
        add(heading);
        
        
        //customer id
        JLabel lblId= new JLabel("Customer Id");
        lblId.setBounds(30, 80, 100, 30);
        add(lblId);
        
        
        cId = new Choice();
        cId.setBounds(150, 80, 100, 30);
        cId.setBackground(Color.WHITE);
        add(cId);
        
        
        
        ImageIcon i1= new ImageIcon (ClassLoader.getSystemResource("icons/tick.png"));
        Image i2= i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel tick= new JLabel(i3);
        tick.setBounds(300, 80, 20, 20);
        add(tick);
        
        
         //room label
        JLabel lblRoom= new JLabel("Room  Number");
        lblRoom.setBounds(30, 130, 100, 30);
        add(lblRoom);
        
        lbRoomNo= new JLabel();
        lbRoomNo.setBounds(150, 130, 100, 30);
        lbRoomNo.setFont(new Font("Tahoma" , Font.PLAIN , 12));
        add(lbRoomNo);
        
        //Checkin label
        JLabel lblCheckinTime= new JLabel("Checkin Time");
        lblCheckinTime.setBounds(30, 180, 100, 30);
        add(lblCheckinTime);
        
        lblCheckin= new JLabel();
        lblCheckin.setBounds(150, 180, 200, 30);
        lblCheckin.setFont(new Font("Tahoma" , Font.PLAIN , 12));
        add(lblCheckin);
        
        //Checkout label
        JLabel lblCheckinOut= new JLabel("CheckOut Time");
        lblCheckinOut.setBounds(30, 230, 100, 30);
        add(lblCheckinOut);
        
        Date date= new Date();
        
        checkout= new JLabel(""+date);
        checkout.setBounds(150, 230, 200, 30);
        checkout.setFont(new Font("Tahoma" , Font.PLAIN , 12));
        add(checkout);
        
        //checkOut button
        checkOut = new JButton("CHECKOUT");
        checkOut.setBounds(30, 280, 120, 33 );
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        checkOut.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        checkOut.addActionListener(this);
        add(checkOut);
        
        
        //back button
        back = new JButton("BACK");
        back.setBounds(170, 280, 120, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer");
            while(rs.next()){
                cId.add(rs.getString("number"));
                lbRoomNo.setText(rs.getString("room"));
                lblCheckin.setText(rs.getString("checkinTime"));
                
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
         
        ImageIcon i4= new ImageIcon (ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5= i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel image2= new JLabel(i6);
        image2.setBounds(350, 50, 400, 250);
        add(image2);
        
        
        
        setBounds(330, 200, 800, 400);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == checkOut){
            
            String query1= "delete from customer where number = '"+cId.getSelectedItem()+"' ";
            String query2= "update room set availibility= 'Available' where roomNo= '"+lbRoomNo+"' ";
            
            try{
                
                Conn c= new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "CheckOut Done");
                
                setVisible(false);
                new Reception();
           
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else{
           setVisible(false);
           new Reception();
       }
        
    }
    
    public static void main (String[] args){
        
        new CheckOut();
        
    }
}
