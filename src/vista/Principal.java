package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

		List<Juego> juegos = dao.mostrarTodosJuegos();

		Object[][] matriz = new Object[juegos.size()][10];

		for (int i = 0; i < juegos.size(); i++) {
			matriz[i][0] = juegos.get(i).getId();
			matriz[i][1] = juegos.get(i).getNombre();
			matriz[i][2] = juegos.get(i).getJugabilidad();
			matriz[i][3] = juegos.get(i).getDiseño();
			matriz[i][4] = juegos.get(i).getRejugabilidad();
			matriz[i][5] = juegos.get(i).getMundo();
			matriz[i][6] = juegos.get(i).getGraficos();
			matriz[i][7] = juegos.get(i).getHistoria();
			matriz[i][8] = juegos.get(i).getHistoria();
			matriz[i][9] = juegos.get(i).getMedia();
		}
		String[] cabezeras = { "Id", "Nombre", "Jugabilidad", "Dise\u00F1o", "Rejugabilidad", "Mundo", "Graficos",
				"Historia", "Banda Sonora", "Media" };

		tabla = new JTable(matriz, cabezeras);
		tabla.setFont(new Font("Monospaced", Font.PLAIN, 16));
		tabla.setBounds(86, 258, 1444, 665);
		contentPane.add(tabla);
		Rectangle rect = tabla.getCellRect(tabla.getRowCount() - 1, 0, true);
		tabla.scrollRectToVisible(rect);

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

}
