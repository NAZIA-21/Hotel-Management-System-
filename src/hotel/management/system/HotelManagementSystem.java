package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
       // setSize(1366, 565);
       // setLocation(100, 100);
        setBounds(100, 100, 1366, 565);
        setLayout(null);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); //loactionX , locationY , height , breadth
        add(image);
        
        JLabel text= new JLabel ("Hotel Management System");
        text.setBounds(20, 400, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma" , Font.PLAIN , 60));
        image.add(text);
        
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(1140, 450, 120 , 45 );
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLUE);
        nextButton.addActionListener(this);
        nextButton.setFont(new Font("Monospaced" , Font.BOLD , 25));
        image.add(nextButton);
        
        setVisible(true);
        
        //dipper functionality
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(450);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(450);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    

    public  void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
