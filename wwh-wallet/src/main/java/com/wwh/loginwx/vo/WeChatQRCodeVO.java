package com.wwh.loginwx.vo;

public class WeChatQRCodeVO {
	// ticket
	private String ticket;
	// 有效时间
	private Integer expire_seconds;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	@Override
	public String toString() {
		return "WeChatQRCodeVO [ticket=" + ticket + ", expire_seconds=" + expire_seconds + "]";
	}

}
