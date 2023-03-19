package clase;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EjemploJComboBoxFiltrado {
	public static void main(String[] args) {
		String[] opciones = { "Alicante", "Barcelona", "Cádiz", "Córdoba", "Girona", "Granada", "Madrid", "Málaga",
				"Sevilla", "Valencia" };
		JComboBox<String> comboBox = new JComboBox<>(opciones);

		// Agregamos un JTextField para filtrar las opciones
		JTextField textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filtrarOpciones(textField.getText().toLowerCase(), comboBox);
			}
		});

		// Agregamos los componentes al panel
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(textField, BorderLayout.NORTH);
		panel.add(comboBox, BorderLayout.CENTER);

		// Creamos una ventana y la mostramos
		JFrame ventana = new JFrame("JComboBox filtrado");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(panel);
		ventana.pack();
		ventana.setVisible(true);
	}

	private static void filtrarOpciones(String filtro, JComboBox<String> comboBox) {
		List<String> opcionesFiltradas = new ArrayList<>();
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			String item = comboBox.getItemAt(i).toLowerCase();
			if (item.startsWith(filtro)) {
				opcionesFiltradas.add(comboBox.getItemAt(i));
			}
		}

		comboBox.removeAllItems();
		for (String opcion : opcionesFiltradas) {
			comboBox.addItem(opcion);
		}
	}

}