package com.beafoodie.usshike.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Reply implements Serializable {

	public static final String TEXT = "text";
	public static final String MUSIC = "music";
	public static final String NEWS = "news";
	
	public static final String ERROR_CONTENT = "ERROR TO SEARCH";
	public static final String WELCOME_CONTENT = "WELCOME";
	
    private String ToUserName;  
    private String FromUserName;  
    private int CreateTime;  
    private String MsgType;  
    private String Content;
   // private String MusicUrl;
   // private String HQMusicUrl;
   // private int ArticleCount; 
   // private List<Article> Articles;

	public static void main(String[] args) {
		System.out.println("http://mmsns.qpic.cn/mmsns/UKMLIAeREF9IyZGhfvF8f0CAKDzEvXwCibLKUM4kmsfGnZvFM7EJlrg/0".length());
	}
	

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String ToUserName) {
		this.ToUserName = ToUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String FromUserName) {
		this.FromUserName = FromUserName;
	}

	public int getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(int CreateTime) {
		this.CreateTime = CreateTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String MsgType) {
		this.MsgType = MsgType;
	}


	public String getContent() {
		return Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}
/**
	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String MusicUrl) {
		this.MusicUrl = MusicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String HQMusicUrl) {
		this.HQMusicUrl = HQMusicUrl;
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int ArticleCount) {
		this.ArticleCount = ArticleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> Articles) {
		this.Articles = Articles;
	}

    
	**/
	
}
