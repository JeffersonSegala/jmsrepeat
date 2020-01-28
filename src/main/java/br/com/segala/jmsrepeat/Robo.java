package br.com.segala.jmsrepeat;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Robo {

	private static final Robo instance = new Robo();

	private Robot robot;

	private Robo() {
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static Robo getInstance() {
		return instance;
	}

	public void pixelInfo() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		System.out.println(p);
		System.out.println(robot.getPixelColor((int) p.getX(), (int) p.getY()));
	}
	
	public void mouseMove(int x, int y) {
		robot.mouseMove(x, y);	
	}
	
	public void mouseClick () {
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);     
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void mouseMove(Point point) {
		robot.mouseMove((int) point.getX(), (int) point.getY());	
	}

	public void moveAndClick(Point point) {
		mouseMove(point);
		mouseClick();
	}
	
	public void sleep(long mills) {
		try {
		    Thread.sleep(mills);
		} catch (InterruptedException e){
		    Thread.currentThread().interrupt();
		    System.out.println("Thread was interrupted, Failed to complete operation");
		}
	}
}
