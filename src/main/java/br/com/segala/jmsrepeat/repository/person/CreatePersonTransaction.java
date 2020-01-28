package br.com.segala.jmsrepeat.repository.person;
import java.io.Serializable;
import java.util.Date;

import org.prevayler.TransactionWithQuery;

import br.com.segala.jmsrepeat.repository.Person;
import br.com.segala.jmsrepeat.repository.prevayler.Root;

public class CreatePersonTransaction implements TransactionWithQuery<Root, Person>, Serializable {

  private static final long serialVersionUID = 1l;

  private Long identity;

  public CreatePersonTransaction() {
  }

  public CreatePersonTransaction(Long identity) {
    this.identity = identity;
  }

  public Person executeAndQuery(Root prevalentSystem, Date executionTime) throws Exception {
    Person entity = new Person();
    entity.setIdentity(identity);
    prevalentSystem.getPersons().put(entity.getIdentity(), entity);
    return entity;
  }

  public Long getIdentity() {
    return identity;
  }

  public void setIdentity(Long identity) {
    this.identity = identity;
  }
}