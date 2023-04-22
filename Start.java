package com.company.employee;

//importing
import java.util.Scanner;
public class Start {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Boolean start=true;
		Boolean isSuccess=false;
		System.out.println("Welcome to EMS");
		
		while(start) {
			System.out.println("1.Add Employee");
			System.out.println("2.Delete Employee");
			System.out.println("3.Read Employee");
			System.out.println("4.Update Employee");
			System.out.println("5.Exit");
			System.out.print("Your Input[1-5] : ");
			
			int ch=sc.nextInt();
			
			sc.nextLine();
			switch(ch) {
			case 1: System.out.print("Enter Employee Name: ");
					String ename=sc.nextLine();
					
					System.out.print("Enter Employee Phone: ");
					String ephone=sc.nextLine();
					
					System.out.print("Enter Employee dept: ");
					int edept=sc.nextInt();
					
					Employee employee =new Employee(ename,ephone,edept);
					
					System.out.println(employee.toString());
					
					isSuccess=EmployeeController.insertEmployeeIntoDb(employee);
					
					if(isSuccess) {
						System.out.println("Successful");
					}
					else {
						System.out.println("Unsuccessful");
					}
					break;
			case 2:
				System.out.println("Enter id: ");
				int eid = sc.nextInt();	
				
				isSuccess=EmployeeController.deletefromEmployee(eid);
				
				if(isSuccess) {
					System.out.println("Successful");
				}
				else {
					System.out.println("Unsuccessful");
				}
				
				break;
			case 3:
				System.out.print("For all records: 1\nFor specific employee: 2");
				System.out.print("\nYour Choice: ");
				int choice=sc.nextInt();
				
				if(choice==1) {
					isSuccess=EmployeeController.showAll();	
					if(isSuccess) {
						System.out.println("Successful");
					}
					else {
						System.out.println("Unsuccessful");
					}
				}
				else if(choice==2) {
					int id;
					System.out.print("Enter id of the Employee: ");
					id=sc.nextInt();
					isSuccess=EmployeeController.showRecord(id);
					if(isSuccess) {
						System.out.println("Successful");
					}
					else {
						System.out.println("Unsuccessful");
					}
				}
				break;
			case 4:
				int id;
				System.out.print("Enter id of the Employee whose details are to be updated: ");
				id=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Employee's updated Phone: ");
				String uphone=sc.nextLine();
				
				isSuccess=EmployeeController.updateTable(uphone,id);
				
				if(isSuccess) {
					System.out.println("Successful");
				}
				else {
					System.out.println("Unsuccessful");
				}
				break;
			case 5:
				System.out.println("Exiting EMS..!!!!!");
				start=false;
				break;
				
			default:
				System.out.println("Invalid Input !!");
				break;
			}
		}
	}
}
