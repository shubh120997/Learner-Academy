<%@page import="com.entities.ClassList"%>
<%@page import="com.entities.StudentList"%>
<%@page import="com.entities.SubjectList"%>
<%@page import="com.entities.TeacherList"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Class Report</title>
		<style>
			table, th,td{
				border: 1px solid;
				padding:5px;
			}
		</style>
	</head>
	<body>
		<a href="Dashboard.html">Back to Main Menu</a><br>
		<%String clas = request.getParameter("class");%>
		<h1>Class Report for <%=clas%></h1>
		<%
			SessionFactory sf  = ConnectionProvider.getFactory();
			Session hibernateSession = sf.openSession();
			List<ClassList> classes = hibernateSession.createQuery("from ClassList cl where cl.cname='" + clas + "'").list();
			ClassList clasForReport = classes.get(0);
		%>
		<table>
			<tr>
				<th>S.No.</th>
				<th>Subject</th>
				<th>Teacher-Name</th>
			</tr>
			<%	
				int i=1;
				for(SubjectList subject: clasForReport.getListSubjects()){
					out.print("<tr><td>" + i + "</td>");	
					out.print("<td>" + subject.getSubname() + "</td>");
					out.print("<td>" + getTeacherName(subject) + "</td></tr>");
					i++;
				}
			%>
		</table>
			<%!
				public String getTeacherName(SubjectList subject){
					TeacherList teacher = subject.getListTeachers();
					String name;
					if(teacher != null){
						name=teacher.getTname();
						return name;
					}else{
						return "No Teacher assigned";
					}
				}
			%>
		<br />
		<table>
			<tr>
				<th colspan="5">Students in <%=clas%></th>
			</tr>
			<tr>
				<th> S.No.</th>
				<th> Id </th>
				<th> Name </th>
				<th> Email </th>
				<th> Mobile Number</th>
			</tr>
			<%
				int j=1;
				for(StudentList student : clasForReport.getListStudents()){
					out.print("<tr><td>" + j + "</td>");
					out.print("<td>" + student.getSid() + "</td>");
					out.print("<td>" + student.getSname() + "</td>");
					out.print("<td>" + student.getEmail() + "</td>");
					out.print("<td>" + student.getPhone() + "</td></tr>");
					j++;
				}
			%>
		</table>
	</body>
</html>