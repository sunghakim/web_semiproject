package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardManagement {

	// db 주소
	private String dbURL = "";
	private String dbID = "";
	private String dbPassword = "";
	
	public BoardManagement() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Board> boardList() {
		String SQL = "SELECT BOARD_NUM, BOARD_NAME FROM BOARDDB";
		List<Board> boardList = new ArrayList<>();

		try (// db 접속, 쿼리 try-with-resource 사용
				Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				boardList.add(new Board(id, name));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boardList;
	}
	
	public int insertCategory(String categoryName) {
		String SQL = "INSERT INTO BOARDDB VALUES(BOARD_NUMBER.NEXTVAL, ?)";

		try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);) {

			pstmt.setString(1, categoryName);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int updateCategory(String changeName, int categoryNumber) {
		String SQL = "UPDATE BOARDDB SET BOARD_NAME = ? WHERE BOARD_NUM = ?";

		try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);) {

			pstmt.setString(1, changeName);
			pstmt.setInt(2, categoryNumber);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int deleteCategory(int categoryNumber) {
		String SQL = "DELETE FROM BOARDDB WHERE BOARD_NUM = ?";

		try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery();) {

			pstmt.setInt(1, categoryNumber);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
