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

	// 接收微信公众号接收的消息，处理后再做相应的回复
	@RequestMapping(value = "/weixin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String replyMessage(HttpServletRequest request) {
		String replyContent = Reply.WELCOME_CONTENT;
		int i = 12345678;
		Reply reply = new Reply();
		String rep = null;
		// 仅处理微信服务端发的请求
		if (!checkWeixinReques(request)) {
			Map<String, String> requestMap = WeixinUtil.parseXml(request);
			if (requestMap.get("MsgType").equals(InMsg.TEXT)) {
				InTextMsg inTextMessage = WeixinUtil
						.mapToTextMessage(requestMap);
				// weixinService.addMessage(textMessage);
				replyContent = "我已经收到了你的文字信息";
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
							"<Content><![CDATA[我已经收到了你的文字信息]]></Content>\n" +
						"</xml>";
				// weixinService.addReply(reply);
			}
			/**else if (requestMap.get("MsgType").equals(InMsg.IMAGE)) {
				InImageMsg inImageMessage = WeixinUtil
						.mapToImageMessage(requestMap);
				// weixinService.addMessage(imageMessage);
				replyContent = "我已经收到了你的图片信息";
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
				replyContent = "我已经收到了你的超文本链接信息";
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
				replyContent = "我已经收到了你的地址信息";
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

	// 微信公众平台验证url是否有效使用的接口
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
	 * 根据token计算signature验证是否为weixin服务端发送的消息
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
