package kr.ac.mjc.sungbin.myapp.student.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.sungbin.myapp.common.mvc.Controller;
import kr.ac.mjc.sungbin.myapp.common.mvc.ControllerException;
import kr.ac.mjc.sungbin.myapp.common.mvc.RequestMapping;
import kr.ac.mjc.sungbin.myapp.common.mvc.RequestMapping.RequestMethod;
import kr.ac.mjc.sungbin.myapp.student.dao.Student;
import kr.ac.mjc.sungbin.myapp.student.dao.StudentDao;

@Controller
public class StudentController {

	StudentDao studentDao = null;

	public StudentController() {
		studentDao = new StudentDao();
	}

	/**
	 * 목록 화면
	 */
	@RequestMapping(value = "/student/studentList", method = RequestMethod.GET)
	public void studentList(HttpServletRequest request, HttpServletResponse response) {
		List<Student> studentList = studentDao.listStudents();
		request.setAttribute("studentList", studentList);
		forward(request, response, "student/studentList.jsp");
	}

	/**
	 * 조회 화면
	 */
	@RequestMapping(value = "/student/studentInfo", method = RequestMethod.GET)
	public void studentInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Student student = studentDao.getStudent(id);
		request.setAttribute("student", student);
		forward(request, response, "student/studentInfo.jsp");
	}

	/**
	 * 수정 화면
	 */
	@RequestMapping(value = "/student/studentEdit", method = RequestMethod.GET)
	public void studentEdit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Student student = studentDao.getStudent(id);
		request.setAttribute("student", student);
		forward(request, response, "student/studentEdit.jsp");
	}

	/**
	 * 추가 액션
	 */
	@RequestMapping(value = "/student/addStudent", method = RequestMethod.POST)
	public void addStudent(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		String dept = request.getParameter("dept");

		Student student = new Student(null, name, dept);
		studentDao.addStudent(student);
		redirect(request, response, "/app/student/studentList");
	}

	/**
	 * 수정 액션
	 */
	@RequestMapping(value = "/student/updateStudent", method = RequestMethod.POST)
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");

		Student student = new Student(id, name, dept);
		studentDao.updateStudent(student);
		redirect(request, response, "/app/student/studentInfo?id=" + id);
	}

	/**
	 * 삭제 액션
	 */
	@RequestMapping(value = "/student/deleteStudent", method = RequestMethod.GET)
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		studentDao.deleteStudent(id);
		redirect(request, response, "/app/student/studentList");
	}

	/**
	 * forward
	 */
	private void forward(HttpServletRequest request, HttpServletResponse response, String jsp) {
		try {
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jsp).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
	}

	/**
	 * redirect
	 */
	private void redirect(HttpServletRequest request, HttpServletResponse response, String url) {
		try {
			response.sendRedirect(request.getContextPath() + url);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
	}
}
