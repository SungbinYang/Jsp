<%@ page import="java.util.*, kr.ac.mjc.sungbin.myapp.student.dao.Student"%>
<%
	List<Student> studentList = (List<Student>) request.getAttribute("studentList");
%>
<!DOCTYPE html>
<html>
<body>
	<h3>학생 목록</h3>
	<ul>
		<%
			for (Student student : studentList) {
		%>
		<li>학번: <a href="studentInfo?id=<%=student.getId()%>"><%=student.getId()%></a>,
			이름: <%=student.getName()%>, 학과: <%=student.getDept()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>