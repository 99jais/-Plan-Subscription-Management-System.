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
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Long invoiceId = Long.parseLong(request.getParameter("invoiceId"));
		System.out.println(invoiceId);
		double invoiceAmount = Double.parseDouble(request.getParameter("invoiceAmount"));
		System.out.println(invoiceAmount);
		String note = request.getParameter("note");
		System.out.println(note);
		
		
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
					stmt=conn.prepareStatement("UPDATE invoice_details SET total_open_amount ='"+ invoiceAmount+"' , notes ='"+note+"' where doc_id='"+invoiceId+"'"); 
					
					System.out.println("hi_1");
					stmt.executeUpdate();
					System.out.println("hi_3");
					System.out.println("Invoice details added sucessfully !!");
					}
				catch(SQLException e) {
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
