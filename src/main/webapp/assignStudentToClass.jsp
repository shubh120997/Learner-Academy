<%@page import="com.entities.ClassList"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.StudentList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Assign Student To Class</title>
		<style>
			table,th,td{
				border: 1px solid;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<h1>Assign a Student to a Class:</h1>
		<%
			SessionFactory sf = ConnectionProvider.getFactory();
			Session hibernateSession = sf.openSession();
			List<StudentList> students = hibernateSession.createQuery("from  StudentList").list();
			List<ClassList> classes = hibernateSession.createQuery("from  ClassList").list();
		%>
		<form action="AssignStudentToClass" method="post">
			<table>
				<tr>
					<th>Student Name </th>
					<th>Class Name </th>
				</tr>
				<tr> 
					<td> <select name="name">
						<%
							for (StudentList student : students){
								out.print("<option>" + student.getSname());
								out.print("</option>");
							}
						%>
					</select> </td>
					<td> <select name="class">
						<%
							for (ClassList clas : classes){
								out.print("<option>" + clas.getCname());
								out.print("</option>");
							}
						%>
					</select> </td>
				</tr>
			</table>
			<br /> <input type="submit" value="Submit">
		</form>
	</body>
</html>