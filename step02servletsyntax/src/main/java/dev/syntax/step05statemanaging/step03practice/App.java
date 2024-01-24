package dev.syntax.step05statemanaging.step03practice;


public class App {

	public static void main(String[] args) {

//		Logger logger = LoggerFactory.getLogger(App.class);
//		dao.createUser("test", "1234");

		DAO.login("test", "1234");
//		logger.info("로그인 시도");
	}

}
