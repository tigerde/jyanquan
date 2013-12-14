package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.SafetyDistance;
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class CopyOfSafetyDistanceDao {
	private static final Logger log=Logger.getLogger(CopyOfSafetyDistanceDao.class);
	
	/**
	 * 获取驾驶员 安全里程列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<SafetyDistance> getSafetyDistances(String id,String sql){
		List<SafetyDistance> list=new ArrayList<SafetyDistance>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from safety_distance where  deleted=0 and idcard=? "+sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				
				SafetyDistance be=new SafetyDistance();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				//be.setName("");
				be.setBus_number(rs.getString("bus_number"));
				be.setYear(rs.getInt("year"));
				be.setMonth(rs.getInt("month"));
				be.setMileage_month(rs.getDouble("mileage_month"));
				be.setMileage_year(rs.getDouble("mileage_year"));
				
				try {
					be.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getDisciplines时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDisciplines时间格式化错误", e);
				}
				
				try {
					be.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getDisciplines时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDisciplines时间格式化错误", e);
				}
				
				be.setCreate_user_id(rs.getString("create_user_id"));
				be.setModifi_user_id(rs.getString("modifi_user_id"));
				list.add(be);
			}
			
		} catch (SQLException e) {
			log.error("getSafetyDistance获取驾驶员 安全里程列表", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	
	
	/**
	 * 获取驾驶员 安全里程
	 * @param id
	 * @return
	 */
	public static SafetyDistance getSafetyDistance(String id){
		SafetyDistance be=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from safety_distance where deleted=0 and id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				
				be=new SafetyDistance();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				
				be.setBus_number(rs.getString("bus_number"));
				be.setYear(rs.getInt("year"));
				be.setMonth(rs.getInt("month"));
				be.setMileage_month(rs.getDouble("mileage_month"));
				be.setMileage_year(rs.getDouble("mileage_year"));
				
				 
				try {
					be.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getDisciplines时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDisciplines时间格式化错误", e);
				}
				
				try {
					be.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getDisciplines时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getDisciplines时间格式化错误", e);
				}
				
				be.setCreate_user_id(rs.getString("create_user_id"));
				be.setModifi_user_id(rs.getString("modifi_user_id"));
				
			}
			
		} catch (SQLException e) {
			log.error("getSafetyDistance获取驾驶员行为信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return be;
	}
	
	/**
	 * 删除某条获取驾驶员 安全里程
	 * @param id
	 * @return
	 */
	public static int delSafetyDistance(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update safety_distance set deleted=1 where id=? ");
			ps.setString(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("delSafetyDistance删除某条获取驾驶员 安全里程", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	
	/**
	 * 更新驾驶员某年月安全里程
	 * @param ta
	 * @return
	 */
	public static int updateSafetyDistance(SafetyDistance be){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update safety_distance set bus_number=?,year=?,month=?,mileage_month=?,mileage_year=?,mileage=?," +
			"modifi_datetime=?,modifi_user_id=?  where id=? ");
			
			ps.setString(1, be.getBus_number());
			ps.setInt(2, be.getYear());
			ps.setInt(3, be.getMonth());
			ps.setDouble(4, be.getMileage_month());
			ps.setDouble(5, be.getMileage_year());
			ps.setDouble(6, be.getMileage());
			ps.setString(7, be.getModifi_datetime());
			ps.setString(8, be.getModifi_user_id());
			ps.setString(9, be.getId());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("updateSafetyDistance更新驾驶员某年月安全里程", e);
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
	public static int insertSafetyDistance(SafetyDistance be){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into  safety_distance (bus_number,year,month,mileage_month,mileage_year,mileage," +
			"modifi_datetime,modifi_user_id,idcard,create_datetime,create_user_id,deleted) values(?,?,?,?,?,?,?,?,?,?,?,0) ");
		
			ps.setString(1, be.getBus_number());
			ps.setInt(2, be.getYear());
			ps.setInt(3, be.getMonth());
			ps.setDouble(4, be.getMileage_month());
			ps.setDouble(5, be.getMileage_year());
			ps.setDouble(6, be.getMileage());
			
			ps.setString(7, be.getModifi_datetime());
			ps.setString(8, be.getModifi_user_id());
			ps.setString(9, be.getIdcard());
			ps.setString(10, be.getCreate_datetime());
			ps.setString(11, be.getCreate_user_id());
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("写入驾驶员某年月安全里程", e);
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
	public static int getSafetyDistanceCount(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from safety_distance where idcard=? and deleted=0");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getSafetyDistanceCount获取驾驶员行为信息条数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	
}
