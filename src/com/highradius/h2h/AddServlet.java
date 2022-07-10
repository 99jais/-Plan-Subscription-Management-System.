package com.highradius.h2h;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AddServlet
 */
//@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String customerNumber = request.getParameter("customerNumber");
		String customerName = request.getParameter("customerName");
		double invoiceAmount = Double.parseDouble(request.getParameter("invoiceAmount"));
		Long invoiceId = Long.parseLong(request.getParameter("invoiceId"));
		String note = request.getParameter("note");
		Date dueInDate = null;
		try {
			java.util.Date cr2 = new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("dueInDate"));
			java.sql.Date cd2 = new java.sql.Date(cr2.getTime());
			dueInDate = cd2;
		}catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		
		//make the jdbc connection 
		
		//JDBC driver name and database URL
				 final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
				 final String DB_URL = "jdbc:mysql://localhost:3306/h2h_internship";
				
				//Database credentials
				 final String USER = "root";
				 final String PASS = "poonam76";
				
				 Connection conn = null;
				 
				 
				 PreparedStatement stmt=null;
				 
				try {
					//register JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//open a connection
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					
					System.out.println("connection estabilish");	
					
				
				}catch(Exception e) {
					//handle error for class.forName
					e.printStackTrace();
				}
				
				try {
					stmt=conn.prepareStatement("insert into invoice_details (cust_number,name_customer,invoice_id,total_open_amount,due_in_date,doc_id,notes) values (?,?,?,?,?,?,?)"); // i am right now not inserting note
					stmt.setString(1, customerNumber);
					stmt.setString(2, customerName);
					stmt.setLong(3,invoiceId);
					stmt.setDouble(4, invoiceAmount);
					stmt.setDate(5, dueInDate);
					stmt.setLong(6, invoiceId);
					stmt.setString(7, note);
					stmt.executeUpdate();
					
					System.out.println("Invoice details added sucessfully !!");
					}catch(SQLException e) {
					e.printStackTrace();
				}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
