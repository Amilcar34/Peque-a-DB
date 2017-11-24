package com.utn.dao;
import java.util.List;

import com.utn.entities.Persona;

public interface IAcciones extends IConeccion {


	List<Persona> read();
	
	boolean actualizar(String nombre, String apellido, int id);
	
	boolean borrar(int id);
	
	boolean crear(String nombre, String apellido, double altura, double peso);
}
