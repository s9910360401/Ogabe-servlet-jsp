package com.Ogabe_jsp.usercontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ogabe_jsp.userservice.UserService;
import com.Ogabe_jsp.uservo.UserVO;


@WebServlet("/AdminUser")
@MultipartConfig
public class AdminUserController extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		PrintWriter out = res.getWriter();

		
		
		if("admin_GetOneUser_ForUpdate".equals(action)) {
			
			Integer user_id = Integer.valueOf(req.getParameter("user_ID")) ;
			
			UserService service = new UserService();
			
			UserVO uservo = service.getOneUserById(user_id);
			
			req.setAttribute("uservo", uservo);
			String url = "/user_admin_update.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
		
		if("admin_UserUpdate".equals(action)) {
			
			Integer user_ID = Integer.valueOf(req.getParameter("user_ID").trim());
			String user_email = req.getParameter("UserEmail");
			String user_pwd = req.getParameter("UserPwd");
			String user_name = req.getParameter("user_name");
			String user_nickname = req.getParameter("user_nickname");
			String user_address = req.getParameter("user_address");
			String user_tel = req.getParameter("user_tel");
			Integer user_vip_level_id = Integer.valueOf(req.getParameter("UserVip").trim());
			Date user_datetime = Date.valueOf(req.getParameter("Userdatetime"));
			Integer user_status = Integer.valueOf(req.getParameter("Userstatus").trim());
			
			
			String savepath = req.getServletContext().getRealPath("/DB-image");
			File imgfolderPath = new File(savepath);
			if (!imgfolderPath.exists()){
				imgfolderPath.mkdirs();
			    }
			javax.servlet.http.Part part = req.getPart("user_pic");
			String filename = part.getSubmittedFileName();
			
			byte [] user_pic = null;
			
			if(filename!="") {
				String imgPath = imgfolderPath+"/"+filename;
				part.write(imgPath);
				user_pic = getPictureByteArray(imgPath);
			}
			
			UserVO uservo = new UserVO();
			uservo.setUser_ID(user_ID);
			uservo.setUser_email(user_email);
			uservo.setUser_pwd(user_pwd);
			uservo.setUser_name(user_name);
			uservo.setUser_nickname(user_nickname);
			uservo.setUser_address(user_address);
			uservo.setUser_tel(user_tel);
			uservo.setUser_pic(user_pic);
			uservo.setUser_vip_level_id(user_vip_level_id);
			uservo.setUser_datetime(user_datetime);
			uservo.setUser_status(user_status);
			
//			System.out.println(uservo.getUser_vip_level_id());

			UserService service = new UserService();
			service.adminupdate(uservo);
			req.setAttribute("uservo", uservo); //讓跳轉後的頁面可以立即更新
			
			String url = "/user_admin_list.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			
			
		}
		
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
