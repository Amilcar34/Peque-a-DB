package com.utn.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IConeccion {

	public static Connection realizaConexion(){
		
		Connection con = null;
		
		//declaro usuario y pass de la DB
		
		final String user = "root";
		final String pass = "";
		
		// generamos la conexion
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/persona", user, pass);
			
			if (con != null) 
				System.out.println("Se realizo la conexion :D");
			else
				System.err.println("la conexion aparece como nula");
		
		}catch (Exception e){
			System.err.println("No se realizo la conexion :c");
			e.getMessage();
			e.printStackTrace();
		}
		
		return con;	
	}
}
