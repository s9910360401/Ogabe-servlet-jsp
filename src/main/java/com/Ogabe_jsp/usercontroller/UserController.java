package com.Ogabe_jsp.usercontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ogabe_jsp.userservice.UserService;
import com.Ogabe_jsp.uservo.UserVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.Part;


@WebServlet("/user")
@MultipartConfig
public class UserController extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		Integer user_ID = Integer.valueOf(req.getParameter("user_ID"));
		res.setContentType("image/gif, image/jpg, image/jpeg, image/png");
		ServletOutputStream out = res.getOutputStream();
		UserService service = new UserService();
		UserVO uservo = service.getOneUserById(user_ID);
		out.write(uservo.getUser_pic());
		out.close();
		
		
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); 
		String action = req.getParameter("action");
//		PrintWriter out = res.getWriter();
		
		
		//===================會員登入===================
		
		if("login".equals(action)) {
			String errorMsgs = null;
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			String user_email = req.getParameter("user_email");
			String user_pwd = req.getParameter("user_pwd");
			
			UserService service = new UserService();
			UserVO user = service.login(user_email, user_pwd);
			HttpSession session = req.getSession();
			RequestDispatcher dispatcher = null;
			if(user == null) {
				errorMsgs = "登入失敗，請確認帳號密碼";
				session.setAttribute("errorMsgs", errorMsgs);
				System.out.println("no member");
				String url = "user_login.jsp";
				res.sendRedirect(url);	
				
			}else {
				
			//===================會員頁面顯示資料===================
				String url = "user_data.jsp";
				session.setAttribute("uservo", user);
				res.sendRedirect(url);
			}
		}
		
		//===================會員註冊資料===================
		
		if("register".equals(action)) {
			UserVO uservo = new UserVO();
			String user_email = req.getParameter("user_email");
			String user_pwd = req.getParameter("user_pwd");
			String user_name = req.getParameter("user_name");
			String user_nickname = req.getParameter("user_nickname");
			String user_address = req.getParameter("user_address");
			String user_tel = req.getParameter("user_tel");
			
			
			uservo.setUser_email(user_email);
			uservo.setUser_pwd(user_pwd);
			uservo.setUser_name(user_name);
			uservo.setUser_nickname(user_nickname);
			uservo.setUser_address(user_address);
			uservo.setUser_tel(user_tel);
			
			UserService service = new UserService();
			service.register(uservo);
			String url = "user_login.jsp";
			res.sendRedirect(url);	
			
		}	
		
		//===================會員更新資料===================
		if("update".equals(action)) {
		
			Integer user_ID = Integer.valueOf(req.getParameter("user_ID").trim());
			String user_name = req.getParameter("user_name");
			String user_nickname = req.getParameter("user_nickname");
			String user_address = req.getParameter("user_address");
			String user_tel = req.getParameter("user_tel");
			
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
			uservo.setUser_name(user_name);
			uservo.setUser_nickname(user_nickname);
			uservo.setUser_address(user_address);
			uservo.setUser_tel(user_tel);
			uservo.setUser_pic(user_pic);
			
			UserService service = new UserService();
			service.adminupdate(uservo);
			
			
			String url = "/user_data.jsp";
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
