package br.com.segala.jmsrepeat.action;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.segala.jmsrepeat.step.Step;

public class ActionRecord implements ActionStrategy {

	@Override
	public void execute() {
		ActionExecute.steps = new ArrayList<Step>();
		String comand = "";
		Scanner s = new Scanner(System.in);
		while (!comand.equals("q")) {
			comand = s.nextLine();
			System.out.println("Commando: " + comand);
			if ( !comand.equals("q") ) {
				ActionExecute.steps.add(new Step(comand));
			}
		}
		s.close();
	}
	
}
