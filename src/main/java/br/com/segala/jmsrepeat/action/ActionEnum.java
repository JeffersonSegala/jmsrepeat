package br.com.segala.jmsrepeat.action;

public enum ActionEnum {

	PIXEL_INFO(1, "ALT+SHIFT+i", new ActionPixelInfo()),
	RECORD(2, "ALT+SHIFT+r", new ActionRecord()),
	EXECUTE(3, "ALT+SHIFT+e", new ActionExecute()),
	EXIT(0, "ALT+SHIFT+q", new ActionExit());
	
	private int identifier;
	private String hotkey;
	private ActionStrategy action;
	
	private ActionEnum(int identifier, String hotkey, ActionStrategy action) {
		this.identifier = identifier;
		this.hotkey = hotkey;
		this.action = action;
	}

	public int getIdentifier() {
		return identifier;
	}
	
	public String getHotkey() {
		return hotkey;
	}
	
	public ActionStrategy getAction() {
		return action;
	}

}
