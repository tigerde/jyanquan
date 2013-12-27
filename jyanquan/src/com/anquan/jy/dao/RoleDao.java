package com.anquan.jy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.anquan.jy.entity.Role;
import com.anquan.jy.util.DBConn;
import com.anquan.jy.util.TimeFormatUtil;

public class RoleDao {
	private static final Logger log = Logger.getLogger(RoleDao.class);

	/**
	 * 获取驾驶员交通事故信息列表
	 * @param 驾驶员db中
	 * @return 
	 */
	public static List<Role> getRoles(String id) {
		List<Role> list = new ArrayList<Role>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("select * from sys_role where user_id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Role ta = new Role();
				ta.setId(rs.getString("id"));
				ta.setUser_id(rs.getString("user_id"));
				ta.setRole_name(rs.getString("role_name"));
				ta.setRole_value(rs.getString("role_value"));
				try {
					ta.setCreate_datetime(TimeFormatUtil.getTime(rs.getString("create_datetime")));
				} catch (ParseException e) {
					log.error("getRoles时间格式化错误", e);
				} catch (NullPointerException e) {
					log.error("getRoles时间格式化错误", e);
				}
				list.add(ta);
			}

		} catch (SQLException e) {
			log.error("getRoles获取用户权限信息错误", e);
		} finally {
			DBConn.close(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 获取驾驶员交通事故信息列表
	 * @param 驾驶员db中
	 * @return 
	 */
	public static Map<String, String> getmapRoles(String id){
		Map<String, String> map = new HashMap<String, String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("select * from sys_role where user_id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getString("role_name"), rs.getString("role_value"));
			}
			
		} catch (SQLException e) {
			log.error("getRoles获取用户权限信息错误", e);
		} finally {
			DBConn.close(rs, ps, conn);
		}
		return map;
	}

	/**
	 * 删除某用户权限信息
	 * @param id
	 * @return
	 */
	public static int delRole(String id) {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("delete from sys_role  where  user_id=? ");
			ps.setString(1, id);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			log.error("delRole", e);
		} finally {
			DBConn.close(rs, ps, conn);
		}
		return i;
	}

	/**
	 * 创建交通事故信息
	 * 
	 * @param ta
	 * @return
	 */
	public static boolean insertRole(List<Role> list,String id) {
		boolean b = false;
		int i=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("delete from sys_role  where  user_id=? ");
			ps.setString(1, id);
			i = ps.executeUpdate();
			ps = conn.prepareStatement("insert into  sys_role (user_id,role_name,role_value,create_datetime,create_user_id) values(?,?,?,?,?) ");
			for(Role u:list){
				ps.setString(1, u.getUser_id());
				ps.setString(2, u.getRole_name());
				ps.setString(3, u.getRole_value());
				ps.setString(4, u.getCreate_datetime());
				ps.setString(5, u.getCreate_user_id());
			ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			log.error("创建新用户", e);
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConn.close(rs, ps, conn);
		}
		b=i>0;
		return b;
	}

}
