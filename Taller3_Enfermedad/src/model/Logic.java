package model;

import java.util.LinkedList;

import exceptions.ExceptionInfected;
import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private String[] data;
	private LinkedList<Person> healthy;
	private LinkedList<Person> infected;
	private LinkedList<Person> recovered;
	private LinkedList<Count> count;

	public Logic(PApplet app) {
		this.app = app;
		data = app.loadStrings("../data/datos.txt");
		healthy = new LinkedList<Person>();
		infected = new LinkedList<Person>();
		recovered = new LinkedList<Person>();
		count = new LinkedList<Count>();
		readData();

	}

	private void readData() {

		for (int i = 0; i < data.length; i++) {

			String[] splitBySpace = data[i].split(" ");
			String state = splitBySpace[0];
			int amount = Integer.parseInt(splitBySpace[1]);

			if (state.equals("sanas:")) {
				for (int j = 0; j < amount; j++) {
					healthy.add(new Person(false, false, app));
				}
			}

			else if (state.equals("infectadas:")) {
				infected.add(new Person(false, true, app));
			}

			else if (state.equals("recuperadas:")) {
				recovered.add(new Person(true, false, app));
			}

		}
		System.out.println(healthy.size());
		System.out.println(infected.size());
		System.out.println(recovered.size());

	}

	public void addToCountList() {
		count.add(new HealthyCount(app));
		count.add(new InfectedCount(app));
		count.add(new RecoveredCount(app));
	}

	public void drawAll() {

		for (int i = 0; i < healthy.size(); i++) {
			healthy.get(i).drawPerson();
			Thread pintar = new Thread(healthy.get(i));
			pintar.start();
		}
		for (int i = 0; i < infected.size(); i++) {
			infected.get(i).drawPerson();
			Thread pintar = new Thread(infected.get(i));
			pintar.start();
		}
		for (int i = 0; i < recovered.size(); i++) {
			infected.get(i).drawPerson();
			Thread pintar = new Thread(recovered.get(i));
			pintar.start();
		}
		
		
		try {
			changeState();
		} catch (ExceptionInfected e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void changeState() throws ExceptionInfected {
		int num = (int) (app.random(100));

		for (int i = 0; i < infected.size(); i++) {
			for (int j = 0; j < healthy.size(); j++) {
				int X0 = infected.get(i).getPosX();
				int Y0 = infected.get(i).getPosY();
				int X1 = healthy.get(j).getPosX();
				int Y1 = healthy.get(j).getPosY();

				int size = healthy.get(j).getSize();

				if (PApplet.dist(X0, Y0, X1, Y1) < size && num<=90) {
					infected.add(new Person(false, true, healthy.get(j).getPosX(), healthy.get(j).getPosY(), app)); 
					healthy.remove(healthy.get(j));
					throw new ExceptionInfected("Contagiado");
				}
			}
		}

	}
	
	

}