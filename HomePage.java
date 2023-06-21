package Employee_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener{
   
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f,f1,f2;
    JPanel p1;
    
    HomePage(){
        
        super("Employee Home Page");
        
        setLocation(0, 0);       
        setSize(1550,900);
        
        f=new Font("Lucida Fax", Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);
                                  
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icons/Im.jpg"));
        Image i2 = il.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1=new JLabel(i3);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Profile");
        JMenuItem ment1=new JMenuItem("Complete Profile");
        JMenuItem ment2=new JMenuItem("View Profile");
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        
        JMenu men2=new JMenu("Manage");
        JMenuItem ment3=new JMenuItem("Update Details");
        ment3.addActionListener(this);
        
        JMenu men3=new JMenu("Attendance");
        JMenuItem ment5=new JMenuItem("Take Attendance");
        JMenuItem ment6=new JMenuItem("View Attendance");
        ment5.addActionListener(this);
        ment6.addActionListener(this);        
        
        JMenu men5=new JMenu("Salary");
        JMenuItem ment9=new JMenuItem("Add Salary");
        JMenuItem ment10=new JMenuItem("Generate Salary Slip");
        ment9.addActionListener(this);
        ment10.addActionListener(this);
                
        JMenu men6=new JMenu("Exit");
        JMenuItem ment11=new JMenuItem("Logout");
        ment11.addActionListener(this);
        
        JMenu men7=new JMenu("Delete");
        JMenuItem ment12=new JMenuItem("Delete Employee");
        ment12.addActionListener(this);
        
        men1.add(ment1);
        men1.add(ment2);
        men2.add(ment3);        
        men3.add(ment5);
        men3.add(ment6);
        men5.add(ment9);
        men5.add(ment10);
        men6.add(ment11);
        men7.add(ment12);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men5);
        m1.add(men7);
        m1.add(men6);
        
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);        
        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
       
        m1.setBackground(Color.BLACK);
        
        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men7.setForeground(Color.GRAY);
        men6.setForeground(Color.RED);
        
        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment10.setBackground(Color.BLACK);
        ment11.setBackground(Color.BLACK);
        ment12.setBackground(Color.BLACK);
        
        ment1.setForeground(Color.YELLOW);
        ment2.setForeground(Color.YELLOW);
        ment3.setForeground(Color.YELLOW);     
        ment5.setForeground(Color.YELLOW);
        ment6.setForeground(Color.YELLOW);   
        ment9.setForeground(Color.YELLOW);
        ment10.setForeground(Color.YELLOW);
        ment11.setForeground(Color.YELLOW);
        ment12.setForeground(Color.YELLOW);
        
        setJMenuBar(m1);
        add(l1);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
         String comnd=e.getActionCommand();
         if(comnd.equals("Complete Profile")){
             new AddEmployee();
         }
         else if(comnd.equals("View Profile")){
             new View_Employee();             
         }
         else if(comnd.equals("Update Details")){
             new Update_Details_Data().setVisible(true);
         }
         else if(comnd.equals("Take Attendance")){
             new Employee_Attendance().setVisible(true);
         }
         else if(comnd.equals("View Attendance")){
             new View_Attendance().setVisible(true);
         }          
          else if(comnd.equals("Add Salary")){
             new Salary().setVisible(true);
         }
         else if(comnd.equals("Generate Salary Slip")){
             new Generate_PaySlip().setVisible(true);
         }
         else if(comnd.equals("Delete Employee")){
             new Delete_Employee().setVisible(true);
         }
         else if(comnd.equals("Logout")){
             System.exit(0);
         }
    }
    
    public static void main(String args[]){
        new HomePage();
    }
}


