package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.entity.TrafficViolation;
import com.anquan.jy.entity.User;
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class UserDao {
	private static final Logger log=Logger.getLogger(UserDao.class);
	
	/**
	 * 获取驾驶员交通事故信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<User> getUsers(String sql){
		List<User> list=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from sys_user where  deleted=0  "+sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				User ta=new User();
				ta.setId(rs.getString("id"));
				ta.setName(rs.getString("name"));
				ta.setUser_id(rs.getString("user_id"));
				ta.setPassword(rs.getString("password"));
			try {
				ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
			}catch (ParseException e) {
				log.error("getTrafficAccident时间格式化错误", e);
			}catch (NullPointerException e){
				log.error("getTrafficAccident时间格式化错误", e);
			}
			
			try {
				ta.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
			}catch (ParseException e) {
				log.error("getTrafficAccident时间格式化错误", e);
			}catch (NullPointerException e){
				log.error("getTrafficAccident时间格式化错误", e);
			}
			
			
		
				list.add(ta);
			}
			
		} catch (SQLException e) {
			log.error("getTrafficAccidents获取驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 获取驾驶员交通事故信息
	 * @param id
	 * @return
	 */
	public static User getUser(String id){
		User ta=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from sys_user where deleted=0 and id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
					ta=new User();
					ta.setId(rs.getString("id"));
					ta.setName(rs.getString("name"));
					ta.setUser_id(rs.getString(""));
					ta.setPassword(rs.getString("password"));
				try {
					ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficAccident时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficAccident时间格式化错误", e);
				}
				
				try {
					ta.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficAccident时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficAccident时间格式化错误", e);
				}
				
				
			}
			
		} catch (SQLException e) {
			log.error("getTrafficAccident获取驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return ta;
	}
	/**
	 * 删除某条交通事故信息
	 * @param id
	 * @return
	 */
	public static int delUser(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update sys_user set deleted=1 where id=? ");
			ps.setString(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("delTrafficAccident删除驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	/**
	 * 更新驾驶员某条交通事故信息
	 * @param ta
	 * @return
	 */
	public static int updateUser(User u){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update sys_user set user_id=?,password=?,name=?,modifi_datetime=? where id=? ");
			ps.setString(1, u.getUser_id());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setString(4, u.getModifi_datetime());
			ps.setString(5, u.getId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("更新驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	/**
	 * 创建交通事故信息
	 * @param ta
	 * @return
	 */
	public static int insertUser(User u){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into  sys_user (user_id,password,name,create_datetime,modifi_datetime" +
			",deleted) values(?,?,?,?,?,0) ");
			ps.setString(1, u.getUser_id());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setString(4, u.getCreate_datetime());
			ps.setString(5, u.getModifi_datetime());
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("创建新用户", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	/**
	 * 获取某驾驶员交通事故总行数
	 * @param id
	 * @return
	 */
	public static int getUserCount(){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from sys_user where deleted=0");
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getUserCount", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	 
	public static void main(String[] args) {
		//System.out.println(getTrafficAccident("3").getAccident_date());
		
	}
	
}
