package com.highradius.h2h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Searchrows {
	
	 public static ArrayList<Pojo> getAll(Long search) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			Connection dbCon=null;
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        Long value = search;
	        String query="SELECT * FROM invoice_details WHERE invoice_id LIKE '" + search + "%' LIMIT 30";
	        String jdbcURL = "jdbc:mysql://localhost:3306/h2h_internship";
	        String userName="root";
	        String password="poonam76";
	        
	        ArrayList<Pojo> DataList = new ArrayList<Pojo>();
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            dbCon=DriverManager.getConnection(jdbcURL,userName,password);
	            pstmt=dbCon.prepareStatement(query);
	            rs=pstmt.executeQuery();
	            
	            while(rs.next()) {	
	            	Pojo ob =new Pojo();
	            	
	            	ob.setName_customer(rs.getString("name_customer"));
	            	ob.setCust_number(rs.getString("cust_number"));
	            	ob.setInvoice_id(rs.getLong("invoice_id"));
	            	ob.setTotal_open_amount(rs.getLong("total_open_amount"));
	            	ob.setDue_in_date(rs.getDate("due_in_date"));
	            	DataList.add(ob);
	            }
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return DataList;
		}

		
		
		}
