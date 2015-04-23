package com.beafoodie.usshike.util;


import java.io.InputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.beafoodie.usshike.model.Article;
import com.beafoodie.usshike.model.Reply;
import com.beafoodie.usshike.model.msg.InImageMsg;
import com.beafoodie.usshike.model.msg.InLinkMsg;
import com.beafoodie.usshike.model.msg.InLocationMsg;
import com.beafoodie.usshike.model.msg.InTextMsg;

/**
 * 微信相关工具类
 */
public class WeixinUtil {
	
	
	private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;  
                public void startNode(String name, Class clazz) {  
                    super.startNode(name, clazz);  
                }  
                protected void writeText(QuickWriter writer, String text) {  
                    if (cdata) {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    });  
	
	/**
	 * 将回复消息对象转换成xml字符串
	 * @param reply 回复消息对象
	 * @return 返回符合微信接口的xml字符串
	 */
	public static String replyToXml(Reply reply){
		String type = reply.getMsgType();
		if(Reply.TEXT.equals(type)){
			xstream.omitField(Reply.class, "articles");
			xstream.omitField(Reply.class, "articleCount");
			xstream.omitField(Reply.class, "musicUrl");
			xstream.omitField(Reply.class, "hQMusicUrl");
		}else if(Reply.MUSIC.equals(type)){
			xstream.omitField(Reply.class, "articles");
			xstream.omitField(Reply.class, "articleCount");
			xstream.omitField(Reply.class, "content");
		}else if(Reply.NEWS.equals(type)){
			xstream.omitField(Reply.class, "content");
			xstream.omitField(Reply.class, "musicUrl");
			xstream.omitField(Reply.class, "hQMusicUrl");
		}
		xstream.autodetectAnnotations(true);  
		xstream.alias("xml", reply.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(reply);
	}
	
	
	/**
	 * 存储数据的Map转换为对应的Message对象
	 * @param map 存储数据的map
	 * @return 返回对应Message对象
	 */
	public static InTextMsg mapToTextMessage(Map<String, String> map) {
		if (map == null)
			return null;
		InTextMsg textMessage = new InTextMsg(map.get("FromUserName"),map.get("ToUserName"),Integer.parseInt((map.get("CreateTime"))),map.get("MsgType"));
		textMessage.setContent(map.get("Content"));
		textMessage.setMsgId(map.get("MsgId"));
		return textMessage;
	}

	public static InImageMsg mapToImageMessage(Map<String, String> map) {
		if (map == null)
			return null;
		InImageMsg imageMessage = new InImageMsg(map.get("FromUserName"),map.get("ToUserName"),Integer.parseInt((map.get("CreateTime"))),map.get("MsgType"));
		imageMessage.setPicUrl(map.get("PicUrl"));
		imageMessage.setMsgId(map.get("MsgId"));
		return imageMessage;
	}

	public static InLinkMsg mapToLinkMessage(Map<String, String> map) {
		if (map == null)
			return null;
		InLinkMsg linkMessage = new InLinkMsg(map.get("FromUserName"),map.get("ToUserName"),Integer.parseInt((map.get("CreateTime"))),map.get("MsgType"));
		linkMessage.setTitle(map.get("Title"));
		linkMessage.setDescription(map.get("Description"));
		linkMessage.setUrl(map.get("Url"));
		linkMessage.setMsgId(map.get("MsgId"));
		return linkMessage;
	}

	public static InLocationMsg mapToLocationMessage(Map<String, String> map) {
		if (map == null)
			return null;
		InLocationMsg locationMessage = new InLocationMsg(map.get("FromUserName"),map.get("ToUserName"),Integer.parseInt((map.get("CreateTime"))),map.get("MsgType"));
		locationMessage.setLocation_X(map.get("Location_X"));
		locationMessage.setLocation_Y(map.get("Location_Y"));
		locationMessage.setScale(map.get("Scale"));
		locationMessage.setLabel(map.get("Label"));
		locationMessage.setMsgId(map.get("MsgId"));
		return locationMessage;
	}
	
	
	/**
	 * 解析request中的xml 并将数据存储到一个Map中返回
	 * @param request
	 */
	public static Map<String, String> parseXml(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream inputStream = request.getInputStream();
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			List<Element> elementList = root.elements();
			for (Element e : elementList)
				//遍历xml将数据写入map
				map.put(e.getName(), e.getText());
			inputStream.close();
			inputStream = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	/**
	 * sha1加密算法
	 * @param key需要加密的字符串
	 * @return 加密后的结果
	 */
	public static String sha1(String key) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(key.getBytes());
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
			return key;
		}
	}
	
}
