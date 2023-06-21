package Employee_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connectionclass {
   
    Connection con;
    Statement stm;
    
    Connectionclass(){
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///employee_management","root","PFH#23kgrw9");
            stm = con.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }  
    }
    public static void main(String[] args)
    {
        new EmployeeFirstpage();
        new Connectionclass();
    }
}

