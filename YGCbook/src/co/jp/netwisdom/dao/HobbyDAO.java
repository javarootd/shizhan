package co.jp.netwisdom.dao;


import java.sql.SQLException;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Hobby;

public class HobbyDAO {
	private JdbcTemplate template = new JdbcTemplate();
	public boolean save( List<Hobby> hobbyArr) {
		int row = 0;
		String sql = "insert into hobby(username,hobby)" +
						" values(?,?)" ;
			
		try {
			
		for(int i=0;i<hobbyArr.size();i++){
			Object[] values = new Object[]{hobbyArr.get(i).getUsername(),hobbyArr.get(i).getHobby()};
			row =row + template.updata(sql, values);
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return row == hobbyArr.size();
	}
	
	
	
	
}

