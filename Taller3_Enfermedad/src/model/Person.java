package model;

import processing.core.PApplet;

public class Person implements Runnable{
	

	PApplet app;
	private boolean infected, recovered;
	private int posX, posY, size, speed, dirX, dirY;

	public Person (boolean recovered, boolean infected, PApplet app) {
		this.app = app;
		this.recovered = recovered;
		this.infected = infected;
		posX = (int) (app.random(100, 700));
		posY = (int) (app.random(80, 500));
		dirX = (int) app.random(-2, 2);
		dirY = (int) app.random(-2, 2);
		speed=1;
		this.size=10;
	}
	
	public Person (boolean recovered, boolean infected, int posX, int posY, PApplet app) {
		this.app = app;
		this.recovered = recovered;
		this.infected = infected;
		this.posX = posX;
		this.posY = posY;
		dirX = (int) app.random(-2, 2);
		dirY = (int) app.random(-2, 2);
		speed=1;
		this.size=10;
	}
	
	/**
	 * 
	 */
	public void move () {
		if (dirX==0) {
			dirX = (int) app.random(-2, 2);
		}
		if (dirY==0) {
			dirY = (int) app.random(-2, 2);
		}
		posX = (posX+ (speed*dirX));
		
		posY= (posY+ (speed*dirY));	
		
		
		if (posX >= 710 | posX <= 90) {
			dirX =(dirX * (-1));
		}

		if (posY >= 510|| posY <= (70)) {
			dirY =(dirY * (-1));
		}
	}
	
	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void drawPerson() {
		
		 if(!recovered && !infected){
			app.noStroke();
			app.fill(0,255,0);
			app.ellipse(posX, posY, size, size);
			
		} else if(infected) {

		app.fill(255,0,0);
		app.ellipse(posX, posY, size, size);
		
		}else if (recovered) {
			
			app.fill(0,0,255);
			app.ellipse(posX, posY, size, size);			
		}
		 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		move();
		if(infected) {

			try {
			
			Thread.sleep(14000);
			infected=false;
			recovered = true;
			
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
