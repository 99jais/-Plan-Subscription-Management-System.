package com.highradius.h2h;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class FetchdataServlet
 */

public class DeletedataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * Default constructor. 
     */
    public DeletedataServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doDelete(HttpServletRequest request, HttpServletResponse resp) throws IOException
    {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String req_body = req.getReader().lines().reduce("",(accumulator,actual) -> accumulator +actual);
//		HashMap<String,String[]> req_body_map = new Gson().fromJson(req_body, new TypeToken<HashMap<String ,String[]>>(){}.getType());
//		
    	
    	String req_body = request.getReader().lines()
			    .reduce("", (accumulator, actual) -> accumulator + actual);
		System.out.println(req_body);
		
		HashMap<String, String[]> req_body_map = new Gson().fromJson(
												req_body, new TypeToken<HashMap<String, String[]>>(){}.getType()
											);
		
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(req_body_map.get("doc_ids")));

		String docIds = (String) list.stream().collect(Collectors.joining(",","(",")"));

		System.out.println("inside servlet");
		
		Connection dbCon=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    String jdbcURL = "jdbc:mysql://localhost:3306/h2h_internship";
	    String userName="root";
	    String password="poonam76";
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.addAll(Arrays.asList(req_body_map.get("doc_ids")));
//		
//		String docIds =(String)list.stream().collect(Collectors.joining(",","(",")"));
		 try {
		  		Class.forName("com.mysql.cj.jdbc.Driver");
		        dbCon=DriverManager.getConnection(jdbcURL,userName,password);
		        String query="DELETE FROM invoice_details WHERE doc_id IN" +docIds;
		        pstmt=dbCon.prepareStatement(query);
		        //rs=pstmt.executeQuery();
		        pstmt.executeUpdate();
		        pstmt.close();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
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


 
