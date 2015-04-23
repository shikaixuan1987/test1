
package com.beafoodie.usshike.model.msg;

import com.beafoodie.usshike.model.msg.InMsg;

/**
	���� ��ע/ȡ����ע�¼�
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[subscribe]]></Event>
	</xml>
*/

/**
	��עʵ�����ݽ���� �ȹٷ��ĵ����һ�� EventKey ���
	<xml>
		<ToUserName><![CDATA[gh_e21b62f685f4]]></ToUserName>
		<FromUserName><![CDATA[o5Ljujn78A_S0uk_WvAM_fKFEXm4]]></FromUserName>
		<CreateTime>1411785252</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[subscribe]]></Event>
			<EventKey><![CDATA[]]></EventKey>
	</xml>
	ȡ����עʵ�����ݽ�����ȹٷ��ĵ����һ�� EventKey ���
	<xml>
		<ToUserName><![CDATA[gh_e21b62f685f4]]></ToUserName>
		<FromUserName><![CDATA[o5Ljujn78A_S0uk_WvAM_fKFEXm4]]></FromUserName>
		<CreateTime>1411785559</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[unsubscribe]]></Event>
			<EventKey><![CDATA[]]></EventKey>
	</xml>
*/
public class InFollowEvent extends InMsg {
	
	// ���ģ�subscribe
	// ȡ�����ģ�unsubscribe
	private String event;
	
	public InFollowEvent(String toUserName, String fromUserName, Integer createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
}






