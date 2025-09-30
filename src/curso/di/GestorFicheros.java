package curso.di;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorFicheros {
	private final String PATH;
	private String textoCompleto;
	private File fichero = null;
	private FileReader reader = null;
	private BufferedReader buffered = null;
	private FileWriter writer = null;
	
    public GestorFicheros() {
    	PATH = "src/curso/di/resources/texto.txt";
    	textoCompleto = new String("");
    	fichero = null;
    	reader = null;
    	buffered = null;
    	writer = null;
    }
    
    public String getTextoFichero() {
    	// Leer fichero
    	// Retorna un String con el texto del fichero
    	String texto;
    	
    	fichero = new File(PATH);
    	
    	try (BufferedReader reader = new FileReader(fichero)) {
    		String line;
    		
    		while ((line = reader.readLine()) != null) {
    			texto += line;
    		}
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}
    	
    	return texto;
    }
}