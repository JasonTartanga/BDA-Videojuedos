package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clase.Juego;
import modelo.DAO;

public class Eliminar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JComboBox<String> comboBox;
	private JButton btnEliminar;
	private JTextArea pantalla;
	private List<Juego> juegos;
	private Juego juego;

	private DAO dao;

	public Eliminar(Principal main, DAO dao) {
		super(main);
		setResizable(false);
		this.setModal(true);

		this.dao = dao;

		getContentPane().setBackground(new Color(49, 51, 56));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 561);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		pantalla = new JTextArea();
		pantalla.setFont(new Font("Monospaced", Font.PLAIN, 20));
		pantalla.setBounds(87, 195, 609, 270);
		getContentPane().add(pantalla);

		juegos = dao.listarJuegos();

		comboBox = new JComboBox<String>();
		comboBox.setBounds(143, 116, 497, 49);
		getContentPane().add(comboBox);
		for (Juego juego : juegos) {
			comboBox.addItem(juego.getNombre());
		}
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Que juego quieres eliminar?");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel.setBounds(226, 47, 331, 39);
		getContentPane().add(lblNewLabel);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(SystemColor.controlHighlight);
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Serif", Font.PLAIN, 20));
		btnEliminar.setBounds(297, 501, 190, 49);
		getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(comboBox)) {
			mostrar();
		}else if(e.getSource().equals(btnEliminar)) {
			eliminar();
		}

	}

	private void eliminar() {
		int opc =JOptionPane.showConfirmDialog(this, "Seguro que quieres eliminar el " + juego.getNombre() + "?");
		
		if(opc == 0) {
			dao.eliminarJuego(juego.getId());
			JOptionPane.showMessageDialog(this, juego.getNombre() + "ha sido eliminado correctamente", "", 3);
		}
	}

	private void mostrar() {
		juego = dao.mostrarJuego(comboBox.getSelectedItem().toString());

		String mensaje = "\tId:\t\t" + juego.getId() + "\n";
		mensaje += "\tNombre:\t\t" + juego.getNombre() + "\n";
		mensaje += "\tJugabilidad:\t" + juego.getJugabilidad() + "\n";
		mensaje += "\tDiseño:\t\t" + juego.getDiseño() + "\n";
		mensaje += "\tRejugabilidad:\t" + juego.getRejugabilidad() + "\n";
		mensaje += "\tMundo:\t\t" + juego.getMundo() + "\n";
		mensaje += "\tGraficos:\t" + juego.getGraficos() + "\n";
		mensaje += "\tBanda Sonora:\t" + juego.getBanda_sonora() + "\n";
		mensaje += "\tMedia:\t" + juego.getMedia() + "\n";
		
		pantalla.setText(mensaje);

	}
}