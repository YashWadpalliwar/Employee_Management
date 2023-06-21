package Employee_Management;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
     JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfage, tfdesignation,tfempid ;
     JDateChooser dcdob;
     JComboBox cbeducation;
     JLabel lblempID,b1;
     JButton add, back;
    
    AddEmployee() {
                
        getContentPane().setBackground(Color.white);
        setLayout(null);
                 
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icons/add_employee.jpg"));
        Image i2 = il.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
                
        JLabel heading = new JLabel("New Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("TAHOMA", Font.BOLD,25));
        image.add(heading);  
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelname);
                
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        image.add(tfname);
        
        JLabel labelfname = new JLabel("Father Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelfname);
                
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        image.add(tffname);                
        
        JLabel labelsalary = new JLabel("Age");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelsalary);
                
        tfage = new JTextField();
        tfage.setBounds(600, 200, 150, 30);
        image.add(tfage);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labeldob);
                
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        image.add(dcdob);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labeladdress);
                
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        image.add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelphone);
                
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        image.add(tfphone);
        
         JLabel labelemail = new JLabel("Email id");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelemail);
                
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        image.add(tfemail);
        
        JLabel labeleducation = new JLabel("Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labeleducation);
        
        String courses[] = {"BCCA", "BCA", "B.Com", "BA", "BTech", "BSC", "MSC", "MBA", "MCA", "MA", "MTech"};        
        cbeducation = new JComboBox(courses);        
        cbeducation.setBounds(600, 300, 150, 30);
        image.add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Job Post");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labeldesignation);
                
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        image.add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar NO.");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelaadhar);
                
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        image.add(tfaadhar);
        
        JLabel labelempID = new JLabel("Employee ID");
        labelempID.setBounds(50, 400, 150, 30);
        labelempID.setFont(new Font("TAHOMA", Font.BOLD,20));
        image.add(labelempID);              
        
        tfempid = new JTextField();
        tfempid.setBounds(200,400, 150, 30);
        image.add(tfempid);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back = new JButton("Cancel");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == add){
             String name = tfname.getText();
             String fname = tffname.getText();
             String dod = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
             String age = tfage.getText();
             String address = tfaddress.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();
             String education = (String)cbeducation.getSelectedItem();
             String designation = tfdesignation.getText();
             String aadhar = tfaadhar.getText();
             String empID = tfempid.getText();
             
             try{
                 Connectionclass conn = new Connectionclass();
                 String query = "insert into employee values('"+name+"', '"+fname+"', '"+age+"', '"+dod+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empID+"')";
                 conn.stm.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Detail added Successfully");
                 setVisible(false);
                 new HomePage();
                 
             }catch (Exception e){
                 e.printStackTrace();
             }             
         }if(ae.getSource() == back) {
            setVisible(false);
            new HomePage();
         }
        }
    
    public static void main(String[] args){
        new AddEmployee();
    }
}
