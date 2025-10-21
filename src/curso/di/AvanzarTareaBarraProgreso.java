package curso.di;

import javax.swing.JProgressBar;

public class AvanzarTareaBarraProgreso extends Thread {
	private String nombre;
	private JProgressBar progressBar;
	
	
	public AvanzarTareaBarraProgreso() {
		this.nombre = "Tarea Predeterminada";
	}
	
	public AvanzarTareaBarraProgreso(String nombre) {
		this.nombre = nombre;
	}
	
	public AvanzarTareaBarraProgreso(String nombre, JProgressBar progressBar) {
		this.nombre = nombre;
		this.progressBar = progressBar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	// Sobre cargar el método "run"
	public void run() {
		for (int i = 1; i <= 100; i++) {			
			try {
				sleep(100);
				progressBar.setValue(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}