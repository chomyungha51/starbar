package dev.mouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.dao.MouseDAO;
import dev.mouse.model.Mouse;

/*
 * 전체 Mouse 목록을 리스트 형태로 출력하는 서블릿
 * 
 * DB에서 전체 Mouse 목록을 가져와서 화면에 출력하는 역할 수행
 */
@WebServlet("/mice")
public class MouseListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MouseDAO dao = new MouseDAO();
		List<Mouse> mouselist = dao.findAll();
		// 조회하는 로직

		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("	<head>");
		responseHTML.append("		<meta charset=\"UTF-8\">");
		
		responseHTML.append("		<title>Mouse 목록 페이지</title>");
		responseHTML.append("	</head>");
		responseHTML.append("	<body>");
		responseHTML.append("<h1>Mouse 목록 페이지</h1>");

		// Mouse 데이터 출력 로직, html 태그 작성 부분(ex. Mouse 목록 작성을 위한 <ul>, <li>태그 등)
		responseHTML.append("<ul>");

		for (Mouse mouse : mouselist) {
			System.out.println(mouse.getId() + mouse.getName() + mouse.getCountry() + mouse.getAddress());
			responseHTML.append("<div>");
			responseHTML.append("<p>" + mouse.getId() + "</p>");
			responseHTML.append("<p>" + mouse.getName() + "</p>");
			responseHTML.append("<p>" + mouse.getCountry() + "</p>");
			responseHTML.append("<p>" + mouse.getAddress() + "</p>");
			responseHTML.append("</div>");
		}

		responseHTML.append("</ul>");

		responseHTML.append("	</body>");
		responseHTML.append("		</html>");

		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(responseHTML.toString());
	}

}
