package com.beafoodie.usshike.model.msg;

import com.beafoodie.usshike.model.msg.InMsg;

/**
	�ظ���Ƶ��Ϣ
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[video]]></MsgType>
			<Video>
				<MediaId><![CDATA[media_id]]></MediaId>
				<Title><![CDATA[title]]></Title>
				<Description><![CDATA[description]]></Description>
			</Video>
	</xml>
 */
public class OutVideoMsg extends OutMsg {
	public static final String TEMPLATE =
			"<xml>\n" +
			"<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n" +
			"<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n" +
			"<CreateTime>${__msg.createTime}</CreateTime>\n" +
			"<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n" +
				"<Video>\n" +
					"<MediaId><![CDATA[${__msg.mediaId}]]></MediaId>\n" +
					"<Title><![CDATA[${(__msg.title)!}]]></Title>\n" +
					"<Description><![CDATA[${(__msg.description)!}]]></Description>\n" +
				"</Video>\n" +
			"</xml>";
	
	private String mediaId;
	private String title;		// ���Ǳ���
	private String description;	// ���Ǳ���
	
	public OutVideoMsg() {
		this.msgType = "video";
	}
	
	public OutVideoMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "video";
	}
	
	public String getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
}







