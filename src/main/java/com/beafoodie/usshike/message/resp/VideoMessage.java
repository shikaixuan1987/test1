package com.beafoodie.usshike.message.resp;

import com.beafoodie.usshike.model.Video;

public class VideoMessage extends BaseMessage {
	// สำฦต
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}