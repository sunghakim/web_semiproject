package com.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.conn.OracleConnect;

public class AccountDAO {
	private OracleConnect oc;

	public AccountDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public List<AccountDTO> select(String UserID) {
		
		String query = "SELECT * FROM ACCOUNTDB WHERE USER_ID = '" + UserID + "'";
		ResultSet res = oc.select(query);
		
		List<AccountDTO> datas = new ArrayList<AccountDTO>();
		try {
			while(res.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setUserID(res.getString("USER_ID"));
				dto.setUserPassword(res.getString("PASSWORD"));
				datas.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public boolean insert(AccountDTO dto) {
		String query = "INSERT INTO ACCOUNTDB VALUES('"
				+ dto.getUserID() + "', '"
				+ dto.getUserPassword() + "', '0')";
		int res = oc.insert(query);
		return res == 1 ? true : false;
	}
	
	public boolean updatePassword(AccountDTO dto) {
		String UserID = dto.getUserID();
		String NewUserPassword = dto.getNewUserPassword();
		String query = "UPDATE ACCOUNTDB SET PASSWORD = '"
				+ NewUserPassword + "' WHERE USER_ID = '" 
				+ UserID + "'";
		int res = oc.update(query);
		return res == 1 ? true : false;
	}
	
	public boolean deleteUser(AccountDTO dto) {
		String UserID = dto.getUserID();
		String query = "DELETE FROM ACCOUNTDB WHERE USER_ID = '" + UserID + "'";
		int res = oc.delete(query);
		return res == 1 ? true : false;
	}

	public void rollback() {
		oc.rollback();
	}

	public void commit() {
		oc.commit();
		
	}

	public void close() {
		oc.close();
	}

}
