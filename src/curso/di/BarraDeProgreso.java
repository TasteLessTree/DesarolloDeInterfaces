package curso.di;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class BarraDeProgreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalir, btnAvanzar;
	private JProgressBar pbCuenta;
	private JLabel lblPorcentaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraDeProgreso frame = new BarraDeProgreso();
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
	public BarraDeProgreso() {
		setTitle("Ejercicio 8 - Barra de progreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						BarraDeProgreso.this,
						"¿Seguro que quieres salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) System.exit(EXIT_ON_CLOSE); 
			}
		});
		btnSalir.setBounds(321, 173, 89, 54);
		contentPane.add(btnSalir);
		
		pbCuenta = new JProgressBar();
		pbCuenta.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblPorcentaje.setText(String.valueOf(pbCuenta.getValue() + " %"));
			}
		});
		pbCuenta.setValue(0);
		pbCuenta.setMinimum(0);
		pbCuenta.setMaximum(100);
		pbCuenta.setBounds(10, 11, 361, 34);
		contentPane.add(pbCuenta);
		
		lblPorcentaje = new JLabel("%");
		lblPorcentaje.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 14));
		lblPorcentaje.setBounds(381, 11, 62, 34);
		contentPane.add(lblPorcentaje);
		
		btnAvanzar = new JButton("Avanzar");
		btnAvanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvanzarTareaBarraProgreso tarea1 = new AvanzarTareaBarraProgreso("Tarea 1", pbCuenta);
				tarea1.start();
			}
		});
		btnAvanzar.setBounds(10, 56, 89, 42);
		contentPane.add(btnAvanzar);

	}
}
