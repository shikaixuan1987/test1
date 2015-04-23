package com.beafoodie.usshike.model.msg;

/**
	������Ϣ�������ǽ����ı���Ϣ������
	�����ı���Ϣ
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName> 
		<CreateTime>1348831860</CreateTime>
		<MsgType><![CDATA[text]]></MsgType>
			<Content><![CDATA[this is a test]]></Content>
			<MsgId>1234567890123456</MsgId>
	</xml>
 */
public  class InMsg {
	
	// ������΢�ź�
	protected String toUserName;
	
	// ���ͷ��ʺţ�һ��OpenID��
	protected String fromUserName;
	
	// ��Ϣ����ʱ�� �����ͣ�
	protected Integer createTime;
	
	
	
	/**
	 * ��Ϣ����
	 * 1��text �ı���Ϣ
	 * 2��image ͼƬ��Ϣ
	 * 3��voice ������Ϣ
	 * 4��video ��Ƶ��Ϣ
	 * 5��location ��ַλ����Ϣ
	 * 6��link ������Ϣ
	 * 7��event �¼�
	 */
	
	
	
	public static final String TEXT = "text";
	public static final String IMAGE = "image";
	public static final String LOCATION = "location";
	public static final String LINK = "link";
	public static final String EVENT = "event";
	
	protected String msgType;
	
	public InMsg(){
		
	}
	
	public InMsg(String toUserName, String fromUserName, Integer createTime, String msgType) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
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







