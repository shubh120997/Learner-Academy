<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.SaveTeacher"%>
<%@page import="com.entities.TeacherList"%>
<%@page import="com.entities.SubjectList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Teacher and Subject</title>
		<style>
			table,th,td{
				border: 1px solid;
				padding:5px;,
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<a href="assignTeacherToSubject.jsp">Assign Teacher to Subject</a><br>
	
		<h1>Listing of Teacher assigned to subject:</h1>
		<%
			ArrayList<TeacherList> tealist= new ArrayList<TeacherList>();
			tealist=(ArrayList<TeacherList>) SaveTeacher.teacherDisplay();
		%>
		<table>
			<tr>
				<th>S.No</th>
				<th>Teacher Name</th>
				<th>Subject Name</th>
			</tr>	
     		<%
     			String s=null;
     			int i=1;
 				for(TeacherList tea : tealist){
 					for (SubjectList sub:tea.getListSubjects()){
	 					if(tea.getTname()!=s) {
	 	       				out.print("<tr><td>" + i + "</td>");	
	 	       				out.print("<td>" + tea.getTname() + "</td>");
	 		        		out.print("<td>" + sub.getSubname() + "</td></tr>");
	 		        		i++;
	 	           		}
 					}
 	 				s=tea.getTname();
 				}
     		%>
		</table>
	</body>
</html>