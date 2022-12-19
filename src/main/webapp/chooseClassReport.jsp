<%@page import="com.entities.ClassList"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Choose Class for Report</title>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<h1>Choose a Class for Report Page: </h1>
		<%
			SessionFactory sf  = ConnectionProvider.getFactory();
			Session hibernateSession = sf.openSession();
			List<ClassList> classes = hibernateSession.createQuery("from ClassList").list();	
		%>
		<form action="classReport.jsp" method="post">
			Class-Name: 
			<select name="class">
				<%
					for (ClassList clas : classes){
						out.print("<option>" + clas.getCname());
						out.print("</option>");
					}
				%>
			</select>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>