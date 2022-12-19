<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveClass"%>
<%@page import="com.entities.ClassList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>	
		<meta charset="UTF-8">
		<title>Classes</title>
		<style>
			table, th,td{
				border: 1px solid;
				padding:5px;
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>
		<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>
		<a href="assignTeacherToClass.jsp">Assign Teacher to Class</a><br>
		<h1>Listing of Classes:</h1>
		<%
			ArrayList<ClassList> clslist= new ArrayList<ClassList>();
			clslist=(ArrayList<ClassList>) SaveClass.classDisplay();
		%>
		<table>
			<tr>
				<th>S.No.</th>
				<th>Id</th>
				<th>Name</th>
			</tr>
			<%
				int i=1;
				for(ClassList cls:clslist){
					out.print("<tr><td>" + i + "</td>");
					out.print("<td>" +cls.getCid() + "</td>");
					out.print("<td>" + cls.getCname() + "</td></tr>");
					i++;
				}
			%>
		</table>
	</body>
</html>