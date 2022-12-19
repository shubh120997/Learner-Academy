<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveTeacher"%>
<%@page import="com.entities.TeacherList"%>
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
		<title>Teachers</title>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignTeacherToClass.jsp">Assign Teacher to Class</a><br>
		<a href="assignTeacherToSubject.jsp">Assign Teacher to Subject</a><br>
		<h1>Listing of Teachers:</h1>
		<%
			ArrayList<TeacherList> tealist= new ArrayList<TeacherList>();
			tealist=(ArrayList<TeacherList>) SaveTeacher.teacherDisplay();
		%>
		<table>
			<tr>
				<th>S.No</th>
				<th>Id</th>
				<th>Name</th>
			</tr>	
				<%
					int i=1;
					for(TeacherList tea:tealist){
						out.print("<tr><td>" + i + "</td>");	
						out.print("<td>" + tea.getTid() + "</td>");
						out.print("<td>" + tea.getTname()+ "</td></tr>");
						i++;
					}
				%>
		</table>
	</body>
</html>