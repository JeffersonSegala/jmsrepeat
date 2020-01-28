package br.com.segala.jmsrepeat.listner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import br.com.segala.jmsrepeat.action.ActionEnum;
import br.com.segala.jmsrepeat.action.ActionStrategy;

public class MyHotkeyListner implements HotkeyListener {

	private Map<Integer, ? extends ActionStrategy> actions; 
	
	@SuppressWarnings("serial")
	public MyHotkeyListner () {
		
		for (ActionEnum actionEnum : Arrays.asList(ActionEnum.values())) {
			JIntellitype.getInstance().registerHotKey(actionEnum.getIdentifier(), actionEnum.getHotkey());	
		}

		this.actions = new HashMap<Integer, ActionStrategy>() {{
			for (ActionEnum actionEnum : Arrays.asList(ActionEnum.values())) {
				put(actionEnum.getIdentifier(), actionEnum.getAction());
			}
		}};
	}
	
	public void onHotKey(int aIdentifier) {
		System.out.println("Hotkey: " + aIdentifier);
		
		ActionStrategy action = actions.get(Integer.valueOf(aIdentifier));
		if (action == null) {
			System.out.println("Unexpected hotkey: " + aIdentifier);	
			return;
		}
		
		action.execute();
	}
	
}
