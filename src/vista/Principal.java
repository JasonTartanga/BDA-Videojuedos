package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

	public Principal(DAO dao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/utilidades/base-de-datos.png")));
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

		tabla = new JTable();
		tabla.setBounds(86, 258, 1444, 665);
		contentPane.add(tabla);

		buscar = new JTextField();
		buscar.setBounds(1340, 31, 357, 44);
		contentPane.add(buscar);
		buscar.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.controlHighlight);
		btnBuscar.setFont(new Font("Serif", Font.PLAIN, 20));
		btnBuscar.setBounds(1745, 31, 149, 44);
		contentPane.add(btnBuscar);
		btnBuscar.setRolloverEnabled(false);
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
		Listar list = new Listar(this, dao);
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
