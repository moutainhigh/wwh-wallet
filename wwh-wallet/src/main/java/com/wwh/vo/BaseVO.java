
package com.wwh.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = 2929192541916818946L;

	/**
	 * 用户主键ID
	 */
	private Long id;

	/**
	 * 用户唯一身份标识
	 */
	private Long userId;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 创建人
	 */
	private Long createdBy;

	/**
	 * 创建日期
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="CCT")
	private Date createdDate;

	/**
	 * 最后更新人
	 */
	private Long lastUpdatedBy;

	/**
	 * 最后更新时间
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="CCT")
	private Date lastUpdatedDate;

	/**
	 * 有效标识（Y：有效 N:无效）
	 */
	private String activeFlag;

	/**
	 * 删除标识（Y：删除 N:未删除）
	 */
	private String deleteFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
