package models;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		String[] array = new String[1];
		ArrayList<Persona> gente = new ArrayList<Persona>();
		for (int i = gente.size(); i < gente.size() + 1; i++) {
			array[0] = "per" + (i + 1);
			System.out.println(array[0]);
			Persona arr = new Persona("Dan", "ape", "dni", 1234);
		}
	}

}
