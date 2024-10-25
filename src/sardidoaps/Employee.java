
package sardidoaps;

import java.util.Scanner;


public class Employee {

public void Employee(){
    Employee test = new Employee();
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
public void addEmployees(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Employee First Name: ");
        String e_fname = sc.nextLine();
        System.out.print("Employee Last Name: ");
        String e_lname = sc.nextLine();
        System.out.print("Employee Email: ");
        String e_email = sc.nextLine();
        System.out.print("Employee Phone Number: ");
        String e_phonenumber = sc.nextLine();
        System.out.print("Employee Role: ");
        String e_role = sc.nextLine();
        
        
        
          String sql = "INSERT INTO employees (e_fname, e_lname, e_email, e_phonenumber, e_role)VALUES (?, ?, ?, ?, ?)";
          
          conf.addRecord(sql, e_fname, e_lname, e_email, e_phonenumber , e_role);
    }
public void viewEmployees() {
        String query = "SELECT * FROM employees";
        String[] headers = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Employee Role"};
        String[] columns = {"e_id", "e_fname", "e_lname", "e_email", "e_phonenumber", "e_role"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
 public void updateEmployees(){
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Employee First Name: ");
        String new_fname = sc.next();
        System.out.print("Enter new Employee Last Name: ");
        String new_lname = sc.next();
        System.out.print("Enter new Employee Email: ");
        String new_email = sc.next();
        System.out.print("Enter new Phone Number: ");
        String new_phonenumber = sc.next();
        System.out.print("Enter new Employee Role: ");
        String new_role = sc.next();
        
        String query = "UPDATE employees SET e_fname = ?, e_lname = ?, e_email = ?, e_phonenumber = ?, e_role = ? WHERE e_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_fname, new_lname, new_email, new_phonenumber, new_role, id);
 }
   public void deleteEmployee(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM employees WHERE e_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
     
    
    }

}
