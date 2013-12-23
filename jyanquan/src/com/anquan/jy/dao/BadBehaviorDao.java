package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.Behavior;
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class BadBehaviorDao {
	private static final Logger log=Logger.getLogger(BadBehaviorDao.class);
	
	/**
	 * 获取驾驶员行为信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<Behavior> getBehaviors(String starttime,String endtime,String sql){
		List<Behavior> list=new ArrayList<Behavior>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select b.name,b.company,a.*  from badbehavior a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and   a.incident_date between ? and ? "+sql);
			ps.setString(1, starttime);
			ps.setString(2, endtime);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Behavior be=new Behavior();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				
				be.setName(rs.getString("name"));
				be.setIncident_date(rs.getString("incident_date"));
				be.setIncident_location(rs.getString("incident_location"));
				be.setDescription(rs.getString("description"));
				be.setResult(rs.getString("result"));
				 
				
				try {
					be.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getBehaviors时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getBehaviors时间格式化错误", e);
				}
				
				try {
					be.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getBehaviors时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getBehaviors时间格式化错误", e);
				}
				
				be.setCreate_user_id(rs.getString("create_user_id"));
				be.setModifi_user_id(rs.getString("modifi_user_id"));
				list.add(be);
			}
			
		} catch (SQLException e) {
			log.error("getBehaviors获取驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 获取驾驶员行为信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<Behavior> getBehaviors(String id,String sql){
		List<Behavior> list=new ArrayList<Behavior>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from badbehavior where  deleted=0 and idcard=? "+sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Behavior be=new Behavior();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				
				be.setName(rs.getString("name"));
				be.setIncident_date(rs.getString("incident_date"));
				be.setIncident_location(rs.getString("incident_location"));
				be.setDescription(rs.getString("description"));
				be.setResult(rs.getString("result"));
				 
				 
				//be.setType(rs.getString("type"));
				 
				try {
					be.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getBehaviors时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getBehaviors时间格式化错误", e);
				}
				
				try {
					be.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getBehaviors时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getBehaviors时间格式化错误", e);
				}
				
				be.setCreate_user_id(rs.getString("create_user_id"));
				be.setModifi_user_id(rs.getString("modifi_user_id"));
				list.add(be);
			}
			
		} catch (SQLException e) {
			log.error("getBehaviors获取驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	
	
	/**
	 * 获取驾驶员行为信息
	 * @param id
	 * @return
	 */
	public static Behavior getBehavior(String id){
		Behavior be=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from badbehavior where deleted=0 and id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				
				be=new Behavior();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				
				be.setName(rs.getString("name"));
				be.setIncident_date(rs.getString("incident_date"));
				be.setIncident_location(rs.getString("incident_location"));
				be.setDescription(rs.getString("description"));
				be.setResult(rs.getString("result")); 
				 
				try {
					be.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getBehaviors时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getBehaviors时间格式化错误", e);
				}
				
				try {
					be.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getBehaviors时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getBehaviors时间格式化错误", e);
				}
				
				be.setCreate_user_id(rs.getString("create_user_id"));
				be.setModifi_user_id(rs.getString("modifi_user_id"));
				
			}
			
		} catch (SQLException e) {
			log.error("getBehavior获取驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return be;
	}
	
	/**
	 * 删除某条行为信息
	 * @param id
	 * @return
	 */
	public static int delBehavior(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update badbehavior set deleted=1 where id=? ");
			ps.setString(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("delBehavior删除驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	
	/**
	 * 更新驾驶员行为信息
	 * @param ta
	 * @return
	 */
	public static int updateBehavior(Behavior be){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update badbehavior set incident_date=?,incident_location=?,description=?,result=?," +
			"modifi_datetime=?,modifi_user_id=?  where id=? ");
			ps.setString(1, be.getIncident_date());
			ps.setString(2, be.getIncident_location());
			ps.setString(3, be.getDescription());
			ps.setString(4, be.getResult());
			ps.setString(5, be.getModifi_datetime());
			ps.setString(6, be.getModifi_user_id());
			ps.setString(7, be.getId());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("updateBehavior更新驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	/**
	 * 创建行为信息
	 * @param ta
	 * @return
	 */
	public static int insertBehavior(Behavior be){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into  badbehavior (incident_date,incident_location,description,result," +
			"modifi_datetime,modifi_user_id,idcard,create_datetime,create_user_id,deleted) values(?,?,?,?,?,?,?,?,?,0) ");
		
			ps.setString(1, be.getIncident_date());
			ps.setString(2, be.getIncident_location());
			ps.setString(3, be.getDescription());
			ps.setString(4, be.getResult());
			
			ps.setString(5, be.getModifi_datetime());
			ps.setString(6, be.getModifi_user_id());
			ps.setString(7, be.getIdcard());
			ps.setString(8, be.getCreate_datetime());
			ps.setString(9, be.getCreate_user_id());
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("更新驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	/**
	 * 获取某驾驶员行为数据总行数
	 * @param id
	 * @return
	 */
	public static int getBehaviorCount(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from badbehavior where idcard=? and deleted=0");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getBadBehaviorCount获取驾驶员行为信息条数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	/**
	 * 获取某驾驶员行为数据总行数
	 * @param id
	 * @return
	 */
	public static int getBehaviorCount(String starttime,String endtime){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from badbehavior a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and a.incident_date between ? and ?");
			ps.setString(1, starttime);
			ps.setString(2, endtime);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getBadBehaviorCount获取驾驶员行为信息条数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	
}
