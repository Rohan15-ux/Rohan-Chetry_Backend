package com.company.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeController {
	static Boolean insertEmployeeIntoDb(Employee employee) {
		Boolean statusok=false;
		//Creating connection
		try {
			Connection dbconnect=DBConnection.createConnection();
			
			String query="insert into employee(name,ephone,dept)values (?, ?, ?)";
			PreparedStatement pstm=dbconnect.prepareStatement(query);
			
			//setting parameters
			pstm.setString(1,employee.getName());
			pstm.setString(2,employee.getPhone());
			pstm.setInt(3,employee.getDept());
			
			
			//execute
			pstm.executeUpdate();
			
			statusok=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statusok;
	}
	
	static Boolean deletefromEmployee(int eid) {
		Boolean statusok=false;
		
		try {
			Connection con=DBConnection.createConnection();
			
			String query="delete from employee where id = ?";
			PreparedStatement pstm=con.prepareStatement(query);
			
			pstm.setInt(1,eid);
			
			pstm.executeUpdate();
			
			statusok=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return statusok;
	}
	
	static Boolean showAll() {
		Boolean statusok=false;
		
		try {
			Connection con=DBConnection.createConnection();
			String query="Select * from employee";
			
			Statement smt=con.createStatement();
			
			ResultSet r=smt.executeQuery(query);
			
			while(r.next()) {
				int id=r.getInt("id");
				String name=r.getString("name");
				String phone=r.getString("ephone");
				int dept=r.getInt("dept");
				
				Employee e=new Employee(id,name,phone,dept);
				
				System.out.println(e.toString());
			}
			statusok=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return statusok;
	}
	
	static Boolean showRecord(int id) {
		Boolean statusok=false;
		
		
		try {
			Connection con=DBConnection.createConnection();
			
			String query="select * from employee where id=?";
			PreparedStatement st=con.prepareStatement(query);
			
			st.setInt(1,id);
//			
			ResultSet rs=st.executeQuery();  
			while(rs.next()) {
				int eid=rs.getInt("id");
				String name=rs.getString("name");
				String phone=rs.getString("ephone");
				int dept=rs.getInt("dept");
				Employee e=new Employee(eid,name,phone,dept);
				System.out.println(e.toString());
			}
			
			statusok=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusok;
	}
	
	static Boolean updateTable(String uphone,int id) {
		Boolean statusok=false;
		
		try {
			Connection con=DBConnection.createConnection();
			
			String query="update employee set ephone=? where id=?";
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1,uphone);
			st.setInt(2, id);
			
			st.executeUpdate();  
			
			statusok=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusok;
	}
}
