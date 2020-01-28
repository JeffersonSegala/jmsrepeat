package br.com.segala.jmsrepeat.repository.prevayler;

import java.io.Serializable;

public class Entity implements Serializable {

	/**
    * java.io.Serializable with a non changing serialVersionUID
    * will automatically handle backwards compatibility
    * if you add new non transient fields the the class.
    */
	private static final long serialVersionUID = 1l;

	private Long identity;

	public Long getIdentity() {
		return identity;
	}

	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Entity entity = (Entity) o;

		if (identity != null ? !identity.equals(entity.identity) : entity.identity != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return identity != null ? identity.hashCode() : 0;
	}
}