package Employee_Management;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Loginpage extends JFrame implements ActionListener{
    JTextField tfusername, tfpassword;
    
    Loginpage(){
       getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton Login = new JButton("Login");
        Login.setBounds(150, 140, 150, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icons/second.jpg"));
        Image i2 = il.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
          try{
              String username = tfusername.getText();
              String password = tfpassword.getText();
              
              Connectionclass c = new Connectionclass();
              String query = "select * from logindata where username = '"+username+"' and password = '"+password+"'";
              
              ResultSet rs = c.stm.executeQuery(query);
              if (rs.next()){
                  setVisible(false);
                  new HomePage();
                 
              }else {
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
              
              
          }catch (Exception e){
              e.printStackTrace();
          }
        }
    
    public static void main(String[] args){
        new Loginpage();
    }
}
