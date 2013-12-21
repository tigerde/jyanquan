package com.anquan.jy.action;

import net.sf.json.JSONObject;

import com.anquan.jy.biz.DriverInfoBiz;
import com.anquan.jy.dao.BehaviorDao;
import com.anquan.jy.dao.DisciplineDao;
import com.anquan.jy.entity.Behavior;
import com.anquan.jy.entity.Discipline;
import com.anquan.jy.entity.TrafficViolation;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DisciplineAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo;// 页码
	private int pageSize;// 页值
	private String sidx;// 排序字段
	private String sord;// 排序方式 asc /desc
	private boolean _search=false;// 是否搜索 true false
	private String oper; // 增删改判断标记
	private String id;
	private JSONObject json;
	
	private String idcard;// '身份证',
	private String name;// '驾驶员',
	private String position;// '职位',
	private String discipline_date;// '时间',
	private String description;// '事由',
	private String gist;// '处罚依据',
	private String fine;// '罚款金额',
	
	private String starttime;
	private String endtime;
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDiscipline(){

		if(id!=null&&!id.equals("")){
			json=DriverInfoBiz.getDisciplines(pageNo, pageSize, sidx, sord, id);
		}else{
			json=DriverInfoBiz.getDisciplines(pageNo, pageSize, sidx, sord, starttime,endtime);
		}
		return SUCCESS;
	}
	/**
	 * 编辑驾驶员违章违纪信息
	 */
	public void editDiscipline(){
		if (oper.equals("del")){
			//删除
			DisciplineDao.delDiscipline(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			Discipline be=new Discipline();
			be.setId(id);
			be.setIdcard(idcard);
			
			be.setName(name);
			
			be.setPosition(position);
			be.setDiscipline_date(discipline_date);
			be.setDescription(description);
			be.setGist(gist);
			be.setFine(fine);
		
			
			be.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			be.setModifi_user_id("1");
			DisciplineDao.updateDiscipline(be);
		}else if(oper.equals("add")){
			Discipline be=new Discipline();
			be.setIdcard(idcard);

			be.setName(name);
			be.setPosition(position);
			be.setDiscipline_date(discipline_date);
			be.setDescription(description);
			be.setGist(gist);
			be.setFine(fine);
			
			be.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			be.setModifi_user_id("1");
			be.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			be.setCreate_user_id("1");
			DisciplineDao.insertDiscipline(be);
		}
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public boolean is_search() {
		return _search;
	}
	public void set_search(boolean search) {
		_search = search;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDiscipline_date() {
		return discipline_date;
	}
	public void setDiscipline_date(String discipline_date) {
		this.discipline_date = discipline_date;
	}
	public String getGist() {
		return gist;
	}
	public void setGist(String gist) {
		this.gist = gist;
	}
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
	}
	 
}
