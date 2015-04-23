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
 * ΢����ع�����
 */
public class WeixinUtil {
	
	
	private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // ������xml�ڵ��ת��������CDATA���  
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
	 * ���ظ���Ϣ����ת����xml�ַ���
	 * @param reply �ظ���Ϣ����
	 * @return ���ط���΢�Žӿڵ�xml�ַ���
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
	 * �洢���ݵ�Mapת��Ϊ��Ӧ��Message����
	 * @param map �洢���ݵ�map
	 * @return ���ض�ӦMessage����
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
	 * ����request�е�xml �������ݴ洢��һ��Map�з���
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
				//����xml������д��map
				map.put(e.getName(), e.getText());
			inputStream.close();
			inputStream = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	/**
	 * sha1�����㷨
	 * @param key��Ҫ���ܵ��ַ���
	 * @return ���ܺ�Ľ��
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
