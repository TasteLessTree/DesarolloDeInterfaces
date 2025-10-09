package curso.di;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
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
	private GestorFicheros gFichero = new GestorFicheros();;

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
		setBounds(100, 100, 620, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.setText(gFichero.getTextoFichero());
			}
		});
		btnLeer.setBounds(10, 308, 89, 23);
		contentPane.add(btnLeer);
		
		btnEscribir = new JButton("Escribir");
		btnEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gFichero.setTextFichero();
			}
		});
		btnEscribir.setBounds(116, 308, 89, 23);
		contentPane.add(btnEscribir);
		
		btnContar = new JButton("Contar");
		btnContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Integer> contadores = new HashMap<String, Integer>();
				contadores = gFichero.contarTipoChar(textArea.getText());
				
				txtVocales.setText(String.valueOf(contadores.get("Vocales")));
				txtConsonantes.setText(String.valueOf(contadores.get("Consonantes")));
				txtEspeciales.setText(String.valueOf(contadores.get("Especiales")));
				txtResto.setText(String.valueOf(contadores.get("Resto")));
				txtNumeros.setText(String.valueOf(contadores.get("Numeros")));
				txtTotal.setText(String.valueOf(contadores.get("Total")));
			}
		});
		btnContar.setBounds(226, 308, 89, 23);
		contentPane.add(btnContar);
		
		lblVocales = new Label("Vocales");
		lblVocales.setBounds(406, 11, 62, 22);
		contentPane.add(lblVocales);
		
		lblConsonantes = new Label("Consonantes");
		lblConsonantes.setBounds(406, 48, 78, 22);
		contentPane.add(lblConsonantes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 390, 286);
		contentPane.add(scrollPane);
		
		textArea = new TextArea();
		scrollPane.setViewportView(textArea);
		
		lblEspeciales = new Label("Especiales");
		lblEspeciales.setBounds(406, 83, 78, 22);
		contentPane.add(lblEspeciales);
		
		lblResto = new Label("Resto");
		lblResto.setBounds(406, 111, 78, 22);
		contentPane.add(lblResto);
		
		lblNumeros = new Label("Números");
		lblNumeros.setBounds(406, 139, 78, 22);
		contentPane.add(lblNumeros);
		
		lblTotal = new Label("Total");
		lblTotal.setBounds(406, 167, 78, 22);
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
		btnSalir.setBounds(506, 308, 89, 23);
		contentPane.add(btnSalir);
		
		txtVocales = new TextField();
		txtVocales.setBounds(490, 11, 105, 22);
		contentPane.add(txtVocales);
		
		txtConsonantes = new TextField();
		txtConsonantes.setBounds(490, 48, 105, 22);
		contentPane.add(txtConsonantes);
		
		txtEspeciales = new TextField();
		txtEspeciales.setBounds(490, 83, 105, 22);
		contentPane.add(txtEspeciales);
		
		txtResto = new TextField();
		txtResto.setBounds(490, 111, 105, 22);
		contentPane.add(txtResto);
		
		txtNumeros = new TextField();
		txtNumeros.setBounds(490, 139, 105, 22);
		contentPane.add(txtNumeros);
		
		txtTotal = new TextField();
		txtTotal.setBounds(490, 167, 105, 22);
		contentPane.add(txtTotal);
	}
}