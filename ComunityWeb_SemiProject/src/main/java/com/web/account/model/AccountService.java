package com.web.account.model;

import java.util.List;

public class AccountService {
	
	public boolean isValid(AccountDTO dto) {
		if(isEmpty(dto.getUserID()) || isEmpty(dto.getUserPassword())) {
			return false;
		}
		return true;
	}
	
	public boolean isEmpty(String str) {
		return str.isEmpty();
	}
	
	public boolean add(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		int count = dao.select(dto.getUserID()).size();
		if(count == 0) {
			boolean res = dao.insert(dto);
			if(res) {
				dao.commit();
				dao.close();
				return true;
			} else {
				dao.rollback();
				dao.close();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean login(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> data = dao.select(dto.getUserID());
		if(data.size() == 1) {
			AccountDTO DBData = data.get(0);
			if(dto.getUserPassword().equals(DBData.getUserPassword())) {
				//로그인 성공
				dto.setUserID(DBData.getUserID());
				dto.setUserPassword("");
				return true;
			} else {
				//비밀번호 다름
				return false;
			}
		} else {
			//DB 데이터 오류(관리자에게 보고할것)
			return false;
		}
	}
	
	public boolean updatePassword(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		if (login(dto)) {
			if(dao.updatePassword(dto)) {
				//비밀번호 변경 성공
				dao.commit();
				dao.close();
				return true;
			} else {
				//데이터베이스 오류
				dao.rollback();
				dao.close();
				return false;
			}
		} else {
			return false; //원래 비밀번호 오류
		}
	}
	
	public boolean quitCommunity(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.deleteUser(dto);
		if(result) {
			//유저 삭제 성공
			dao.commit();
			dao.close();
			return true;
		} else {
			//유저 삭제 실패
			dao.rollback();
			dao.close();
			return false;
		}
	}
}
