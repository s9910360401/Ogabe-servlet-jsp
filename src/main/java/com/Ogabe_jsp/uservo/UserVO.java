package com.Ogabe_jsp.uservo;

import java.sql.Date;

public class UserVO {
	
	private Integer user_ID;
	private String user_email;
	private String user_pwd;
	private String user_name;
	private String user_nickname;
	private String user_address;
	private String user_tel;
	private Integer user_vip_level_id;
	private Date user_datetime;
	private Integer user_status;
	private byte[] user_pic;
	
	public UserVO() {}
	
	
	public UserVO(Integer user_ID, String user_email, String user_pwd, String user_name, String user_nickname,
			String user_address, String user_tel, Integer user_vip_level_id, Date user_datetime, Integer user_status,
			byte[] user_pic) {
		super();
		this.user_ID = user_ID;
		this.user_email = user_email;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_address = user_address;
		this.user_tel = user_tel;
		this.user_vip_level_id = user_vip_level_id;
		this.user_datetime = user_datetime;
		this.user_status = user_status;
		this.user_pic = user_pic;
	}
	public Integer getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(Integer user_ID) {
		this.user_ID = user_ID;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public Integer getUser_vip_level_id() {
		return user_vip_level_id;
	}
	public void setUser_vip_level_id(Integer user_vip_level_id) {
		this.user_vip_level_id = user_vip_level_id;
	}
	public Date getUser_datetime() {
		return user_datetime;
	}
	public void setUser_datetime(Date user_datetime) {
		this.user_datetime = user_datetime;
	}
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
	public byte[] getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(byte[] user_pic) {
		this.user_pic = user_pic;
	}

	@Override
	public String toString() {
		
		return "user_email[ "+user_email+" ], " + "user_pwd[ "+ user_pwd + " ]";
		
	}
	
	
}
