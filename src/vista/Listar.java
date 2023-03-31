package vista;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clase.Juego;
import modelo.DAO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Listar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JComboBox<String> criterio;
	private JComboBox<String> condicion;
	private JComboBox<String> orden;
	private JRadioButton rdbtnMas;
	private JRadioButton rdbtnMenos;
	private ButtonGroup grupo;
	private JButton btnOrdenar;

	private DAO dao;
	private JTable tabla;
	private Principal main;

	public Listar(Principal main, DAO dao, JTable tabla) {
		super(main);
		setResizable(false);
		this.setModal(true);

		this.dao = dao;
		this.tabla = tabla;
		this.main = main;

		getContentPane().setBackground(new Color(49, 51, 56));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 561);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		String[] criterios = { "id", "Nombre", "Jugabilidad", "Diseño", "Rejugabilidad", "Mundo", "Graficos",
				"Historia", "Banda Sonora", "Media" };

		criterio = new JComboBox<String>();
		criterio.setBackground(SystemColor.controlHighlight);
		criterio.setBounds(46, 206, 200, 40);
		getContentPane().add(criterio);

		for (int i = 0; i < criterios.length; i++) {
			criterio.addItem(criterios[i]);
		}
		criterio.setSelectedIndex(-1);
		criterio.addActionListener(this);

		condicion = new JComboBox<String>();
		condicion.setBackground(SystemColor.controlHighlight);
		condicion.setBounds(292, 206, 200, 40);
		getContentPane().add(condicion);
		condicion.setSelectedIndex(-1);
		condicion.addActionListener(this);

		String[] ordenes = { "Mayor a menor", "Menor a mayor" };
		orden = new JComboBox<String>();
		orden.setBackground(SystemColor.controlHighlight);
		orden.setBounds(538, 206, 200, 40);
		getContentPane().add(orden);
		for (int i = 0; i < ordenes.length; i++) {
			orden.addItem(ordenes[i]);
		}
		orden.setSelectedIndex(-1);

		rdbtnMas = new JRadioButton("Mayor que:");
		rdbtnMas.setEnabled(false);
		rdbtnMas.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnMas.setForeground(SystemColor.textHighlightText);
		rdbtnMas.setBackground(new Color(49, 51, 56));
		rdbtnMas.setBounds(334, 264, 117, 35);
		getContentPane().add(rdbtnMas);

		rdbtnMenos = new JRadioButton("Menor que:");
		rdbtnMenos.setEnabled(false);
		rdbtnMenos.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnMenos.setForeground(SystemColor.textHighlightText);
		rdbtnMenos.setBackground(new Color(49, 51, 56));
		rdbtnMenos.setBounds(334, 306, 117, 35);
		getContentPane().add(rdbtnMenos);
		setLocationRelativeTo(null);

		grupo = new ButtonGroup();
		grupo.add(rdbtnMas);
		grupo.add(rdbtnMenos);

		JLabel lblNewLabel = new JLabel("Criterio:");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel.setBounds(97, 107, 98, 39);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Orden:");
		lblNewLabel_1.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(597, 107, 83, 39);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Condicion:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel_1_1.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_1.setBounds(327, 107, 130, 39);
		getContentPane().add(lblNewLabel_1_1);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setBackground(SystemColor.controlHighlight);
		btnOrdenar.setForeground(new Color(0, 0, 0));
		btnOrdenar.setFont(new Font("Serif", Font.PLAIN, 20));
		btnOrdenar.setBounds(296, 473, 191, 50);
		getContentPane().add(btnOrdenar);
		btnOrdenar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(criterio)) {
			criterio();
		} else if (e.getSource().equals(condicion)) {
			condicion();
		} else if (e.getSource().equals(btnOrdenar)) {
			ordenar();
		}

	}

	private void ordenar() {
		String criterioS = null;

		try {
			criterioS = criterio.getSelectedItem().toString();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Debes escojer almenos un criterio", "ERROR", 0);
		}

		String condicionS;

		if (condicion.getSelectedIndex() == -1) {
			condicionS = "";
		} else {
			condicionS = condicion.getSelectedItem().toString();
		}

		String ordenS = orden.getSelectedItem().toString();
		String operador;

		if (criterioS.equalsIgnoreCase("Banda Sonora")) {
			criterioS = "banda_sonora";
		}
		// Cambiamos la variable operador para que coincida con SQL
		if (rdbtnMas.isSelected()) {
			operador = ">";
		} else {
			operador = "<";
		}

		// Cambiamos la variable de orden para que coincida con SQL
		System.out.println(ordenS);
		if (ordenS.equalsIgnoreCase("Mayor a menor")) {
			ordenS = "desc";
		} else {
			ordenS = "asc";
		}
 
		List<Juego> juegos = dao.ordenar(criterioS, condicionS, operador, ordenS);

		for (Juego juego : juegos) {
			System.out.println(juego.toString());
		}
	
		main.presentarTabla(juegos);

		tabla.repaint();

		this.dispose();

	}

	private void condicion() {
		if (condicion.getSelectedItem().toString().equalsIgnoreCase("")) {
			rdbtnMas.setEnabled(false);
			rdbtnMenos.setEnabled(false);
		} else {
			rdbtnMenos.setEnabled(true);
			rdbtnMas.setEnabled(true);
		}
	}

	private void criterio() {
		orden.setSelectedIndex(0);
		if (!criterio.getSelectedItem().toString().equalsIgnoreCase("id")
				&& !criterio.getSelectedItem().toString().equalsIgnoreCase("nombre")) {
			condicion.addItem("");
			for (int i = 0; i <= 10; i++) {
				condicion.addItem(i + "");
			}
			condicion.setSelectedIndex(0);

		} else {
			condicion.removeAllItems();
			rdbtnMas.setEnabled(false);
			rdbtnMenos.setEnabled(false);
		}

	}
}
