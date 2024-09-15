package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tfAge, tfSalary, tfPhone, tfEmail, tfAadhar;
    JRadioButton rbMale, rbFemale, rbother;
    JButton submit;
    JComboBox cbJob;
    
    
    AddEmployee(){
        setLayout(null);
        
        //name label 
        JLabel lbname= new JLabel("NAME");
        lbname.setBounds(60, 30, 120, 30);
        lbname.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbname);
        
        tfname= new JTextField ();
        tfname.setBounds(200, 30, 180, 30);
        add(tfname);
        
        
        //age label
        JLabel lbAge= new JLabel("AGE");
        lbAge.setBounds(60, 80, 120, 30);
        lbAge.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbAge);
        
        tfAge= new JTextField ();
        tfAge.setBounds(200, 80, 180, 30);
        add(tfAge);
        
        
        //gender label
        JLabel lbgender= new JLabel("GENDER");
        lbgender.setBounds(60, 130, 120, 30);
        lbgender.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbgender);
        
        rbMale= new JRadioButton("Male");
        rbMale.setBounds(200, 130, 70, 30);
        rbMale.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        
        rbFemale= new JRadioButton("Female");
        rbFemale.setBounds(280, 130, 70, 30);
        rbFemale.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        
        rbother= new JRadioButton("Other");
        rbother.setBounds(370, 130, 70, 30);
        rbother.setFont(new Font("Tahoma" , Font.PLAIN, 13));
        rbother.setBackground(Color.WHITE);
        add(rbother);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        bg.add(rbother);

        
        
        
        
        //job label
        JLabel lbjob= new JLabel("JOB");
        lbjob.setBounds(60, 180, 120, 30);
        lbjob.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbjob);
        
        String str[]= {"Front desk clerk" ,"Porters","Housekeeping","Kitchen Staff",
                        "Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        cbJob= new JComboBox(str);
        cbJob.setBounds(200, 180, 150, 30);
        cbJob.setBackground(Color.WHITE);
        add(cbJob);
        
        
        //Salary label
        JLabel lbSalary= new JLabel("SALARY");
        lbSalary.setBounds(60, 230, 120, 30);
        lbSalary.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbSalary);
        
        tfSalary= new JTextField ();
        tfSalary.setBounds(200, 230, 150, 30);
        add(tfSalary);
        
        
        //Phone label
        JLabel lbPhone= new JLabel("PHONE NO.");
        lbPhone.setBounds(60, 330, 120, 30);
        lbPhone.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbPhone);
        
        tfPhone= new JTextField ();
        tfPhone.setBounds(200, 330, 150, 30);
        add(tfPhone);
        
     
        //E-mail label
        JLabel lbEmail= new JLabel("E-MAIL");
        lbEmail.setBounds(60, 280, 120, 30);
        lbEmail.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbEmail);
        
        tfEmail= new JTextField ();
        tfEmail.setBounds(200, 280, 150, 30);
        add(tfEmail);
        
        
        //AAdhar label
        JLabel lbAadhar= new JLabel("AADHAR NO.");
        lbAadhar.setBounds(60, 380, 120, 30);
        lbAadhar.setFont(new Font("Tahoma" , Font.PLAIN, 18));
        add(lbAadhar);
        
        tfAadhar= new JTextField ();
        tfAadhar.setBounds(200, 380, 150, 30);
        add(tfAadhar);
        
        
        
        //Submit button
        submit = new JButton("SUBMIT");
        submit.setBounds(200, 450, 120, 30 );
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma" , Font.BOLD, 20));
        submit.addActionListener(this);
        add(submit);
        
        
        //adding image 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2= i1.getImage().getScaledInstance(420, 450, Image.SCALE_DEFAULT);
        ImageIcon i3= new  ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(380, 60, 450, 380);
        add(image);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name = tfname.getText();
        String age = tfAge.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String salary = tfSalary.getText();
        String aadhar = tfAadhar.getText();
        
        String gender = null;
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "NAME SHOULD NOT BE EMPTY.");
            return;
        }
        
        if(age.equals("")){
            JOptionPane.showMessageDialog(null, "AGE SHOULD NOT BE EMPTY.");
            return;
        }
        

        
        if(email.equals("") && email.contains("@") && email.contains(".com")){
            JOptionPane.showMessageDialog(null, "INVALID EMAIL");
            return;
        }
        
        if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "PHONE NUMBER CANNOT BE EMPTY");
            return;
        }
        
        if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "AADHAR NUMBER CANNOT BE EMPTY");
            return;
        }
        
        if(salary.equals("")){
            JOptionPane.showMessageDialog(null, "SALARY CANNOT BE EMPTY");
            return;
        }
        
        if(cbJob.equals("")){
            JOptionPane.showMessageDialog(null, "JOB FIELD CANNOT BE EMPTY");
            return;
        }
        
        
        
        if(rbMale.isSelected()){
            gender= "Male";
        } else if (rbFemale.isSelected()){
            gender = "Female";
        } else{
            gender = "Other";
        }
        
        String job= (String) cbJob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employeee values('"+name+"' , '"+age+"' , '"+gender+"' , '"+job+"' , '"+salary+"' , '"+phone+"' , '"+email+"' , '"+aadhar+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added succesfully");
            
            setVisible(false);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public static void main(String [] args){
        new AddEmployee();
    }
}
