package com.beafoodie.usshike.message.resp;

import com.beafoodie.usshike.model.Music;

public class MusicMessage extends BaseMessage {
	// ����
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
