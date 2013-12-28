package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.Driver;
import com.anquan.jy.entity.User;
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class AnquanDao {
	private final static Logger log=Logger.getLogger(AnquanDao.class);
	
	/**
	 * 用户登录验证
	 * @param username
	 * @param password
	 * @return User实体对象：成功，或者null
	 */
	public static User checkLogin(String username,String password){
		User user=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from  sys_user where user_id=? and password=? and deleted=0");
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getString("id"));
				user.setUser_id(rs.getString("user_id"));
				user.setName(rs.getString("name"));
				user.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				user.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
			}
		} catch (SQLException e) {
			log.error("checkLogin用户登录验证", e);
		} catch (ParseException e) {
			log.error("checkLogin时间格式化错误", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return user;
	}
	
	/**
	 * 获取符合条件司机列表
	 * @param sql
	 * @return List<Driver>
	 */
	public static List<Driver> getDrivers(String sql){
		List<Driver> list=new ArrayList<Driver>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from drivers where deleted=0 "+sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Driver driver=new Driver();
				driver.setId(rs.getString("id"));
				driver.setStaffid(rs.getString("staffid"));
				driver.setName(rs.getString("name"));
				driver.setIdcard(rs.getString("idcard"));
				driver.setSex(rs.getString("sex"));
				driver.setBirth(rs.getString("birth"));
				driver.setMobile_phone(rs.getString("mobile_phone"));
				driver.setHome_phone(rs.getString("home_phone"));
				driver.setLine_number(rs.getString("line_number"));
				driver.setBus_number(rs.getString("bus_number"));
				driver.setDriving_type(rs.getString("driving_type"));
				driver.setPass_time(rs.getString("pass_time"));
				driver.setCompany(rs.getString("company"));
				 
				try {
					driver.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getDrivers时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDrivers时间格式化错误", e);
				}
				try {
					driver.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getDrivers时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDrivers时间格式化错误", e);
				}
				driver.setModifi_user_id(rs.getString("create_user_id"));
				driver.setModifi_user_id(rs.getString("modifi_user_id"));
				driver.setDeleted(rs.getInt("deleted"));
				list.add(driver);
			}
		} catch (SQLException e) {
			log.error("getDrivers获取符合条件的司机列表", e);
		} finally{
			DBConn.close(rs, ps, conn);
		}
		
		return list;
	}
	/**
	 * 根据id获取驾驶员信息
	 * @param id
	 * @return Driver
	 */
	public static Driver getDriver(String id){
		Driver driver=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from drivers where id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				driver=new Driver();
				driver.setId(rs.getString("id"));
				driver.setStaffid(rs.getString("staffid"));
				driver.setName(rs.getString("name"));
				driver.setIdcard(rs.getString("idcard"));
				driver.setSex(rs.getString("sex"));
				driver.setBirth(rs.getString("birth"));
				driver.setMobile_phone(rs.getString("mobile_phone"));
				driver.setHome_phone(rs.getString("home_phone"));
				driver.setLine_number(rs.getString("line_number"));
				driver.setBus_number(rs.getString("bus_number"));
				driver.setDriving_type(rs.getString("driving_type"));
				driver.setPass_time(rs.getString("pass_time"));
				driver.setCompany(rs.getString("company"));
				
				try {
					driver.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getDrivers时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDrivers时间格式化错误", e);
				}
				try {
					driver.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getDrivers时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDrivers时间格式化错误", e);
				}
				driver.setModifi_user_id(rs.getString("create_user_id"));
				driver.setModifi_user_id(rs.getString("modifi_user_id"));
				driver.setDeleted(rs.getInt("deleted"));
				
			}
		} catch (SQLException e) {
			log.error("getDrivers获取符合条件的司机列表", e);
		} finally{
			DBConn.close(rs, ps, conn);
		}
		
		return driver;
	}
	
	
	
	
	
	
	/**
	 * 获取符合条件司机总数
	 * @param sql
	 * @return List<Driver>
	 */
	public static int getDriversCount(String sql){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from drivers where deleted=0 "+ sql);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getDrivers获取符合条件的司机列表总数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	/**
	 * 删除某驾驶员信息
	 * @param id
	 * @return 成功 1，失败0
	 */
	public static int delDriver(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("update drivers set deleted=1 where id=? ");
			ps.setString(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("getDrivers获取符合条件的司机列表总数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	
	/**
	 * 删除某驾驶员信息
	 * @param id
	 * @return 成功 1，失败0
	 */
	public static int updateDriver(Driver driver){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			
			ps=conn.prepareStatement("update drivers set staffid=?,name=?, idcard=?, sex=?,"+
					"birth=?,mobile_phone=?,home_phone=?,line_number=?,bus_number=?,driving_type=?,pass_time=?,"+
					"company=?,modifi_datetime=?,modifi_user_id=? where id=?");
			ps.setString(1, driver.getStaffid());
			ps.setString(2, driver.getName());
			ps.setString(3, driver.getIdcard());
			ps.setString(4, driver.getSex());
			ps.setString(5, driver.getBirth());
			ps.setString(6, driver.getMobile_phone());
			ps.setString(7, driver.getHome_phone());
			ps.setString(8, driver.getLine_number());
			ps.setString(9, driver.getBus_number());
			ps.setString(10, driver.getDriving_type());
			ps.setString(11, driver.getPass_time());
			ps.setString(12, driver.getCompany());
			ps.setString(13, driver.getModifi_datetime());
			ps.setString(14, driver.getModifi_user_id());
			ps.setString(15, driver.getId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("updateDriver更新驾驶员信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	/**
	 * 删除某驾驶员信息
	 * @param id
	 * @return 成功 1，失败0
	 */
	public static int insertDriver(Driver driver){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			
			ps=conn.prepareStatement("insert into drivers(staffid,name, idcard, sex,"+
					"birth,mobile_phone,home_phone,line_number,bus_number,driving_type,pass_time,"+
			"company,modifi_datetime,modifi_user_id,create_datetime,create_user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, driver.getStaffid());
			ps.setString(2, driver.getName());
			ps.setString(3, driver.getIdcard());
			ps.setString(4, driver.getSex());
			ps.setString(5, driver.getBirth());
			ps.setString(6, driver.getMobile_phone());
			ps.setString(7, driver.getHome_phone());
			ps.setString(8, driver.getLine_number());
			ps.setString(9, driver.getBus_number());
			ps.setString(10, driver.getDriving_type());
			ps.setString(11, driver.getPass_time());
			ps.setString(12, driver.getCompany());
			ps.setString(13, driver.getModifi_datetime());
			ps.setString(14, driver.getModifi_user_id());
			ps.setString(15, driver.getCreate_datetime());
			ps.setString(16, driver.getCreate_user_id());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("updateDriver更新驾驶员信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	
	//******************************驾驶员事故信息数据操作**************************************
	
	
	
public static void main(String[] args) {
	/*登录验证测试
	User user=checkLogin("admin", "admin");
	System.out.println(user.getCreate_datetime());
	*/

	
}
}

