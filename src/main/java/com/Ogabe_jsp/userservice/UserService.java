package com.Ogabe_jsp.userservice;

import java.util.List;

import com.Ogabe_jsp.userdao.UserDAO;
import com.Ogabe_jsp.userdao.UserDAOImp;
import com.Ogabe_jsp.uservo.UserVO;

public class UserService {
	
	private UserDAOImp dao;
	public UserService(){
		dao = new UserDAO();
	}
	
	public UserVO login(String user_email, String user_pwd) {
		return dao.login(user_email, user_pwd);
	}
	
	public void register(UserVO uservo) {
		dao.insert(uservo);
	}
	
	public UserVO getOneUserById(Integer user_ID) {
		return dao.getOneUserbyID(user_ID);
	}
	
	public void update(UserVO uservo) {
		dao.update(uservo);
	}
	
	public void adminupdate(UserVO uservo) {
		dao.adminUpdate(uservo);
	}
	
	public List<UserVO> getAll(){
		return dao.getAll();
	}

}
