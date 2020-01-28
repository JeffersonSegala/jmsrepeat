package br.com.segala.jmsrepeat;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Coletor implements Runnable {
	
	public static final int COPPER_ORE_1 = 7;
	public static final int TIN_ORE_1 = 8;
	public static final int IRON_ORE_1 = 6;
	public static final int CELK = 9;
	
	private int type;
    private Thread worker;
    private AtomicBoolean running = new AtomicBoolean(false);
    
    public Coletor(int type) {
    	this.type = type;
	}
 
    public void interrupt2() {
        running.set(false);
        getWorker().interrupt();
    }
 
    boolean isRunning() {
        return running.get();
    }
 
    public void run() {
        running.set(true);
        while (running.get()) {
        	coletar();
        }
    }

    private void coletar () {
    	switch (type) {
		case 1:
			System.out.println("tipo 1");
			break;
		case COPPER_ORE_1:
			System.out.println("Coletando coletarCopperOre1");
			coletarCopperOre1();
			break;
		case TIN_ORE_1:
			System.out.println("Coletando coletarTinOre1");
			coletarTinOre1();
			break;
		case IRON_ORE_1:
			System.out.println("Coletando coletarIronOre1");
			coletarIronOre1();
			break;
		case CELK:
			System.out.println("Coletando Celk");
			celk();
			break;

		default:
			System.out.println("coletar oq? " + type);
			break;
		}
	}
    
	public void coletarTinOre1 () {
		moveClickWaitMargin(849, 655, 16000);
		moveClickWaitMargin(1040,306, 16000);

	}
	
	public void coletarCopperOre1 () {
		moveClickWaitMargin(1190, 317, 8000);
		moveClickWaitMargin(1102, 558, 8000);
		moveClickWaitMargin(643 , 575, 8000);
    }
	
	public void coletarIronOre1 () {
		moveClickWaitMargin(1034 , 533, 18000);
		moveClickWaitMargin(1006, 392, 18000);
    }
	
	public void celk () {
		moveClickWait(2044, 311, 1000);
		moveClickWait(2044, 311, 2000);
//		java.awt.Color[r=243,g=245,b=244]
		moveClickWait(1941, 319, 2000);
//		java.awt.Color[r=226,g=180,b=93]
		moveClickWait(1961, 636, 2000);
//		java.awt.Color[r=10,g=138,b=145]
	}
	
	private static int randomInt(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}
	
	private void moveClickWait(int x, int y, long t) {
		Robo.getInstance().mouseMove(x, y);
		Robo.getInstance().mouseClick();
		sleep(t);
	}
	
	private void moveClickWaitMargin(int x, int y, long t) {
		Robo.getInstance().mouseMove(randomInt(x-3, x+3), randomInt(y-3, y+3));
		Robo.getInstance().mouseClick();
		sleep(t);
	}
    
	private void sleep(long mills) {
		try {
		    Thread.sleep(mills);
		} catch (InterruptedException e){
		    Thread.currentThread().interrupt();
		    System.out.println("Thread was interrupted, Failed to complete operation");
		}
	}

	public Thread getWorker() {
		return worker;
	}

	public void setWorker(Thread worker) {
		this.worker = worker;
	}
}