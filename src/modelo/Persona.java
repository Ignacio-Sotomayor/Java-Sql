package modelo;

import java.sql.Date;

public class Persona {

	private String nombre;
	private String telefono;
	private Date fecNac;
	
	
	public Persona(String nombre, String telefono, Date fecNac) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.fecNac = fecNac;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public Date getFecNac() {
		return fecNac;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	@Override
	public String toString() {
		return nombre + "          " + fecNac + "          " + telefono;
	}
	
	
	
	
	
}
