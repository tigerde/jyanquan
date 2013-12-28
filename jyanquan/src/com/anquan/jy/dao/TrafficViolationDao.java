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
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class TrafficViolationDao {
	private static final Logger log=Logger.getLogger(TrafficViolationDao.class);
	
	/**
	 * 获取驾驶员交通违章信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<TrafficViolation> getTrafficViolations(String starttime,String endtime,String sql){
		List<TrafficViolation> list=new ArrayList<TrafficViolation>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select b.name,b.company,a.* from traffic_violation a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and   a.violation_date between ? and ? "+sql);
			ps.setString(1, starttime);
			ps.setString(2, endtime);
			rs=ps.executeQuery();
			while(rs.next()){
				
				TrafficViolation ta=new TrafficViolation();
				ta.setId(rs.getString("id"));
				ta.setIdcard(rs.getString("idcard"));
				ta.setCompany(rs.getString("company"));
				ta.setBus_number(rs.getString("bus_number"));
				ta.setName(rs.getString("name"));
				ta.setViolation_date(rs.getString("violation_date"));
				ta.setViolation_location(rs.getString("violation_location"));
				ta.setViolation_reason(rs.getString("violation_reason"));
				ta.setPoints(rs.getInt("points"));
				ta.setFine(rs.getDouble("fine"));
				ta.setAssessment_date(rs.getString("assessment_date"));
				
				try {
					ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficViolations时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficViolations时间格式化错误", e);
				}
				
				try {
					ta.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficViolations时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficViolations时间格式化错误", e);
				}
				
				ta.setCreate_user_id(rs.getString("create_user_id"));
				ta.setModifi_user_id(rs.getString("modifi_user_id"));
				list.add(ta);
			}
			
		} catch (SQLException e) {
			log.error("getTrafficViolations获取驾驶员交通违章信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 获取驾驶员交通违章信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<TrafficViolation> getTrafficViolations(String id,String sql){
		List<TrafficViolation> list=new ArrayList<TrafficViolation>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from traffic_violation where  deleted=0 and idcard=? "+sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				
				TrafficViolation ta=new TrafficViolation();
				ta.setId(rs.getString("id"));
				ta.setIdcard(rs.getString("idcard"));
				ta.setCompany(rs.getString("company"));
				ta.setBus_number(rs.getString("bus_number"));
				ta.setName("");
				ta.setViolation_date(rs.getString("violation_date"));
				ta.setViolation_location(rs.getString("violation_location"));
				ta.setViolation_reason(rs.getString("violation_reason"));
				ta.setPoints(rs.getInt("points"));
				ta.setFine(rs.getDouble("fine"));
				ta.setAssessment_date(rs.getString("assessment_date"));
				 
				try {
					ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficViolations时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficViolations时间格式化错误", e);
				}
				
				try {
					ta.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficViolations时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficViolations时间格式化错误", e);
				}
				
				ta.setCreate_user_id(rs.getString("create_user_id"));
				ta.setModifi_user_id(rs.getString("modifi_user_id"));
				list.add(ta);
			}
			
		} catch (SQLException e) {
			log.error("getTrafficViolations获取驾驶员交通违章信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	
	
	/**
	 * 获取驾驶员交通违章信息
	 * @param id
	 * @return
	 */
	public static TrafficViolation getTrafficViolation(String id){
		TrafficViolation ta=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from traffic_violation where deleted=0 and id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				ta=new TrafficViolation();
				ta.setId(rs.getString("id"));
				ta.setIdcard(rs.getString("idcard"));
				ta.setCompany(rs.getString("company"));
				ta.setBus_number(rs.getString("bus_number"));
				ta.setName("");
				ta.setViolation_date(rs.getString("violation_date"));
				ta.setViolation_location(rs.getString("violation_location"));
				ta.setViolation_reason(rs.getString("violation_reason"));
				ta.setPoints(rs.getInt("points"));
				ta.setFine(rs.getDouble("fine"));
				ta.setAssessment_date(rs.getString("assessment_date"));
				
				try {
					ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficViolation时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficViolation时间格式化错误", e);
				}
				
				try {
					ta.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficViolation时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficViolation时间格式化错误", e);
				}
				
				ta.setCreate_user_id(rs.getString("create_user_id"));
				ta.setModifi_user_id(rs.getString("modifi_user_id"));
				
			}
			
		} catch (SQLException e) {
			log.error("getTrafficViolation获取驾驶员交通违章信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return ta;
	}
	
	/**
	 * 删除某条交通违章信息
	 * @param id
	 * @return
	 */
	public static int delTrafficViolation(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update traffic_violation set deleted=1 where id=? ");
			ps.setString(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("delTrafficViolation删除驾驶员交通违章信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	
	/**
	 * 更新驾驶员违章信息
	 * @param ta
	 * @return
	 */
	public static int updateTrafficViolation(TrafficViolation ta){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update traffic_violation set bus_number=?,company=?,violation_date=?,violation_location=?,violation_reason=?," +
			"points=?,fine=?,assessment_date=?,modifi_datetime=?,modifi_user_id=?  where id=? ");
			ps.setString(1, ta.getBus_number());
			ps.setString(2, ta.getCompany());
			ps.setString(3, ta.getViolation_date());
			ps.setString(4, ta.getViolation_location());
			ps.setString(5, ta.getViolation_reason());
			ps.setInt(6, ta.getPoints());
			ps.setDouble(7, ta.getFine());
			ps.setString(8, ta.getAssessment_date());
			ps.setString(9, ta.getModifi_datetime());
			ps.setString(10, ta.getModifi_user_id());
			ps.setString(11, ta.getId());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("updateTrafficViolation更新驾驶员交通违章信息", e);
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
	public static int insertTrafficViolation(TrafficViolation ta){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into  traffic_violation (bus_number,company,violation_date,violation_location,violation_reason," +
			"points,fine,assessment_date,modifi_datetime,modifi_user_id,idcard,create_datetime,create_user_id,deleted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,0) ");
			ps.setString(1, ta.getBus_number());
			ps.setString(2, ta.getCompany());
			ps.setString(3, ta.getViolation_date());
			ps.setString(4, ta.getViolation_location());
			ps.setString(5, ta.getViolation_reason());
			ps.setInt(6, ta.getPoints());
			ps.setDouble(7, ta.getFine());
			ps.setString(8, ta.getAssessment_date());
			 
			ps.setString(9, ta.getModifi_datetime());
			ps.setString(10, ta.getModifi_user_id());
			ps.setString(11, ta.getIdcard());
			ps.setString(12, ta.getCreate_datetime());
			ps.setString(13, ta.getCreate_user_id());
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("更新驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return i;
	}
	/**
	 * 获取某驾驶员交通违章数据总行数
	 * @param id
	 * @return
	 */
	public static int getTrafficViolationCount(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from traffic_violation where idcard=? and deleted=0");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getTrafficViolationCount获取驾驶员违章信息条数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	/**
	 * 获取某驾驶员交通违章数据总行数
	 * @param id
	 * @return
	 */
	public static int getTrafficViolationCount(String starttime,String endtime){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from traffic_violation a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and   a.violation_date between ? and ?");
			ps.setString(1, starttime);
			ps.setString(2, endtime);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getTrafficViolationCount获取驾驶员违章信息条数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	
}
