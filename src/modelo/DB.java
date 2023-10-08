package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.sql.Date;
import java.util.ArrayList;

public class DB {

	private Connection connection;
	private static DB instancia = null;

	private DB() throws SQLException {
		System.out.println("Iniciando programa.");
		// Se carga el driver JDBC-ODBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo cargar el puente JDBC-ODBC.");

			return;
		}
	}

	public void conectar() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
		System.out.println("Conexion Exitosa");
	}
	
	public static DB getDB() throws SQLException {
		if(DB.instancia == null) {
		
			DB.instancia = new DB();
			
		}
		return DB.instancia;
	}

	@SuppressWarnings("deprecation")
	public void agregarPersona(Persona persona) throws SQLException {
		String nombre = persona.getNombre();
		String telefono = persona.getTelefono();
		Date fecha = new Date(persona.getFecNac().getYear(), persona.getFecNac().getMonth(),
				persona.getFecNac().getDate());
		PreparedStatement agregar = this.connection
				.prepareStatement("INSERT INTO personas (nombre,nacimiento,telefono) VALUES (?,?,?)");

		agregar.setString(1, nombre);
		agregar.setDate(2, fecha);
		agregar.setString(3, telefono);
		agregar.executeUpdate();
	}

	@SuppressWarnings("deprecation")
	public Iterator<Persona> listarPersonas() throws SQLException {
		Statement sentencia;
		ArrayList<Persona> listado_personas = new ArrayList<Persona>();

		String nombre, telefono;
		Date fecha;
		sentencia = connection.createStatement();
		ResultSet resultado = sentencia.executeQuery("SELECT * FROM personas ORDER BY nombre");
		while (resultado.next()) {
			nombre = resultado.getString("nombre");
			fecha = new Date(resultado.getDate("nacimiento").getYear(), resultado.getDate("nacimiento").getMonth(),
					resultado.getDate("nacimiento").getDate());
			telefono = resultado.getString("telefono");
			Persona p = new Persona(nombre, telefono, fecha);
			listado_personas.add(p);
		}
		return listado_personas.iterator();
	}

	public void desconectar() throws SQLException {
		this.connection.close();
	}

}
