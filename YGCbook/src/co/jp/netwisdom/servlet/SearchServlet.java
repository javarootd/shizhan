package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.UserinfoAndHobbyDao;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserinfoAndHobby;

public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 前台拿检索值  
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String major = req.getParameter("major");
		
		// 把检索条件的三个值放到userinfo对象里
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername(username);
		userinfo.setSex(sex);
		userinfo.setMajor(major);
		
		//因为要调用UserinfoAndHobbyDao这个类的searchUAH方法，所以此处要创建一个该类的对象dao 
		UserinfoAndHobbyDao dao = new UserinfoAndHobbyDao();
		

		
		// 等号前面：创建该方法返回值的对象  注意返回值类型
		// 等号后面：通过dao的对象调用searchUAH方法，注意参数
		List<UserinfoAndHobby> list = dao.searchUAH(userinfo);

		

	    // 把获得的list设置到req里，名字叫netwisdom
		req.setAttribute("netwisdom", list);
		// 重定向   
		req.getRequestDispatcher("/userSearch.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}



}