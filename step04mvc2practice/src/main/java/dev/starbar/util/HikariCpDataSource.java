package dev.starbar.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpDataSource {
	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;
	static {
		final String DB_URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		final String USER = "root";
		final String PASSWORD = "1234";

		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		config.setDriverClassName(DRIVER_NAME);
		// 필수 설정 파라미터(url, username, password), classname은 이전 버전 제외하고 생략 가능
		config.setJdbcUrl(DB_URL+DATABASE_NAME); // DB이름은 URL 뒷 부분에 추가하여 기술
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		config.setMinimumIdle(10);
		config.setMaximumPoolSize(50);
		config.setConnectionTimeout(60000L);
		

		// HikariCP Official, https://github.com/brettwooldridge/HikariCP

		// 상세 프로퍼티 설명(https://github.com/brettwooldridge/HikariCP#frequently-used)
		ds = new HikariDataSource(config);

	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	private HikariCpDataSource() {
	}
}
