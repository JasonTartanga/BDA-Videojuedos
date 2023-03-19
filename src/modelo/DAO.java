package modelo;

import java.util.List;

import clase.Juego;

public interface DAO {

	public void añadir(Juego j);
	
	public void modificarJuego(Juego j);
	
	public List<Juego> listarJuegos();
	
	public List<Juego> BuscarJuegos(String busqueda);
	
	public Juego mostrarJuego(String nombre);
}
