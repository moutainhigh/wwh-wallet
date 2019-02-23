package com.wwh.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MShareVO {
	// 用户名
	private String userName;
	// 我的推荐人id
	private Long referenceId;
	// 推荐人用户名
	private String referenceName;
	// 我的邀请总人数
	private Integer totalInvite;
	// 我的路程碑信息
	private List<String> memberStoneList = new ArrayList<String>();
	// 各种会员人数
	private Map<String, Integer> memberNum = new HashMap<String, Integer>();
	// 各种会员信息
	private Map<String, List<UserVO>> uservoList = new HashMap<String, List<UserVO>>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Integer getTotalInvite() {
		return totalInvite;
	}

	public void setTotalInvite(Integer totalInvite) {
		this.totalInvite = totalInvite;
	}

	public List<String> getMemberStoneList() {
		return memberStoneList;
	}

	public void setMemberStoneList(List<String> memberStoneList) {
		this.memberStoneList = memberStoneList;
	}

	public Map<String, Integer> getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Map<String, Integer> memberNum) {
		this.memberNum = memberNum;
	}

	public Map<String, List<UserVO>> getUservoList() {
		return uservoList;
	}

	public void setUservoList(Map<String, List<UserVO>> uservoList) {
		this.uservoList = uservoList;
	}

	@Override
	public String toString() {
		return "MShareVO [userName=" + userName + ", referenceId=" + referenceId + ", referenceName=" + referenceName
				+ ", totalInvite=" + totalInvite + ", memberStoneList=" + memberStoneList + ", memberNum=" + memberNum
				+ ", uservoList=" + uservoList + "]";
	}

}
