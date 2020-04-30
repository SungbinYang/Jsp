package kr.ac.mjc.sungbin.myapp.student.model2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.sungbin.myapp.student.dao.Student;
import kr.ac.mjc.sungbin.myapp.student.dao.StudentDao;

/**
 * Servlet implementation class StudentListServlet
 */
@SuppressWarnings("serial")
@WebServlet("/student/model2/studentList")
public class StudentListServlet extends HttpServlet {

	StudentDao studentDao = null;

	@Override
	public void init() throws ServletException {
		studentDao = (StudentDao) getServletContext()
				.getAttribute("studentDao");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> studentList = studentDao.listStudents();
		request.setAttribute("studentList", studentList);
		request.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/student/el/studentList.jsp")
				.forward(request, response);
	}
}