package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserinfoAndHobby;
import co.jp.netwisdom.mapping.UserinfoAndHobbyMapping;

public class UserinfoAndHobbyDao {

	private JdbcTemplate jdbcObj = new JdbcTemplate();
	
	// 公共的 返回值类型为UserinfoAndHobby为泛型的list 方法名searchUAH 参数UserInfo userinfo
	/* 
	 * public：公共的
	 * List<UserinfoAndHobby> :方法的返回值
	 * searchUAH：方法名
	 * UserInfo userinfo ：参数类型  形式参数
	 * */
	public List<UserinfoAndHobby> searchUAH(UserInfo userinfo){

		// 准备查询用的sql文
		String sql = "select ui.username,ui.sex,hobby,"+
		"ui.major,ui.intro from userinfo ui left join hobby hb on ui.username = hb.username"+
		" where 1=1 ";

		if(!userinfo.getUsername().equals("")){
			sql += "and ui.username = '" +userinfo.getUsername()+"'";
		}

		if(userinfo.getSex() != null){
			sql += "and sex = '" +userinfo.getSex() +"'";
		}

		if(!userinfo.getMajor().equals("")){
			sql += "and major = '" +userinfo.getMajor() +"'";
		}

		


		List<UserinfoAndHobby> list = new ArrayList<UserinfoAndHobby>();


		try {
			list = jdbcObj.selete(sql, new UserinfoAndHobbyMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}


}