package curso.di;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JScrollPane;
import java.awt.TextField;

public class ContadorPalabras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLeer, btnEscribir, btnContar, btnSalir;
	private Label lblVocales, lblConsonantes, lblEspeciales, lblResto, lblNumeros, lblTotal;
	private JScrollPane scrollPane;
	private TextArea textArea;
	private TextField txtVocales, txtConsonantes, txtEspeciales, txtResto, txtNumeros, txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContadorPalabras frame = new ContadorPalabras();
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
	public ContadorPalabras() {
		setTitle("Contador de caracteres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeer.setBounds(10, 308, 89, 23);
		contentPane.add(btnLeer);
		
		btnEscribir = new JButton("Escribir");
		btnEscribir.setBounds(116, 308, 89, 23);
		contentPane.add(btnEscribir);
		
		btnContar = new JButton("Contar");
		btnContar.setBounds(226, 308, 89, 23);
		contentPane.add(btnContar);
		
		lblVocales = new Label("Vocales");
		lblVocales.setBounds(321, 10, 62, 22);
		contentPane.add(lblVocales);
		
		lblConsonantes = new Label("Consonantes");
		lblConsonantes.setBounds(321, 48, 78, 22);
		contentPane.add(lblConsonantes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 305, 286);
		contentPane.add(scrollPane);
		
		textArea = new TextArea();
		scrollPane.setViewportView(textArea);
		
		lblEspeciales = new Label("Especiales");
		lblEspeciales.setBounds(321, 83, 78, 22);
		contentPane.add(lblEspeciales);
		
		lblResto = new Label("Resto");
		lblResto.setBounds(321, 119, 78, 22);
		contentPane.add(lblResto);
		
		lblNumeros = new Label("Números");
		lblNumeros.setBounds(321, 158, 78, 22);
		contentPane.add(lblNumeros);
		
		lblTotal = new Label("Total");
		lblTotal.setBounds(321, 196, 78, 22);
		contentPane.add(lblTotal);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						ContadorPalabras.this,
						"¿Seguro que quieres salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) System.exit(EXIT_ON_CLOSE); 
			}
		});
		btnSalir.setBounds(441, 308, 89, 23);
		contentPane.add(btnSalir);
		
		txtVocales = new TextField();
		txtVocales.setBounds(425, 10, 105, 22);
		contentPane.add(txtVocales);
		
		txtConsonantes = new TextField();
		txtConsonantes.setBounds(425, 48, 105, 22);
		contentPane.add(txtConsonantes);
		
		txtEspeciales = new TextField();
		txtEspeciales.setBounds(425, 83, 105, 22);
		contentPane.add(txtEspeciales);
		
		txtResto = new TextField();
		txtResto.setBounds(425, 119, 105, 22);
		contentPane.add(txtResto);
		
		txtNumeros = new TextField();
		txtNumeros.setBounds(425, 158, 105, 22);
		contentPane.add(txtNumeros);
		
		txtTotal = new TextField();
		txtTotal.setBounds(425, 196, 105, 22);
		contentPane.add(txtTotal);

	}
}
