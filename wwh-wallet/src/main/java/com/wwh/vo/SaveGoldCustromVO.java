package com.wwh.vo;

import java.math.BigDecimal;

import com.wwh.common.PagedResult;

/**
 * 
 * @ClassName: SaveGoldCustromVO
 * @Description: 储备金页面自定义VO
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:09:10
 */
public class SaveGoldCustromVO extends WalletAmountExtendVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -1351009465079999505L;

	/**
	 * 体验系统最后一个盘的状态
	 */
	public String tiyanDiskStatus;
	/**
	 * 惠民系统最后一个盘的状态
	 */
	public String huiminDiskStatus;
	/**
	 * 富民系统最后一个盘的状态
	 */
	public String fuminDiskStatus;
	/**
	 * 兴民系统左后一个盘的状态
	 */
	public String xingminDiskStatus;
	/**
	 * 体验系统收益详情记录LIST
	 */
	private PagedResult<ProfitExtendVO> tiyanList;
	/**
	 * 惠民系统收益详情记录LIST
	 */
	private PagedResult<ProfitExtendVO> huiminList;
	/**
	 * 富民系统收益详情记录LIST
	 */
	private PagedResult<ProfitExtendVO> fuminList;
	/**
	 * 兴民系统收益详情记录LIST
	 */
	private PagedResult<ProfitExtendVO> xingminList;

	/**
	 * 体验系统可提现金额
	 */
	private BigDecimal tiyanWithdrawalsAmount = new BigDecimal(0);
	/**
	 * 惠民系统可提现金额
	 */
	private BigDecimal huiminWithdrawalsAmount = new BigDecimal(0);
	/**
	 * 富民系统可提现金额
	 */
	private BigDecimal fuminWithdrawalsAmount = new BigDecimal(0);
	/**
	 * 兴民系统可提现金额
	 */
	private BigDecimal xingminWithdrawalsAmount = new BigDecimal(0);

	/**
	 * 体验系统储备金
	 */
	private BigDecimal tiyanSaveAmount = new BigDecimal(0);
	/**
	 * 惠民系统储备金
	 */
	private BigDecimal huiminSaveAmount = new BigDecimal(0);
	/**
	 * 富民系统储备金
	 */
	private BigDecimal fuminSaveAmount = new BigDecimal(0);
	/**
	 * 兴民系统储备金
	 */
	private BigDecimal xingminSaveAmount = new BigDecimal(0);

	/**
	 * 体验系统总充值金额
	 */
	private BigDecimal tiyanRcg = new BigDecimal(0);
	/**
	 * 惠民系统总充值金额
	 */
	private BigDecimal huiminRcg = new BigDecimal(0);
	/**
	 * 富民系统总充值金额
	 */
	private BigDecimal fuminRcg = new BigDecimal(0);
	/**
	 * 兴民系统总充值金额
	 */
	private BigDecimal xingminRcg = new BigDecimal(0);
	/**
	 * 体验系统总收益金额
	 */
	private BigDecimal tiyanProfit = new BigDecimal(0);
	/**
	 * 惠民系统总收益金额
	 */
	private BigDecimal huiminProfit = new BigDecimal(0);
	/**
	 * 富民系统总收益金额
	 */
	private BigDecimal fuminProfit = new BigDecimal(0);
	/**
	 * 兴民系统总收益金额
	 */
	private BigDecimal xingminProfit = new BigDecimal(0);

	/**
	 * 体验系统当前会员人数
	 */
	private Integer tiyanMemberCurrentCounter = 0;
	/**
	 * 惠民系统当前会员人数
	 */
	private Integer huiminMemberCurrentCounter = 0;
	/**
	 * 富民系统当前会员人数
	 */
	private Integer fuminMenberCurrentCounter = 0;
	/**
	 * 兴民系统当前会员人数
	 */
	private Integer xingminMenberCurrentCounter = 0;
	/**
	 * 用户在体验系统的A推荐点个数
	 */
	private Integer tiyanARecommentPoint = 0;
	/**
	 * 用户在惠民系统的A推荐点个数
	 */
	private Integer huiminARecommentPoint = 0;
	/**
	 * 用户在富民系统的A推荐点个数
	 */
	private Integer fuminARecommentPoint = 0;
	/**
	 * 用户在兴民系统的A推荐点个数
	 */
	private Integer xingminARecommentPoint = 0;

	/**
	 * 体验系统最后一个盘种的角色id
	 */
	private String tiyanRoleId;
	/**
	 * 惠民系统最后一个盘中的角色id
	 */
	private String huiminRoleId;
	/**
	 * 惠民系统最后一个盘中的角色id
	 */
	private String fuminRoleId;
	/**
	 * 兴民系统最后一个盘中的角色id
	 */
	private String xingminRoleId;

	private Integer tiyanInvitePerson = 0;

	private Integer huiminInvitePerson = 0;

	private Integer fuminInvitePerson = 0;

	private Integer xingminInvitePerson = 0;

	private Integer tiyanUpWaittingRecords = 0;

	private Integer huiminUpWaittingRecords = 0;

	private BigDecimal tiyanUpWaittingSaveGold = new BigDecimal(0.00);

	private BigDecimal huiminUpWaittingSaveGold = new BigDecimal(0.00);

	public Integer getTiyanARecommentPoint() {
		return tiyanARecommentPoint;
	}

	public void setTiyanARecommentPoint(Integer tiyanARecommentPoint) {
		this.tiyanARecommentPoint = tiyanARecommentPoint;
	}

	public Integer getHuiminARecommentPoint() {
		return huiminARecommentPoint;
	}

	public void setHuiminARecommentPoint(Integer huiminARecommentPoint) {
		this.huiminARecommentPoint = huiminARecommentPoint;
	}

	public Integer getTiyanMemberCurrentCounter() {
		return tiyanMemberCurrentCounter;
	}

	public void setTiyanMemberCurrentCounter(Integer tiyanMemberCurrentCounter) {
		this.tiyanMemberCurrentCounter = tiyanMemberCurrentCounter;
	}

	public Integer getHuiminMemberCurrentCounter() {
		return huiminMemberCurrentCounter;
	}

	public void setHuiminMemberCurrentCounter(Integer huiminMemberCurrentCounter) {
		this.huiminMemberCurrentCounter = huiminMemberCurrentCounter;
	}

	public Integer getFuminMenberCurrentCounter() {
		return fuminMenberCurrentCounter;
	}

	public void setFuminMenberCurrentCounter(Integer fuminMenberCurrentCounter) {
		this.fuminMenberCurrentCounter = fuminMenberCurrentCounter;
	}

	public Integer getXingminMenberCurrentCounter() {
		return xingminMenberCurrentCounter;
	}

	public void setXingminMenberCurrentCounter(Integer xingminMenberCurrentCounter) {
		this.xingminMenberCurrentCounter = xingminMenberCurrentCounter;
	}

	public BigDecimal getTiyanWithdrawalsAmount() {
		return tiyanWithdrawalsAmount;
	}

	public void setTiyanWithdrawalsAmount(BigDecimal tiyanWithdrawalsAmount) {
		this.tiyanWithdrawalsAmount = tiyanWithdrawalsAmount;
	}

	public BigDecimal getHuiminWithdrawalsAmount() {
		return huiminWithdrawalsAmount;
	}

	public void setHuiminWithdrawalsAmount(BigDecimal huiminWithdrawalsAmount) {
		this.huiminWithdrawalsAmount = huiminWithdrawalsAmount;
	}

	public BigDecimal getFuminWithdrawalsAmount() {
		return fuminWithdrawalsAmount;
	}

	public void setFuminWithdrawalsAmount(BigDecimal fuminWithdrawalsAmount) {
		this.fuminWithdrawalsAmount = fuminWithdrawalsAmount;
	}

	public BigDecimal getXingminWithdrawalsAmount() {
		return xingminWithdrawalsAmount;
	}

	public void setXingminWithdrawalsAmount(BigDecimal xingminWithdrawalsAmount) {
		this.xingminWithdrawalsAmount = xingminWithdrawalsAmount;
	}

	public BigDecimal getTiyanSaveAmount() {
		return tiyanSaveAmount;
	}

	public void setTiyanSaveAmount(BigDecimal tiyanSaveAmount) {
		this.tiyanSaveAmount = tiyanSaveAmount;
	}

	public BigDecimal getHuiminSaveAmount() {
		return huiminSaveAmount;
	}

	public void setHuiminSaveAmount(BigDecimal huiminSaveAmount) {
		this.huiminSaveAmount = huiminSaveAmount;
	}

	public BigDecimal getFuminSaveAmount() {
		return fuminSaveAmount;
	}

	public void setFuminSaveAmount(BigDecimal fuminSaveAmount) {
		this.fuminSaveAmount = fuminSaveAmount;
	}

	public BigDecimal getXingminSaveAmount() {
		return xingminSaveAmount;
	}

	public void setXingminSaveAmount(BigDecimal xingminSaveAmount) {
		this.xingminSaveAmount = xingminSaveAmount;
	}

	public BigDecimal getTiyanRcg() {
		return tiyanRcg;
	}

	public void setTiyanRcg(BigDecimal tiyanRcg) {
		this.tiyanRcg = tiyanRcg;
	}

	public BigDecimal getHuiminRcg() {
		return huiminRcg;
	}

	public void setHuiminRcg(BigDecimal huiminRcg) {
		this.huiminRcg = huiminRcg;
	}

	public BigDecimal getFuminRcg() {
		return fuminRcg;
	}

	public void setFuminRcg(BigDecimal fuminRcg) {
		this.fuminRcg = fuminRcg;
	}

	public BigDecimal getXingminRcg() {
		return xingminRcg;
	}

	public void setXingminRcg(BigDecimal xingminRcg) {
		this.xingminRcg = xingminRcg;
	}

	public BigDecimal getTiyanProfit() {
		return tiyanProfit;
	}

	public void setTiyanProfit(BigDecimal tiyanProfit) {
		this.tiyanProfit = tiyanProfit;
	}

	public BigDecimal getHuiminProfit() {
		return huiminProfit;
	}

	public void setHuiminProfit(BigDecimal huiminProfit) {
		this.huiminProfit = huiminProfit;
	}

	public BigDecimal getFuminProfit() {
		return fuminProfit;
	}

	public void setFuminProfit(BigDecimal fuminProfit) {
		this.fuminProfit = fuminProfit;
	}

	public BigDecimal getXingminProfit() {
		return xingminProfit;
	}

	public void setXingminProfit(BigDecimal xingminProfit) {
		this.xingminProfit = xingminProfit;
	}

	public PagedResult<ProfitExtendVO> getTiyanList() {
		return tiyanList;
	}

	public void setTiyanList(PagedResult<ProfitExtendVO> tiyanList) {
		this.tiyanList = tiyanList;
	}

	public PagedResult<ProfitExtendVO> getHuiminList() {
		return huiminList;
	}

	public void setHuiminList(PagedResult<ProfitExtendVO> huiminList) {
		this.huiminList = huiminList;
	}

	public PagedResult<ProfitExtendVO> getFuminList() {
		return fuminList;
	}

	public void setFuminList(PagedResult<ProfitExtendVO> fuminList) {
		this.fuminList = fuminList;
	}

	public PagedResult<ProfitExtendVO> getXingminList() {
		return xingminList;
	}

	public void setXingminList(PagedResult<ProfitExtendVO> xingminList) {
		this.xingminList = xingminList;
	}

	public Integer getFuminARecommentPoint() {
		return fuminARecommentPoint;
	}

	public void setFuminARecommentPoint(Integer fuminARecommentPoint) {
		this.fuminARecommentPoint = fuminARecommentPoint;
	}

	public Integer getXingminARecommentPoint() {
		return xingminARecommentPoint;
	}

	public void setXingminARecommentPoint(Integer xingminARecommentPoint) {
		this.xingminARecommentPoint = xingminARecommentPoint;
	}

	public String getTiyanRoleId() {
		return tiyanRoleId;
	}

	public void setTiyanRoleId(String tiyanRoleId) {
		this.tiyanRoleId = tiyanRoleId;
	}

	public String getHuiminRoleId() {
		return huiminRoleId;
	}

	public void setHuiminRoleId(String huiminRoleId) {
		this.huiminRoleId = huiminRoleId;
	}

	public String getFuminRoleId() {
		return fuminRoleId;
	}

	public void setFuminRoleId(String fuminRoleId) {
		this.fuminRoleId = fuminRoleId;
	}

	public String getXingminRoleId() {
		return xingminRoleId;
	}

	public void setXingminRoleId(String xingminRoleId) {
		this.xingminRoleId = xingminRoleId;
	}

	public String getTiyanDiskStatus() {
		return tiyanDiskStatus;
	}

	public void setTiyanDiskStatus(String tiyanDiskStatus) {
		this.tiyanDiskStatus = tiyanDiskStatus;
	}

	public String getHuiminDiskStatus() {
		return huiminDiskStatus;
	}

	public void setHuiminDiskStatus(String huiminDiskStatus) {
		this.huiminDiskStatus = huiminDiskStatus;
	}

	public String getFuminDiskStatus() {
		return fuminDiskStatus;
	}

	public void setFuminDiskStatus(String fuminDiskStatus) {
		this.fuminDiskStatus = fuminDiskStatus;
	}

	public String getXingminDiskStatus() {
		return xingminDiskStatus;
	}

	public void setXingminDiskStatus(String xingminDiskStatus) {
		this.xingminDiskStatus = xingminDiskStatus;
	}

	public Integer getTiyanInvitePerson() {
		return tiyanInvitePerson;
	}

	public void setTiyanInvitePerson(Integer tiyanInvitePerson) {
		this.tiyanInvitePerson = tiyanInvitePerson;
	}

	public Integer getHuiminInvitePerson() {
		return huiminInvitePerson;
	}

	public void setHuiminInvitePerson(Integer huiminInvitePerson) {
		this.huiminInvitePerson = huiminInvitePerson;
	}

	public Integer getFuminInvitePerson() {
		return fuminInvitePerson;
	}

	public void setFuminInvitePerson(Integer fuminInvitePerson) {
		this.fuminInvitePerson = fuminInvitePerson;
	}

	public Integer getXingminInvitePerson() {
		return xingminInvitePerson;
	}

	public void setXingminInvitePerson(Integer xingminInvitePerson) {
		this.xingminInvitePerson = xingminInvitePerson;
	}

	public Integer getTiyanUpWaittingRecords() {
		return tiyanUpWaittingRecords;
	}

	public void setTiyanUpWaittingRecords(Integer tiyanUpWaittingRecords) {
		this.tiyanUpWaittingRecords = tiyanUpWaittingRecords;
	}

	public Integer getHuiminUpWaittingRecords() {
		return huiminUpWaittingRecords;
	}

	public void setHuiminUpWaittingRecords(Integer huiminUpWaittingRecords) {
		this.huiminUpWaittingRecords = huiminUpWaittingRecords;
	}

	public BigDecimal getTiyanUpWaittingSaveGold() {
		return tiyanUpWaittingSaveGold;
	}

	public void setTiyanUpWaittingSaveGold(BigDecimal tiyanUpWaittingSaveGold) {
		this.tiyanUpWaittingSaveGold = tiyanUpWaittingSaveGold;
	}

	public BigDecimal getHuiminUpWaittingSaveGold() {
		return huiminUpWaittingSaveGold;
	}

	public void setHuiminUpWaittingSaveGold(BigDecimal huiminUpWaittingSaveGold) {
		this.huiminUpWaittingSaveGold = huiminUpWaittingSaveGold;
	}

	@Override
	public String toString() {
		return "SaveGoldCustromVO [tiyanDiskStatus=" + tiyanDiskStatus + ", huiminDiskStatus=" + huiminDiskStatus
				+ ", fuminDiskStatus=" + fuminDiskStatus + ", xingminDiskStatus=" + xingminDiskStatus + ", tiyanList="
				+ tiyanList + ", huiminList=" + huiminList + ", fuminList=" + fuminList + ", xingminList=" + xingminList
				+ ", tiyanWithdrawalsAmount=" + tiyanWithdrawalsAmount + ", huiminWithdrawalsAmount="
				+ huiminWithdrawalsAmount + ", fuminWithdrawalsAmount=" + fuminWithdrawalsAmount
				+ ", xingminWithdrawalsAmount=" + xingminWithdrawalsAmount + ", tiyanSaveAmount=" + tiyanSaveAmount
				+ ", huiminSaveAmount=" + huiminSaveAmount + ", fuminSaveAmount=" + fuminSaveAmount
				+ ", xingminSaveAmount=" + xingminSaveAmount + ", tiyanRcg=" + tiyanRcg + ", huiminRcg=" + huiminRcg
				+ ", fuminRcg=" + fuminRcg + ", xingminRcg=" + xingminRcg + ", tiyanProfit=" + tiyanProfit
				+ ", huiminProfit=" + huiminProfit + ", fuminProfit=" + fuminProfit + ", xingminProfit=" + xingminProfit
				+ ", tiyanMemberCurrentCounter=" + tiyanMemberCurrentCounter + ", huiminMemberCurrentCounter="
				+ huiminMemberCurrentCounter + ", fuminMenberCurrentCounter=" + fuminMenberCurrentCounter
				+ ", xingminMenberCurrentCounter=" + xingminMenberCurrentCounter + ", tiyanARecommentPoint="
				+ tiyanARecommentPoint + ", huiminARecommentPoint=" + huiminARecommentPoint + ", fuminARecommentPoint="
				+ fuminARecommentPoint + ", xingminARecommentPoint=" + xingminARecommentPoint + ", tiyanRoleId="
				+ tiyanRoleId + ", huiminRoleId=" + huiminRoleId + ", fuminRoleId=" + fuminRoleId + ", xingminRoleId="
				+ xingminRoleId + ", tiyanInvitePerson=" + tiyanInvitePerson + ", huiminInvitePerson="
				+ huiminInvitePerson + ", fuminInvitePerson=" + fuminInvitePerson + ", xingminInvitePerson="
				+ xingminInvitePerson + ", tiyanUpWaittingRecords=" + tiyanUpWaittingRecords
				+ ", huiminUpWaittingRecords=" + huiminUpWaittingRecords + ", tiyanUpWaittingSaveGold="
				+ tiyanUpWaittingSaveGold + ", huiminUpWaittingSaveGold=" + huiminUpWaittingSaveGold + "]";
	}
}
