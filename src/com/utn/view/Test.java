package com.utn.view;
import com.utn.controller.*;

public class Test {

	public static void main(String[] args) {

		TablaController tc = new TablaController();
		tc.crear("juan", "ramirez", 1.6, 70.0);
		tc.crear("Pablo", "Gonzalez", 1.65, 75.0);
		tc.crear("Fernando Albaro", "Gimenez", 1.9, 78.0);
		tc.crear("Geronimo", "Vitalio", 1.3, 80.0);
		tc.crear("Juana", "Fartner", 1.7, 84.0);
		tc.crear("Jesica", "Colesty", 1.5, 83.0);
		tc.crear("Laura", "Heller", 2, 90.0);
		
		tc.actualizar("alberto", "", 15);
		
		tc.borrar(15);
		
		tc.read();
	}

}
