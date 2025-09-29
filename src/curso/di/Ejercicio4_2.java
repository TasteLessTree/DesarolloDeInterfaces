package curso.di;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/** @author AndrésPérezM
 * */

public class Ejercicio4_2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userInput;
	private JLabel lblMaterialAnyadir, lblMateriales;
	private JButton btnAnyadir, btnSalir, btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4_2 frame = new Ejercicio4_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio4_2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ejercicio4_2.class.getResource("/curso/di/images/minecraft.png")));
		setTitle("Añadir a la lista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Ejercicio4_2.class.getResource("/curso/di/images/exit_small.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						Ejercicio4_2.this,
						"¿Seguro que quieres salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) System.exit(EXIT_ON_CLOSE); 
			}
		});
		contentPane.setLayout(null);
		btnSalir.setBounds(208, 171, 70, 70);
		contentPane.add(btnSalir);
		
		DefaultComboBoxModel<String> defaultCBM = new DefaultComboBoxModel<String>();
		JComboBox<String> cBMateriales = new JComboBox<String>(defaultCBM);
		cBMateriales.setBounds(316, 72, 141, 27);
		contentPane.add(cBMateriales);
		
		lblMaterialAnyadir = new JLabel("MATERIAL");
		lblMaterialAnyadir.setVerticalAlignment(SwingConstants.TOP);
		lblMaterialAnyadir.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblMaterialAnyadir.setBounds(10, 34, 86, 27);
		contentPane.add(lblMaterialAnyadir);
		
		userInput = new JTextField();
		userInput.setBounds(10, 72, 156, 27);
		contentPane.add(userInput);
		userInput.setColumns(10);
		
		btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = userInput.getText();
				
				if (texto.isBlank() && texto.isEmpty()) {
					aviso("NO se puede añadir un elemento en blanco o vacío.");
				} else if (!texto.matches("[a-zA-Z]+")) {
					aviso("NO se puede añadir un elemento con caracteres especiales.");
				} else if (!(defaultCBM.getIndexOf(texto.toUpperCase()) == -1)) {
					aviso("Elemento ya en la lista");
				} else {
					defaultCBM.addElement(texto.toUpperCase());
					defaultCBM.setSelectedItem(texto.toUpperCase());
					userInput.setText("");
				}
			}
		});
		btnAnyadir.setBounds(193, 72, 100, 27);
		contentPane.add(btnAnyadir);
		
		lblMateriales = new JLabel("MATERIALES");
		lblMateriales.setVerticalAlignment(SwingConstants.TOP);
		lblMateriales.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblMateriales.setBounds(316, 34, 112, 27);
		contentPane.add(lblMateriales);
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object eliminar = defaultCBM.getSelectedItem();
				
				int respuesta = JOptionPane.showConfirmDialog(
						Ejercicio4_2.this,
						"¿Seguro que quieres eliminar: \"" + eliminar + "\"?",
						"ELIMINAR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) {
					defaultCBM.removeElement(eliminar);
					defaultCBM.setSelectedItem(defaultCBM.getElementAt(0));
				} 
			}
		});
		btnEliminar.setBounds(193, 119, 100, 27);
		contentPane.add(btnEliminar);
	}
	
	private void aviso(String mensaje) {
		JOptionPane.showMessageDialog(
				Ejercicio4_2.this,
				mensaje);
	}
}
