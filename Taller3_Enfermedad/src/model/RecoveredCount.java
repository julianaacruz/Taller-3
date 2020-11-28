package model;

import processing.core.PApplet;

public class RecoveredCount extends Count{

	public RecoveredCount(PApplet app) {
		
		super(app);

		}
		
		public void drawCount(int count, int posY){
			
			app.fill(0,0,255);
			app.text("Recuperadas: " + count, 600 , posY);
			
		}


}
