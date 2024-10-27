
package sardidoaps;


import java.util.Scanner;

public class SardidoAPS {

  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HR hr = new HR();
        Attendance att = new Attendance();
        Payslip pays = new Payslip();
        int chose;
        
    do{ 
        System.out.println("Enter Option: ");
        System.out.println("1. Employee");
        System.out.println("2. Attendance");
        System.out.println("3. Payslip");
        System.out.println("4. Exit");
        System.out.print("Enter Choice: ");
        int act = sc.nextInt();
       
     switch(act){
            case 1:
                hr.Employee();
                break;
            
            case 2:
                att.EAttendance();
                break;

            case 3:
                pays.Payslip();
                break;
                
            case 4:
                System.out.println("Exiting.......");
                break;
            default:
                System.out.println("Action Error, There's no such number");
        }
        System.out.print("\nEnter Choice Again (1/0)?: ");
        chose = sc.nextInt();
        
}while(chose != 0);
        System.out.println("Thank You for using Payslip Generation System!)!");   
    }
    
}
