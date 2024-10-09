
package sardidoaps;


import java.util.Scanner;

public class SardidoAPS {

public void addEmployees(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Employee Full Name: ");
        String e_fullname = sc.nextLine();
        System.out.println("Employee Time In: ");
        String e_timein = sc.nextLine();
        System.out.print("Employee Time Out: ");
        String e_timeout = sc.nextLine();
        System.out.print("Date: ");
        String date = sc.nextLine();
        System.out.print("Employee Role: ");
        String e_role = sc.nextLine();
        System.out.print("Employee Status: ");
        String e_status = sc.nextLine();
        
          String sql = "INSERT INTO employees (e_fullname, e_timein, e_timeout, date, e_role, e_status)VALUES (?, ?, ?, ?, ?, ?)";
          
          conf.addRecord(sql, e_fullname, e_timein, e_timeout, date , e_role, e_status);
}
private void viewEmployees() {
        String query = "SELECT * FROM employees";
        String[] headers = {"ID", "Full Name", "Time In", "Time Out", "Date", "Employee Role", "Employee Status"};
        String[] columns = {"e_id", "e_fullname", "e_timein", "e_timeout", "date", "e_role", "e_status"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
 public void updateEmployees(){
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Employee Full Name: (Don't put space between firstname and lastname): ");
        String new_fullname = sc.next();
        System.out.print("Enter new Employee Time In: ");
        String new_timein = sc.next();
        System.out.print("Enter new Employee Time out: ");
        String new_timeout = sc.next();
        System.out.print("Enter new Date: ");
        String new_date = sc.next();
        System.out.print("Enter new Employee Role: ");
        String new_role = sc.next();
        System.out.print("Enter new Employee Status: ");
        String new_status = sc.next();
        
        String query = "UPDATE employees SET e_fullname = ?, e_timein = ?, e_timeout = ?, date = ?, e_role = ?, e_status = ? WHERE e_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_fullname, new_timein, new_timeout, new_date, new_role, new_status, id);
 }
   private void deleteEmployee(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM employees WHERE e_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);

   }
 public static void main(String[] args) {
        
        SardidoAPS test = new SardidoAPS();
        Scanner sc = new Scanner(System.in);
        String response;
      
        do{  
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Action: ");
        int action = sc.nextInt();
        
        switch(action){
            case 1:
                test.addEmployees();
            break;    
            case 2:
                test.viewEmployees();
            break;
            case 3:
                test.viewEmployees();
                test.updateEmployees();
                break;
            case 4:
                test.viewEmployees();
                test.deleteEmployee();
                test.viewEmployees();
            break;
                
        }
        System.out.print("Do you want to CONTINUE? ");
            response = sc.next();
            
        }while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");
        
    }
    
}
