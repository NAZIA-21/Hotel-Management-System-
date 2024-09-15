package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox cbId;
    JTextField tfNum, tfName, tfCountry, tfDeposit;
    JRadioButton rbMale, rbFemale ,rbother;
    Choice rooms;
    JLabel checkin;
    JButton add, back;
    
    AddCustomer(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //heading label
        JLabel heading= new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(150, 10 , 300, 20);
        heading.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(heading);
        
        //id
        JLabel lbId= new JLabel("Id");
        lbId.setBounds(35, 80, 100, 30);
        lbId.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbId);
        
        
        String opt[] = {"Passport" , "Aadhar card" , "Pan card" , "Driving Licence"  , "Voter Id" , "Rashan CARD"}; 
        cbId = new JComboBox(opt);
        cbId.setBounds(200, 80, 150, 25);
        cbId.setBackground(Color.WHITE);
        add(cbId);
        
        //number
        JLabel lbNum= new JLabel("Number");
        lbNum.setBounds(35, 120 , 150, 30);
        lbNum.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbNum);
        
        tfNum= new JTextField();
        tfNum.setBounds(200, 120, 150, 30);
        add(tfNum);
        
        //name
        JLabel lbName= new JLabel("NAME");
        lbName.setBounds(35, 170 , 150, 30);
        lbName.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbName);
        
        tfName= new JTextField();
        tfName.setBounds(200, 170, 150, 30);
        add(tfName);
        
        //gender label
        JLabel lbgender= new JLabel("GENDER");
        lbgender.setBounds(35, 220, 150, 30);
        lbgender.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbgender);
        
        rbMale= new JRadioButton("Male");
        rbMale.setBounds(200, 220, 55, 30);
        rbMale.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        
        rbFemale= new JRadioButton("Female");
        rbFemale.setBounds(280, 220, 65, 30);
        rbFemale.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        
        rbother= new JRadioButton("Other");
        rbother.setBounds(370, 220, 63, 30);
        rbother.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbother.setBackground(Color.WHITE);
        add(rbother);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        bg.add(rbother);
        
        //country
        JLabel lbCountry= new JLabel("Country");
        lbCountry.setBounds(35, 270 , 150, 30);
        lbCountry.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbCountry);
        
        tfCountry= new JTextField();
        tfCountry.setBounds(200, 270, 150, 30);
        add(tfCountry);
        
        //allocated rooms
        JLabel lbRoom= new JLabel("Allocated Room No.");
        lbRoom.setBounds(35, 320 , 150, 30);
        lbRoom.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbRoom);
        
        rooms = new Choice();
        try{
            
            Conn conn= new Conn();
            String query= "select * from room where availibility = 'Available'";
            ResultSet rs= conn.s.executeQuery(query);
            while(rs.next()){
                rooms.add(rs.getString("roomNo"));
            }
        
        } catch(Exception e){
                e.printStackTrace();
                }
        rooms.setBounds(200, 320, 150, 30);
        add(rooms);
        
        // time
        JLabel lbTime= new JLabel("Checkin Time");
        lbTime.setBounds(35, 370 , 150, 30);
        lbTime.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbTime);
        
        Date date= new Date();
        
        checkin= new JLabel(""+date);
        checkin.setBounds(200, 370 , 210, 30);
        checkin.setFont(new Font("Tahoma" , Font.PLAIN , 14));
        add(checkin);
        
        //deposit
        JLabel lbDeposit= new JLabel("Deposit");
        lbDeposit.setBounds(35, 420 , 150, 30);
        lbDeposit.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbDeposit);
        
        tfDeposit= new JTextField();
        tfDeposit.setBounds(200, 420, 150, 30);
        add(tfDeposit);
        
        //Add button
        add = new JButton("ADD CUSTOMER");
        add.setBounds(40, 470, 180, 33 );
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        add.addActionListener(this);
        add(add);
        
        //back button
        back = new JButton("BACK");
        back.setBounds(250, 470, 150, 33 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);
        
        //adding image 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2= i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3= new  ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        
        
        
                
        setBounds(350, 200, 800, 580);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== add){
            
            String document= (String) cbId.getSelectedItem();
            String number= tfNum.getText();
            String name= tfName.getText();
            
            String gender= null;
            if(rbMale.isSelected()){
                gender= "Male";
            } else if (rbFemale.isSelected()){
                gender = "Female";
            } else{
                gender = "Other";
            }
            
            String country = tfCountry.getText();
            String room= rooms.getSelectedItem();
            String checkinTime = checkin.getText();
            String deposit = tfDeposit.getText();
            
            try{
                String query= "insert into customer values ('"+document+"','"+number+"','"+name+"' ,'"+gender+"' ,'"+country+"' ,'"+room+"','"+checkinTime+"', '"+deposit+"')";
                String query2= "update room set availibility= 'Occupied' where roomNo= '"+room+"' ";
                
                Conn conn= new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "New Customer Added Succesfully");
                
                setVisible(false);
                
                new Reception();
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource()== back){
            setVisible(false);
                
                new Reception();
        }
    }
    
    public static void main (String[] args){
        new AddCustomer();
        
    }
    
}
