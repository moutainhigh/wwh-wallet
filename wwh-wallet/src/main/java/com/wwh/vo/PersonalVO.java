package com.wwh.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 手机版个人中心
 * 
 * @author u1
 */
public class PersonalVO {

	// 用户名
	String userName;
	// 用户头像
	String pic;
	// 会员的里程碑信息
	List<String> memLevel = new ArrayList<String>();
	// 我的积分
	String myScore;
	// 我的金币
	String myGoldCoin;
	// 我的分享
	String myShare;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public List<String> getMemLevel() {
		return memLevel;
	}

	public void setMemLevel(List<String> memLevel) {
		this.memLevel = memLevel;
	}

	public String getMyScore() {
		return myScore;
	}

	public void setMyScore(String myScore) {
		this.myScore = myScore;
	}

	public String getMyGoldCoin() {
		return myGoldCoin;
	}

	public void setMyGoldCoin(String myGoldCoin) {
		this.myGoldCoin = myGoldCoin;
	}

	public String getMyShare() {
		return myShare;
	}

	public void setMyShare(String myShare) {
		this.myShare = myShare;
	}

	@Override
	public String toString() {
		return "PersonalVO [userName=" + userName + ", pic=" + pic + ", memLevel=" + memLevel + ", myScore=" + myScore
				+ ", myGoldCoin=" + myGoldCoin + ", myShare=" + myShare + "]";
	}
}
