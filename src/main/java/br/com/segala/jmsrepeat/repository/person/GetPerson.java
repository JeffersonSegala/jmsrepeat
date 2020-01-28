package br.com.segala.jmsrepeat.repository.person;
import java.util.Date;

import org.prevayler.Query;

import br.com.segala.jmsrepeat.repository.Person;
import br.com.segala.jmsrepeat.repository.prevayler.Root;

public class GetPerson implements Query<Root, Person> {

  private static final long serialVersionUID = 3799438221680331803L;
  private String identity;

  public GetPerson(String identity) {
    this.identity = identity;
  }

  public Person query(Root prevalentSystem, Date executionTime) throws Exception {
    return prevalentSystem.getPersons().get(identity);
  }
}