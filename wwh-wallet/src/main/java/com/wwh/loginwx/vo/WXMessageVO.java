package com.wwh.loginwx.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")  
public class WXMessageVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4772087110317260916L;
		//开发者微信号
	 	@XStreamAlias("ToUserName")  
	    private String ToUserName; 
	 	//发送方帐号（一个OpenID）
	    @XStreamAlias("FromUserName")  
	    private String FromUserName;  
	    //消息创建时间 （整型）
	    @XStreamAlias("CreateTime")  
	    private Long CreateTime; 
	    //消息类型 文本：text，图片：image，语音：voice，视频：video，地理位置：location ，链接：link，事件：event
	    @XStreamAlias("MsgType")  
	    private String MsgType; 
	    //消息id
	    @XStreamAlias("MsgId")  
	    private Long MsgId;
	    
	    // 文本消息  
	    @XStreamAlias("Content")  
	    private String Content;
	    
	    // 图片消息  
	    @XStreamAlias("PicUrl")  
	    private String PicUrl;
	    
	    // 位置消息  
	    @XStreamAlias("LocationX")  
	    private String LocationX;  
	    @XStreamAlias("LocationY")  
	    private String LocationY;  
	    @XStreamAlias("Scale")  
	    private Long Scale;  
	    @XStreamAlias("Label")  
	    private String Label; 
	    
	    // 链接消息  
	    @XStreamAlias("Title")  
	    private String Title;  
	    @XStreamAlias("Description")  
	    private String Description;  
	    @XStreamAlias("Url")  
	    private String URL; 
	    
	    // 语音信息  
	    @XStreamAlias("MediaId")  
	    private String MediaId;  
	    @XStreamAlias("Format")  
	    private String Format;  
	    @XStreamAlias("Recognition")  
	    private String Recognition; 
	    
	    //事件
	    // 事件类型，未关注：subscribe  已关注：SCAN
	    @XStreamAlias("Event")  
	    private String Event; 
	    //事件KEY值，未关注：qrscene_为前缀，后面为二维码的参数值
	    //已关注：是一个32位无符号整数，即创建二维码时的二维码scene_id
	    @XStreamAlias("EventKey")  
	    private String EventKey;
	    //二维码的ticket，可用来换取二维码图片
	    @XStreamAlias("Ticket")  
	    private String Ticket;  
	  
	    public String getToUserName() {  
	        return ToUserName;  
	    }  
	  
	    public void setToUserName(String toUserName) {  
	        ToUserName = toUserName;  
	    }  
	  
	    public String getFromUserName() {  
	        return FromUserName;  
	    }  
	  
	    public void setFromUserName(String fromUserName) {  
	        FromUserName = fromUserName;  
	    }  
	  
	    public Long getCreateTime() {  
	        return CreateTime;  
	    }  
	  
	    public void setCreateTime(Long createTime) {  
	        CreateTime = createTime;  
	    }  
	  
	    public String getMsgType() {  
	        return MsgType;  
	    }  
	  
	    public void setMsgType(String msgType) {  
	        MsgType = msgType;  
	    }  
	  
	    public Long getMsgId() {  
	        return MsgId;  
	    }  
	  
	    public void setMsgId(Long msgId) {  
	        MsgId = msgId;  
	    }  
	  
	    public String getContent() {  
	        return Content;  
	    }  
	  
	    public void setContent(String content) {  
	        Content = content;  
	    }  
	  
	    public String getPicUrl() {  
	        return PicUrl;  
	    }  
	  
	    public void setPicUrl(String picUrl) {  
	        PicUrl = picUrl;  
	    }  
	  
	    public String getLocationX() {  
	        return LocationX;  
	    }  
	  
	    public void setLocationX(String locationX) {  
	        LocationX = locationX;  
	    }  
	  
	    public String getLocationY() {  
	        return LocationY;  
	    }  
	  
	    public void setLocationY(String locationY) {  
	        LocationY = locationY;  
	    }  
	  
	    public Long getScale() {  
	        return Scale;  
	    }  
	  
	    public void setScale(Long scale) {  
	        Scale = scale;  
	    }  
	  
	    public String getLabel() {  
	        return Label;  
	    }  
	  
	    public void setLabel(String label) {  
	        Label = label;  
	    }  
	  
	    public String getTitle() {  
	        return Title;  
	    }  
	  
	    public void setTitle(String title) {  
	        Title = title;  
	    }  
	  
	    public String getDescription() {  
	        return Description;  
	    }  
	  
	    public void setDescription(String description) {  
	        Description = description;  
	    }  
	  
	    public String getURL() {  
	        return URL;  
	    }  
	  
	    public void setURL(String uRL) {  
	        URL = uRL;  
	    }  
	  
	    public String getEvent() {  
	        return Event;  
	    }  
	  
	    public void setEvent(String event) {  
	        Event = event;  
	    }  
	  
	    public String getEventKey() {  
	        return EventKey;  
	    }  
	  
	    public void setEventKey(String eventKey) {  
	        EventKey = eventKey;  
	    }  
	  
	    public String getMediaId() {  
	        return MediaId;  
	    }  
	  
	    public void setMediaId(String mediaId) {  
	        MediaId = mediaId;  
	    }  
	  
	    public String getFormat() {  
	        return Format;  
	    }  
	  
	    public void setFormat(String format) {  
	        Format = format;  
	    }  
	  
	    public String getRecognition() {  
	        return Recognition;  
	    }  
	  
	    public void setRecognition(String recognition) {  
	        Recognition = recognition;  
	    }  
	  
	    public String getTicket() {  
	        return Ticket;  
	    }  
	  
	    public void setTicket(String ticket) {  
	        Ticket = ticket;  
	    }

		@Override
		public String toString() {
			return "WXMessageVO [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime="
					+ CreateTime + ", MsgType=" + MsgType + ", MsgId=" + MsgId + ", Content=" + Content + ", PicUrl="
					+ PicUrl + ", LocationX=" + LocationX + ", LocationY=" + LocationY + ", Scale=" + Scale + ", Label="
					+ Label + ", Title=" + Title + ", Description=" + Description + ", URL=" + URL + ", MediaId="
					+ MediaId + ", Format=" + Format + ", Recognition=" + Recognition + ", Event=" + Event
					+ ", EventKey=" + EventKey + ", Ticket=" + Ticket + "]";
		}  
    
}
