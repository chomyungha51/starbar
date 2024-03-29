package dev.starbar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	

	// Java와 MySQL Database 연결
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		Connection connection = null;
//		Class.forName(DRIVER_NAME);
//		connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return HikariCpDataSource.getConnection();
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection con, PreparedStatement pstmt) {
		try {

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}