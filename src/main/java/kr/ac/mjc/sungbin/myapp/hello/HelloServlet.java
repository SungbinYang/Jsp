package kr.ac.mjc.sungbin.myapp.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
/**web.xml에서 metadata-complete=false로 설정하면
 * 
 * @WebServlet("/hello)으로 mapping 할수 있다.
 *
 */
@SuppressWarnings("serial")
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name"); //url의 붙어서 들어오는것 or Get이나 post방식으로 브라우저로 요청을 보내는것

		// request에 데이터를 싣는다.
		request.setAttribute("greeting", "Hello " + name); //greeting이라는 attribute이름으로 값을 받는다.

		// forward to /WEB-INF/jsp/hello.jsp
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello.jsp")
				.forward(request, response);
	}

}
