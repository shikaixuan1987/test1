package com.beafoodie.usshike.model.msg;

import com.beafoodie.usshike.model.msg.InMsg;;

/**
	ɨ���������ά���¼�
	1. �û�δ��עʱ�����й�ע����¼�����
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[subscribe]]></Event>
			<EventKey><![CDATA[qrscene_123123]]></EventKey>
			<Ticket><![CDATA[TICKET]]></Ticket>
	</xml>
	
	2. �û��ѹ�עʱ���¼�����
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[SCAN]]></Event>
			<EventKey><![CDATA[SCENE_VALUE]]></EventKey>
			<Ticket><![CDATA[TICKET]]></Ticket>
	</xml>
 */
public class InQrCodeEvent extends InMsg {
	
	// 1. �û�δ��עʱ�����й�ע����¼����ͣ� subscribe
	// 2. �û��ѹ�עʱ���¼����ͣ� SCAN
	private String event;
	
	// 1. �û�δ��עʱ�����й�ע����¼����ͣ� qrscene_123123
	// 2. �û��ѹ�עʱ���¼����ͣ� SCENE_VALUE
	private String eventKey;
	private String ticket;
	
	public InQrCodeEvent(String toUserName, String fromUserName, Integer createTime, String msgType) {
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
	
	public String getTicket() {
		return ticket;
	}
	
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}




