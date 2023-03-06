package com.Ogabe_jsp.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ogabe_jsp.userservice.UserService;
import com.Ogabe_jsp.uservo.UserVO;


@WebServlet("/ShowImage")
public class ShowImage extends HttpServlet {



	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
		req.setCharacterEncoding("UTF-8");
		Integer user_ID = Integer.valueOf(req.getParameter("user_ID"));
		res.setContentType("image/gif, image/jpg, image/jpeg, image/png");
		ServletOutputStream out = res.getOutputStream();
		UserService service = new UserService();
		UserVO uservo = service.getOneUserById(user_ID);
		out.write(uservo.getUser_pic());
		out.close();
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
	}

}
