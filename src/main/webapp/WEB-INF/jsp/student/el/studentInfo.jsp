<!DOCTYPE html>
<html>
<body>
	<h3>학생 상세정보</h3>
	<p>학번: ${student.id }</p> <!-- student.getId() -->
	<p>이름: ${student.name }</p> <!-- student.getname() -->
	<p>학과: ${student.dept }</p> <!-- student.getdept() -->
	<p>
		<a href="studentList">목록</a> <a href="studentEdit?id=${student.id }">수정</a> <a
			id="deleteBtn" href="deleteStudent?id=${student.id }">삭제</a>
	</p>
</body>
</html>