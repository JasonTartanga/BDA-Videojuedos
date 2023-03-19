package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Juego;
import modelo.DAO;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Modificar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JComboBox<String> listaJuegos;
	private DAO dao;
	private List<Juego> juegos;

	private JTextField jugabilidad;
	private JTextField diseño;
	private JTextField rejugabilidad;
	private JTextField mundo;
	private JTextField graficos;
	private JTextField historia;
	private JTextField banda_sonora;

	private JButton btnLimpiar;
	private JButton btnModificar;

	public Modificar(Principal main, DAO dao) {
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
		setLocationRelativeTo(null);

		juegos = dao.listarJuegos();

		listaJuegos = new JComboBox<String>();
		listaJuegos.setEditable(true);
		listaJuegos.setBounds(171, 27, 375, 42);
		getContentPane().add(listaJuegos);
		/*
		 * listaJuegos.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println(listaJuegos.getEditor().getItem().toString()); juegos =
		 * dao.BuscarJuegos(listaJuegos.getEditor().getItem().toString());
		 * listaJuegos.removeAllItems(); for (Juego juego : juegos) {
		 * listaJuegos.addItem(juego.getNombre()); } listaJuegos.setSelectedIndex(-1); }
		 * });
		 */

		for (Juego juego : juegos) {
			listaJuegos.addItem(juego.getNombre());
		}

		listaJuegos.setSelectedIndex(-1);
		listaJuegos.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Videojuego:");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 35, 97, 27);
		getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 92, 563, 8);
		getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("Jugabilidad:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(60, 129, 98, 27);
		getContentPane().add(lblNewLabel_1);

		jugabilidad = new JTextField();
		jugabilidad.setFont(new Font("Serif", Font.PLAIN, 20));
		jugabilidad.setColumns(10);
		jugabilidad.setBounds(251, 126, 273, 40);
		getContentPane().add(jugabilidad);

		diseño = new JTextField();
		diseño.setFont(new Font("Serif", Font.PLAIN, 20));
		diseño.setColumns(10);
		diseño.setBounds(251, 199, 273, 40);
		getContentPane().add(diseño);

		JLabel lblNewLabel_2 = new JLabel("Diseño de nivel:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(60, 202, 131, 27);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Rejugabilidad:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(60, 275, 118, 27);
		getContentPane().add(lblNewLabel_2_1);

		rejugabilidad = new JTextField();
		rejugabilidad.setFont(new Font("Serif", Font.PLAIN, 20));
		rejugabilidad.setColumns(10);
		rejugabilidad.setBounds(251, 272, 273, 40);
		getContentPane().add(rejugabilidad);

		mundo = new JTextField();
		mundo.setFont(new Font("Serif", Font.PLAIN, 20));
		mundo.setColumns(10);
		mundo.setBounds(251, 345, 273, 40);
		getContentPane().add(mundo);

		JLabel lblNewLabel_2_2 = new JLabel("Mundo/Mapa:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(60, 348, 112, 27);
		getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Gráficos:");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2_1.setBounds(60, 421, 75, 27);
		getContentPane().add(lblNewLabel_2_2_1);

		graficos = new JTextField();
		graficos.setFont(new Font("Serif", Font.PLAIN, 20));
		graficos.setColumns(10);
		graficos.setBounds(251, 418, 273, 40);
		getContentPane().add(graficos);

		historia = new JTextField();
		historia.setFont(new Font("Serif", Font.PLAIN, 20));
		historia.setColumns(10);
		historia.setBounds(251, 491, 273, 40);
		getContentPane().add(historia);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Historia:");
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2_1_1.setBounds(60, 494, 71, 27);
		getContentPane().add(lblNewLabel_2_2_1_1);

		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Banda sonora:");
		lblNewLabel_2_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_2_1_1_1.setBounds(60, 567, 114, 27);
		getContentPane().add(lblNewLabel_2_2_1_1_1);

		banda_sonora = new JTextField();
		banda_sonora.setFont(new Font("Serif", Font.PLAIN, 20));
		banda_sonora.setColumns(10);
		banda_sonora.setBounds(251, 564, 273, 40);
		getContentPane().add(banda_sonora);

		btnModificar = new JButton("Añadir");
		btnModificar.setFont(new Font("Serif", Font.PLAIN, 20));
		btnModificar.setBackground(SystemColor.controlHighlight);
		btnModificar.setBounds(335, 680, 159, 52);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Serif", Font.PLAIN, 20));
		btnLimpiar.setBackground(SystemColor.controlHighlight);
		btnLimpiar.setBounds(88, 680, 159, 52);
		getContentPane().add(btnLimpiar);
		btnLimpiar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLimpiar)) {
			limpiar();
		} else if (e.getSource().equals(btnModificar)) {
			if (comprobar()) {
				modificar();
			}
		} else if (e.getSource().equals(listaJuegos)) {
			mostrar();
		}
	}

	private void mostrar() {
		Juego j = dao.mostrarJuego(listaJuegos.getSelectedItem().toString());
		
		//Creamos un objeto y cambiamos el texto de los campos a los valores de ese objeto
		jugabilidad.setText(j.getJugabilidad() + "");
		diseño.setText(j.getDiseño() + "");
		rejugabilidad.setText(j.getRejugabilidad() + "");
		mundo.setText(j.getMundo() + "");
		graficos.setText(j.getGraficos() + "");
		historia.setText(j.getHistoria() + "");
		banda_sonora.setText(j.getBanda_sonora() + "");
	}

	private boolean comprobar() {
		JTextField[] campos = { jugabilidad, diseño, rejugabilidad, mundo, graficos, historia, banda_sonora };
		boolean correcto = true;
		float comprobar;
		
		//Comprobar que no esta vacio 
		for (int i = 0; i < campos.length; i++) {
			try {
				comprobar = Float.parseFloat(campos[i].getText());
				
				//Comprobar que el numero es entre 0 y 10
				if(comprobar > 0 && comprobar < 10) {
					campos[i].setBackground(new Color(102, 204, 102));
				}else {
					//Provocamos fallo
					Float.parseFloat("asdjaidaos");
				}
			} catch (NumberFormatException e) {
				campos[i].setBackground(new Color(153, 51, 51));
				correcto = false;
			}
		}
		
		if (correcto)
			return true;
		JOptionPane.showMessageDialog(this, "El valor debe ser un numero");
		return false;
	}

	private void modificar() {
		JTextField[] campos = { jugabilidad, diseño, rejugabilidad, mundo, graficos, historia, banda_sonora };
		float media = 0;

		//Calculamos la media
		for (int i = 0; i < campos.length; i++) {
			media += Float.parseFloat(campos[i].getText());
		}
		media /= campos.length;

		//Creamos un objeto para guardarlo en la bd
		Juego j = new Juego();
		j.setNombre(listaJuegos.getSelectedItem().toString());
		j.setJugabilidad(Float.parseFloat(jugabilidad.getText()));
		j.setDiseño(Float.parseFloat(diseño.getText()));
		j.setRejugabilidad(Float.parseFloat(rejugabilidad.getText()));
		j.setMundo(Float.parseFloat(mundo.getText()));
		j.setGraficos(Float.parseFloat(graficos.getText()));
		j.setHistoria(Float.parseFloat(historia.getText()));
		j.setBanda_sonora(Float.parseFloat(banda_sonora.getText()));
		j.setMedia(media);

		dao.modificarJuego(j);

		JOptionPane.showMessageDialog(this, j.getNombre() + " a sido actualizado correctamente", "", 3);

		// Limpiar
		// this.limpiar();

		// Salir
		this.dispose();
	}

	private void limpiar() {
		JTextField[] campos = { jugabilidad, diseño, rejugabilidad, mundo, graficos, historia, banda_sonora };

		//Vaciamos todos los campos
		for (int i = 0; i < campos.length; i++) {
			campos[i].setText("");
			campos[i].setBackground(new Color(240, 240, 240));
		}
	}
}
