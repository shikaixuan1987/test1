package com.beafoodie.usshike.message.resp;

import com.beafoodie.usshike.model.Image;

public class ImageMessage extends BaseMessage {

	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}