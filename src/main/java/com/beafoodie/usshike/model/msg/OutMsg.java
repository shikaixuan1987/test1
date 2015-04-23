package com.beafoodie.usshike.model.msg;

import com.beafoodie.usshike.model.msg.InMsg;

/**
	�ظ��ı���Ϣ
	<xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[fromUser]]></FromUserName>
	<CreateTime>12345678</CreateTime>
	<MsgType><![CDATA[text]]></MsgType>
	<Content><![CDATA[���]]></Content>
	</xml>

 */
public abstract class OutMsg {
	
	// ���շ��ʺţ��յ���OpenID��
	protected String toUserName;
	
	// ������΢�ź�
	protected String fromUserName;
	
	// ��Ϣ����ʱ�� �����ͣ�
	protected Integer createTime;
	
	/**
	 * ������Ӧ��Ϣ����
	 * 1��text �ı���Ϣ
	 * 2��image ͼƬ��Ϣ
	 * 3��voice ������Ϣ
	 * 4��video ��Ƶ��Ϣ
	 * 5��music ������Ϣ
	 * 6��news ͼ����Ϣ
	 */
	public static final String TEXT = "text";
	public static final String IMAGE = "image";
	public static final String LOCATION = "location";
	public static final String LINK = "link";
	public static final String EVENT = "event";
	
	protected String msgType;
	
	/**
	 * �ý��յ�����Ϣ��ʼ��Ҫ����ȥ����Ϣ���ؼ��������� toUserName �� fromUserName �෴
	 */
	public OutMsg(InMsg inMsg) {
		this.toUserName = inMsg.getFromUserName();
		this.fromUserName = inMsg.getToUserName();
		this.createTime = now();
	}
	
	public OutMsg() {
		
	}
	
	public Integer now() {
		return (int)(System.currentTimeMillis() / 1000);
	}
	
	public String getToUserName() {
		return toUserName;
	}
	
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	public String getFromUserName() {
		return fromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	public Integer getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	public String getMsgType() {
		return msgType;
	}
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
