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
	private JButton btnSalir, btnPasarUnElemento, btnPasarTodosElementos, btnPasarIzquierda, btnPasarTodoIzquierda;
	private JLabel lblPersonajes, lblPersonajesSeleccionados;
	private JScrollPane spPersonajes;
	private JScrollPane spPersonajesSeleccionados;
	private DefaultListModel<String> dlistPersonajes;
	private DefaultListModel<String> dlistSeleccionados;
	private JList<String> listPersonajes;
	private JList<String> listPersonajesSeleccionados;
	private JButton btnInsertar;
	private JButton btnInsertarIzquierda;
	
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
		Fujibayashi_Naoe,
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
				insertarUnElemento(listPersonajes, dlistPersonajes, dlistSeleccionados);
			}
		});
		btnPasarUnElemento.setBounds(258, 100, 89, 23);
		contentPane.add(btnPasarUnElemento);
		
		btnPasarTodosElementos = new JButton(">>");
		btnPasarTodosElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				moverTodos(dlistPersonajes, dlistSeleccionados);
			}
		});
		btnPasarTodosElementos.setBounds(258, 134, 89, 23);
		contentPane.add(btnPasarTodosElementos);
		
		lblPersonajes = new JLabel("Selecciona un personaje");
		lblPersonajes.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 16));
		lblPersonajes.setBounds(10, 11, 233, 54);
		contentPane.add(lblPersonajes);
		
		lblPersonajesSeleccionados = new JLabel("Personajes seleccionados");
		lblPersonajesSeleccionados.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 16));
		lblPersonajesSeleccionados.setBounds(357, 11, 284, 54);
		contentPane.add(lblPersonajesSeleccionados);
		
		dlistPersonajes = new DefaultListModel<String>();			
		dlistSeleccionados = new DefaultListModel<String>();
		
		spPersonajes = new JScrollPane();
		spPersonajes.setBounds(10, 76, 221, 222);
		contentPane.add(spPersonajes);
		
		listPersonajes = new JList<>(dlistPersonajes);
		spPersonajes.setViewportView(listPersonajes);
		
		spPersonajesSeleccionados = new JScrollPane();
		spPersonajesSeleccionados.setBounds(367, 76, 221, 222);
		contentPane.add(spPersonajesSeleccionados);
		
		listPersonajesSeleccionados = new JList<>(dlistSeleccionados);
		spPersonajesSeleccionados.setViewportView(listPersonajesSeleccionados);
		
		btnPasarIzquierda = new JButton("<");
		btnPasarIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarUnElemento(listPersonajesSeleccionados, dlistSeleccionados, dlistPersonajes);
			}
		});
		btnPasarIzquierda.setBounds(258, 168, 89, 23);
		contentPane.add(btnPasarIzquierda);
		
		btnPasarTodoIzquierda = new JButton("<<");
		btnPasarTodoIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				moverTodos(dlistSeleccionados, dlistPersonajes);
			}
		});
		btnPasarTodoIzquierda.setBounds(258, 202, 89, 23);
		contentPane.add(btnPasarTodoIzquierda);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarUnElementoSegunTexto(dlistPersonajes);
			}
		});
		btnInsertar.setBounds(10, 309, 89, 23);
		contentPane.add(btnInsertar);
		
		btnInsertarIzquierda = new JButton("Insertar");
		btnInsertarIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarUnElementoSegunTexto(dlistSeleccionados);
			}
		});
		btnInsertarIzquierda.setBounds(367, 309, 89, 23);
		contentPane.add(btnInsertarIzquierda);

		// Seguramente exista una forma más fácil de hacer esto
		dlistPersonajes.addElement(Personajes.Altair_Ibn_Lahad.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Ezio_Auditore_da_Firenze.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Connor_Kennway.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Edward_Kennway.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Shay_Patrick_Cormac.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Arno_Victor_Dorian.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Jacob_Frye.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Evie_Frye.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Bayek_de_Siwa.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Aya.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Kassandra.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Eivor.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Basim_Ibn_Ishaq.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Fujibayashi_Naoe.toString().replace("_", " "));
		dlistPersonajes.addElement(Personajes.Yasuke.toString().replace("_", " "));
	}
	
	private void insertarUnElemento(JList<String> lista, DefaultListModel<String> origen, DefaultListModel<String> destino) {
		String personaje = lista.getSelectedValue();
		
		if (personaje == null) {
			JOptionPane.showMessageDialog(
					Ejercicio7.this,
					"No has seleccionado ningún personaje"
					);	
		} else {			
			for (int i : lista.getSelectedIndices()) {
				destino.addElement(origen.get(i).toString());
				origen.remove(lista.getSelectedIndex());
			}
		}
	}
	
	private void moverTodos(DefaultListModel<String> origen, DefaultListModel<String> destino) {
		if (origen.getSize() == 0) {
			JOptionPane.showMessageDialog(
					Ejercicio7.this,
					"La lista está vacía"
					);	
		} else {					
			String[] todosElememtos = new String[origen.getSize()];
			for (int i = 0; i < origen.getSize(); i++) {
				todosElememtos[i] = origen.getElementAt(i);
			}
			
			for (int i = 0; i < todosElememtos.length; i++) {
				destino.addElement(todosElememtos[i]);
			}
			origen.removeAllElements();
		}
	}
	
	private void insertarUnElementoSegunTexto(DefaultListModel<String> origen) {
		String mensaje = JOptionPane.showInputDialog(Ejercicio7.this,
				"Escribe el nombre de un personaje:");
		origen.addElement(mensaje);
	}
}
