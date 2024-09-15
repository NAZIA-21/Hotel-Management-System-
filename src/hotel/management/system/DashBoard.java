package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DashBoard extends JFrame implements ActionListener{
    
    DashBoard(){
        setBounds(0, 0 ,1550, 825);
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1550, 820, Image.SCALE_DEFAULT);
        ImageIcon i3= new  ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0 ,1550, 825);
        add(image);
        
        JLabel text= new JLabel("THE TAJ GROUP WELCOMES YOU!");
        text.setBounds(300, 80, 1500, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma" , Font.BOLD , 60));
        image.add(text);
        
        
        //menu bar
        JMenuBar mb= new JMenuBar();
        mb.setBounds(0, 0, 1550, 35);
        image.add(mb);
        
        //hotel menu
        JMenu hotel= new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        //item1 : reception
        JMenuItem reception= new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        //admin menu
        JMenu admin= new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        //item2.1 : addEmployee
        JMenuItem addEmployee= new JMenuItem("ADD EMPLOEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        
        //item2.2 : addRoom
        JMenuItem addRoom= new JMenuItem("ADD ROOM");
        addRoom.addActionListener(this);
        admin.add(addRoom);
        
        //item2.2 : addDriver
        JMenuItem addDriver= new JMenuItem("ADD DRIVER");
        addDriver.addActionListener(this);
        admin.add(addDriver);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("ADD EMPLOEE")){
            new AddEmployee();
        } else if(ae.getActionCommand().equals("ADD ROOM")){
            new AddRooms();
        } else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDrivers();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
   
    public static void main(String[] args){
        new DashBoard();
    }
}