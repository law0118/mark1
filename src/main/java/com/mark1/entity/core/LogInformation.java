package com.mark1.entity.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Embeddable
public class LogInformation {
	
	private Date createDate = new Date();
	private Date lastUpdate;
	private String createBy;
	private String lastUpdateBy;
	private int activeFlag = ACTIVE;
	
	public final static int ACTIVE = 1;
	public final static int INACTIVE = 0;
	
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "update_date")
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Column(name = "create_by")
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	@Column(name = "update_by")
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	
	@Column(name = "active_flag")
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
//	public static int getActive() {
//		return ACTIVE;
//	}
//	public static int getInactive() {
//		return INACTIVE;
//	}
	
	@JsonIgnore
	@Transient
	public boolean isActive(){
		return(getActiveFlag() == ACTIVE);
	}
	
	@JsonIgnore
	@Transient
	public boolean isInactive(){
		return(getActiveFlag() == INACTIVE);
	}
	

}
