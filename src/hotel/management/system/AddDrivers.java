package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JTextField tfName, tfAge, tfPhone, tfCarModel , tfCarCompany , tfLocation;
    JRadioButton rbMale, rbFemale, rbother;
    JComboBox cbAvailable;
    JButton add, cancel;
    
    AddDrivers(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //heading label
        JLabel heading= new JLabel("ADD DRIVERS");
        heading.setBounds(150, 10 , 200, 20);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 20));
        add(heading);
        
        //name
        JLabel lbName= new JLabel("NAME");
        lbName.setBounds(60, 70 , 150, 30);
        lbName.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbName);
        
        tfName= new JTextField();
        tfName.setBounds(200, 70, 150, 30);
        add(tfName);
        
        //age label
        JLabel lbAge= new JLabel("AGE");
        lbAge.setBounds(60, 120, 150, 30);
        lbAge.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbAge);
        
        tfAge= new JTextField ();
        tfAge.setBounds(200, 120, 150, 30);
        add(tfAge);
        
        
        //gender label
        JLabel lbgender= new JLabel("GENDER");
        lbgender.setBounds(60, 170, 150, 30);
        lbgender.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbgender);
        
        rbMale= new JRadioButton("Male");
        rbMale.setBounds(200, 170, 60, 30);
        rbMale.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        
        rbFemale= new JRadioButton("Female");
        rbFemale.setBounds(280, 170, 65, 30);
        rbFemale.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        
        rbother= new JRadioButton("Other");
        rbother.setBounds(370, 170, 65, 30);
        rbother.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbother.setBackground(Color.WHITE);
        add(rbother);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        bg.add(rbother);

     
//        //Salary label
//        JLabel lbSalary= new JLabel("SALARY");
//        lbSalary.setBounds(60, 220, 150, 30);
//        lbSalary.setFont(new Font("Tahoma" , Font.PLAIN, 18));
//        add(lbSalary);
//        
//        tfSalary= new JTextField ();
//        tfSalary.setBounds(200, 220, 150, 30);
//        add(tfSalary);
//        
        
        //Car company label
        JLabel lbCarCompany= new JLabel("CAR COMPANY");
        lbCarCompany.setBounds(60, 220, 150, 30);
        lbCarCompany.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbCarCompany);
        
        tfCarCompany= new JTextField ();
        tfCarCompany.setBounds(200, 220, 150, 30);
        add(tfCarCompany);
        
        
     
        //Car model
        JLabel lbCarModel= new JLabel("CAR MODEL");
        lbCarModel.setBounds(60, 270, 150, 30);
        lbCarModel.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbCarModel);
        
        tfCarModel= new JTextField ();
        tfCarModel.setBounds(200, 270, 150, 30);
        add(tfCarModel);
        
        //Available or not
        JLabel lbAvailable= new JLabel("AVAILABILITY");
        lbAvailable.setBounds(60, 320 , 150, 30);
        lbAvailable.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        add(lbAvailable);
        
        String availableOptions[] ={"Available" , "Occupied"};
        cbAvailable = new JComboBox(availableOptions);
        cbAvailable.setBounds(200, 320, 150, 30);
        cbAvailable.setBackground(Color.WHITE);
        add(cbAvailable);
        
        
        
        //Phone label
        JLabel lbPhone= new JLabel("PHONE NO.");
        lbPhone.setBounds(60, 370, 150, 30);
        lbPhone.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbPhone);
        
        tfPhone= new JTextField ();
        tfPhone.setBounds(200, 370, 150, 30);
        add(tfPhone);
        
        
        
        //location label
        JLabel lbLocation= new JLabel("LOCATION");
        lbLocation.setBounds(60, 420, 150, 30);
        lbLocation.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbLocation);
        
        tfLocation= new JTextField ();
        tfLocation.setBounds(200, 420, 150, 30);
        add(tfLocation);
        
       
        
      
        //Add button
        add = new JButton("ADD DRIVER");
        add.setBounds(60, 490, 150, 33 );
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add.addActionListener(this);
        add(add);
        
        //cancel button
        cancel = new JButton("CANCEL");
        cancel.setBounds(230, 490, 150, 33 );
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        cancel.addActionListener(this);
        add(cancel);
        
         
        
        
        //adding image 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2= i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new  ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(430, 30, 530, 450);
        add(image);
        setBounds(320, 200, 980, 600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            
            String name= tfName.getText();
            String age= tfAge.getText();
            
            
            
            String gender= null;
            if(rbMale.isSelected()){
                gender= "Male";
            } else if (rbFemale.isSelected()){
                gender = "Female";
            } else{
                gender = "Other";
            }
            
            String carCompany= tfCarCompany.getText();
            String carModel= tfCarModel.getText();
            String availibility = (String) cbAvailable.getSelectedItem();
            String phone= tfPhone.getText();
            String location= tfLocation.getText();
            
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "NAME SHOULD NOT BE EMPTY.");
                return;
            }

            if(age.equals("")){
                JOptionPane.showMessageDialog(null, "AGE SHOULD NOT BE EMPTY.");
                return;
            }

       
            
            if(carCompany.equals("")){
                JOptionPane.showMessageDialog(null, "CAR COMPANY SHOULD NOT BE EMPTY.");
                return;
            }

            
            if(carModel.equals("")){
                JOptionPane.showMessageDialog(null, "CAR MODEL SHOULD NOT BE EMPTY.");
                return;
            }


            if(phone.equals("")){
                JOptionPane.showMessageDialog(null, "PHONE NUMBER CANNOT BE EMPTY");
                return;
            }

            if(location.equals("")){
                JOptionPane.showMessageDialog(null, "LOCATION CANNOT BE EMPTY");
                return;
            }
            
//            if(cbAvailable.equals("")){
//                JOptionPane.showMessageDialog(null, "AVAILIBILITY FIELD CANNOT BE EMPTY");
//                return;
//            }
        
        
        
           
            try{
                Conn conn = new Conn();
                
                String str= " insert into driver values  ('"+name+"' , '"+age+"' , '"+gender+"', '"+carCompany+"' , '"+carModel+"',  '"+availibility+"' , '"+phone+"', '"+location+"')";
                conn.s.executeUpdate(str);
            
                JOptionPane.showMessageDialog(null, "New Driver Added Succesfully");
                
                setVisible(false);
            
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else{
            //cancel button clicled
            setVisible(false);
        }
        
    }
    
    public static void main (String [] args){
        new AddDrivers();
    }
    
}
