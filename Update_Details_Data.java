package Employee_Management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update_Details_Data extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField tf1, tf10, tf2, tf3, tf4, tf5, tf6, tf7,tf8,tf9;
    Font f,f1;
    Choice ch;
    
    Update_Details_Data(){
        super("Update Employee");
        setLocation(450,50);
        setSize(950,750);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);
        
        ch=new Choice();
        
        try {
              Connectionclass obj = new Connectionclass();
              String q = "select empID from employee";
              ResultSet rest=obj.stm.executeQuery(q);
              while(rest.next())
              {
                  ch.add(rest.getString("empID"));
              }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        l1=new JLabel("Update Employee");
        l2=new JLabel("Name");
        l3=new JLabel("Father Name");
        l4=new JLabel("Age");
        l5=new JLabel("Date of birth");
        l6=new JLabel("Address");
        l7=new JLabel("Phone");
        l8=new JLabel("Email");
        l9=new JLabel("Education");
        l10=new JLabel("Job post");
        l11=new JLabel("Aadhar");
        l12=new JLabel("Employee ID");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        tf8=new JTextField();
        tf9=new JTextField();
        tf10=new JTextField();
        
        b1=new JButton("Update Data");
        b2=new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        ch.setFont(f1);
               
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);
        tf10.setFont(f1);
        
        b1.setFont(f1);
        b2.setFont(f1);
        
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.red);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(12,2,10,10));
        
        p2.add(l12);
        p2.add(ch);
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(l7);
        p2.add(tf6);
        p2.add(l8);
        p2.add(tf7);
        p2.add(l9);
        p2.add(tf8);
        p2.add(l10);
        p2.add(tf9);
        p2.add(l11);
        p2.add(tf10);
        p2.add(b1);
        p2.add(b2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icons/empng.png"));
        Image i2 = il.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l13=new JLabel(i3);
        
        p3.add(l13);
        
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");
        
        
        ch.addMouseListener(new MouseAdapter ()
        {
         
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    Connectionclass obj2 = new Connectionclass();
                    String empID=ch.getSelectedItem();
                    String q1 = "select * from employee where empID='"+empID+"'";                 
                    ResultSet rest1=obj2.stm.executeQuery(q1);
                    while(rest1.next()){
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("fname"));
                        tf3.setText(rest1.getString("age"));
                        tf4.setText(rest1.getString("dod"));
                        tf5.setText(rest1.getString("address"));
                        tf6.setText(rest1.getString("phone"));
                        tf7.setText(rest1.getString("email"));
                        tf8.setText(rest1.getString("education"));
                        tf9.setText(rest1.getString("designation"));
                        tf10.setText(rest1.getString("aadhar"));
                       
                    }
                }
                catch(Exception exx){
                    exx.printStackTrace();
                }
            }
        });        
    }      
    public void actionPerformed(ActionEvent e){
         String id=ch.getSelectedItem();
         String name=tf1.getText();
         String fname=tf2.getText();
         String age=tf3.getText();
         String dod=tf4.getText();
         String address=tf5.getText();
         String phone=tf6.getText();
         String email=tf7.getText();
         String education=tf8.getText();
         String designation=tf9.getText();
         String aadhar=tf10.getText();
        
         if(e.getSource()==b1){
             try{
                  Connectionclass conn = new Connectionclass();
                  String q1 = "update employee set name ='"+name+"', fname = '"+fname+"', age = '"+age+"', dod = '"+dod+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"', aadhar = '"+aadhar+"' where empID = '"+id+"'";
                  int aa=conn.stm.executeUpdate(q1);
                  if(aa == 1)
                  {
                      JOptionPane.showMessageDialog(null, "Data Successfully Updated");
                      this.setVisible(false);
                      new Update_Details_Data();
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Please fill all details carefully");
                  }                  
             }
             catch(Exception ee){
                 ee.printStackTrace();
             }             
         }if(e.getSource() == b2) {
            this.setVisible(false);
         }                 
     }
     public static void main(String[] args){
         new Update_Details_Data().setVisible(true);
         
     }
}
