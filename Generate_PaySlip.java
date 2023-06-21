package Employee_Management;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_PaySlip extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6;
    Font f;
    JTextArea ta;
    Choice ch1,ch2,ch3;
    JButton bt1,bt2;
    JPanel p1;
    
    Generate_PaySlip(){
        
        super("Generate pay Slip");
        setLocation(100,100);
        setSize(500,500);
        setResizable(false);
                
        f=new Font("Arial",Font.BOLD,16);
  
        l1=new JLabel("Employee Id");
        l2=new JLabel("Month");
        l3=new JLabel("Year");
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        
        ch1=new Choice();
        
        try {
              Connectionclass obj = new Connectionclass();
              String q = "select * from employee";
              ResultSet rest=obj.stm.executeQuery(q);
              while(rest.next())
              {
                  ch1.add(rest.getString("empID"));
              }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        ch2=new Choice();
        ch2.add("January");
        ch2.add("February");
        ch2.add("March");
        ch2.add("April");
        ch2.add("May");
        ch2.add("June");
        ch2.add("July");
        ch2.add("August");
        ch2.add("September");
        ch2.add("October");
        ch2.add("November");
        ch2.add("December");
        
        ch3=new Choice();
        ch3.add("2015");
        ch3.add("2016");
        ch3.add("2017");
        ch3.add("2018");
        ch3.add("2019");
        ch3.add("2020");
        ch3.add("2021");
        ch3.add("2022");
        ch3.add("2023");
        ch3.add("2024");
        
        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
            
        bt1=new JButton("Print");
        bt1.setBackground(Color.BLACK);        
        bt1.setForeground(Color.WHITE);   
        bt1.addActionListener(this);
        bt1.setFont(f);
        
        bt2=new JButton("Close");
        bt2.setBackground(Color.BLACK);        
        bt2.setForeground(Color.WHITE);
        bt2.addActionListener(this);
        bt2.setFont(f);               

        p1=new JPanel();
        p1.setLayout(new GridLayout(4,2,10,10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(ch2);
        p1.add(l3);
        p1.add(ch3);
        p1.add(bt1);
        p1.add(bt2);
                
        ta=new JTextArea();
        JScrollPane sp=new JScrollPane(ta);
        ta.setEditable(false);
        ta.setFont(f);
        
        setLayout(new BorderLayout ());
        add(sp,"Center");
        add(p1,"South");
        
    }
    
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1){
            ta.setText("-----------------------pay slip-------------------------");
            try{
                
                Connectionclass obj1 = new Connectionclass();
                String id=ch1.getSelectedItem();
                String month_year=ch2.getSelectedItem()+" "+ch3.getSelectedItem();            
                String q1="select * from salary where Eid='"+id+"'";
                ResultSet rest1=obj1.stm.executeQuery(q1);
                while(rest1.next()){
                    ta.append("\n\nEmployee Id : "+Integer.parseInt(rest1.getString("Eid")));
                    ta.append("\nEmployee Name :"+rest1.getString("name"));
                    ta.append("\nEmployee Name :"+rest1.getString("email"));
                    ta.append("\n-------------------------------------------\n\n");
                    
                }
                
                String q2="select * from salary where month_year='"+month_year+"' and Eid='"+id+"'";                
                ResultSet rest2=obj1.stm.executeQuery(q2);
                if(rest2.next()==false){
                    ta.append("\n-----------------------------------------------------------\n\n");
                    ta.append("Record Not Found of this Month and year.\n");
                    ta.append("\n-----------------------------or------------------------------\n\n");
                    ta.append("Please add the salary of this month and year for this record.\n");
                }
                else{
                        ta.append("\n\nHRA : "+Float.parseFloat(rest2.getString("hra")));
                        ta.append("\nDA : "+Float.parseFloat(rest2.getString("da")));
                        ta.append("\nMED : "+Float.parseFloat(rest2.getString("mid")));
                        ta.append("\nPF : "+Float.parseFloat(rest2.getString("pf")));
                        ta.append("\nBASIC Salary : "+Float.parseFloat(rest2.getString("basic")));      
                } 
            }
            catch(Exception exx){
                 exx.printStackTrace();
             }
        }        
        if(e.getSource()==bt2){
            JOptionPane.showMessageDialog(null, "Are you sure to close?");
            setVisible(false);
     }
}
    
    public static void main(String[] args)
    {
        new Generate_PaySlip().setVisible(true);   
    }
}
