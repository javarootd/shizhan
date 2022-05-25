package co.jp.netwisdom.servlet;

import co.jp.netwisdom.dao.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;

public class UserRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 注册相关信息获取 （userinfo）
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String intro = request.getParameter("intro");	
		
		String[] hobbyArr =request.getParameterValues("hobby");
		
		// uesrname张三 
		// hobbyArr[0]足球  
		// hobbyArr[1] 篮球
		List<Hobby>  hobbyList = new ArrayList<Hobby>();

//		Hobby hobby1 = new Hobby(); 
//		hobby1.setUsername(username);
//		hobby1.setHobby(hobbyArr[0]);
//		
//		hobbyList.add(hobby1);
//		
//		Hobby hobby2 = new Hobby(); 
//		hobby2.setUsername(username);
//		hobby2.setHobby(hobbyArr[1]);
//		hobbyList.add(hobby2);
//		
		for(int i=0;i<hobbyArr.length;i++){
			Hobby hobby = new Hobby(); 
			hobby.setUsername(username);
			hobby.setHobby(hobbyArr[i]);
			hobbyList.add(hobby);
			
		}
		
		HobbyDAO dao1 = new HobbyDAO();
		dao1.save(hobbyList);
		
		
		
     	UserInfoDAO dao = new UserInfoDAO();
	
		if(dao.save(new UserInfo(username,password,sex,major,intro) )){
			request.getRequestDispatcher("/userRegSuccess.jsp").forward(request, response);
			System.out.println("用户表插入成功");
		}else{
			request.getRequestDispatcher("/userRegErr.jsp").forward(request, response);
			System.out.println("用户表插入表失败");
		}
		
		
		
		
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

		

}
