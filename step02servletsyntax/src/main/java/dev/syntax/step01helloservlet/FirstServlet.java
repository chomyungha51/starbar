package dev.syntax.step01helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 0. 서블릿이란?
 * 
 * 
 * 1. XML 기반 맵핑(web.xml)
 * - <servlet> : 서블릿 객체 맵핑
 * 		<servlet-name> : 서블릿 이름
 * 		<servlet-class> : 서블릿 클래스명
 *   </servlet>
 *   
 * - <servlet-mapping>
 * 		<servlet-name> : 서블릿 이름
 * 		<url-pattern> : 서블릿이 동작할 url 주소
 * 	 </servlet-mapping>
 */
@WebServlet(name="MyFirstServlet", urlPatterns = "/servlets/firstservlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World!</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
