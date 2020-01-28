package br.com.segala.jmsrepeat.action;

import com.melloware.jintellitype.JIntellitype;

public class ActionExit implements ActionStrategy {

	@Override
	public void execute() {
		System.out.println("CleanUp and exit...");
		JIntellitype.getInstance().cleanUp();
		System.exit(0);
	}
	
}
