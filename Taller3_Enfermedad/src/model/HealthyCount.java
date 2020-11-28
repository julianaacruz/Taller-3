package model;

import processing.core.PApplet;

public class HealthyCount extends Count{

	public HealthyCount(PApplet app) {
		
		super(app);

		}
		
		public void drawCount(int count, int posY){
			
			app.fill(0,255,0);
			app.text("Sanas: " + count, 600 , posY);
			
		}


}
