<%@page import="com.entities.SubjectList"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.TeacherList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Assign Subject to Teacher</title>
		<style>
			table,th,td{
				border: 1px solid;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Main Menu</a><br>
		<h1>Assign Teacher to Subject:</h1>
		<%
			SessionFactory sf = ConnectionProvider.getFactory();
			Session hibernateSession = sf.openSession();
			List<TeacherList> techears = hibernateSession.createQuery("from  TeacherList").list();
			List< SubjectList> subject = hibernateSession.createQuery("from  SubjectList").list();
		%>
		<form action="AssignTeacherToSubject" method="post">
			<table>
				<tr>
					<th>Teacher Name </th>
					<th>Subject Name </th>
				</tr>
				<tr>
					<td> <select name="name">
						<%
							for (TeacherList tea :techears){
								out.print("<option>" + tea.getTname());
								out.print("</option>");
							}
						%>
					</select> </td>
					<td> <select name="subject">
						<%
							for (SubjectList sub : subject){
								out.print("<option>" + sub.getSubname());
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