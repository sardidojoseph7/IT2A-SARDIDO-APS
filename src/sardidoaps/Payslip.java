
package sardidoaps;

import java.util.Scanner;


public class Payslip {
    
    public void Payslip(){
    Payslip pays = new Payslip();
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
                pays.addPayslip();
            break;    
            case 2:
                pays.viewPayslip();
            break;
            case 3:
                pays.viewPayslip();
                pays.updatePayslip();
                break;
            case 4:
                pays.viewPayslip();
                pays.deletePayslip();
                pays.viewPayslip();
            break;
                
        }
        System.out.print("Do you want to CONTINUE? ");
            response = sc.next();
            
        }while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");
}
    
    
public void addPayslip(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
      
        System.out.print("PsE First Name: ");
        String p_fname = sc.nextLine();
        System.out.print("PsE Last Name: ");
        String p_lname = sc.nextLine();
        System.out.print("Payslip Date: ");
        String p_pdate = sc.nextLine();
        System.out.print("Payslip Basic Salary: ");
        String p_bsalary = sc.nextLine();
        System.out.print("Payslip Total Hours Worked: ");
        String p_totalhoursworked = sc.nextLine();
        System.out.print("Payslip Hourly Rate: ");
        String p_hourlyrate = sc.nextLine();
        System.out.print("Payslip Allowance: ");
        String p_allowance = sc.nextLine();
        System.out.print("Payslip Deductions: ");
        String p_deductions = sc.nextLine();
        System.out.print("Payslip Overtime Hours: ");
        String p_overtimehours = sc.nextLine();
        System.out.print("Payslip Overtime Pay: ");
        String p_overtimepay = sc.nextLine();
     
        double p_grosspay = calculateGrossPay(p_hourlyrate, p_totalhoursworked, p_overtimehours, p_overtimepay);
        double p_netpay = calculateNetPay(p_grosspay, p_allowance, p_deductions);

          String sql = "INSERT INTO payslip (p_fname, p_lname, p_pdate, p_bsalary, p_totalhoursworked, p_hourlyrate, p_allowance, p_deductions, p_overtimehours, p_overtimepay)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          
          conf.addRecord(sql, p_fname, p_lname ,p_pdate, p_bsalary,p_totalhoursworked, p_hourlyrate, p_allowance , p_deductions, p_overtimehours, p_overtimepay);
    }
public void viewPayslip() {
        String query = "SELECT * FROM payslip";
        String[] headers = {"Payslip ID", "Payslip Employee First Name","Payslip Employee Last Name","Payslip Date", "Payslip Basic Salary", "Payslip Hourly Rate", "Payslip Allowance", "Payslip Deductions", "Payslip Overtime Hours", "Payslip Overtime Pay", "Payslip Gross Pay", "Payslip Netpay"};
        String[] columns = {"p_id", "p_fname", "p_lname","p_pdate", "p_bsalary", "p_hourlyrate", "p_allowance", "p_deductions", "p_overtimehours", "p_overtimepay", "p_grosspay","p_netpay"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
 public void updatePayslip(){
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Payslip EFirst Name: ");
        String new_fname = sc.next();
        System.out.print("Enter new Payslip ELast Name: ");
        String new_lname = sc.next();
        System.out.print("Enter new Payslip Date: ");
        String new_pdate = sc.next();
        System.out.print("Enter new Payslip Basic Salary:: ");
        String new_bsalary = sc.next();
        System.out.print("Enter new Total Hours Worked: ");
        String new_totalhoursworked = sc.next();
        System.out.print("Enter new Hourly Rate:: ");
        String new_hourlyrate = sc.next();
        System.out.print("Enter new Allowance: ");
        String new_allowance = sc.next();
        System.out.print("Enter new Deductions: ");
        String new_deductions = sc.next();
        System.out.print("Enter new Overtime Hours: ");
        String new_overtimehours = sc.next();
        System.out.print("Enter Overtime Pay: ");
        String new_overtimepay = sc.next();
        
        String query = "UPDATE payslip SET p_fname = ?, p_lname = ?, p_pdate = ?, p_bsalary = ?, p_totalhoursworked = ?, p_hourlyrate = ?, p_allowance = ?, p_deductions = ?, p_overtimehours = ?, p_overtimepay = ? WHERE e_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_fname, new_lname ,new_pdate, new_bsalary, new_totalhoursworked, new_hourlyrate, new_allowance, new_deductions, new_overtimehours, new_overtimepay, id);
 }
   public void deletePayslip(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM payslip WHERE p_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
     
    
    }

   public double calculateGrossPay(double p_hourlyrate, double p_totalhoursworked, double p_overtimehours, double p_overtimepay) {
        return (p_hourlyrate * p_totalhoursworked) + (p_overtimehours * p_overtimepay);
   }
   public double calculateNetPay(double p_grosspay, double p_allowances, double p_deductions) {
        return p_grosspay + p_allowances - p_deductions;
   }
}

