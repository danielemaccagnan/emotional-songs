package ProgettoEmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import prog.io.ConsoleInputManager;

/**
 * @author danym
 *classe che fornisce il servizio per visualizzare emozioni relative a un brano,attraverso il metodo Visualizzaemozioni
 */

public class VisualizzaEmozioni {
	
	/**
	 *metodo che ritorna a schermo le emozioni relative a un brano ,lette dal file emozioni.dati.txt 
	 * @return void
	 * @throws IOException
	 */
	public static void Visualizzaemozioni() throws IOException{
	
		ConsoleInputManager in = new ConsoleInputManager();
		
		//apertura stream lettura
		File file = new File("Emozioni.dati.txt");
		if(!file.exists())
			file.createNewFile();
		
		String path = file.getAbsolutePath();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		boolean trovata=false;
		int cont=0;
        String canzone = in.readLine("quale canzone vuoi ricercare?");
        
        while(line!=null) {      	
        	for(int i=0; i<line.length();i++) {
        		if(line.length()!=canzone.length()||line.charAt(i)!=canzone.charAt(i)) {
        			trovata=false;
        		} else if(line.length()==canzone.length()&&line.charAt(i)==canzone.charAt(i)){    			
        			trovata=true;       			
        		}
        	} line=reader.readLine();
        
        if(trovata==true) {
        	System.out.println("\n"+ "canzone trovata");
        	System.out.println("le emozioni della canzone " + canzone + " sono:");
    			for (int i=0; i<10;i++) {
    				
    				System.out.println(line);
    				line=reader.readLine();	
    				cont++;
    		}  		
    	}   	
     }
   	if(cont==0) 
   		System.out.println("non è stata trovata nessuna canzone");
     reader.close();
	}	
}