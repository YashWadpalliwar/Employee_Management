package Employee_Management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Delete_Employee extends JFrame implements ActionListener{
    
    JTable t;
    JButton bt1;
    JTextField tf1;
    JPanel p1,p2,p3;
    String x[]={"Employee ID","Name","Email","Age","Date of Birth","Post"};
    String y[][]=new String [20][6];
    int i=0,j=0;
    Font f,f1;
    JLabel l1,l2;
    
    Delete_Employee(){
         super("Delete any Employee");
        setLocation(0,10);
        setSize(1480,400);
        f=new Font("MS UI Gothic",Font.BOLD,17); 
        
        try
                {
                    Connectionclass obj = new Connectionclass();               
                    String q = "select * from employee";                 
                    ResultSet rest=obj.stm.executeQuery(q);
                    while(rest.next()){
                        
                        y[i][j++]=rest.getString("empID");
                        y[i][j++]=rest.getString("name");
                        y[i][j++]=rest.getString("Email");
                         y[i][j++]=rest.getString("Age");
                        y[i][j++]=rest.getString("dod");
                        y[i][j++]=rest.getString("designation");                       
                        i++;
                        j=0;
                    }
                    t=new JTable(y,x);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }   
                t.setBackground(Color.BLACK);
                t.setForeground(Color.WHITE);
                t.setFont(f);
        
                JScrollPane js=new JScrollPane(t);
                
                f1=new Font("Lucida Fax",Font.BOLD,25);
                
                l1=new JLabel("Delete any Employee");
                l1.setHorizontalAlignment(JLabel.CENTER);
                l1.setFont(f1);
                l1.setForeground(Color.YELLOW);
                
                l2=new JLabel("Employee ID");
                l2.setFont(f1);
                l2.setForeground(Color.GRAY);      
                
                tf1=new JTextField();
                bt1=new JButton("Delete Employee");
                tf1.setFont(f);
                bt1.setFont(f);
                
                bt1.setBackground(Color.BLACK);
                bt1.setForeground(Color.red);
                bt1.addActionListener(this);
                
                p1=new JPanel();
                p1.setLayout(new GridLayout(1,1,10,10));
                p1.add(l1);

                p2=new JPanel();
                p2.setLayout(new GridLayout(1,3,10,10));
                p2.add(l2);
                p2.add(tf1);
                p2.add(bt1);

                p3=new JPanel();
                p3.setLayout(new GridLayout(2,1,10,10));
                p3.add(p1);
                p3.add(p2);
                
                p1.setBackground(Color.BLACK);
                p2.setBackground(Color.BLACK);
                p3.setBackground(Color.BLACK);

                add(p3,"South");
                add(js);                                                
                
                
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1)
        {
            String eid=tf1.getText();
            
            try{
                 Connectionclass obj1 = new Connectionclass();
                 String q="delete from employee where empID='"+eid+"'";
                 String q1="delete from attendence where Eid='"+eid+"'";
                 String q2="delete from salary where Eid='"+eid+"'";
                 int res=obj1.stm.executeUpdate(q);
                 
                 
                 if(res==1){
                     JOptionPane.showMessageDialog(null, "Data Successfully deleted");
                     obj1.stm.executeUpdate(q1);
                     obj1.stm.executeUpdate(q2);
                     this.setVisible(false);          
                     new Delete_Employee().setVisible(true);
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "did't delete sorry !!!");
                     this.setVisible(false);          
                     new Delete_Employee().setVisible(true);
                 }
                 
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }        
    }
    public static void main(String[] args){
         new Delete_Employee().setVisible(true);         
     }
}
