package curso.di;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Ejercicio7 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalir, btnPasarUnElemento, btnPasarTodosElementos;
	private JLabel lblPersonajes, lblPersonajesSeleccionados;
	private JScrollPane spPersonajes;
	private JScrollPane spPersonajesSeleccionados;
	private DefaultListModel<Personajes> listModel;
	private JList<Personajes> listPersonajes;
	private JList<Personajes> listPersonajesSeleccionados;
	
	private enum Personajes {
		Altair_Ibn_Lahad,
		Ezio_Auditore_da_Firenze,
		Connor_Kennway,
		Edward_Kennway,
		Shay_Patrick_Cormac,
		Arno_Victor_Dorian,
		Jacob_Frye,
		Evie_Frye,
		Bayek_de_Siwa,
		Aya,
		Kassandra,
		Eivor,
		Basim_Ibn_Ishaq,
		Fujibayashi_Naeo,
		Yasuke
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7 frame = new Ejercicio7();
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
	public Ejercicio7() {
		setTitle("Ejercicio 7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						Ejercicio7.this,
						"¿Seguro que quieres salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0) System.exit(EXIT_ON_CLOSE); 
			}
		});
		btnSalir.setBounds(587, 376, 77, 54);
		contentPane.add(btnSalir);
		
		btnPasarUnElemento = new JButton(">");
		btnPasarUnElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personajes personaje = listPersonajes.getSelectedValue();
				int indice = listPersonajes.getSelectedIndex();
				
				if (personaje == null) {
					JOptionPane.showMessageDialog(
							Ejercicio7.this,
							"No has seleccionado ningún personaje"
							);	
				} else {
					listModel.remove(indice);
					listModel.addElement(personaje);
				}
			}
		});
		btnPasarUnElemento.setBounds(258, 100, 89, 23);
		contentPane.add(btnPasarUnElemento);
		
		btnPasarTodosElementos = new JButton(">>");
		btnPasarTodosElementos.setBounds(258, 179, 89, 23);
		contentPane.add(btnPasarTodosElementos);
		
		lblPersonajes = new JLabel("Selecciona un personaje");
		lblPersonajes.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 16));
		lblPersonajes.setBounds(10, 11, 233, 54);
		contentPane.add(lblPersonajes);
		
		lblPersonajesSeleccionados = new JLabel("Personajes seleccionados");
		lblPersonajesSeleccionados.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 16));
		lblPersonajesSeleccionados.setBounds(357, 11, 284, 54);
		contentPane.add(lblPersonajesSeleccionados);
		
		listModel = new DefaultListModel<>();
		
		spPersonajes = new JScrollPane();
		spPersonajes.setBounds(10, 76, 221, 222);
		contentPane.add(spPersonajes);
		
		listPersonajes = new JList<Personajes>(listModel);
		spPersonajes.setViewportView(listPersonajes);
		
		spPersonajesSeleccionados = new JScrollPane();
		spPersonajesSeleccionados.setBounds(367, 76, 221, 222);
		contentPane.add(spPersonajesSeleccionados);
		
		listPersonajesSeleccionados = new JList<>(listModel);
		spPersonajesSeleccionados.setViewportView(listPersonajesSeleccionados);

	}
}
