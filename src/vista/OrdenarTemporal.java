package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clase.Juego;
import modelo.DAO;

public class OrdenarTemporal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTextArea pantalla;
	public OrdenarTemporal(Listar listar, DAO dao, List<Juego> juegos) {
		setBounds(100, 100, 1920, 1080);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(49, 51, 56));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		pantalla = new JTextArea();
		pantalla.setWrapStyleWord(true);
		pantalla.setLineWrap(true);
		pantalla.setEditable(false);
		pantalla.setBounds(10, 11, 1884, 1019);
		contentPanel.add(pantalla);

		String texto = "";
		for(Juego j : juegos) {
			texto += j.toString() + "\n"; 
		}
		pantalla.setText(texto);
	}

}
