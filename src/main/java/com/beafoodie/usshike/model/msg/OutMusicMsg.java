package com.beafoodie.usshike.model.msg;

import com.beafoodie.usshike.model.msg.InMsg;

/**
	�ظ�������Ϣ
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[music]]></MsgType>
			<Music>
				<Title><![CDATA[TITLE]]></Title>
				<Description><![CDATA[DESCRIPTION]]></Description>
				<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
				<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
				<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
			</Music>
	</xml>
*/
public class OutMusicMsg extends OutMsg {
	
	public static final String TEMPLATE =
		"<xml>\n" +
			"<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n" +
			"<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n" +
			"<CreateTime>${__msg.createTime}</CreateTime>\n" +
			"<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n" +
				"<Music>\n" +
					"<Title><![CDATA[${(__msg.title)!}]]></Title>\n" +
					"<Description><![CDATA[${(__msg.description)!}]]></Description>\n" +
					"<MusicUrl><![CDATA[${(__msg.musicUrl)!}]]></MusicUrl>\n" +
					"<HQMusicUrl><![CDATA[${(__msg.hqMusicUrl)!}]]></HQMusicUrl>\n" +
					// ��˾���ĵ������޴˱��: "<ThumbMediaId><![CDATA[${__msg.thumbMediaId}]]></ThumbMediaId>\n" +
					"<FuncFlag>${__msg.funcFlag}</FuncFlag>\n" +
				"</Music>\n" +
		"</xml>";
			
	private String title;		// ���Ǳ���
	private String description;	// ���Ǳ���
	private String musicUrl;	// ���Ǳ���
	private String hqMusicUrl;	// ���Ǳ���
	// private String thumbMediaId;	// �ٷ��ĵ������޴�����
	private String funcFlag = "0";
	
	public OutMusicMsg() {
		this.msgType = "music";
	}
	
	public OutMusicMsg(InMsg inMsg) {
		super(inMsg);
		this.msgType = "music";
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
	
	public String getMusicUrl() {
		return musicUrl;
	}
	
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	
	public String getFuncFlag() {
		return funcFlag;
	}
	
	// ����Ϊ�Ǳ�
	public void setFuncFlag(boolean funcFlag) {
		this.funcFlag = funcFlag ? "1" : "0";
	}
	
	/* �ٷ��ĵ������޴�����
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}*/
}






