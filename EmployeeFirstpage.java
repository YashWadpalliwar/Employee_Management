package Employee_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class EmployeeFirstpage extends JFrame implements ActionListener{
    
    EmployeeFirstpage(){
        
           setBounds(100, 100, 1322, 566);
           setLayout(null);        
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icons/emplo.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(0, 0, 1366, 565);
        add(image);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(155, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN,60));
        heading.setForeground(Color.blue);
        add(heading);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 470, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN, 24));
        image.add(next);        
        setVisible(true); 
        
        
        }
        
    
    public void actionPerformed(ActionEvent ae){
          setVisible(false);
          new Loginpage();
        }         
    
    public static void main(String[] args) {
        new EmployeeFirstpage();
    }
}
