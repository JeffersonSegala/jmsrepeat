package br.com.segala.jmsrepeat.action;

import br.com.segala.jmsrepeat.Robo;

public class ActionPixelInfo implements ActionStrategy {

	@Override
	public void execute() {
		Robo.getInstance().pixelInfo();
	}
	
}
