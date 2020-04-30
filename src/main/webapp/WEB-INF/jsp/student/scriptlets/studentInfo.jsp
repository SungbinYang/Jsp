<%@ page import="java.util.*, kr.ac.mjc.sungbin.myapp.student.dao.Student"%>
<%
	Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<body>
	<h3>학생 상세정보</h3>
	<p>
		학번:
		<%=student.getId()%></p>
	<p>
		이름:
		<%=student.getName()%></p>
	<p>
		학과:
		<%=student.getDept()%></p>
	<p>
		<a href='studentList'>목록</a>
	</p>
</body>
</html>