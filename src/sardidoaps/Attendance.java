
package sardidoaps;

import java.util.Scanner;

public class Attendance {
    Scanner sc = new Scanner(System.in);
    Attendance att = new Attendance();
    String response;
    
    public void Attendance() {
        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Action: ");
            int action = sc.nextInt();
            sc.nextLine(); 

            switch (action) {
                case 1:
                    att.addAttendance();
                    break;
                case 2:
                    att.viewAttendance();
                    break;
                case 3:
                    att.viewAttendance();
                    att.updateAttendance();
                    break;
                case 4:
                    att.viewAttendance();
                    att.deleteAttendance();
                    break;
                case 5:
                    System.out.println("Exiting Attendance Data.");
                    return; 
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Do you want to CONTINUE? (yes/no): ");
            response = sc.nextLine();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank You!");
    }
    
    public void addAttendance(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Attendance Date: ");
        String a_date = sc.nextLine();
        System.out.print("Attendance Time In: ");
        String a_timein = sc.nextLine();
        System.out.print("Attendance Time Out: ");
        String a_timeout = sc.nextLine();
        System.out.print("Total Hours Worked: ");
        String a_totalhoursworked = sc.nextLine();
        System.out.print("Attendance Status(Present, Late, Absent): ");
        String a_status = sc.nextLine();
        
        
        
          String sql = "INSERT INTO attendance (a_date, a_timein, a_timeout, a_totalhoursworked, a_status)VALUES (?, ?, ?, ?, ?)";
          
          conf.addRecord(sql, a_date, a_timein, a_timeout, a_totalhoursworked , a_status);
    }
private void viewAttendance() {
        String query = "SELECT * FROM attendance";
        String[] headers = {"Attendance ID", "Employee ID", "Attendance Date", "Attendance Time In", "Attendance Time Out", "Total Hours Worked","Attendance Status"};
        String[] columns = {"a_id", "e_id", "a_date", "a_timein", "a_timeout", "a_totalhoursworked", "a_status"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
 public void updateAttendance(){
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Attendance Date: ");
        String new_date = sc.next();
        System.out.print("Enter new Attendance Time In: ");
        String new_timein = sc.next();
        System.out.print("Enter new Attendance Time Out: ");
        String new_timeout = sc.next();
        System.out.print("Enter new Total Hours Worked: ");
        String new_totalhoursworked = sc.next();
        System.out.print("Enter new Attendance Status: ");
        String new_status = sc.next();
        
        String query = "UPDATE attendance SET a_date = ?, a_timein = ?, a_timeout = ?, a_totalhoursworked = ?, a_status = ? WHERE e_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_date, new_timein, new_timeout, new_totalhoursworked, new_status, id);
 }
   private void deleteAttendance(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM attendance WHERE e_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
     
   }
}
