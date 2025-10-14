package curso.di;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ejercicio6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRojo, lblVerde, lblAzul;
	private JSlider slRojo, slVerde, slAzul;
	private JTextField tfRojo;
	private JTextField tfVerde;
	private JTextField tfAzul;
	private JPanel showCase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
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
	public Ejercicio6() {
		setTitle("Ejercicio6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRojo = new JLabel("Rojo");
		lblRojo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfRojo.setText("225");
				tfVerde.setText("0");
				tfAzul.setText("0");
				
				slRojo.setValue(255);
				slVerde.setValue(0);
				slAzul.setValue(0);
			}
		});
		lblRojo.setForeground(new Color(255, 0, 0));
		lblRojo.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		lblRojo.setBounds(10, 29, 48, 35);
		contentPane.add(lblRojo);
		
		lblVerde = new JLabel("Verde");
		lblVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfRojo.setText("0");
				tfVerde.setText("255");
				tfAzul.setText("0");
				
				slRojo.setValue(0);
				slVerde.setValue(255);
				slAzul.setValue(0);
			}
		});
		lblVerde.setForeground(new Color(0, 255, 0));
		lblVerde.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		lblVerde.setBounds(10, 81, 48, 35);
		contentPane.add(lblVerde);
		
		lblAzul = new JLabel("Azul");
		lblAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfRojo.setText("0");
				tfVerde.setText("0");
				tfAzul.setText("255");
				
				slRojo.setValue(0);
				slVerde.setValue(0);
				slAzul.setValue(255);
			}
		});
		lblAzul.setForeground(new Color(0, 0, 255));
		lblAzul.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		lblAzul.setBounds(10, 140, 48, 35);
		contentPane.add(lblAzul);
		
		slRojo = new JSlider();
		slRojo.setValue(0);
		slRojo.setMinimum(0);
		slRojo.setMaximum(255);
		slRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfRojo.setText(String.valueOf(slRojo.getValue()));
				
				showCase.setBackground(new Color(slRojo.getValue(),
												slVerde.getValue(),
												slAzul.getValue()));
			}
		});
		slRojo.setBounds(68, 29, 200, 26);
		contentPane.add(slRojo);
		
		slVerde = new JSlider();
		slVerde.setValue(0);
		slVerde.setMinimum(0);
		slVerde.setMaximum(255);
		slVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfVerde.setText(String.valueOf(slVerde.getValue()));
				
				showCase.setBackground(new Color(slRojo.getValue(),
												slVerde.getValue(),
												slAzul.getValue()));
			}
		});
		slVerde.setBounds(68, 81, 200, 26);
		contentPane.add(slVerde);
		
		slAzul = new JSlider();
		slAzul.setValue(0);
		slAzul.setMinimum(0);
		slAzul.setMaximum(255);
		slAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfAzul.setText(String.valueOf(slAzul.getValue()));
				
				showCase.setBackground(new Color(slRojo.getValue(),
												slVerde.getValue(),
												slAzul.getValue()));
			}
		});
		slAzul.setBounds(68, 140, 200, 26);
		contentPane.add(slAzul);
		
		tfRojo = new JTextField();
		tfRojo.setHorizontalAlignment(SwingConstants.RIGHT);
		tfRojo.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {
				String texto = tfRojo.getText();
				
				if (texto.isBlank() || texto.isEmpty()) {
					texto = "0";
				}
				
				char c = e.getKeyChar();
				
				// Solo números
				if (c < '0' || c > '9') {
					e.consume();
				} else {
					int num = Integer.parseInt(texto + c);
					
					if (num > 255) e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = tfRojo.getText();
				
				if (texto.isBlank() || texto.isEmpty()) {
					texto = "0";
				}
				
				slRojo.setValue(Integer.parseInt(texto));
			}
		});
		tfRojo.setText("0");
		tfRojo.setBounds(278, 29, 86, 20);
		contentPane.add(tfRojo);
		tfRojo.setColumns(10);
		
		tfVerde = new JTextField();
		tfVerde.setHorizontalAlignment(SwingConstants.RIGHT);
		tfVerde.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {
				String texto = tfVerde.getText();
				
				if (texto.isBlank() || texto.isEmpty()) {
					texto = "0";
				}
				
				char c = e.getKeyChar();
				
				// Solo números
				if (c < '0' || c > '9') {
					e.consume();
				} else {
					int num = Integer.parseInt(texto + c);
					
					if (num > 255) e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = tfVerde.getText();
				
				if (texto.isBlank() || texto.isEmpty()) {
					texto = "0";
				}
				
				slVerde.setValue(Integer.parseInt(texto));
			}
		});
		tfVerde.setText("0");
		tfVerde.setColumns(10);
		tfVerde.setBounds(278, 81, 86, 20);
		contentPane.add(tfVerde);
		
		tfAzul = new JTextField();
		tfAzul.setHorizontalAlignment(SwingConstants.RIGHT);
		tfAzul.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {
				String texto = tfAzul.getText();
				
				if (texto.isBlank() || texto.isEmpty()) {
					texto = "0";
				}
				
				char c = e.getKeyChar();
				
				// Solo números
				if (c < '0' || c > '9') {
					e.consume();
				} else {
					int num = Integer.parseInt(texto + c);
					
					if (num > 255) e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = tfAzul.getText();
				
				if (texto.isBlank() || texto.isEmpty()) {
					texto = "0";
				}
				
				slAzul.setValue(Integer.parseInt(texto));
			}
		});
		tfAzul.setText("0");
		tfAzul.setColumns(10);
		tfAzul.setBounds(278, 140, 86, 20);
		contentPane.add(tfAzul);
		
		showCase = new JPanel();
		showCase.setBackground(new Color(0, 0, 0));
		showCase.setBounds(10, 186, 354, 176);
		contentPane.add(showCase);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						Ejercicio6.this,
						"¿Seguro que quieres salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) System.exit(EXIT_ON_CLOSE); 
			}
		});
		btnSalir.setBounds(463, 322, 111, 40);
		contentPane.add(btnSalir);
	}
}
