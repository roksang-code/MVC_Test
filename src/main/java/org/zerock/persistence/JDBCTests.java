package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버를 로딩했습니다.");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclmydb", "book_ex",
				"111111")) {
				System.out.println("데이터베이스 접속 성공");
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
