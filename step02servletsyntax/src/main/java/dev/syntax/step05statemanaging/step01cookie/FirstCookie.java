package dev.syntax.step05statemanaging.step01cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first-cookie-set")
public class FirstCookie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		Cookie cookie1 = new Cookie("id", "guest"); // 쿠키 생성 
		resp.addCookie(cookie1); // 브라우저에 전송
		
		Cookie cookie2 = new Cookie("nickname","ironman");
		cookie2.setMaxAge(60 * 60 * 3); // 초 단위
	
		resp.addCookie(cookie2);
		
		PrintWriter out = resp.getWriter();
		out.print("서버에서 생성한 쿠키가 클라이언트로 전송됨");
		out.close();

	}

}
