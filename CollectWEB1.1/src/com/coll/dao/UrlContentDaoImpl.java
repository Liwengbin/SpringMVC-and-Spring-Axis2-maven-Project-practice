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
import com.coll.model.BehaviorModel;
import com.coll.model.DhModel;
import com.coll.model.NavModel;
import com.coll.model.UrlModel;
import com.coll.model.UrlnavModel;

@Repository
public class UrlContentDaoImpl implements UrlContentDao {

	Logger logger = Logger.getLogger(UrlContentDaoImpl.class);
    public JdbcTemplate jdbcTemplate;

    /**
     * 提供Spring注入JdbcTemplate的方法
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	/**
     * 添加网址
     * @param urlmodel
     */
    @Override
    public void addUrl(UrlModel urlmodel) {
    	System.out.println("===================================添加网址===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into URL_TABLE(url_id,href,title,logo,isfather,loction,size,user_email)"  
                    + "values (?,?,?,?,?,?,?,?)";
        
        Object[] params = {urlmodel.getUrl_id(),
        				   urlmodel.getHref(),
        				   urlmodel.getTitle(),
        				   urlmodel.getLogo(),
        				   urlmodel.getFather(),
        				   urlmodel.getLoction(),
        				   urlmodel.getSize(),
        				   urlmodel.getUser_email()
        				   };
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.BIT,Types.INTEGER,Types.INTEGER,Types.VARCHAR};  
        jdbcTemplate.update(sql, params, types);  
    }

    /**
     * 查询出是目录的集合
     */
    @Override
    public ArrayList<UrlModel> loadUrl(String user_email, boolean isfather) {
    	List<Object> objectlist = new ArrayList<Object>();
    	ArrayList<UrlModel> urlcontentModellist = new ArrayList<UrlModel>();
    	String sql = "select * from URL_TABLE where user_email = ? and isfather = ? order by loction";
        Object[] params = new Object[]{user_email,isfather};
        int[] types =  new int[]{Types.VARCHAR,Types.BIT}; 
        objectlist=jdbcTemplate.query(sql, params, types, new UrlMapper());
        for(Object li:objectlist){
        	try{
        	urlcontentModellist.add((UrlModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return urlcontentModellist;
    }

    /**
     * 知道目录id查询出目录下的网址
     */
    @Override
    public ArrayList<UrlModel> load_one_Url(int loction, boolean isfather, String user_email) {
    	List<Object> objectlist = new ArrayList<Object>();
    	ArrayList<UrlModel> urlcontentModellist = new ArrayList<UrlModel>();
    	String sql = "select * from URL_TABLE where user_email = ? and loction = ? and isfather = ? order by url_id";
        Object[] params = new Object[]{user_email,loction,isfather};
        int[] types =  new int[]{Types.VARCHAR,Types.INTEGER,Types.BIT}; 
        objectlist=jdbcTemplate.query(sql, params, types, new UrlMapper());
        for(Object li:objectlist){
        	try{
        	urlcontentModellist.add((UrlModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return urlcontentModellist;
    }
    
    protected class UrlMapper implements RowMapper<Object>,Serializable{  
  	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException { 
			UrlModel url = new UrlModel();
			url.setUrl_id(rs.getString("url_id"));
			url.setHref(rs.getString("href"));
			url.setTitle(rs.getString("title"));
			url.setLogo(rs.getString("logo"));//需要解析
			url.setFather(rs.getBoolean("isfather"));
			url.setLoction(rs.getInt("loction"));
			url.setUser_email(rs.getString("user_email"));
            return url;  
        }
    }

	@Override
	public void addDH(String user_email) {
		logger.info("===================================添加标记===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into DH_TABLE(user_email,H0,H1,H2,H3,H4,H5,H6,H7,H8,H9)"  
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {user_email,1,1,1,1,1,1,1,1,1,1};
        int[] types = {Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER};  
        jdbcTemplate.update(sql, params, types);
	}

	@Override
	public void updataDH(DhModel dh) {
		logger.info("===================================修改标记===================================");
    	jdbcTemplate.getDataSource();
        String sql = "update DH_TABLE set H0 = ?,H1 = ?,H2 = ?,H3 = ?,H4 = ?,H5 = ?,H6 = ?,H7 = ?,H8 = ?,H9 = ? where user_email= ?";
        Object[] params = {dh.getH0(),dh.getH1(),dh.getH2(),dh.getH3(),dh.getH4(),dh.getH5(),dh.getH6(),dh.getH7(),dh.getH8(),dh.getH9(),dh.getUser_email()};
        int[] types = {Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.VARCHAR};  
        jdbcTemplate.update(sql, params, types);
	}

	@Override
	public DhModel loadDh(String user_email) {
		List<Object> objectlist = new ArrayList<Object>();
    	String sql = "select * from DH_TABLE where user_email = ?";
        Object[] params = new Object[]{user_email};
        int[] types =  new int[]{Types.VARCHAR};
        objectlist=jdbcTemplate.query(sql, params, types, new DhMapper());
        
        if(objectlist.size()>0)
        {
        	return  (DhModel)objectlist.get(0);
        }else{
        	return null;
        }
	}
	
	protected class DhMapper implements RowMapper<Object>,Serializable{  
	  	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException { 
			DhModel dh = new DhModel();
			dh.setUser_email(rs.getString("user_email"));
			dh.setH0(rs.getInt("H0"));
			dh.setH1(rs.getInt("H1"));
			dh.setH2(rs.getInt("H2"));
			dh.setH3(rs.getInt("H3"));
			dh.setH4(rs.getInt("H4"));
			dh.setH5(rs.getInt("H5"));
			dh.setH6(rs.getInt("H6"));
			dh.setH7(rs.getInt("H7"));
			dh.setH8(rs.getInt("H8"));
			dh.setH9(rs.getInt("H9"));
            return dh;  
        }
    }


	@Override
	public ArrayList<NavModel> load_Nav(int f_type_id) {
		List<Object> objectlist = new ArrayList<Object>();
    	ArrayList<NavModel> navModellist = new ArrayList<NavModel>();
    	String sql = "select * from T_TYPE where f_type_id = ? order by type_id";
        Object[] params = new Object[]{f_type_id};
        int[] types =  new int[]{Types.INTEGER}; 
        objectlist=jdbcTemplate.query(sql, params, types, new NavMapper());
        for(Object li:objectlist){
        	try{
        		navModellist.add((NavModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return navModellist;
	}

	protected class NavMapper implements RowMapper<Object>,Serializable{  
	  	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException { 
			NavModel nav = new NavModel();
			nav.setType_id(rs.getInt("type_id"));
			nav.setType_name(rs.getString("type_name"));
			nav.setF_type_id(rs.getInt("f_type_id"));
			nav.setType_intension(rs.getDouble("type_intension"));
            return nav;  
        }
    }

	@Override
	public ArrayList<UrlnavModel> load_Nav_Url(int type_id) {
		List<Object> objectlist = new ArrayList<Object>();
    	ArrayList<UrlnavModel> urlnavModellist = new ArrayList<UrlnavModel>();
    	String sql = "select * from T_URL_SYS where type_id = ? order by size";
        Object[] params = new Object[]{type_id};
        int[] types =  new int[]{Types.INTEGER}; 
        objectlist=jdbcTemplate.query(sql, params, types, new UrlnavMapper());
        for(Object li:objectlist){
        	try{
        		urlnavModellist.add((UrlnavModel)li);
        	}catch(DataException e){
        		e.getStackTrace();
        	}
        }
        return urlnavModellist;
	}
	
    protected class UrlnavMapper implements RowMapper<Object>,Serializable{  
    	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override  
        public Object mapRow(ResultSet rs, int num) throws SQLException { 
			UrlnavModel url = new UrlnavModel();
			url.setUrl_id(rs.getString("url_id"));
			url.setHref(rs.getString("href"));
			url.setTitle(rs.getString("title"));
			url.setLogo(rs.getString("logo"));//需要解析
			url.setSize(rs.getInt("size"));
			url.setType_id(rs.getInt("type_id"));
            return url;  
        }
    }
    
	@Override
	public void addBehavior(BehaviorModel behavior) {
		
		
		logger.info("===================================添加被访问网址===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into HAVIOR_TABLE(havior_id,url_id,user_email,havior_time)"  
                    + "values (?,?,?,?)";
        Timestamp timestamp = new Timestamp(behavior.getHavior_time().getTime());//将java包中的date转为sql中的Timestamp
        Object[] params = {
        		behavior.getHavior_id(),
        		behavior.getUrl_id(),
        		behavior.getUser_email(),
        		timestamp
        				   };

        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP};
        jdbcTemplate.update(sql, params, types);
	}

	@Override
	public void add_Nav_Url(UrlnavModel urlnavModel) {
		System.out.println("===================================添加navurl网址===================================");
    	jdbcTemplate.getDataSource();
        String sql = "insert into T_URL_SYS(url_id,href,title,logo,size,type_id)"  
                    + "values (?,?,?,?,?,?)";
        
        Object[] params = {urlnavModel.getUrl_id(),
		        		   urlnavModel.getHref(),
		        		   urlnavModel.getTitle(),
		        		   urlnavModel.getLogo(),
        				   urlnavModel.getSize(),
        				   urlnavModel.getType_id()
        				   };
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.INTEGER};  
        jdbcTemplate.update(sql, params, types);
	}
}
