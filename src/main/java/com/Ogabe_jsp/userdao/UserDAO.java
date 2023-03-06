package com.Ogabe_jsp.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.Ogabe_jsp.uservo.UserVO;

public class UserDAO implements UserDAOImp {
	
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/user");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String REGISTER = 
			"INSERT INTO user01 (user_email,user_pwd,user_name,user_nickname,user_address,user_tel) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_USER = 
			"SELECT * FROM user01 order by user_ID";
	private static final String GET_ONE_USER = 
			"SELECT * FROM user01 where user_ID = ?";
	private static final String DELETE = 
			"DELETE FROM user01 where user_ID = ?";
	private static final String UPDATE = 
			"UPDATE user01 set user_name=?, user_nickname=?, user_address=?, user_tel=?, user_pic=? where user_ID = ?";
	private static final String UPDATE_WITHOUTPIC = 
			"UPDATE user01 set user_name=?, user_nickname=?, user_address=?, user_tel=? where user_ID = ?";
	private static final String ADMIN_UPDATE = 
			"UPDATE user01 set user_email = ?, user_pwd = ?, user_name=?, user_nickname=?, user_address=?, user_tel=?, user_vip_level_id=?, user_datetime=?, user_status=?, user_pic=? where user_ID = ?";
	private static final String ADMIN_UPDATE_WITHOUTPIC = 
			"UPDATE user01 set user_email = ?, user_pwd = ?, user_name=?, user_nickname=?, user_address=?, user_tel=?, user_vip_level_id=?, user_datetime=?, user_status=? where user_ID = ?";
	
	private static final String LOGIN = 
			"SELECT * FROM user01 where user_email = ? and user_pwd = ?";
	
	@Override
	public void insert(UserVO userVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(REGISTER);
			
			pstmt.setString(1, userVO.getUser_email());
			pstmt.setString(2, userVO.getUser_pwd());
			pstmt.setString(3, userVO.getUser_name());
			pstmt.setString(4, userVO.getUser_nickname());
			pstmt.setString(5, userVO.getUser_address());
			pstmt.setString(6, userVO.getUser_tel());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			// TODO: handle exception
		}

	}

	@Override
	public void update(UserVO userVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		if(userVO.getUser_pic()!=null) {
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);
				
				pstmt.setString(1, userVO.getUser_name());
				pstmt.setString(2, userVO.getUser_nickname());
				pstmt.setString(3, userVO.getUser_address());
				pstmt.setString(4, userVO.getUser_tel());
				pstmt.setBytes(5, userVO.getUser_pic());
				pstmt.setInt(6, userVO.getUser_ID());
				
				pstmt.executeUpdate();
				
			} catch (SQLException se) {
				// TODO: handle exception
			}
		}else {
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_WITHOUTPIC);
				
				pstmt.setString(1, userVO.getUser_name());
				pstmt.setString(2, userVO.getUser_nickname());
				pstmt.setString(3, userVO.getUser_address());
				pstmt.setString(4, userVO.getUser_tel());
				pstmt.setInt(5, userVO.getUser_ID());
				
				pstmt.executeUpdate();
				
			} catch (SQLException se) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void delete(Integer user_ID) {
		// TODO Auto-generated method stub

	}



	@Override
	public List<UserVO> getAll() {
		List<UserVO> list = new ArrayList<UserVO>();
		UserVO uservo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_USER);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				uservo = new UserVO();
				uservo.setUser_ID(rs.getInt("user_ID"));
				uservo.setUser_email(rs.getString("user_email"));
				uservo.setUser_pwd(rs.getString("user_pwd"));
				uservo.setUser_name(rs.getString("user_name"));
				uservo.setUser_nickname(rs.getString("user_nickname"));
				uservo.setUser_address(rs.getString("user_address"));
				uservo.setUser_tel(rs.getString("user_tel"));
				uservo.setUser_vip_level_id(rs.getInt("user_vip_level_id"));
				uservo.setUser_datetime(rs.getDate("user_datetime"));
				uservo.setUser_status(rs.getInt("user_status"));
				uservo.setUser_pic(rs.getBytes("user_pic"));
				list.add(uservo);
				
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
		}finally {
			if(rs!=null || pstmt!=null || con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {

				}
			}
		}
		return list;
	}

	@Override
	public UserVO login(String user_email, String user_pwd) {
		
		UserVO uservo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(LOGIN);
			
			pstmt.setString(1, user_email);
			pstmt.setString(2, user_pwd);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				uservo = new UserVO();
				uservo.setUser_ID(rs.getInt("user_ID"));
				uservo.setUser_email(rs.getString("user_email"));
				uservo.setUser_pwd(rs.getString("user_pwd"));
				uservo.setUser_name(rs.getString("user_name"));
				uservo.setUser_nickname(rs.getString("user_nickname"));
				uservo.setUser_address(rs.getString("user_address"));
				uservo.setUser_tel(rs.getString("user_tel"));
				uservo.setUser_vip_level_id(rs.getInt("user_vip_level_id"));
				uservo.setUser_datetime(rs.getDate("user_datetime"));
				uservo.setUser_status(rs.getInt("user_status"));
				uservo.setUser_pic(rs.getBytes("user_pic"));
			}
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs!=null || pstmt!=null || con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {

				}
			}
		}
			return uservo;	
	}

	@Override
	public UserVO getOneUserbyID(Integer user_ID) {
		UserVO user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_USER);
			
			pstmt.setInt(1, user_ID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user = new UserVO();
				user.setUser_ID(rs.getInt("user_ID"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_nickname(rs.getString("user_nickname"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_vip_level_id(rs.getInt("user_vip_level_id"));
				user.setUser_datetime(rs.getDate("user_datetime"));
				user.setUser_status(rs.getInt("user_status"));
				user.setUser_pic(rs.getBytes("user_pic"));
			}
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs!=null || pstmt!=null || con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {

				}
			}
		}
			return user;	
	}

	@Override
	public void adminUpdate(UserVO userVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		
		if(userVO.getUser_pic()!=null) {
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(ADMIN_UPDATE);
				
				pstmt.setString(1, userVO.getUser_email());
				pstmt.setString(2, userVO.getUser_pwd());
				pstmt.setString(3, userVO.getUser_name());
				pstmt.setString(4, userVO.getUser_nickname());
				pstmt.setString(5, userVO.getUser_address());
				pstmt.setString(6, userVO.getUser_tel());					
				pstmt.setInt(7, userVO.getUser_vip_level_id());
				pstmt.setDate(8, userVO.getUser_datetime());
				pstmt.setInt(9, userVO.getUser_status());
				pstmt.setBytes(10, userVO.getUser_pic());			
				pstmt.setInt(11, userVO.getUser_ID());
				
				System.out.println(userVO.getUser_vip_level_id());
				
				pstmt.executeUpdate();
				
			} catch (SQLException se) {
				// TODO: handle exception
			}
		}else {
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(ADMIN_UPDATE_WITHOUTPIC);
				
				pstmt.setString(1, userVO.getUser_email());
				pstmt.setString(2, userVO.getUser_pwd());
				pstmt.setString(3, userVO.getUser_name());
				pstmt.setString(4, userVO.getUser_nickname());
				pstmt.setString(5, userVO.getUser_address());
				pstmt.setString(6, userVO.getUser_tel());					
				pstmt.setInt(7, userVO.getUser_vip_level_id());
				pstmt.setDate(8, userVO.getUser_datetime());
				pstmt.setInt(9, userVO.getUser_status());		
				pstmt.setInt(10, userVO.getUser_ID());
				
				pstmt.executeUpdate();
				
			} catch (SQLException se) {
				// TODO: handle exception
			}
		}
	}
		
	}


			
	
		
		
	

