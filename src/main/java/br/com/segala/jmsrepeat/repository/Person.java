package br.com.segala.jmsrepeat.repository;

import br.com.segala.jmsrepeat.repository.prevayler.Entity;

public class Person extends Entity {

	private static final long serialVersionUID = 1l;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}