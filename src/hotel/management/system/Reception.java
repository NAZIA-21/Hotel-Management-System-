package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Reception extends JFrame implements ActionListener {
    
    JButton newCustomer, rooms , dept, allEmp, custInfo, managerInfo, checkout, updateStatus, roomStatus, pickupService, searchRooms, logout;
   
    
    Reception(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //new costumer
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        //rooms
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        //dept 
        dept = new JButton("Department");
        dept.setBounds(10, 110, 200, 30);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        dept.addActionListener(this);
        add(dept);
        
        //allEmp
        allEmp = new JButton("All Employees");
        allEmp.setBounds(10, 150, 200, 30);
        allEmp.setBackground(Color.BLACK);
        allEmp.setForeground(Color.WHITE);
        allEmp.addActionListener(this);
        add(allEmp);
        
        //custInfo 
        custInfo = new JButton("Customer Info");
        custInfo.setBounds(10, 190, 200, 30);
        custInfo.setBackground(Color.BLACK);
        custInfo.setForeground(Color.WHITE);
        custInfo.addActionListener(this);
        add(custInfo);
        
        //managerInfo 
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
         //checkout 
        checkout = new JButton("Check Out");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        //update status
        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10, 310, 200, 30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.addActionListener(this);
        add(updateStatus);
        
        //room status
        roomStatus = new JButton("Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        //pickup service
        pickupService = new JButton("Pick Up Services");
        pickupService.setBounds(10, 390, 200, 30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.addActionListener(this);
        add(pickupService);
        
        
        //search rooms
        searchRooms = new JButton("Search Rooms");
        searchRooms.setBounds(10, 430, 200, 30);
        searchRooms.setBackground(Color.BLACK);
        searchRooms.setForeground(Color.WHITE);
        searchRooms.addActionListener(this);
        add(searchRooms);
        
        //logout
        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image= new JLabel(i1);
        image.setBounds(250 , 30, 500, 470);
        add(image);
        
        
        
        setBounds(350, 200, 800, 570);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== newCustomer){
             setVisible(false);  
             new AddCustomer();
         } else if(ae.getSource()== rooms){
             setVisible(false);
             new Room();
         } else if(ae.getSource()== dept){
             setVisible(false);
             new Department();  
        }else if(ae.getSource()== allEmp){
                setVisible(false);
                new EmployeeInfo();
        }else if(ae.getSource()== managerInfo){
                setVisible(false);
                new ManagerInfo();
        }else if(ae.getSource()== custInfo){
                setVisible(false);
                new CustomerInfo();
        }else if(ae.getSource()== searchRooms){
                setVisible(false);
                new SearchRoom();
        }else if(ae.getSource()== updateStatus){
                setVisible(false);
                new UpdateCheck();
        }else if(ae.getSource()== roomStatus){
                setVisible(false);
                new UpdateRoom();
        }else if(ae.getSource()== pickupService){
                setVisible(false);
                new PickUpServices();
        }else if(ae.getSource()== checkout){
                setVisible(false);
                new CheckOut();
        }else if(ae.getSource()== logout){
                setVisible(false);
                System.exit(0);
        }
     }
   
    public static void main (String[] args){
        new Reception();
        
    }
    
}
