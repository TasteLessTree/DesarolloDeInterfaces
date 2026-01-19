package curso.di.img;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 frame = new Ejemplo2();
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
	public Ejemplo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		lblImagen = new JLabel();
		contentPane.add(lblImagen);
		
		JButton btnAC = new JButton("Assassin's Creed");
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarImagen("ac_shadows");
			}
		});
		contentPane.add(btnAC);
		
		JButton btnSpongeBob = new JButton("Sponge Bob");
		btnSpongeBob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarImagen("spongebob_money");
			}
		});
		contentPane.add(btnSpongeBob);
		
		JButton btnMinecraft = new JButton("Minecraft");
		btnMinecraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarImagen("cool_minecraft_wallpaper");
			}
		});
		contentPane.add(btnMinecraft);
	}
	
	// Cambiar Imagen
	private void cambiarImagen(String imagen) {		
		String fichero = "/curso/di/images/" + imagen + ".jpg";
		ImageIcon imageIcon = new ImageIcon(Ejemplo2.class.getResource(fichero));
		
		Image image = imageIcon.getImage();
		int ancho = image.getWidth(contentPane);
		int alto = image.getHeight(contentPane);
		
		Image imagenEscalada = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(imagenEscalada);
		
		lblImagen.setIcon(imageIcon);
	}
}