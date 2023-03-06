package com.Ogabe_jsp.userdao;

import java.util.List;

import com.Ogabe_jsp.uservo.UserVO;

public interface UserDAOImp {
    public void insert(UserVO userVO);
    public void update(UserVO userVO);
    public void adminUpdate(UserVO userVO);
    public void delete(Integer user_ID);
    public UserVO login(String user_email, String user_pwd);
    public UserVO getOneUserbyID(Integer user_ID);
    public List<UserVO> getAll();	
}
