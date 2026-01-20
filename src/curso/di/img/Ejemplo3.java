package curso.di.img;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel lblImagen;
	private JButton btnAbrirImagen;
	
	private JFileChooser jfChooser = new JFileChooser(FileSystemView.getFileSystemView());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo3 frame = new Ejemplo3();
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
	public Ejemplo3() {
		// Filtro
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images",
				"jpg", "gif", "jpeg", "png", "webp");
		jfChooser.setFileFilter(filter);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		btnAbrirImagen = new JButton("Abrir imagen");
		btnAbrirImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				int respuesta = jfChooser.showOpenDialog(Ejemplo3.this);
				
				if (respuesta == JFileChooser.APPROVE_OPTION) {
					String rutaImagen = jfChooser.getSelectedFile().getPath();
					
					if (rutaImagen != null) {
						ImageIcon imageIcon = new ImageIcon(rutaImagen);
						Image image = imageIcon.getImage();
						int ancho = image.getWidth(contentPane);
						int alto = image.getHeight(contentPane);
						
						Image imagenEscalada = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
						imageIcon = new ImageIcon(imagenEscalada);
						
						lblImagen.setIcon(imageIcon);
					} else {
						System.err.println("Error, la ruta a la imagen no existe");
					}
				}
			}
		});
		contentPane.add(btnAbrirImagen);
		
		lblImagen = new JLabel("");
		contentPane.add(lblImagen);
	}
}