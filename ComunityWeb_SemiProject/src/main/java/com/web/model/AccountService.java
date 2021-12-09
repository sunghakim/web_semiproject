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
			if(dto.getUserPassword().equals(DBData.getUserPassword())) {
				//로그인 성공
				if (DBData.getManager()) {
					dao.close();
					return 1;//관리자 로그인
				} else {
					dao.close();
					return 2;//일반회원 로그인
				}
			} else {
				dao.close();
				return 3;//비밀번호 다름
			}
		} else {
			dao.close();
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
				dao.close();
				return 3;
			}
		} else {
			//데이터베이스에서 중복된 값 오류 검출
			dao.close();
			return 4;
		}
	}
	public boolean deleteAllComments(AccountDTO dto) {
		CommentDAO Cdao = new CommentDAO();
		int searchedComments = Cdao.searchUsersAllComments(dto);
		int deletedComments = Cdao.deleteUsersAllComments(dto);
		if (searchedComments == deletedComments) {
			//검색된 댓글 삭제 성공
			Cdao.commit();
			Cdao.close();
			return true;
		} else {
			//검색된 댓글 삭제 실패
			Cdao.rollback();
			Cdao.close();
			return false;
		} 
	}
	
	public boolean deleteAllPosts(AccountDTO dto) {
		PostDAO Pdao = new PostDAO();
		int searchedPosts = Pdao.searchUsersAllPosts(dto);
		int deletedPosts = Pdao.deleteUsersAllPosts(dto);
		if (searchedPosts == deletedPosts) {
			//검색된 게시글 삭제 성공
			Pdao.commit();
			Pdao.close();
			return true;
		} else {
			//검색된 게시글 삭제 실패
			Pdao.rollback();
			Pdao.close();
			return false;
		}
	}
	
	public boolean quitCommunity(AccountDTO dto) {
		if (deleteAllComments(dto)) {
			if (deleteAllPosts(dto)) {
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
		//댓글이나 게시글 삭제실패
		return false;
	}
	
	public int checkID(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> data = dao.select(dto.getUserID());
		if(data.size() == 0) {
			//중복되는 아이디 없음
			dao.close();
			return 0;
		} else if (data.size() == 1) {
			//중복되는 아이디 검출
			dao.close();
			return 1;
		} else {
			//DB 데이터 오류(관리자에게 보고할것)
			dao.close();
			return 2;
		}
	}
}
