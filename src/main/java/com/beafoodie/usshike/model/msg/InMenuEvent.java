package com.beafoodie.usshike.model.msg;

import com.beafoodie.usshike.model.msg.InMsg;

/**
	�Զ���˵��¼�
	1�� ����˵���ȡ��Ϣʱ���¼�����
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[CLICK]]></Event>
			<EventKey><![CDATA[EVENTKEY]]></EventKey>
	</xml>
	
	2�� ����˵���ת����ʱ���¼�����
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[VIEW]]></Event>
			<EventKey><![CDATA[www.qq.com]]></EventKey>
	</xml>
 */
public class InMenuEvent extends InMsg {
	private String event;
	private String eventKey;
	
	public InMenuEvent(String toUserName, String fromUserName, Integer createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public String getEventKey() {
		return eventKey;
	}
	
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}



