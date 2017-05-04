package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListenerTester extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		System.out.println("1");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("test context attributes set by listener<br>");
		out.print("<br>");
		
		Dog dog = (Dog) getServletContext().getAttribute("dog");
		
		out.println("Dog's breed is: " + dog.getBreed());
	}
}
