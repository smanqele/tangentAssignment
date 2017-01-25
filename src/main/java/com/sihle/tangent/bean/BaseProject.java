package com.sihle.tangent.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public abstract class BaseProject {
	
	private int pk = 0;
	private String title = "";
	private String description = "";
	private String start_date = null;
	private String end_date = null;
	private boolean is_billable = true;
	private boolean is_active = false;
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public boolean isIs_billable() {
		return is_billable;
	}
	public void setIs_billable(boolean is_billable) {
		this.is_billable = is_billable;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	// Currently not used
	private Date createDate(String dStr){
		if (StringUtils.isEmpty(dStr)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
