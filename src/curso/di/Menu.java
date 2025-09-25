package curso.di;
 
import java.awt.Color;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
 
public class Menu extends JFrame implements ActionListener { 
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menu1_opciones, menu2_windowSize, menu3_backgroundColor, menu4_salir;
	private JMenuItem mi1_size1, mi2_size2, mi3_rojo, mi4_verde, mi5_salir;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AndrésPérezM\\Downloads\\horario.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu desplegable");
		setBounds(100, 100, 710, 528);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 12));
		menuBar.setToolTipText("Opciones");
		menuBar.setBounds(20, 22, 100, 42);
		getContentPane().add(menuBar);
		
		menu1_opciones = new JMenu("Opciones");
		menu1_opciones.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 16));
		menuBar.add(menu1_opciones);
		
		menu2_windowSize = new JMenu("Tamaño de la ventana");
		menu2_windowSize.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 14));
		menu1_opciones.add(menu2_windowSize);
		
		mi1_size1 = new JMenuItem("640 x 480");
		mi1_size1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				camiarLaPantalla(e);
			}
		});
		mi1_size1.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 12));
		
		menu2_windowSize.add(mi1_size1);
		
		mi2_size2 = new JMenuItem("1024 x 768");
		mi2_size2.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 12));
		menu2_windowSize.add(mi2_size2);
		mi2_size2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				camiarLaPantalla(e);
			}
		});
		
		menu3_backgroundColor = new JMenu("Color de fondo");
		menu3_backgroundColor.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 14));
		menu1_opciones.add(menu3_backgroundColor);
		
		mi3_rojo = new JMenuItem("Rojo");
		mi3_rojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				camiarLaPantalla(e);
			}
		});
		mi3_rojo.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 12));
		menu3_backgroundColor.add(mi3_rojo);
		
		mi4_verde = new JMenuItem("Verde");
		mi4_verde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				camiarLaPantalla(e);
			}
		});
		mi4_verde.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 12));
		menu3_backgroundColor.add(mi4_verde);
		
		menu4_salir = new JMenu("Salir");
		menu4_salir.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 14));
		menu1_opciones.add(menu4_salir);
		
		mi5_salir = new JMenuItem("Salir");
		mi5_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null,
						"¿Seguro que desea salir?",
						"SALIR",
						JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		mi5_salir.setFont(new Font("JetBrainsMonoNL NF", Font.PLAIN, 12));
		menu4_salir.add(mi5_salir);
	}
	
	/* Action listener
	 * */
	public void camiarLaPantalla(ActionEvent e) {
		if (e.getSource() == mi1_size1) {
			setSize(640, 480);
		} else if (e.getSource()== mi2_size2) {
			setSize(1024, 768);
		} else if (e.getSource() == mi3_rojo) {
			getContentPane().setBackground(new Color(255, 0, 0));
		} else if (e.getSource() == mi4_verde) {
			getContentPane().setBackground(new Color(0, 255, 00));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		camiarLaPantalla(e);
	}
}