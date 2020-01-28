package br.com.segala.jmsrepeat.repository.prevayler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.segala.jmsrepeat.repository.Person;
import br.com.segala.jmsrepeat.repository.Step;

public class Root implements Serializable {

	/**
	 * java.io.Serializable with a non changing serialVersionUID will automatically
	 * handle backwards compatibility if you add new non transient fields the the
	 * class.
	 */
	private static final long serialVersionUID = 1l;

	private Map<Long, Person> persons = new HashMap<Long, Person>();
	private Map<Integer, Step> steps = new HashMap<Integer, Step>();

	public Map<Long, Person> getPersons() {
		return persons;
	}

	public void setPersons(Map<Long, Person> persons) {
		this.persons = persons;
	}

	public Map<Integer, Step> getSteps() {
		return steps;
	}

	public void setSteps(Map<Integer, Step> steps) {
		this.steps = steps;
	}
	
}