package curso.di.graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Ejemplo1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo1 frame = new Ejemplo1();
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
	public Ejemplo1() {
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Categoria 1", 43.2);
		data.setValue("Categoria 2", 59.0);
		data.setValue("Categoria 3", 25.5);
		
		JFreeChart chart = ChartFactory.createPieChart(getName(), data, data, ABORT, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
				
		
		ChartFrame frame = new ChartFrame("Primer Chat para Java", chart);
		frame.pack();
 
	}
}