package dev.syntax.step05statemanaging.step03practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DAO {

	private static Connection connection;

	private DAO() {

	}

	public static void createUser(String userId, String userPw) {
		final String createUserSQL = "insert into user (user_id, user_pw) values ( \"" + userId + "\", \"" + userPw
				+ "\")";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "logindb", "root", "1234");

			Statement statement = connection.createStatement();
			statement.execute(createUserSQL);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("회원가입 완료");
	}

	public static boolean login(String userId, String userPw) {
		final String loginSQL = "select * from user where user_id=\"" + userId + "\" and user_pw=\"" + userPw + "\"";
		boolean loginResult = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "logindb", "root", "1234");
			if (connection != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(loginSQL);
			System.out.println(loginSQL);
			if (result.next() == true) {
				
				System.out.println("로그인 성공!");
				loginResult = true;
			} else {
				System.out.println("로그인 실패");

			}
			result.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginResult;
	}
}
