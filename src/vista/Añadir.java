package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clase.Juego;
import modelo.DAO;

public class Añadir extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField videojuego;
	private JTextField jugabilidad;
	private JTextField diseño;
	private JTextField rejugabilidad;
	private JTextField mundo;
	private JTextField graficos;
	private JTextField historia;
	private JTextField banda_sonora;
	private JButton btnLimpiar;
	private JButton btnAñadir;

	private DAO dao;
	
	public Añadir(Principal main, DAO dao) {
		super(main);
		setResizable(false);
		this.setModal(true);

		this.dao = dao;
		
		getContentPane().setBackground(new Color(49, 51, 56));
		setBounds(100, 100, 600, 800);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 761);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Serif", Font.PLAIN, 20));
		btnLimpiar.setBackground(SystemColor.controlHighlight);
		btnLimpiar.setBounds(88, 682, 159, 52);
		getContentPane().add(btnLimpiar);
		btnLimpiar.addActionListener(this);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Serif", Font.PLAIN, 20));
		btnAñadir.setBackground(SystemColor.controlHighlight);
		btnAñadir.setBounds(335, 682, 159, 52);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);

		videojuego = new JTextField();
		videojuego.setFont(new Font("Serif", Font.PLAIN, 20));
		videojuego.setBounds(240, 31, 273, 40);
		getContentPane().add(videojuego);
		videojuego.setColumns(10);

		JLabel lblNewLabel = new JLabel("Videojuego:");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(71, 34, 97, 27);
		getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 94, 563, 8);
		getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("Jugabilidad:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(72, 131, 98, 27);
		getContentPane().add(lblNewLabel_1);

		jugabilidad = new JTextField();
		jugabilidad.setFont(new Font("Serif", Font.PLAIN, 20));
		jugabilidad.setColumns(10);
		jugabilidad.setBounds(241, 128, 273, 40);
		getContentPane().add(jugabilidad);

		JLabel lblNewLabel_2 = new JLabel("Diseño de nivel:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(72, 204, 131, 27);
		getContentPane().add(lblNewLabel_2);

		diseño = new JTextField();
		diseño.setFont(new Font("Serif", Font.PLAIN, 20));
		diseño.setColumns(10);
		diseño.setBounds(240, 201, 273, 40);
		getContentPane().add(diseño);

		JLabel lblNewLabel_2_1 = new JLabel("Rejugabilidad:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(72, 277, 118, 27);
		getContentPane().add(lblNewLabel_2_1);

		rejugabilidad = new JTextField();
		rejugabilidad.setFont(new Font("Serif", Font.PLAIN, 20));
		rejugabilidad.setColumns(10);
		rejugabilidad.setBounds(240, 274, 273, 40);
		getContentPane().add(rejugabilidad);

		JLabel lblNewLabel_2_2 = new JLabel("Mundo/Mapa:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(72, 350, 112, 27);
		getContentPane().add(lblNewLabel_2_2);

		mundo = new JTextField();
		mundo.setFont(new Font("Serif", Font.PLAIN, 20));
		mundo.setColumns(10);
		mundo.setBounds(241, 347, 273, 40);
		getContentPane().add(mundo);

		JLabel lblNewLabel_2_2_1 = new JLabel("Gráficos:");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2_1.setBounds(72, 423, 75, 27);
		getContentPane().add(lblNewLabel_2_2_1);

		graficos = new JTextField();
		graficos.setFont(new Font("Serif", Font.PLAIN, 20));
		graficos.setColumns(10);
		graficos.setBounds(240, 420, 273, 40);
		getContentPane().add(graficos);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Historia:");
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2_1_1.setBounds(72, 496, 71, 27);
		getContentPane().add(lblNewLabel_2_2_1_1);

		historia = new JTextField();
		historia.setFont(new Font("Serif", Font.PLAIN, 20));
		historia.setColumns(10);
		historia.setBounds(240, 493, 273, 40);
		getContentPane().add(historia);

		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Banda sonora:");
		lblNewLabel_2_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2_1_1_1.setBounds(72, 569, 114, 27);
		getContentPane().add(lblNewLabel_2_2_1_1_1);

		banda_sonora = new JTextField();
		banda_sonora.setFont(new Font("Serif", Font.PLAIN, 20));
		banda_sonora.setColumns(10);
		banda_sonora.setBounds(240, 566, 273, 40);
		getContentPane().add(banda_sonora);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLimpiar)) {
			limpiar();
		} else if (e.getSource().equals(btnAñadir)) {
			if (comrpobar()) {
				añadir();
			}
		}
	}

	private void añadir() {
		//Calculamos la media
		
		float media = 0;
		JTextField[] campos = { jugabilidad, diseño, rejugabilidad, mundo, graficos, historia, banda_sonora };
		for (int i = 0; i < campos.length; i++) {
			media += Float.parseFloat(campos[i].getText());
		}
		media /= campos.length;
		
		//Damos valores al Juego
		Juego j = new Juego();
		j.setNombre(videojuego.getText());
		j.setJugabilidad(Float.parseFloat(jugabilidad.getText()));
		j.setDiseño(Float.parseFloat(diseño.getText()));
		j.setRejugabilidad(Float.parseFloat(rejugabilidad.getText()));
		j.setMundo(Float.parseFloat(mundo.getText()));
		j.setGraficos(Float.parseFloat(graficos.getText()));
		j.setHistoria(Float.parseFloat(historia.getText()));
		j.setBanda_sonora(Float.parseFloat(banda_sonora.getText()));	
		j.setMedia(media);
		
		//Añadimos el juego a la bda
		dao.añadir(j);
		JOptionPane.showMessageDialog(this, j.getNombre() + " a sido añadido con exito", "", 3);
		
		//Limpiamos
		//this.limpiar();
		
		//Salimos
		this.dispose();
	}

	private boolean comrpobar() {
		//Comprobamos que todos los valores han sido introducidos
		
		JTextField[] campos = { jugabilidad, diseño, rejugabilidad, mundo, graficos, historia, banda_sonora };
		boolean correcto = true;
		for (int i = 0; i < campos.length; i++) {
			try {
				Float.parseFloat(campos[i].getText());
				campos[i].setBackground(new Color(102, 204, 102));
			} catch (NumberFormatException e) {
				campos[i].setBackground(new Color(153, 51, 51));
				JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "ERROR", 0);
				correcto = false;
			}
		}
		if (correcto)
			return true;
		return false;
	}

	private void limpiar() {
		//Vacia todos los campos
		
		JTextField[] campos = { videojuego, jugabilidad, diseño, rejugabilidad, mundo, graficos, historia,
				banda_sonora };

		for (int i = 0; i < campos.length; i++) {
			campos[i].setText("");
			campos[i].setBackground(new Color(240, 240, 240));
		}
	}
}
