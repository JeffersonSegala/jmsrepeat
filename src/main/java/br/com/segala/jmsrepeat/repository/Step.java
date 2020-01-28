package br.com.segala.jmsrepeat.repository;

import java.awt.MouseInfo;
import java.awt.Point;

import br.com.segala.jmsrepeat.Robo;
import br.com.segala.jmsrepeat.repository.prevayler.Entity;

public class Step extends Entity {

	private static final long serialVersionUID = 1L;

	public static final Robo robo = Robo.getInstance(); 
	
	private Point point;
	private Long time;
	private String text;
	
	public Step(String comand) {
		if ("c".equals(comand)) {
			point = MouseInfo.getPointerInfo().getLocation(); 
		} else if ('w' == comand.charAt(0)) {
			time = Long.valueOf(comand.substring(1));
		} else if ('t' == comand.charAt(0)) {
			text = comand.substring(1);
		}
	}

	public void execute() {
		if (point != null) {
			robo.moveAndClick(point);
			robo.sleep(3000);
		}
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
