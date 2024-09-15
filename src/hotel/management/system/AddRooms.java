package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AddRooms extends JFrame implements ActionListener{
    
    JTextField tfRoomNo, tfPrice;
    JComboBox cbAvailable, cbCleaningSt , cbBedType;
    JButton add,cancel;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading label
        JLabel heading= new JLabel("ADD ROOMS");
        heading.setBounds(150, 20 , 200, 20);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 20));
        add(heading);
        
        //room no.
        JLabel lbRoomNo= new JLabel("ROOM NUMBER");
        lbRoomNo.setBounds(60, 80 , 150, 30);
        lbRoomNo.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbRoomNo);
        
        tfRoomNo= new JTextField();
        tfRoomNo.setBounds(200, 80, 150, 30);
        add(tfRoomNo);
        
        //Available or not
        JLabel lbAvailable= new JLabel("AVAILABILITY");
        lbAvailable.setBounds(60, 130 , 150, 30);
        lbAvailable.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbAvailable);
        
        String availableOptions[] ={"Available" , "Occupied"};
        cbAvailable = new JComboBox(availableOptions);
        cbAvailable.setBounds(200, 130, 150, 30);
        cbAvailable.setBackground(Color.WHITE);
        add(cbAvailable);
        
        //clean or not
        JLabel lbCleaningSt= new JLabel("CLEANING STATUS");
        lbCleaningSt.setBounds(60, 180 , 150, 30);
        lbCleaningSt.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbCleaningSt);
        
        String cleaningSt[] ={"Cleaned" , "Dirty"};
        cbCleaningSt = new JComboBox(cleaningSt);
        cbCleaningSt.setBounds(200, 180, 150, 30);
        cbCleaningSt.setBackground(Color.WHITE);
        add(cbCleaningSt);
        
        //bed type
        JLabel lbBedType= new JLabel("BED TYPE");
        lbBedType.setBounds(60, 230 , 150, 30);
        lbBedType.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbBedType);
        
        String bedType[] ={"Single bed" , "Double bed"};
        cbBedType = new JComboBox(bedType);
        cbBedType.setBounds(200, 230, 150, 30);
        cbBedType.setBackground(Color.WHITE);
        add(cbBedType);
        
        //price
        JLabel lbPrice= new JLabel("PRICE");
        lbPrice.setBounds(60, 280 , 150, 30);
        lbPrice.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbPrice);
        
        tfPrice= new JTextField();
        tfPrice.setBounds(200, 280, 150, 30);
        add(tfPrice);
        
        //Add button
        add = new JButton("ADD ROOM");
        add.setBounds(60, 360, 150, 33 );
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add.addActionListener(this);
        add(add);
        
        //cancel button
        cancel = new JButton("CANCEL");
        cancel.setBounds(230, 360, 150, 33 );
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        cancel.addActionListener(this);
        add(cancel);
        
        //adding image 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image= new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(330, 200, 940, 470);
        setVisible(true);
        
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            
            String roomNo= tfRoomNo.getText();
            String availibility = (String) cbAvailable.getSelectedItem();
            String cleaningStatus = (String) cbCleaningSt.getSelectedItem();
            String bedType = (String) cbBedType.getSelectedItem();
            String price= tfPrice.getText();
           
            if(roomNo.equals("")){
                JOptionPane.showMessageDialog(null, "Room Number Should Not Be Empty.");
                return;
            }
//            
//            String querryy= "select roomNo from room";
//            if(roomNo.matches(querryy)){
//                JOptionPane.showMessageDialog(null, "Room already exists.");
//                return;
//            }

            if(price.equals("")){
                JOptionPane.showMessageDialog(null, "Price Number Should Not Be Empty.");
                return;
            }


            try{
                Conn conn= new Conn();
                String str= "insert into room values ('"+roomNo+"' , '"+availibility+"' , '"+cleaningStatus+"' , '"+bedType+"' , '"+price+"' )";
                
                conn.s.executeUpdate(str);
            
                JOptionPane.showMessageDialog(null, "Room added succesfully");
                
                setVisible(false);
            
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else{
            //cancel button clicled
            setVisible(false);
        }
        
        
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
    
}
