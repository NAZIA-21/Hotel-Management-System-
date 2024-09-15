package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JTextField userName;
    JPasswordField password;
    JButton loginButton, cancelButton;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user= new JLabel("UserName");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
         userName = new JTextField();
        userName.setBounds(150, 20, 180, 30);
        add(userName);
        
        
        
        JLabel pass= new JLabel("Password");
        pass.setBounds(40, 60, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 60, 180, 30);
        add(password);
        
        loginButton= new JButton("Login");
        loginButton.setBounds(40, 130, 100, 30);
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);
        
        cancelButton= new JButton("Cancel");
        cancelButton.setBounds(160, 130, 100, 30);
        cancelButton.setBackground(Color.DARK_GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new  ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350, 12, 200, 200);
        add(image);
        
        
        
        setBounds(500, 200, 600, 300);
        setVisible(true);
}
        
       public  void actionPerformed (ActionEvent ae){
           if(ae.getSource() == loginButton){
               String user = userName.getText();
               String pass = password.getText();
               
               try{
                   Conn c= new Conn();
                   
                   String query = "select * from login where userName = '" + user + "'and password= '" + pass + "'";
                   
                   ResultSet rs= c.s.executeQuery(query);
                   
                if(rs.next()){ 
                      new DashBoard().setVisible(true);
                      setVisible(false);
                }else{
                     JOptionPane.showMessageDialog(null, "Invalid userName or password");
                     setVisible(false);
            }
                   
//                   if(rs.next()){
//                       setVisible(false);
//                       new DashBoard();
//                       
//                   } else{
//                       JOptionPane.showMessageDialog(null , "Invalid userName or password");
//                       setVisible(false);
//                   }
                   
               } catch(Exception e){
                   e.printStackTrace();
               }
           } else if (ae.getSource() == cancelButton){
               setVisible(false);
           }
           
        
    }
    
    
    public static void main(String[] args){
         new Login();

}
}


