package model;

import processing.core.PApplet;

public class InfectedCount extends Count{

	public InfectedCount(PApplet app) {
		
		super(app);

		}
		
		public void drawCount(int count, int posY){
			
			app.fill(255,0,0);
			app.text("Infectadas: " + count, 600 , posY);
			
		}


}
