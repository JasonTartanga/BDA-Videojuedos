package controlador;

import modelo.DAO;
import modelo.DAOImplementacionBD;
import vista.Principal;

public class MainVideojuegos {

	public static void main(String[] args) {
		DAO dao = new DAOImplementacionBD();
		
		Principal main = new Principal(dao);
		main.setVisible(true);
	}
}
