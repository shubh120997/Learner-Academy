<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveStudent"%>
<%@page import="com.entities.StudentList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			table, th,td{
				border: 1px solid;
				padding:5px;
			}
		</style>
		<meta charset="UTF-8">
		<title>Students</title>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>
		<h1>Listing of Students:</h1>
		<%	
			ArrayList<StudentList> stulist= new ArrayList<StudentList>();
			stulist=(ArrayList<StudentList>) SaveStudent.studentDisplay();
		%>
		<table>
			<tr>
				<th>S.No.</th>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
			</tr>	
				<%
					int i=1;
					for(StudentList stu:stulist){
						out.print("<tr><td>" + i + "</td>");
						out.print("<td>" + stu.getSid() + "</td>");
						out.print("<td>" + stu.getSname() + "</td>");
						out.print("<td>" + stu.getEmail() + "</td>");
						out.print("<td>" + stu.getPhone()  + "</td></tr>");
						i++;
					}	
				%>
		</table>
	</body>
</html>