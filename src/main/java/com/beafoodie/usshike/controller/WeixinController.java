package com.beafoodie.usshike.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beafoodie.usshike.model.Message;
import com.beafoodie.usshike.model.Reply;
import com.beafoodie.usshike.model.msg.InImageMsg;
import com.beafoodie.usshike.model.msg.InLinkMsg;
import com.beafoodie.usshike.model.msg.InLocationMsg;
import com.beafoodie.usshike.model.msg.InMsg;
import com.beafoodie.usshike.model.msg.InTextMsg;
import com.beafoodie.usshike.util.WeixinUtil;

@Controller()
public class WeixinController {

	private static final String TOKEN = "beafoodie";

	public static int pagesize = 10;


	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String test(HttpServletRequest request) {
		return "Test";
	}

	// ����΢�Ź��ںŽ��յ���Ϣ�������������Ӧ�Ļظ�
	@RequestMapping(value = "/weixin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String replyMessage(HttpServletRequest request) {
		String replyContent = Reply.WELCOME_CONTENT;
		int i = 12345678;
		Reply reply = new Reply();
		String rep = null;
		// ������΢�ŷ���˷�������
		if (!checkWeixinReques(request)) {
			Map<String, String> requestMap = WeixinUtil.parseXml(request);
			if (requestMap.get("MsgType").equals(InMsg.TEXT)) {
				InTextMsg inTextMessage = WeixinUtil
						.mapToTextMessage(requestMap);
				// weixinService.addMessage(textMessage);
				replyContent = "���Ѿ��յ������������Ϣ";
				reply.setToUserName(inTextMessage.getFromUserName());
				reply.setFromUserName(inTextMessage.getToUserName());
				reply.setContent(replyContent);
				reply.setMsgType(Reply.TEXT);
				reply.setContent(replyContent);
				reply.setCreateTime(1233322);
				rep =   "<xml>\n" +
						"<ToUserName><![CDATA["+inTextMessage.getFromUserName()+"]]></ToUserName>\n" +
						"<FromUserName><![CDATA["+inTextMessage.getToUserName()+"]]></FromUserName>\n" +
						"<CreateTime>"+i+"</CreateTime>\n" +
						"<MsgType><![CDATA[text]]></MsgType>\n" +
							"<Content><![CDATA[���Ѿ��յ������������Ϣ]]></Content>\n" +
						"</xml>";
				// weixinService.addReply(reply);
			}
			/**else if (requestMap.get("MsgType").equals(InMsg.IMAGE)) {
				InImageMsg inImageMessage = WeixinUtil
						.mapToImageMessage(requestMap);
				// weixinService.addMessage(imageMessage);
				replyContent = "���Ѿ��յ������ͼƬ��Ϣ";
				reply.setToUserName(inImageMessage.getFromUserName());
				reply.setFromUserName(inImageMessage.getToUserName());
				reply.setContent(replyContent);
				reply.setMsgType(Reply.TEXT);
				reply.setContent(replyContent);
				reply.setCreateTime(1233322);
				// weixinService.addReply(reply);
			} else if (requestMap.get("MsgType").equals(InMsg.LINK)) {
				InLinkMsg inLinkMessage = WeixinUtil
						.mapToLinkMessage(requestMap);
				// weixinService.addMessage(linkMessage);
				replyContent = "���Ѿ��յ�����ĳ��ı�������Ϣ";
				reply.setToUserName(inLinkMessage.getFromUserName());
				reply.setFromUserName(inLinkMessage.getToUserName());
				reply.setContent(replyContent);
				reply.setMsgType(Reply.TEXT);
				reply.setContent(replyContent);
				reply.setCreateTime(1233322);
				// weixinService.addReply(reply);
			} else if (requestMap.get("MsgType").equals(InMsg.LOCATION)) {
				InLocationMsg inLocationMessage = WeixinUtil
						.mapToLocationMessage(requestMap);
				// weixinService.addMessage(locationMessage);
				replyContent = "���Ѿ��յ�����ĵ�ַ��Ϣ";
				reply.setToUserName(inLocationMessage.getFromUserName());
				reply.setFromUserName(inLocationMessage.getToUserName());
				reply.setContent(replyContent);
				reply.setMsgType(Reply.TEXT);
				reply.setContent(replyContent);
				reply.setCreateTime(1233322);
				// weixinService.addReply(reply);
			}**/
			String back = WeixinUtil.replyToXml(reply);
			return rep;
		} else {
			return "error";
		}
	}

	// ΢�Ź���ƽ̨��֤url�Ƿ���Чʹ�õĽӿ�
	@RequestMapping(value = "/weixin", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String initWeixinURL(HttpServletRequest request) {
		String echostr = request.getParameter("echostr");
		if (checkWeixinReques(request) && echostr != null) {
			return echostr;
		} else {
			return "error";
		}
	}

	/**
	 * ����token����signature��֤�Ƿ�Ϊweixin����˷��͵���Ϣ
	 */
	private static boolean checkWeixinReques(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		if (signature != null && timestamp != null && nonce != null) {
			String[] strSet = new String[] { TOKEN, timestamp, nonce };
			java.util.Arrays.sort(strSet);
			String key = "";
			for (String string : strSet) {
				key = key + string;
			}
			String pwd = WeixinUtil.sha1(key);
			return pwd.equals(signature);
		} else {
			return false;
		}
	}


}
