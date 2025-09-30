<<<<<<< HEAD
package curso.di;
 
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
 
public class Saludar extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JTextField mensajeUsuario;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saludar frame = new Saludar();
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
	public Saludar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AndrésPérezM\\eclipse-workspace\\DesarrolloDeInterfaces\\src\\curso\\di\\assets\\minecraft.png"));
		setTitle("Hola Mundo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 528);
		getContentPane().setLayout(null);
		
		mensajeUsuario = new JTextField();
		mensajeUsuario.setBounds(25, 83, 635, 48);
		getContentPane().add(mensajeUsuario);
		mensajeUsuario.setColumns(10);
		
		JButton saludarButton = new JButton("Saludar");
		saludarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeUsuario.setText("Hola, ¿Cómo estas?");
			}
		});
		saludarButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		saludarButton.setBounds(25, 320, 119, 54);
		getContentPane().add(saludarButton);
		
		JButton adiosButton = new JButton("Adios");
		adiosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeUsuario.setText("Adios. Buenas tardes");
			}
		});
		adiosButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		adiosButton.setBounds(154, 320, 119, 54);
		getContentPane().add(adiosButton);
		
		JButton dialogo1Button = new JButton("Dialogo1");
		dialogo1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = mensajeUsuario.getText();
				JOptionPane.showMessageDialog(Saludar.this,
						string);
				
			}
		});
		dialogo1Button.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		dialogo1Button.setBounds(283, 320, 119, 54);
		getContentPane().add(dialogo1Button);
		
		JButton dialogo2Button = new JButton("Dialogo2");
		dialogo2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog(Saludar.this,
						"Escribe algo");
				mensajeUsuario.setText(s);
			}
		});
		dialogo2Button.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		dialogo2Button.setBounds(412, 320, 119, 54);
		getContentPane().add(dialogo2Button);
		
		JButton salirButton = new JButton("Salir");
		salirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						Saludar.this,
						"¿Seguro que desea salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		salirButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		salirButton.setBounds(541, 320, 119, 54);
		getContentPane().add(salirButton);
 
	}
=======
package curso.di;
 
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
 
public class Saludar extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JTextField mensajeUsuario;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saludar frame = new Saludar();
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
	public Saludar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AndrésPérezM\\eclipse-workspace\\DesarrolloDeInterfaces\\src\\curso\\di\\assets\\minecraft.png"));
		setTitle("Hola Mundo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 528);
		getContentPane().setLayout(null);
		
		mensajeUsuario = new JTextField();
		mensajeUsuario.setBounds(25, 83, 635, 48);
		getContentPane().add(mensajeUsuario);
		mensajeUsuario.setColumns(10);
		
		JButton saludarButton = new JButton("Saludar");
		saludarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeUsuario.setText("Hola, ¿Cómo estas?");
			}
		});
		saludarButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		saludarButton.setBounds(25, 320, 119, 54);
		getContentPane().add(saludarButton);
		
		JButton adiosButton = new JButton("Adios");
		adiosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeUsuario.setText("Adios. Buenas tardes");
			}
		});
		adiosButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		adiosButton.setBounds(154, 320, 119, 54);
		getContentPane().add(adiosButton);
		
		JButton dialogo1Button = new JButton("Dialogo1");
		dialogo1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = mensajeUsuario.getText();
				JOptionPane.showMessageDialog(Saludar.this,
						string);
				
			}
		});
		dialogo1Button.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		dialogo1Button.setBounds(283, 320, 119, 54);
		getContentPane().add(dialogo1Button);
		
		JButton dialogo2Button = new JButton("Dialogo2");
		dialogo2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog(Saludar.this,
						"Escribe algo");
				mensajeUsuario.setText(s);
			}
		});
		dialogo2Button.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		dialogo2Button.setBounds(412, 320, 119, 54);
		getContentPane().add(dialogo2Button);
		
		JButton salirButton = new JButton("Salir");
		salirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						Saludar.this,
						"¿Seguro que desea salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		salirButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		salirButton.setBounds(541, 320, 119, 54);
		getContentPane().add(salirButton);
 
	}
>>>>>>> cdbac74ffc4e85b8f9f99bf9b4503fb069d3fef2
}