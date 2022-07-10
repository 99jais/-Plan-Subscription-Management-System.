package com.highradius.h2h;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class FetchdataServlet
 */

public class FetchdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList <Pojo> invoice = new ArrayList<Pojo>();

    /**
     * Default constructor. 
     */
    public FetchdataServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int page = Integer.parseInt(request.getParameter("page"));
		
		System.out.println("inside servlet");
		
		try {
			invoice = Fetchdata.getAllInvoice(page);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson  gson = new Gson();
		String str = gson.toJson(invoice);
		PrintWriter out = response.getWriter();
		out.println(str);
		System.out.println("Successful" + str);
		out.flush();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}


 
