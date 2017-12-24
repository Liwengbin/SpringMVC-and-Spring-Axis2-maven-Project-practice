package com.coll.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coll.exception.DataException;
import com.coll.model.CatitModel;
import com.coll.model.UserinfoModel;

@Repository
public class UserinfoDaoImpl implements UserinfoDao {
	Logger logger = Logger.getLogger(UserinfoDaoImpl.class);
	
	public JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public void addUserInfo(UserinfoModel user) {
		//logger.info("===================================添加用户===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into USERINFO_TABLE(user_email,user_password,user_name,user_img,interest,profession)"  
                    + "values (?,?,?,?,?,?)";
        Object[] params = {user.getUser_email(),
        				   user.getUser_password(),
        				   user.getUser_name(),
        				   user.getUser_img(),
        				   user.getInterest(),
        				   user.getProfession()
        				   };
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};  
        jdbcTemplate.update(sql, params, types);
    }

    @Override
    public UserinfoModel getUserInfo(String email) {
    	List<Object> userinfoModellist = new ArrayList<Object>();
    	String sql = "select * from USERINFO_TABLE where user_email = ?";
        Object[] params = new Object[]{email};
        int[] types =  new int[]{Types.VARCHAR}; 
        userinfoModellist=jdbcTemplate.query(sql, params, types, new UserMapper());
        if(userinfoModellist.size()>0)
        {
        	return  (UserinfoModel)userinfoModellist.get(0);
        }else{
        	return null;
        }
    }

    @Override
    public void updataUserInfo(UserinfoModel user) {

    }

    @Override
    public void removeUserInfo(String email) {
    	String sql = "delete from temp where id = ?"; 
    	int[] types = {Types.VARCHAR};
    	jdbcTemplate.update(sql, email,types);
    }
    
	protected class UserMapper implements RowMapper<Object>,Serializable{  
    	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException {  
        	UserinfoModel user = new UserinfoModel();  
            user.setUser_email(rs.getString("user_email"));
            user.setUser_password(rs.getString("user_password"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_img(rs.getBytes("user_img"));
            user.setInterest(new ArrayList<String>());//需要解析
            user.setProfession(rs.getString("profession"));
            return user;  
        }
          
    }

	/**
	 * 查询用户特征
	 */
	@Override
	public ArrayList<CatitModel> loadUserCatit(String user_email, String f_catit_id) {
		List<Object> objectlist = new ArrayList<Object>();
    	ArrayList<CatitModel> CatitModellist = new ArrayList<CatitModel>();
    	String sql = "select * from V_USER_TYPE where user_email = ? and f_catit_id = ? order by catit_intension";
        Object[] params = new Object[]{user_email,f_catit_id};
        int[] types =  new int[]{Types.VARCHAR,Types.VARCHAR}; 
        objectlist=jdbcTemplate.query(sql, params, types, new CatitMapper());
        for(Object li:objectlist){
        	try{
        		CatitModellist.add((CatitModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return CatitModellist;
	}
	
	/**
	 * 查询URL特征
	 */
	@Override
	public ArrayList<CatitModel> loadUrlCatit(String url_id,String f_catit_id) {
		List<Object> objectlist = new ArrayList<Object>();
    	ArrayList<CatitModel> CatitModellist = new ArrayList<CatitModel>();
    	String sql = "select * from V_URL_TYPE where url_id = ? and f_catit_id = ? order by catit_intension";
        Object[] params = new Object[]{url_id,f_catit_id};
        int[] types =  new int[]{Types.VARCHAR,Types.VARCHAR};
        objectlist=jdbcTemplate.query(sql, params, types, new CatitMapper());
        for(Object li:objectlist){
        	try{
        		CatitModellist.add((CatitModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return CatitModellist;
	}
	
	protected class CatitMapper implements RowMapper<Object>,Serializable{  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException {  
			CatitModel catitModel = new CatitModel();
			catitModel.setCatit_id(rs.getString("catit_id"));
			catitModel.setCatit_intension(rs.getDouble("catit_intension"));
			catitModel.setCatit_name(rs.getString("name"));
			catitModel.setF_catit_id(rs.getString("f_catit_id"));
            return catitModel;  
        }
          
    }
}
