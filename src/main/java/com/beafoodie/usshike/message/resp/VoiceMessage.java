package com.beafoodie.usshike.message.resp;

import com.beafoodie.usshike.model.Voice;

public class VoiceMessage extends BaseMessage {
	// ����
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}

