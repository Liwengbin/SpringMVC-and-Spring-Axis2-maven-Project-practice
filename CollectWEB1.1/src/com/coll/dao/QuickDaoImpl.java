package com.coll.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coll.exception.DataException;
import com.coll.model.QuickModel;
import com.coll.model.UrlquickModel;

@Repository
public class QuickDaoImpl implements QuickDao{

	Logger logger = Logger.getLogger(QuickDaoImpl.class);
	
	public JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addQuick(QuickModel quickModel) {
		logger.info("===================================添加标记===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into QUICK_TABLE(quick_id,quick_prm,tag,user_email)"  
                    + "values (?,?,?,?)";
        Object[] params = {quickModel.getQuick_id(),quickModel.getQuick_prm(),quickModel.getTag(),quickModel.getUser_email()};
        int[] types = {Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.VARCHAR};  
        jdbcTemplate.update(sql, params, types);
		
	}

	@Override
	public void updataQuick(String quick_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuickModel loadQuick(String quick_id) {
		List<Object> quickModellist = new ArrayList<Object>();
    	String sql = "select * from QUICK_TABLE where quick_id = ?";
        Object[] params = new Object[]{quick_id};
        int[] types =  new int[]{Types.VARCHAR};
        quickModellist=jdbcTemplate.query(sql, params, types, new QuickMapper());
        if(quickModellist.size()>0)
        {
        	return  (QuickModel)quickModellist.get(0);
        }else{
        	return null;
        }
	}

	@Override
	public void addUrlQuick(UrlquickModel urlquick) {
		logger.info("===================================添加quickurl===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into URL_QUICK_TABLE(url_id,href,title,time,quick_tag)"  
                    + "values (?,?,?,?,?)";
        Timestamp timestamp = new Timestamp(urlquick.getTime().getTime());//将java包中的date转为sql中的Timestamp
        Object[] params = {urlquick.getUrl_id(),urlquick.getHref(),urlquick.getTitle(),timestamp,urlquick.getTag()};
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP,Types.INTEGER};
        jdbcTemplate.update(sql, params, types);
	}

	@Override
	public void updataUrlQuick(UrlquickModel urlquick) {
		// TODO Auto-generated method stub		
	}

	@Override
	public ArrayList<UrlquickModel> loadUrlQuick(int quick_tag, String word) {
		
		List<Object> objectlist = new ArrayList<Object>();
		ArrayList<UrlquickModel> urlquickModellist = new ArrayList<UrlquickModel>();
		String sql;
		Object[] params;
		int[] types;
		if(word == null){
			sql = "select * from URL_QUICK_TABLE where quick_tag = ? order by time";
			params = new Object[]{quick_tag};
	        types =  new int[]{Types.INTEGER};
		}else{
			sql = "select * from URL_QUICK_TABLE where quick_tag = ? and title like ? order by time";
			params = new Object[]{quick_tag,word}; 
	        types =  new int[]{Types.INTEGER,Types.VARCHAR};
		}

        objectlist=jdbcTemplate.query(sql, params, types, new UrlquickMapper());
        for(Object li:objectlist){
        	try{ 
        		urlquickModellist.add((UrlquickModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return urlquickModellist;
	}

	@Override
	public void deleteUrlQuick(String url_id) {
		String sql = "delete from URL_QUICK_TABLE where url_id = ?"; 
    	int[] types = {Types.VARCHAR};
    	Object[] params = new Object[]{url_id};
    	jdbcTemplate.update(sql,params,types);
	}
	
	/**
	 * 查询QuickModel依赖的内部类
	 * @author Administrator
	 *
	 */
	protected class QuickMapper implements RowMapper<Object>,Serializable{  

		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException { 
			QuickModel quick = new QuickModel();
			quick.setQuick_id(rs.getString("quick_id"));
			quick.setQuick_prm(rs.getInt("quick_prm"));			
			quick.setTag(rs.getInt("tag"));
			quick.setUser_email(rs.getString("user_email"));
            return quick;  
        }
    }

	
	/**
	 * 查询UrlquickModel依赖的内部类
	 * @author Administrator
	 *
	 */
	protected class UrlquickMapper implements RowMapper<Object>,Serializable{  

		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException { 
			UrlquickModel urlquick = new UrlquickModel();
			urlquick.setUrl_id(rs.getString("url_id"));
			urlquick.setHref(rs.getString("href"));			
			urlquick.setTitle(rs.getString("title"));
			urlquick.setTime(rs.getTimestamp("time"));
			urlquick.setTag(rs.getInt("quick_tag"));
            return urlquick;  
        }
    }
}
