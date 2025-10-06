package curso.di;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupES = new ButtonGroup();
	private final ButtonGroup buttonGroupEN = new ButtonGroup();
	private JRadioButton rdbtnRojo, rdbtnVerde, rdbtnAzul, rdbtnAmarillo, rdbtnMorado, rdbtnRed, rdbtnGreen, rdbtnBlue, rdbtnYellow, rdbtnPurple;
	private JButton btnSelection, btnSelectionEN, btnSalir, btnExit;
	private Panel showCase;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
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
	public Ejercicio3() {
		setTitle("clique");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnRojo = new JRadioButton("Rojo");
		buttonGroupES.add(rdbtnRojo);
		rdbtnRojo.setBounds(6, 7, 58, 57);
		contentPane.add(rdbtnRojo);
		
		rdbtnVerde = new JRadioButton("Verde");
		buttonGroupES.add(rdbtnVerde);
		rdbtnVerde.setBounds(6, 72, 85, 57);
		contentPane.add(rdbtnVerde);
		
		rdbtnAzul = new JRadioButton("Azul");
		buttonGroupES.add(rdbtnAzul);
		rdbtnAzul.setBounds(6, 140, 64, 57);
		contentPane.add(rdbtnAzul);
		
		btnSelection = new JButton("Color Elegido");
		btnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensajeString = "";
				
				if (rdbtnRojo.isSelected()) {
					mensajeString = "Color: " + rdbtnRojo.getText();
					showCase.setBackground(new Color(255, 0, 0));
				} else if (rdbtnVerde.isSelected()) {
					mensajeString = "Color: " + rdbtnVerde.getText();
					showCase.setBackground(new Color(0, 255, 0));
				} else if (rdbtnAzul.isSelected()) {
					mensajeString = "Color: " + rdbtnAzul.getText();
					showCase.setBackground(new Color(0, 0, 255));
				} else if(rdbtnAmarillo.isSelected()) {
					mensajeString = "Color: " + rdbtnAmarillo.getText();
					showCase.setBackground(new Color(255, 255, 0));
				}else if(rdbtnMorado.isSelected()) {
					mensajeString = "Color: " + rdbtnMorado.getText();
					showCase.setBackground(new Color(147, 112, 219));
				} else {
					mensajeString = "NO HAS ELEGIDO NINGÚN COLOR";
				}
				
				JOptionPane.showInternalMessageDialog(getParent(),
						mensajeString);
			}
		});
		btnSelection.setBounds(91, 3, 168, 64);
		contentPane.add(btnSelection);
		
		rdbtnRed = new JRadioButton("Red");
		buttonGroupEN.add(rdbtnRed);
		rdbtnRed.setBounds(401, 7, 58, 57);
		contentPane.add(rdbtnRed);
		
		rdbtnGreen = new JRadioButton("Green");
		buttonGroupEN.add(rdbtnGreen);
		rdbtnGreen.setBounds(401, 72, 85, 57);
		contentPane.add(rdbtnGreen);
		
		rdbtnBlue = new JRadioButton("Blue");
		buttonGroupEN.add(rdbtnBlue);
		rdbtnBlue.setBounds(401, 132, 64, 57);
		contentPane.add(rdbtnBlue);
		
		btnSelectionEN = new JButton("Chosen Color");
		btnSelectionEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensajeString = "";
				
				if (rdbtnRed.isSelected()) {
					mensajeString = "Color: " + rdbtnRed.getText();
					showCase.setBackground(new Color(255, 0, 0));
				} else if (rdbtnGreen.isSelected()) {
					mensajeString = "Color: " + rdbtnGreen.getText();
					showCase.setBackground(new Color(0, 255, 0));
				} else if (rdbtnBlue.isSelected()) {
					mensajeString = "Color: " + rdbtnBlue.getText();
					showCase.setBackground(new Color(0, 0, 255));
				} else if (rdbtnYellow.isSelected()) {
					mensajeString = "Color: " + rdbtnYellow.getText();
					showCase.setBackground(new Color(255, 255, 0));
				} else if (rdbtnPurple.isSelected()) {
					mensajeString = "Color: " + rdbtnPurple.getText();
					showCase.setBackground(new Color(147, 112, 219));
				} else {
					mensajeString = "YOU HAVE NOT CHOSEN ANY COLOR";
				}
				
				JOptionPane.showInternalMessageDialog(getParent(),
						mensajeString);
			}
		});
		btnSelectionEN.setBounds(492, 11, 168, 64);
		contentPane.add(btnSelectionEN);
		
		showCase = new Panel();
		showCase.setBounds(6, 432, 654, 168);
		contentPane.add(showCase);
		
		rdbtnAmarillo = new JRadioButton("Amarillo");
		buttonGroupES.add(rdbtnAmarillo);
		rdbtnAmarillo.setBounds(6, 207, 85, 57);
		contentPane.add(rdbtnAmarillo);
		
		rdbtnYellow = new JRadioButton("Yellow");
		buttonGroupEN.add(rdbtnYellow);
		rdbtnYellow.setBounds(401, 207, 64, 57);
		contentPane.add(rdbtnYellow);
		
		rdbtnMorado = new JRadioButton("Morado");
		buttonGroupES.add(rdbtnMorado);
		rdbtnMorado.setBounds(6, 287, 85, 57);
		contentPane.add(rdbtnMorado);
		
		rdbtnPurple = new JRadioButton("Purple");
		buttonGroupEN.add(rdbtnPurple);
		rdbtnPurple.setBounds(401, 287, 64, 57);
		contentPane.add(rdbtnPurple);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null,
						"¿Seguro que desea salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(6, 362, 168, 64);
		contentPane.add(btnSalir);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to exit?",
						"EXIT",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(492, 362, 168, 64);
		contentPane.add(btnExit);

	}
}