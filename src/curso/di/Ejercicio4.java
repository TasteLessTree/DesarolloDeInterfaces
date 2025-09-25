package curso.di;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ejercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private enum Meses {
		ENERO,
		FEBRERO,
		MARZO,
		ABRIL,
		MAYO,
		JUNIO,
		JULIO,
		AGOSTO,
		SEPTIEMBRE,
		OCTUBRE,
		NOVIEMBRE,
		DICIEMBRE
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setTitle("Elegir un mes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox_meses = new JComboBox();
		comboBox_meses.setModel(new DefaultComboBoxModel(Meses.values()));
		comboBox_meses.setBounds(10, 11, 190, 34);
		contentPane.add(comboBox_meses);
		
		JButton btnMesElegido = new JButton("Mes elegido");
		btnMesElegido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						Ejercicio4.this,
						comboBox_meses.getSelectedItem()
						);	
			}
		});
		btnMesElegido.setBounds(249, 8, 111, 40);
		contentPane.add(btnMesElegido);
		
		JButton btnSali = new JButton("Salir");
		btnSali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						Ejercicio4.this,
						"¿Seguro que quieres salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) System.exit(EXIT_ON_CLOSE); 
			}
		});
		btnSali.setBounds(413, 11, 111, 40);
		contentPane.add(btnSali);

	}
}