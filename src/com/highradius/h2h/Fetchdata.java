package com.highradius.h2h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Fetchdata {

	private static Connection connection = null;
	Connection conn = null;
	Statement stmt = null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		if(connection != null)
			return connection;
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String jdbcURL = "jdbc:mysql://localhost:3306/h2h_internship";
		        String username = "root";
		        String password = "poonam76";
		        connection = DriverManager.getConnection(jdbcURL, username, password);
	            connection.setAutoCommit(false);
			}catch (SQLException ex) {
	            ex.printStackTrace();
	 
	            try {
	                connection.rollback();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		}
		return connection;
}
	public static ArrayList<Pojo> getAllInvoice(int page) throws ClassNotFoundException{
		connection = Fetchdata.getConnection();
		ArrayList<Pojo> invoicelist = new ArrayList<Pojo>();
		try {
			Statement statement = connection.createStatement();

			int records_per_page = 20;
			
			ResultSet rs = statement.executeQuery("SELECT * FROM invoice_details LIMIT " +(page-1)*records_per_page+","+records_per_page);
			while(rs.next())
			{
				Pojo ob = new Pojo();
				
				ob.setBusiness_code(rs.getString("business_code"));
				ob.setCust_number(rs.getString("cust_number"));
				ob.setName_customer(rs.getString("name_customer"));
				ob.setClear_date(rs.getString("clear_date"));
				ob.setBusiness_year(rs.getShort("business_year"));
				ob.setDoc_id(rs.getLong("doc_id"));
				ob.setPosting_date(rs.getDate("posting_date"));
				ob.setDocument_create_date(rs.getDate("document_create_date"));
				ob.setDue_in_date(rs.getDate("due_in_date"));
				ob.setInvoice_currency(rs.getString("invoice_currency"));
				ob.setDocument_type(rs.getString("document_type"));
				ob.setPosting_id(rs.getShort("posting_id"));
				ob.setArea_business(rs.getString("area_business"));
				ob.setTotal_open_amount(rs.getLong("total_open_amount"));
				ob.setBaseline_create_date(rs.getDate("baseline_create_date"));
				ob.setCust_payment_terms(rs.getString("cust_payment_terms"));
				ob.setInvoice_id(rs.getLong("invoice_id"));
				ob.setIsOpen(rs.getShort("isOpen"));
				ob.setNotes(rs.getString("notes"));
				
				invoicelist.add(ob);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("abc"+ invoicelist);
		return invoicelist;
		
	}
    }

