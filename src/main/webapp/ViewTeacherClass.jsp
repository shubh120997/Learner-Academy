<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveClass"%>
<%@page import="com.entities.TeacherList"%>
<%@page import="com.entities.ClassList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Teacher and Class</title>
		<style>
			table,th,td{
				border: 1px solid;
				padding:5px;,
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignTeacherToClass.jsp">Assign Teacher to Class</a><br>
		
		<h1>Listing of Teachers assigned to Classes:</h1>
		<%
			ArrayList<ClassList> clslist= new ArrayList<ClassList>();
			clslist=(ArrayList<ClassList>) SaveClass.classDisplay();
		%>
		<table>
			<tr>
				<th>S.No</th>
				<th>Class Name</th>
				<th>Teacher Name</th>
			</tr>	
		    <%
		    	String s=null;
		    	int i=1;
				for(ClassList clas : clslist){
					for (TeacherList tea:clas.getListTeachers() ){
						if(clas.getCname()!=s){
					       out.print("<tr><td>" + i + "</td>");	
					       out.print("<td>" + clas.getCname() + "</td>");
						   out.print("<td>" + tea.getTname() + "</td>");
						   i++;
					    }
					}
					s=clas.getCname();
				}
		     %>
		</table>
	</body>
</html>