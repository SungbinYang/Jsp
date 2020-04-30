<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h3>학생 목록</h3>
	<ul>
		<c:forEach var="student" items="${studentList }">
			<li>학번: <a href="studentInfo?id=${student.id }">${student.id }</a>, 이름:
				${student.name }, 학과: ${student.dept }
			</li>
		</c:forEach>
	</ul>
</body>
</html>