package br.com.segala.jmsrepeat;

import com.melloware.jintellitype.JIntellitype;

import br.com.segala.jmsrepeat.listner.MyHotkeyListner;
import br.com.segala.jmsrepeat.listner.MyIntellitypeListener;
import br.com.segala.jmsrepeat.repository.prevayler.PrevaylerManager;

public class Main {

	public static void main(String[] args) throws Exception {
		initializeHotkeys();
		initializeRepository();
	}

	private static void initializeHotkeys() {
		JIntellitype.getInstance().addHotKeyListener(new MyHotkeyListner());
		JIntellitype.getInstance().addIntellitypeListener(new MyIntellitypeListener());
	}
	
	private static void initializeRepository() throws Exception {
		PrevaylerManager.init();
	}

}
