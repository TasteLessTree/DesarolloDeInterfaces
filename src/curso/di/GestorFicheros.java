package curso.di;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class GestorFicheros {
	private final String PATH;
	private String textoCompleto;
	private File fichero = null;
	private FileReader lector = null;
	private BufferedReader reader = null;
	
    public GestorFicheros() {
    	PATH = "src/curso/di/resources/Ejemplo.java";
    	textoCompleto = new String("");
    	fichero = new File(PATH);
    	lector = null;
    	reader = null;
    }
    
    public String getTextoFichero() {
    	// Leer fichero
    	// Retorna un String con el texto del fichero    	
    	try {
    		lector = new FileReader(fichero);
    		reader = new BufferedReader(lector);
    		
    		String line;
    		
    		while ((line = reader.readLine()) != null) {
    			textoCompleto += line + "\n";
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	} finally {
			try {
				if (null != lector) {
					lector.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    	return textoCompleto;
    }
    
    public Map<String, Integer> contarTipoChar(String texto) {
    	Map<String, Integer> mapa = new HashMap<String, Integer>();
    	
    	int vocales = 0;
		int consonantes = 0;
		int especiales = 0;
		int resto = 0;
		int numeros = 0;
		
		texto = texto.toLowerCase();
		for (int i = 0; i < texto.length(); i++) {
			char charActual = texto.charAt(i);
			 
			 if (charActual == 'a' || charActual == 'e' || charActual == 'i' || charActual == 'o' || charActual == 'u')
				 vocales++;
			 else if (charActual >= 'a' && charActual <= 'z')
				 consonantes++;
			 else if (charActual >= '0' && charActual <= '9')
				 numeros++;
			 else if(!Character.isLetter(charActual) && !Character.isWhitespace(charActual))
				 especiales++;
			 else
				resto++;
		}
			
		int total = vocales + consonantes + especiales + resto + numeros;
		
		mapa.put("Vocales", vocales);
		mapa.put("Consonantes", consonantes);
		mapa.put("Especiales", especiales);
		mapa.put("Resto", resto);
		mapa.put("Numeros", numeros);
		mapa.put("Total", total);
		
		return mapa;
    }
    
    
    public void setTextFichero() {
		//
	}
}