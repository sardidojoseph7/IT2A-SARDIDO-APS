
package sardidoaps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class config {
    
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:sardidoaps.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
        
    }
   public void addAttendance(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Employee Full Name: ");
        String fullname = sc.next();
        System.out.print("Employee Time In: ");
        String timein = sc.next();
        System.out.print("Employee Time Out: ");
        String timeout = sc.next();
        System.out.print("Employee Date: ");
        String date = sc.next();
        System.out.print("Employee Role: ");
        String role = sc.next();
        System.out.print("Student Status: ");
        String status = sc.next();
        
          String sql = "INSERT INTO employee_aps (e_fullname, Time In, Time Out, Date, e_role, e_status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fullname);
            pst.setString(2, timein);
            pst.setString(3, timeout);
            pst.setString(4, date);
            pst.setString(5, role);
            pst.setString(6, status);
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
        }catch(SQLException e){
            System.out.println("Connection error"+e.getMessage());
        };
        
         
    }
}