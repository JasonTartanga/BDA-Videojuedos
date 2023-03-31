package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Juego;
import modelo.DAO;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private JTextField buscar;

	private JButton btnBuscar;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnListar;
	private JButton btnEliminar;

	private DAO dao;
	private JLabel lblNewLabel;
	private List<Juego> juegos;

	public Principal(DAO dao) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/utilidades/base-de-datos.png")));
		setTitle("Videojuegos\r\n");
		Dimension tam = Toolkit.getDefaultToolkit().getScreenSize();
		@SuppressWarnings("unused")
		int ancho = (int) tam.getWidth();
		@SuppressWarnings("unused")
		int alto = (int) tam.getHeight();

		this.dao = dao;

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 51, 56));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Serif", Font.PLAIN, 18));
		btnAñadir.setBackground(SystemColor.controlHighlight);
		btnAñadir.setBounds(1623, 258, 200, 80);
		contentPane.add(btnAñadir);
		btnAñadir.setRolloverEnabled(false);
		btnAñadir.addActionListener(this);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Serif", Font.PLAIN, 18));
		btnModificar.setBackground(SystemColor.controlHighlight);
		btnModificar.setBounds(1623, 453, 200, 80);
		contentPane.add(btnModificar);
		btnModificar.setRolloverEnabled(false);
		btnModificar.addActionListener(this);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Serif", Font.PLAIN, 18));
		btnEliminar.setBackground(SystemColor.controlHighlight);
		btnEliminar.setBounds(1616, 843, 200, 80);
		contentPane.add(btnEliminar);
		btnEliminar.setRolloverEnabled(false);
		btnEliminar.addActionListener(this);

		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Serif", Font.PLAIN, 18));
		btnListar.setBackground(SystemColor.controlHighlight);
		btnListar.setBounds(1623, 648, 200, 80);
		contentPane.add(btnListar);
		btnListar.setRolloverEnabled(false);
		btnListar.addActionListener(this);

		JSeparator separator = new JSeparator();
		separator.setBounds(29, 115, 1865, 28);
		contentPane.add(separator);

		juegos = dao.mostrarTodosJuegos();

		this.presentarTabla(juegos);
		/*
		 * Object[][] matriz = new Object[juegos.size()][10];
		 * 
		 * for (int i = 0; i < juegos.size(); i++) {
		 * 
		 * } String[] cabezeras = { "Id", "Nombre", "Jugabilidad", "Dise\u00F1o",
		 * "Rejugabilidad", "Mundo", "Graficos", "Historia", "Banda Sonora", "Media" };
		 * 
		 * this.crearTabla(matriz, cabezeras);
		 */
		buscar = new JTextField();
		buscar.setFont(new Font("Serif", Font.PLAIN, 24));
		buscar.setBounds(1340, 31, 357, 44);
		contentPane.add(buscar);
		buscar.setColumns(10);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Principal.class.getResource("/utilidades/buscar.png")));
		btnBuscar.setBackground(new Color(49, 51, 56));
		btnBuscar.setFont(new Font("Serif", Font.PLAIN, 24));
		btnBuscar.setBounds(1742, 17, 97, 73);
		contentPane.add(btnBuscar);
		btnBuscar.setRolloverEnabled(false);

		lblNewLabel = new JLabel("Jason\'s BD");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		lblNewLabel.setBounds(163, 39, 233, 65);
		contentPane.add(lblNewLabel);
		btnBuscar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAñadir)) {
			añadir();
		} else if (e.getSource().equals(btnModificar)) {
			modificar();
		} else if (e.getSource().equals(btnListar)) {
			listar();
		} else if (e.getSource().equals(btnEliminar)) {
			eliminar();
		} else if (e.getSource().equals(btnBuscar)) {
			buscar();
		}

	}

	private void buscar() {
		// TODO Auto-generated method stub

	}

	private void eliminar() {
		Eliminar elim = new Eliminar(this, dao);
		elim.setVisible(true);

	}

	private void listar() {
		Listar list = new Listar(this, dao, tabla);
		list.setVisible(true);

	}

	private void modificar() {
		Modificar modi = new Modificar(this, dao);
		modi.setVisible(true);
	}

	private void añadir() {
		Añadir add = new Añadir(this, dao);
		add.setVisible(true);
	}

	public void presentarTabla(List<Juego> juegos) {
		JScrollPane scroll = new JScrollPane();
		tabla = this.cargarTabla(juegos);
		scroll.setViewportView(tabla);
		contentPane.add(scroll);
		scroll.setBounds(86, 258, 1444, 665);
	}

	public JTable cargarTabla(List<Juego> juegos) {
		String[] cabezeras = { "Id", "Nombre", "Jugabilidad", "Dise\u00F1o", "Rejugabilidad", "Mundo", "Graficos",
				"Historia", "Banda Sonora", "Media" };
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabezeras);

		for (Juego j : juegos) {
			fila[0] = j.getId() + "";
			fila[1] = j.getNombre();
			fila[2] = j.getJugabilidad() + "";
			fila[3] = j.getDiseño() + "";
			fila[4] = j.getRejugabilidad() + "";
			fila[5] = j.getMundo() + "";
			fila[6] = j.getGraficos() + "";
			fila[7] = j.getHistoria() + "";
			fila[8] = j.getHistoria() + "";
			fila[9] = j.getMedia() + "";

			model.addRow(fila);
		}

		return new JTable(model);
	}

}
