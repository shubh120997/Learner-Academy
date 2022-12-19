<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveClass"%>
<%@page import="com.entities.SubjectList"%>
<%@page import="com.entities.ClassList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Subject and Class</title>
		<style>
			table,th,td{
				border: 1px solid;
				padding:5px;,
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>
		
		<h1>Listing of Subjects assigned to Classes:</h1>
		<%
			ArrayList<ClassList> clslist= new ArrayList<ClassList>();
			clslist=(ArrayList<ClassList>) SaveClass.classDisplay();
		%>
		<table>
			<tr>
				<th>S.No.</th>
				<th>Class Name</th>
				<th>Subject Name</th>
			</tr>	
		    <%
		     	String s=null;
		    	int i=1;
				for(ClassList clas : clslist){
					for (SubjectList sub:clas.getListSubjects() ){
						if(clas.getCname() != s){
				       		out.print("<tr><td>" + i + "</td>");	
				       		out.print("<td>" + clas.getCname() + "</td>");
						    out.print("<td>" + sub.getSubname() + "</td></tr>");
						    i++;
				        }
					}	
			 		s=clas.getCname();
				}
		     %>
		</table>
	</body>
</html>