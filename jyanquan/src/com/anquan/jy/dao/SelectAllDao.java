package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.SelectAccident;
import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.util.DBConn;

public class SelectAllDao {
	private static final Logger log=Logger.getLogger(SelectAllDao.class);
	
	/**
	 * 获取驾驶员交通事故信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<SelectAccident> getSelectAccidents(String sql){
		List<SelectAccident> list=new ArrayList<SelectAccident>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				SelectAccident ta=new SelectAccident();
				ta.setId(rs.getString("id"));
				ta.setIdcard(rs.getString("idcard"));
				ta.setName(rs.getString("name"));
				ta.setCompany(rs.getString("company"));
				ta.setLine_number(rs.getString("line_number"));
				ta.setBus_number(rs.getString("bus_number"));
				
				ta.setAccident_date(rs.getString("accident_date"));
				ta.setAccident_location(rs.getString("accident_location"));
				ta.setAccident_summary(rs.getString("accident_summary"));
				ta.setAccident_liability(rs.getString("accident_liability"));
				ta.setResult(rs.getString("result"));
				ta.setReporter(rs.getString("reporter"));
				
				list.add(ta);
			}
			
		} catch (SQLException e) {
			log.error("getSelectAccidents获取驾驶员事故信息", e);
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
			ps=conn.prepareStatement("select * from traffic_accident where deleted=0");
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
				
			}
			
		} catch (SQLException e) {
			log.error("getTrafficAccident获取驾驶员交通事故信息", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		return ta;
	}
	
	/**
	 * 获取某驾驶员交通事故总行数
	 * @param id
	 * @return
	 */
	public static int getAccidentCount(String starttime ,String endtime,String type){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			
			String sql="";
			String datetype="";
			if(type.equals("traffic_accident")){
				datetype="accident_date";
			}else if(type.equals("traffic_violation")){
				datetype="violation_date";
			}else if(type.equals("mechanical_accident")){
				datetype="accident_date";
			}else if(type.equals("behavior")){
				datetype="incident_date";
			}else if(type.equals("discipline")){
				datetype="discipline_date";
			}else if(type.equals("all")){
				//datetype="accident_date";
			}
			
			sql="select count(*) count from "+type+" a left join drivers b on a.idcard=b.id where a.deleted=0 and b.deleted=0 and "+datetype+" between '"+starttime+"' and '"+endtime+"'";
			
			//ps=conn.prepareStatement();
			//ps=conn.prepareStatement("select count(*) count from traffic_accident where idcard=? and deleted=0");
			//ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getAccidentCount驾驶员事故列表总数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
}
