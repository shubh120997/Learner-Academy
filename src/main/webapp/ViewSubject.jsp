<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveSubject"%>
<%@page import="com.entities.SubjectList"%>
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
		<title>Subjects</title>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignSubjectToClass.jsp">Assign Subject to Class</a>
		<h1>Listing of Subjects:</h1>		
		<%
			ArrayList<SubjectList> sublist= new ArrayList<SubjectList>();
			sublist=(ArrayList<SubjectList>) SaveSubject.subjectDisplay();
		%>
		<table>
			<tr>
				<th>S.No.</th>
				<th>Id</th>
				<th>Name</th>
			</tr>	
				<% 
					int i=1;
					for(SubjectList sub:sublist){
						out.print("<tr><td>" + i + "</td>");
						out.print("<td>" + sub.getSubid() + "</td>");
						out.print("<td>" + sub.getSubname() + "</td></tr>");
						i++;
					}
				%>
		</table>
	</body>
</html>