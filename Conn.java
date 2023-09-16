import java.sql.*;

public class Conn {
    
    //To connect with SQL
    /*
     * Register the Driver
     * Create connection
     * create statment
     * Execute query
     * Close Connection 
     */

     Connection c;
     Statement s;
    public Conn(){

        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "12345678");
            s  = c.createStatement();
           
        } catch(Exception e){
            System.out.println("This is the Error: " + e);
        }
    }

}
