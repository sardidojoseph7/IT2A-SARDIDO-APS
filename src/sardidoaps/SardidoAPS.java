
package sardidoaps;


import java.util.Scanner;

public class SardidoAPS {

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
        
          String sql = "INSERT INTO employee_aps (e_fullname, e_timein, e_timeout, Date, e_role, e_status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
}
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Action: ");
        int action = sc.nextInt();
        
        switch(action){
            case 1:
                
            break;    
        }
        
        
    }
    
}
