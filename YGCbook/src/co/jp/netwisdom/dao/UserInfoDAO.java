package co.jp.netwisdom.dao;


import java.sql.SQLException;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;

public class UserInfoDAO {
	
	private JdbcTemplate template = new JdbcTemplate();
	
	public boolean save(UserInfo userinfo) {
		int row = 0;
		String sql = "insert into UserInfo(username,password,sex,major,intro)" +
						" values(?,?,?,?,?)" ;
								
		
		Object[] values = new Object[]{userinfo.getUsername(),userinfo.getPassword(),userinfo.getSex(),userinfo.getMajor(),userinfo.getIntro()};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
		
	
	
	
	
}

