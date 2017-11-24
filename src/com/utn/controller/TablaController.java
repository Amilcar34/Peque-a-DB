package com.utn.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utn.dao.IAcciones;
import com.utn.dao.IConeccion;
import com.utn.entities.Persona;

public class TablaController implements IAcciones {

	@Override
	public List<Persona> read() {

		List<Persona> listaDePersonas = new ArrayList<Persona>();

		int id = 0;	double altura, peso = 0;	String apellido, nombre = null;

		Connection con = IConeccion.realizaConexion();

		try {

			if (con != null) {

				Statement st = con.createStatement();
				String sql = "SELECT * FROM personas";
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					id = rs.getInt("id");
					altura = rs.getDouble("altura");
					apellido = rs.getString("apellido");
					peso = rs.getDouble("peso");
					nombre = rs.getString("nombre");
					listaDePersonas.add(new Persona(nombre, apellido, id, altura, peso));
				}

				for (Persona p : listaDePersonas) {
					System.out.print(p.getId() + "  ");
					System.out.print(p.getNombre() + "  ");
					System.out.print(p.getApellido() + "  ");
					System.out.print(p.getAltura() + "  ");
					System.out.print(p.getPeso() + "  ");
					System.out.println();
				}

			} else {
				System.err.println("Error al intentar msotrar las personas");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDePersonas;

	}

	@Override
	public boolean actualizar(String nombre, String apellido, int id) {

		boolean a = false;

		Connection con = IConeccion.realizaConexion();
		try {
			if (con != null) {
				String sql = "UPDATE personas SET nombre=?, apellido=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setInt(3, id);
				ps.execute();
				ps.close();
				a = true;
				System.out.println("se actualizo el registro");
			} else
				System.err.println("No se conecto a la DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public boolean borrar(int id) {

		boolean b = false;

		try {
			Connection con = IConeccion.realizaConexion();

			if (con != null) {
				String sql = "DELETE FROM personas WHERE id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				ps.close();
				b = true;
				System.out.println("Se borro el registro");
			} else
				System.err.println("No se borro el registro");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean crear(String nombre, String apellido, double altura, double peso) {

		boolean c = false;

		Connection con = IConeccion.realizaConexion();
		try {
			if (con != null) {
				String sql = "INSERT INTO personas (nombre, apellido, altura, peso) VALUES(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setDouble(3, altura);
				ps.setDouble(4, peso);
				ps.execute();
				ps.close();
				System.out.println("Se cargo el la tabla la persona");
			} else
				System.err.println("No se logro conectar a la DB");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
}
