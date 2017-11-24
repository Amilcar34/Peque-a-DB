package com.utn.entities;

public class Persona {

	private int id;
	private String nombre;
	private String apellido;
	private double altura;
	private double peso;
	
	
	
	public Persona(String nombre, String apellido, int id, double altura, double peso) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.altura = altura;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getId() {
		return id;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}
	
	
}
