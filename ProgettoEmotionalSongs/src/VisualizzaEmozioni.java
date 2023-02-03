import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import prog.io.ConsoleInputManager;

public class VisualizzaEmozioni {
public static void Visualizzaemozioni() throws IOException{
		ConsoleInputManager in = new ConsoleInputManager();
	  	String pathh = "C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\Emozioni.dati.txt";
		BufferedReader reader;
		File filee = new File(pathh);
		FileReader frr = new FileReader(filee);
		reader = new BufferedReader(frr);
		String line = reader.readLine();
		boolean trovata=false;
        String canzone = in.readLine("quale canzone vuoi ricercare?");
        Scanner b = new Scanner(filee);
        String now=null;
        while(line!=null&&trovata==false) {      	
        	for(int i=0; i<line.length();i++) {
        		if(line.length()!=canzone.length()||line.charAt(i)!=canzone.charAt(i)) {
        			trovata=false;
        		} else if(line.length()==canzone.length()&&line.charAt(i)==canzone.charAt(i)){    			
        			trovata=true;       			
        		}
        	} line=reader.readLine();
        }
        if(trovata==true) {
        	System.out.println("canzone trovata");
        	System.out.println("le emozioni di questa canzone sono:");
    			for (int i=0; i<10;i++) {
    				System.out.println(line);
    				line=reader.readLine();				
    		}  		
    		 }   	
         else if(trovata!=true) {
        	System.out.println("canzone non trovata");
        }	
	}	
}