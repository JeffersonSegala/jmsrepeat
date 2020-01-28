package br.com.segala.jmsrepeat.repository.prevayler;

import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;

public class PrevaylerManager {
	
	public static final String REPOSITPRY_PATH = "C:\\Java\\Prevayler";
	public static Prevayler<Root> prevayler;
	
	public static void init() throws Exception {
		prevayler = PrevaylerFactory.createPrevayler(new Root(), PrevaylerManager.REPOSITPRY_PATH);
//	      final Person person = prevayler.execute(new CreatePersonTransaction("002"));
//	      Person queryResponse = prevayler.execute(new GetPerson("001"));
//	      Person queryResponse2 = prevayler.execute(new GetPerson("002"));
//	      prevayler.execute(new UpdatePersonNameTransaction("001", "Rodolfo"));
//	      prevayler.execute(new UpdatePersonNameTransaction("002", "Rodolfo 4"));
		
	}
	
}
