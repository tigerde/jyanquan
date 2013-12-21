package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.Discipline;
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class DisciplineDao {
	private static final Logger log=Logger.getLogger(DisciplineDao.class);
	
	/**
	 * 获取驾驶员行为信息列表
	 * @param id 驾驶员db中id
	 * @return
	 */
	public static List<Discipline> getDisciplines(String starttime,String endtime,String sql){
		List<Discipline> list=new ArrayList<Discipline>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select  b.name,b.company,a.*  from discipline a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and a.discipline_date between ? and ? "+sql);
			ps.setString(1, starttime);
			ps.setString(2, endtime);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Discipline be=new Discipline();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				be.setName(rs.getString("name"));
				
				be.setPosition(rs.getString("position"));
				be.setDiscipline_date(rs.getString("discipline_date"));
				be.setDescription(rs.getString("description"));
				be.setGist(rs.getString("gist"));
				be.setFine(rs.getString("fine"));
				
				
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
			log.error("getDisciplines获取驾驶员行为信息", e);
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
	public static List<Discipline> getDisciplines(String id,String sql){
		List<Discipline> list=new ArrayList<Discipline>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from discipline where  deleted=0 and idcard=? "+sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Discipline be=new Discipline();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				be.setName("");
				
				be.setPosition(rs.getString("position"));
				be.setDiscipline_date(rs.getString("discipline_date"));
				be.setDescription(rs.getString("description"));
				be.setGist(rs.getString("gist"));
				be.setFine(rs.getString("fine"));
				
				 
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
			log.error("getDisciplines获取驾驶员行为信息", e);
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
	public static List<Discipline> getDisciplines(String sql){
		List<Discipline> list=new ArrayList<Discipline>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from discipline where  deleted=0   "+sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Discipline be=new Discipline();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				be.setName("");
				
				be.setPosition(rs.getString("position"));
				be.setDiscipline_date(rs.getString("discipline_date"));
				be.setDescription(rs.getString("description"));
				be.setGist(rs.getString("gist"));
				be.setFine(rs.getString("fine"));
				
				
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
			log.error("getDisciplines获取驾驶员行为信息", e);
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
	public static Discipline getDiscipline(String id){
		Discipline be=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("select * from discipline where deleted=0 and id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				
				be=new Discipline();
				be.setId(rs.getString("id"));
				be.setIdcard(rs.getString("idcard"));
				
				be.setName("");
				be.setPosition(rs.getString("position"));
				be.setDiscipline_date(rs.getString("discipline_date"));
				be.setDescription(rs.getString("description"));
				be.setGist(rs.getString("gist"));
				be.setFine(rs.getString("fine"));
				
				 
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
			log.error("getDiscipline获取驾驶员行为信息", e);
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
	public static int delDiscipline(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update discipline set deleted=1 where id=? ");
			ps.setString(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("delDiscipline删除驾驶员行为信息", e);
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
	public static int updateDiscipline(Discipline be){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("update discipline set position=?,discipline_date=?,description=?,gist=?,fine=?," +
			"modifi_datetime=?,modifi_user_id=?  where id=? ");
			
			
			ps.setString(1, be.getPosition());
			ps.setString(2, be.getDiscipline_date());
			ps.setString(3, be.getDescription());
			ps.setString(4, be.getGist());
			ps.setString(5, be.getFine());
			ps.setString(6, be.getModifi_datetime());
			ps.setString(7, be.getModifi_user_id());
			ps.setString(8, be.getId());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			log.error("updateDiscipline更新驾驶员行为信息", e);
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
	public static int insertDiscipline(Discipline be){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into  discipline (position,discipline_date,description,gist,fine," +
			"modifi_datetime,modifi_user_id,idcard,create_datetime,create_user_id,deleted) values(?,?,?,?,?,?,?,?,?,?,0) ");
		
			ps.setString(1, be.getPosition());
			ps.setString(2, be.getDiscipline_date());
			ps.setString(3, be.getDescription());
			ps.setString(4, be.getGist());
			ps.setString(5, be.getFine());
			
			ps.setString(6, be.getModifi_datetime());
			ps.setString(7, be.getModifi_user_id());
			ps.setString(8, be.getIdcard());
			ps.setString(9, be.getCreate_datetime());
			ps.setString(10, be.getCreate_user_id());
			
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
	public static int getDisciplineCount(String id){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from discipline where idcard=? and deleted=0");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getDisciplineCount获取驾驶员行为信息条数", e);
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
	public static int getDisciplineCount(String starttime,String endtime){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		conn=DBConn.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) count from discipline a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and a.discipline_date between ? and ?");
			ps.setString(1, starttime);
			ps.setString(2, endtime);
			rs=ps.executeQuery();
			if(rs.next()){
				i=rs.getInt("count");
			}
		} catch (SQLException e) {
			log.error("getDisciplineCount获取驾驶员行为信息条数", e);
		}finally{
			DBConn.close(rs, ps, conn);
		}
		
		return i;
	}
	
}
