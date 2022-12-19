<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveStudent"%>
<%@page import="com.entities.SaveClass"%>
<%@page import="com.entities.StudentList"%>
<%@page import="com.entities.ClassList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Class and Student</title>
		<style>
			table,th,td{
				border: 1px solid;
				padding:5px;,
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>
		
		<h1>Listing of students assigned to class:</h1>
		<%
			ArrayList<ClassList> clslist= new ArrayList<ClassList>();
			clslist=(ArrayList<ClassList>) SaveClass.classDisplay();
		%>
		<table>
			<tr>
				<th>S.No.</th>
				<th>Class Name</th>
				<th>Student Name</th>
			</tr>	
		    <%
		    	String s=null;int i=1;
				for(ClassList clas : clslist){
					if(clas.getCname()!=s) {
					    for (StudentList stu:clas.getListStudents()){
					    	out.print("<tr><td>" + i + "</td>");
					    	out.print("<td>" + clas.getCname() + "</td>");
					    	out.print("<td>" + stu.getSname() + "</td></tr>");
					      	i++;
				        }
					}
			 		s=clas.getCname();
				}
		     %>
		</table>
	</body>
</html>