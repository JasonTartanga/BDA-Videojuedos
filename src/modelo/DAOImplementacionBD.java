package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clase.Juego;

public class DAOImplementacionBD implements DAO {

	private Connection con = null;
	private PreparedStatement stmt;

	// Sentencias SQL
	// INSERTS
	final private String AÑADIR_JUEGO = "INSERT INTO juegos (nombre, jugabilidad, diseño, rejugabilidad, mundo, graficos, historia, banda_sonora, media) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// UPDATES
	final private String MODIFICAR_JUEGO = "UPDATE juegos SET nombre = ?, jugabilidad = ?, diseño = ?, rejugabilidad = ?, mundo = ?, graficos = ?, historia = ?, banda_sonora = ?, media = ? WHERE nombre = ?";

	// DELETES
	final private String ELIMINAR_JUEGO = "DELETE FROM juegos WHERE id = ?";

	// SELECTS
	final private String LISTAR_JUEGOS = "SELECT * FROM juegos";
	final private String BUSCAR_JUEGOS = "SELECT * FROM juegos WHERE nombre like ? ";
	final private String MOSTRAR_JUEGO = "SELECT * FROM juegos WHERE nombre = ?";

	final private String ORDENAR_JUEGOS = "SELECT * FROM juegos ORDER BY ? ?";
	final private String ORDENAR_JUEGOS_CONDICION = "SELECT * FROM juegos WHERE ? ? ? ORDER BY ? ?";

	public void abrirConexion() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/VIDEOJUEGOS?serverTimezone=Europe/Madrid&useSSL=false", "root",
					"abcd*1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement setJuego(PreparedStatement stmt, Juego j) {
		try {
			stmt.setString(1, j.getNombre());
			stmt.setFloat(2, j.getJugabilidad());
			stmt.setFloat(3, j.getDiseño());
			stmt.setFloat(4, j.getRejugabilidad());
			stmt.setFloat(5, j.getMundo());
			stmt.setFloat(6, j.getGraficos());
			stmt.setFloat(7, j.getHistoria());
			stmt.setFloat(8, j.getBanda_sonora());
			stmt.setFloat(9, j.getMedia());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public Juego getJuego(ResultSet rs, Juego j) {
		try {
			j.setId(rs.getInt("id"));
			j.setNombre(rs.getString("nombre"));
			j.setJugabilidad(rs.getFloat("jugabilidad"));
			j.setDiseño(rs.getFloat("diseño"));
			j.setRejugabilidad(rs.getFloat("rejugabilidad"));
			j.setMundo(rs.getFloat("mundo"));
			j.setGraficos(rs.getFloat("graficos"));
			j.setHistoria(rs.getFloat("historia"));
			j.setBanda_sonora(rs.getFloat("banda_sonora"));
			j.setMedia(rs.getFloat("media"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return j;
	}

	@Override
	public void añadir(Juego j) {
		this.abrirConexion();

		try {
			stmt = con.prepareStatement(AÑADIR_JUEGO);
			stmt = this.setJuego(stmt, j);

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarConexion();
	}

	@Override
	public List<Juego> listarJuegos() {
		List<Juego> juegos = new ArrayList<>();

		this.abrirConexion();

		try {
			stmt = con.prepareStatement(LISTAR_JUEGOS);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Juego j = new Juego();
				j.setNombre(rs.getString("nombre"));
				juegos.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return juegos;
	}
	
	@Override
	public List<Juego> mostrarTodosJuegos() {
		List<Juego> juegos = new ArrayList<>();

		this.abrirConexion();

		try {
			stmt = con.prepareStatement(LISTAR_JUEGOS);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Juego j = new Juego();
				j = getJuego(rs, j);
				juegos.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return juegos;
	}


	@Override
	public List<Juego> BuscarJuegos(String busqueda) {
		List<Juego> juegos = new ArrayList<>();

		this.abrirConexion();

		try {
			stmt = con.prepareStatement(BUSCAR_JUEGOS);
			stmt.setString(1, "%" + busqueda + "%");

			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Juego j = new Juego();
				j.setNombre(rs.getString("nombre"));
				juegos.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return juegos;
	}

	@Override
	public void modificarJuego(Juego j) {
		this.abrirConexion();

		try {
			stmt = con.prepareStatement(MODIFICAR_JUEGO);
			stmt = setJuego(stmt, j);
			stmt.setString(10, j.getNombre());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrarConexion();
	}

	@Override
	public Juego mostrarJuego(String nombre) {
		Juego j = new Juego();
		this.abrirConexion();

		try {
			stmt = con.prepareStatement(MOSTRAR_JUEGO);
			stmt.setString(1, nombre);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				j = getJuego(rs, j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return j;
	}

	@Override
	public void eliminarJuego(int id) {
		this.abrirConexion();

		try {
			stmt = con.prepareStatement(ELIMINAR_JUEGO);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
	}

	@Override
	public List<Juego> ordenar(String criterio, String condicion, String operador, String orden) {
		List<Juego> juegos = new ArrayList<>();
		this.abrirConexion();

		try {
			if (condicion == "") {

				stmt = con.prepareStatement("SELECT * FROM juegos ORDER BY " + criterio + " " + orden);

				/*
				 * stmt.setString(1, criterio); stmt.setString(2, orden);
				 */
				System.out.println(stmt);
			} else {
				stmt = con.prepareStatement("SELECT * FROM juegos WHERE " + criterio + " " + operador + " " + condicion
						+ " ORDER BY " + criterio + " " + orden);

				/*
				 * stmt.setString(1, criterio); stmt.setString(2, operador); stmt.setString(3,
				 * condicion); stmt.setString(4, criterio); stmt.setString(5, orden);
				 */
				System.out.println(stmt);
			}
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Juego j = new Juego();
				j = getJuego(rs, j);
				juegos.add(j);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return juegos;
	}

	
}
