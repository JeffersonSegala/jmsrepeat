package br.com.segala.jmsrepeat.listner;

import com.melloware.jintellitype.IntellitypeListener;
import com.melloware.jintellitype.JIntellitype;

public class MyIntellitypeListener implements IntellitypeListener {

	public void onIntellitype(int aCommand) {
		switch (aCommand) {
		case JIntellitype.APPCOMMAND_MEDIA_PLAY_PAUSE:
			System.out.println("Play/Pause message received " + Integer.toString(aCommand));
			break;
		default:
			System.out.println("Undefined INTELLITYPE message caught " + Integer.toString(aCommand));
			break;
		}
	}

}
