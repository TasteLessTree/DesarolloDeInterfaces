package curso.di;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Ejercicio4_2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userInput;
	private JLabel lblMaterialAnyadir, lblMateriales;
	private JComboBox cBMateriales;
	private JButton btnAnyadir, btnSalir;

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
		setTitle("Añadir a la lista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSalir = new JButton("Salir");
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
		btnSalir.setBounds(10, 175, 86, 61);
		contentPane.add(btnSalir);
		
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
				
				//cbMateriales;
			}
		});
		btnAnyadir.setBounds(193, 55, 86, 61);
		contentPane.add(btnAnyadir);
		
		lblMateriales = new JLabel("MATERIALES");
		lblMateriales.setVerticalAlignment(SwingConstants.TOP);
		lblMateriales.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblMateriales.setBounds(316, 34, 112, 27);
		contentPane.add(lblMateriales);
		
		cBMateriales = new JComboBox();
		cBMateriales.setBounds(316, 72, 141, 27);
		contentPane.add(cBMateriales);
	}
}
