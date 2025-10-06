package curso.di.practica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;

/** @author AndrésPérezM
 * Calculadora que convierte entre diferentes bases: de decimal a hexadecimal (y vice versa), etc.
 * */

public class Conversor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup bgBasesNumericas = new ButtonGroup();
	private JButton btnSalir, btnAutor, btnReset,
		btnA, btnB, btnC, btnD, btnE, btnF,
		btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private JLabel lblResultado, lblTitulo;
	private JRadioButton rdbtnDec, rdbtnHex, rdbtnBin, rdbtnOct, rdbtnActual, rdbtnSeleccionado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
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
	public Conversor() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(Conversor.this,
						"¿Seguro que desea salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == JOptionPane.YES_OPTION)
					System.exit(EXIT_ON_CLOSE);
				
				
			}
		});
		btnSalir.setBounds(10, 486, 70, 60);
		contentPane.add(btnSalir);
		
		btnAutor = new JButton("Autor");
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Conversor.this,
						"Código desarrollado por Andrés Pérez Mora.\nCon ayuda de Internet.");
			}
		});
		btnAutor.setBounds(226, 486, 70, 60);
		contentPane.add(btnAutor);
		
		rdbtnDec = new JRadioButton("DEC");
		rdbtnDec.setSelected(true); // Decimal por defecto
		rdbtnSeleccionado = rdbtnDec;
		rdbtnDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarBotones(rdbtnDec);
				hacerConversion(rdbtnActual, rdbtnSeleccionado);
				rdbtnSeleccionado = rdbtnActual;
			}
		});
		bgBasesNumericas.add(rdbtnDec);
		rdbtnDec.setBounds(10, 197, 70, 23);
		contentPane.add(rdbtnDec);
		
		rdbtnHex = new JRadioButton("HEX");
		rdbtnHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarBotones(rdbtnHex);	
				hacerConversion(rdbtnActual, rdbtnSeleccionado);
				rdbtnSeleccionado = rdbtnActual;
			}
		});
		bgBasesNumericas.add(rdbtnHex);
		rdbtnHex.setBounds(154, 197, 70, 23);
		contentPane.add(rdbtnHex);
		
		rdbtnBin = new JRadioButton("BIN");
		rdbtnBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarBotones(rdbtnBin);
				hacerConversion(rdbtnActual, rdbtnSeleccionado);
				rdbtnSeleccionado = rdbtnActual;
			}
		});
		bgBasesNumericas.add(rdbtnBin);
		rdbtnBin.setBounds(82, 197, 70, 23);
		contentPane.add(rdbtnBin);
		
		rdbtnOct = new JRadioButton("OCT");
		rdbtnOct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarBotones(rdbtnOct);
				hacerConversion(rdbtnActual, rdbtnSeleccionado);
				rdbtnSeleccionado = rdbtnActual;
			}
		});
		bgBasesNumericas.add(rdbtnOct);
		rdbtnOct.setBounds(226, 197, 70, 23);
		contentPane.add(rdbtnOct);
		
		btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btnA.getText());
				else
					lblResultado.setText(texto + btnA.getText());
			}
		});
		btnA.setBounds(10, 227, 45, 45);
		contentPane.add(btnA);
		
		btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btnB.getText());
				else
					lblResultado.setText(texto + btnB.getText());
			}
		});
		btnB.setBounds(65, 227, 45, 45);
		contentPane.add(btnB);
		
		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btnC.getText());
				else
					lblResultado.setText(texto + btnC.getText());
			}
		});
		btnC.setBounds(121, 227, 45, 45);
		contentPane.add(btnC);
		
		btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btnD.getText());
				else
					lblResultado.setText(texto + btnD.getText());
			}
		});
		btnD.setBounds(176, 227, 45, 45);
		contentPane.add(btnD);
		
		btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btnE.getText());
				else
					lblResultado.setText(texto + btnE.getText());
			}
		});
		btnE.setBounds(231, 227, 45, 45);
		contentPane.add(btnE);
		
		btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btnF.getText());
				else
					lblResultado.setText(texto + btnF.getText());
			}
		});
		btnF.setBounds(231, 274, 45, 45);
		contentPane.add(btnF);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn0.getText());
				else
					lblResultado.setText(texto + btn0.getText());
			}
		});
		btn0.setBounds(108, 439, 78, 40);
		contentPane.add(btn0);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn1.getText());
				else
					lblResultado.setText(texto + btn1.getText());
			}
		});
		btn1.setBounds(66, 388, 45, 45);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn2.getText());
				else
					lblResultado.setText(texto + btn2.getText());
			}
		});
		btn2.setBounds(121, 388, 45, 45);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn3.getText());
				else
					lblResultado.setText(texto + btn3.getText());
			}
		});
		btn3.setBounds(176, 388, 45, 45);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn4.getText());
				else
					lblResultado.setText(texto + btn4.getText());
			}
		});
		btn4.setBounds(66, 329, 45, 45);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn5.getText());
				else
					lblResultado.setText(texto + btn5.getText());
			}
		});
		btn5.setBounds(121, 329, 45, 45);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn6.getText());
				else
					lblResultado.setText(texto + btn6.getText());
			}
		});
		btn6.setBounds(176, 329, 45, 45);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn7.getText());
				else
					lblResultado.setText(texto + btn7.getText());
			}
		});
		btn7.setBounds(66, 274, 45, 45);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn8.getText());
				else
					lblResultado.setText(texto + btn8.getText());
			}
		});
		btn8.setBounds(121, 274, 45, 45);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = lblResultado.getText();
				if (texto.equals("0"))
					lblResultado.setText(btn9.getText());
				else
					lblResultado.setText(texto + btn9.getText());
			}
		});
		btn9.setBounds(176, 274, 45, 45);
		contentPane.add(btn9);
		
		lblResultado = new JLabel("0");
		lblResultado.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 16));
		lblResultado.setBounds(10, 129, 296, 52);
		contentPane.add(lblResultado);
		
		lblTitulo = new JLabel("Conversor");
		lblTitulo.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 30));
		lblTitulo.setBounds(10, 11, 454, 107);
		contentPane.add(lblTitulo);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("0");
				rdbtnActual = rdbtnDec;
				rdbtnDec.setSelected(true);
				activarBotones(rdbtnActual);
			}
		});
		btnReset.setBounds(108, 486, 78, 60);
		contentPane.add(btnReset);
		
		activarBotones(rdbtnDec); // Asegurar que las letras están desactivadas cuando el conversor se inicia por primera vez
	}
	
	// Hacer la conversion
	// https://es.stackoverflow.com/questions/32796/c%C3%B3mo-pasar-de-decimal-a-binario-en-java
	// Según internet primero pasas a decimal y luego a la base que quieras (binario -> decimal -> hexadecimal)
	private void hacerConversion(JRadioButton actual, JRadioButton seleccionado) {
		if (seleccionado == rdbtnDec) {
			if (actual == rdbtnBin) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto);
				lblResultado.setText(Integer.toBinaryString(decimal));
			} else if (actual == rdbtnHex) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto);
				lblResultado.setText(Integer.toHexString(decimal).toUpperCase());
			} else if (actual == rdbtnOct) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto);
				lblResultado.setText(Integer.toOctalString(decimal));
			}
			
		} else if (seleccionado == rdbtnBin) {
			if (actual == rdbtnDec) {
				String texto = lblResultado.getText();
				int resultado = Integer.parseInt(texto, 2);
				lblResultado.setText(String.valueOf(resultado));
			} else if (actual == rdbtnHex) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 2);
				lblResultado.setText(Integer.toHexString(decimal).toUpperCase());
			} else if (actual == rdbtnOct) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 2);
				lblResultado.setText(Integer.toOctalString(decimal));
			}
			
		} else if (seleccionado == rdbtnOct) {
			if (actual == rdbtnDec) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 8);
				lblResultado.setText(String.valueOf(decimal));
			} else if (actual == rdbtnBin) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 8);
				lblResultado.setText(Integer.toBinaryString(decimal));
			} else if (actual == rdbtnHex) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 8);
				lblResultado.setText(Integer.toHexString(decimal).toUpperCase());
			}
			
		} else if (seleccionado == rdbtnHex) {
			if (actual == rdbtnDec) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 16);
				lblResultado.setText(String.valueOf(decimal));
			} else if (actual == rdbtnBin) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 16);
				lblResultado.setText(Integer.toBinaryString(decimal));
			} else if (actual == rdbtnOct) {
				String texto = lblResultado.getText();
				int decimal = Integer.parseInt(texto, 16);
				lblResultado.setText(Integer.toOctalString(decimal));
			}
		}
	}
	
	// Activar o desactivar los botones según el RadioButton seleccionado
	private void activarBotones(JRadioButton rdbtn) {
		if (rdbtn == rdbtnDec) {
			btnA.setEnabled(false);
			btnB.setEnabled(false);
			btnC.setEnabled(false);
			btnD.setEnabled(false);
			btnE.setEnabled(false);
			btnF.setEnabled(false);
			
			btn0.setEnabled(true);
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
			btn4.setEnabled(true);
			btn5.setEnabled(true);
			btn6.setEnabled(true);
			btn7.setEnabled(true);
			btn8.setEnabled(true);
			btn9.setEnabled(true);
			
			rdbtnActual = rdbtnDec;
		} else if (rdbtn == rdbtnBin) {
			btnA.setEnabled(false);
			btnB.setEnabled(false);
			btnC.setEnabled(false);
			btnD.setEnabled(false);
			btnE.setEnabled(false);
			btnF.setEnabled(false);
			
			btn0.setEnabled(true);
			btn1.setEnabled(true);
			btn2.setEnabled(false);
			btn3.setEnabled(false);
			btn4.setEnabled(false);
			btn5.setEnabled(false);
			btn6.setEnabled(false);
			btn7.setEnabled(false);
			btn8.setEnabled(false);
			btn9.setEnabled(false);
			
			rdbtnActual = rdbtnBin;
		} else if (rdbtn == rdbtnOct) {
			btnA.setEnabled(false);
			btnB.setEnabled(false);
			btnC.setEnabled(false);
			btnD.setEnabled(false);
			btnE.setEnabled(false);
			btnF.setEnabled(false);
			
			btn0.setEnabled(true);
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
			btn4.setEnabled(true);
			btn5.setEnabled(true);
			btn6.setEnabled(true);
			btn7.setEnabled(true);
			btn8.setEnabled(false);
			btn9.setEnabled(false);
			
			rdbtnActual = rdbtnOct;
		} else if (rdbtn == rdbtnHex) {
			btnA.setEnabled(true);
			btnB.setEnabled(true);
			btnC.setEnabled(true);
			btnD.setEnabled(true);
			btnE.setEnabled(true);
			btnF.setEnabled(true);
			
			btn0.setEnabled(true);
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
			btn4.setEnabled(true);
			btn5.setEnabled(true);
			btn6.setEnabled(true);
			btn7.setEnabled(true);
			btn8.setEnabled(true);
			btn9.setEnabled(true);
			
			rdbtnActual = rdbtnHex;
		}
	}
}