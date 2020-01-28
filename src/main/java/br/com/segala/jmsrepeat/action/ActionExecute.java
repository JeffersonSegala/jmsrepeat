package br.com.segala.jmsrepeat.action;

import java.util.List;

import br.com.segala.jmsrepeat.step.Step;

public class ActionExecute implements ActionStrategy {

	public static List<Step> steps;
	
	@Override
	public void execute() {
		for (Step step : steps) {
			step.execute();
		}
	}
	
}
