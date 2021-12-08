package com.web.model;

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

	public int login(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> data = dao.select(dto.getUserID());
		if(data.size() == 1) {
			AccountDTO DBData = data.get(0);
			dto.setManager(DBData.getManager());
			System.out.println(DBData.getManager());
			if(dto.getManager()) {
				System.out.println("dto: true");
			} else {
				System.out.println("dto: false");
			}
			
			if(dto.getUserPassword().equals(DBData.getUserPassword())) {
				//로그인 성공
				if (DBData.getManager()) {
					return 1;//관리자 로그인
				} else {
					return 2;//일반회원 로그인
				}
			} else {
				return 3;//비밀번호 다름
			}
		} else {
			//DB 데이터 오류(관리자에게 보고할것)
			return 4;
		}
	}
	
	public int updatePassword(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> data = dao.select(dto.getUserID());
		if(data.size() == 1) {
			AccountDTO DBData = data.get(0);
			if(dto.getUserPassword().equals(DBData.getUserPassword())) {
				if(dao.updatePassword(dto)) {
					//비밀번호 변경 성공
//					dto.setUserID(DBData.getUserID());
//					dto.setUserPassword("");
					dao.commit();
					dao.close();
					return 1;
				} else {
					//비밀번호 변경 실패
					dao.rollback();
					dao.close();
					return 2;
				}
			} else {
				//현재 비밀번호 다름
				return 3;
			}
		} else {
			System.out.println("4");
			//데이터베이스에서 중복된 값 오류 검출
			return 4;
		}
	}
	
	public boolean quitCommunity(AccountDTO dto) {
		PostDAO Pdao = new PostDAO();
		Pdao.deleteUsersAllPost(dto);
		
		CommentDAO Cdao = new CommentDAO();
		Cdao.deleteUsersAllPost(dto);
		
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
	
	public int checkID(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> data = dao.select(dto.getUserID());
		if(data.size() == 0) {
			//중복되는 아이디 없음
			return 0;
		} else if (data.size() == 1) {
			//중복되는 아이디 검출
			return 1;
		} else {
			//DB 데이터 오류(관리자에게 보고할것)
			return 2;
		}
	}
}
