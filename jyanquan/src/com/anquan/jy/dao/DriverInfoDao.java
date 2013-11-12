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

public class DriverInfoDao {
	private static final Logger log=Logger.getLogger(DriverInfoDao.class);
	
	/**
	 * 获取驾驶员交通事故信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<TrafficAccident> getTrafficAccidents(String id,String sql){
		List<TrafficAccident> list=new ArrayList<TrafficAccident>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from traffic_accident where  deleted=0 and idcard=? "+sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				
				TrafficAccident ta=new TrafficAccident();
				ta.setId(rs.getString("id"));
				ta.setIdcard(rs.getString("idcard"));
				ta.setCompany(rs.getString("company"));
				ta.setLine_number(rs.getString("line_number"));
				ta.setBus_number(rs.getString("bus_number"));
				ta.setName("");
				ta.setAccident_date(rs.getString("accident_date"));
				ta.setAccident_location(rs.getString("accident_location"));
				ta.setAccident_summary(rs.getString("accident_summary"));
				ta.setAccident_liability(rs.getString("accident_liability"));
				ta.setResult(rs.getString("result"));
				ta.setReporter(rs.getString("reporter"));
				
				try {
					ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficAccidents时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficAccidents时间格式化错误", e);
				}
				
				try {
					ta.setModifi_datetime(TimeFormatUtil.getTime(rs.getString("modifi_datetime")));
				}catch (ParseException e) {
					log.error("getTrafficAccidents时间格式化错误", e);
				}catch (NullPointerException e){
					log.error("getTrafficAccidents时间格式化错误", e);
				}
				
				ta.setCreate_user_id(rs.getString("create_user_id"));
				ta.setModifi_user_id(rs.getString("modifi_user_id"));
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
	 * 获取驾驶员交通事故信息
	 * @param id
	 * @return
	 */
	public static TrafficAccident getTrafficAccident(String id){
		TrafficAccident ta=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from traffic_accident where deleted=0 and id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				ta=new TrafficAccident();
				ta.setId(rs.getString("id"));
				ta.setIdcard(rs.getString("idcard"));
				ta.setCompany(rs.getString("company"));
				ta.setLine_number(rs.getString("line_number"));
				ta.setBus_number(rs.getString("bus_number"));
				ta.setName("");
				ta.setAccident_date(rs.getString("accident_date"));
				ta.setAccident_location(rs.getString("accident_location"));
				ta.setAccident_summary(rs.getString("accident_summary"));
				ta.setAccident_liability(rs.getString("accident_liability"));
				ta.setResult(rs.getString("result"));
				ta.setReporter(rs.getString("reporter"));
				
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
				
				ta.setCreate_user_id(rs.getString("create_user_id"));
				ta.setModifi_user_id(rs.getString("modifi_user_id"));
				
			}
			
		} catch (SQLException e) {
			log.error("getTrafficAccident获取驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return ta;
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
	 * 删除某条交通事故信息
	 * @param id
	 * @return
	 */
	public static int delTrafficAccident(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update traffic_accident set deleted=1 where id=? ");
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
	 * 更新驾驶员某条交通事故信息
	 * @param ta
	 * @return
	 */
	public static int updateTrafficAccident(TrafficAccident ta){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update traffic_accident set company=?,line_number=?,bus_number=?,accident_date=?," +
					"accident_location=?,accident_summary=?,accident_liability=?,result=?,reporter=?,modifi_datetime=?,modifi_user_id=?  where id=? ");
			ps.setString(1, ta.getCompany());
			ps.setString(2, ta.getLine_number());
			ps.setString(3, ta.getBus_number());
			ps.setString(4, ta.getAccident_date());
			ps.setString(5, ta.getAccident_location());
			ps.setString(6, ta.getAccident_summary());
			ps.setString(7, ta.getAccident_liability());
			ps.setString(8, ta.getResult());
			ps.setString(9, ta.getReporter());
			ps.setString(10, ta.getModifi_datetime());
			ps.setString(11, ta.getModifi_user_id());
			ps.setString(12, ta.getId());
			
			i=ps.executeUpdate();
			System.out.println("sdfghjkl;'"+i);
		} catch (SQLException e) {
			log.error("更新驾驶员交通事故信息", e);
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
			System.out.println("sdfghjkl;'"+i);
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
	public static int insertTrafficAccident(TrafficAccident ta){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into  traffic_accident (company,line_number,bus_number,accident_date," +
			"accident_location,accident_summary,accident_liability,result,reporter,modifi_datetime,modifi_user_id,idcard,create_datetime,create_user_id,deleted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,0) ");
			ps.setString(1, ta.getCompany());
			ps.setString(2, ta.getLine_number());
			ps.setString(3, ta.getBus_number());
			ps.setString(4, ta.getAccident_date());
			ps.setString(5, ta.getAccident_location());
			ps.setString(6, ta.getAccident_summary());
			ps.setString(7, ta.getAccident_liability());
			ps.setString(8, ta.getResult());
			ps.setString(9, ta.getReporter());
			ps.setString(10, ta.getModifi_datetime());
			ps.setString(11, ta.getModifi_user_id());
			ps.setString(12, ta.getIdcard());
			ps.setString(13, ta.getCreate_datetime());
			ps.setString(14, ta.getCreate_user_id());
			
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
	 * 获取某驾驶员交通事故总行数
	 * @param id
	 * @return
	 */
	public static int getTrafficAccidentCount(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from traffic_accident where idcard=? and deleted=0");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getTrafficAccidentCount驾驶员事故列表总数", e);
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
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(getTrafficAccident("3").getAccident_date());
		
	}
	
}
