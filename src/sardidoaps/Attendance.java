package sardidoaps;

import java.util.Scanner;

public class Attendance {
     Scanner sc = new Scanner(System.in);
     String response;

    public void EAttendance() {
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
                    this.addAttendance(); 
                    break;
                case 2:
                    this.viewAttendance(); 
                    break;
                case 3:
                    this.viewAttendance(); 
                    this.updateAttendance(); 
                    break;
                case 4:
                    this.viewAttendance(); 
                    this.deleteAttendance(); 
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
    
    public void addAttendance() {
        
        System.out.print("Attendance First Name: ");
        String a_fname = sc.nextLine();
        System.out.print("Attendance Last Name: ");
        String a_lname = sc.nextLine();
        System.out.print("Attendance Date: ");
        String a_date = sc.nextLine();
        System.out.print("Attendance Time In: ");
        String a_timein = sc.nextLine();
        System.out.print("Attendance Time Out: ");
        String a_timeout = sc.nextLine();
        System.out.print("Attendance Status (Present, Late, Absent): ");
        String a_status = sc.nextLine();
        
        String sql = "INSERT INTO attendance (a_fname, a_lname, a_date, a_timein, a_timeout, a_status) VALUES (?, ?, ?, ?, ?, ?)";
        
        config conf = new config();
        conf.addRecord(sql, a_fname, a_lname, a_date, a_timein, a_timeout, a_status);
    }

    public void viewAttendance() {
        String query = "SELECT * FROM attendance";
        String[] headers = {"Attendance First Name","Attendance Last Name","Attendance ID", "Employee ID", "Attendance Date", "Attendance Time In", "Attendance Time Out","Attendance Status"};
        String[] columns = {"a_fname", "a_lname" , "a_id", "e_id", "a_date", "a_timein", "a_timeout", "a_status"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }

    public void updateAttendance() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        
        System.out.print("Enter new Attendance First Name: ");
        String new_fname = sc.nextLine();
        System.out.print("Enter new Attendance Last Name: ");
        String new_lname = sc.nextLine();
        System.out.print("Enter new Attendance Date: ");
        String new_date = sc.nextLine();
        System.out.print("Enter new Attendance Time In: ");
        String new_timein = sc.nextLine();
        System.out.print("Enter new Attendance Time Out: ");
        String new_timeout = sc.nextLine();
        System.out.print("Enter new Attendance Status: ");
        String new_status = sc.nextLine();
        
        String query = "UPDATE attendance SET a_fname = ?, a_lname = ?, a_date = ?, a_timein = ?, a_timeout = ?, a_status = ? WHERE a_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_fname,new_lname,new_date, new_timein, new_timeout, new_status, id);
    }

    public void deleteAttendance() {
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM attendance WHERE a_id = ?"; 
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
