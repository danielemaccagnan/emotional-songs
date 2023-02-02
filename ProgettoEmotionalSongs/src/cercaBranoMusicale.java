import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class cercaBranoMusicale extends Registrazione {

	

	public static void main(String[] args) throws IOException {
		
		cercaBranoMusicale("Pneumonia Blues");
 cercaBranoMusicaleAnno(1929,"Blind Lemon Jefferson");
	}
	
	
	public static void cercaBranoMusicale(String titolo) throws IOException {
		
		String path = "C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\Canzoni.txt";
		BufferedReader reader;
		int hash = 0;
		boolean flag =true;			//true non ha ancora stampato una linea, false si
		
		
			File file = new File(path);
			FileReader fr = new FileReader(file);
			reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			int cont=0;
			
			
			//Partenza scorrimento file
			
			while (line != null) {
				boolean uguale=true;		
				int h=line.length()-1;
				// i : posizione carattere linea
				//j : posizione carattere input 
				// x : parte da zero e scorre tutto il titolo
				for (int i=line.length()-1, j=titolo.length()-1, x=0; x<titolo.length();i--,j--, x++) {
				
				if(line.charAt(i)=='>'&& h-i==j) {
					break;
				} if(line.charAt(i)!=titolo.charAt(j)) {
					uguale=false;
					break;
				}
				} 
				char c='>';
				if (line.charAt(line.length()-titolo.length()-1)!=c) {
					uguale=false;
				}
				
				//Titolo trovato
				// posizione 32 in line è il primo carattere dell'autore
				
				if(uguale==true) {
					if(flag) {
						flag = false;
						hash = line.substring(32).hashCode();
						System.out.println(line);
						cont++;			
						//stampa già avvenuta
					}else {
						
						if(line.substring(32).hashCode() != hash) {
							System.out.println(line);
							flag = true;
						}	
				}
			}
					line=reader.readLine();
					if(line==null&&cont==0) {
						System.out.println("non è stata trovata nessuna canzone");
						break;
					}
				}	
	}
	public static void cercaBranoMusicaleAnno(int anno, String autore) throws IOException {	
			String path = "C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\Canzoni.txt";
			BufferedReader reader;
			int hash = 0;
			boolean flag = true;	
			File file = new File(path);
			FileReader fr = new FileReader(file);
			reader = new BufferedReader(fr);
			String line = reader.readLine();
			String annoo = String.valueOf(anno);
			int cont=0;
			while (line != null) {
				boolean uguale=true;
				boolean ugualee = true;
				for (int i=0; i<annoo.length();i++) {
					if(line.charAt(i)!=annoo.charAt(i)) {
						uguale=false;
						break;
					}
				}		
				for (int i=32, j=0; j<autore.length();i++,j++) {
					if(line.charAt(i)!=autore.charAt(j)) {
						ugualee=false;
						break;
				}
					}
				int p=32+autore.length();
				if (ugualee==true) {
				char l='<';
				if(line.charAt(p)!=l) {
					ugualee=false;
					break; 
					} 				
				}								
				if(uguale==true && ugualee==true) {			
					if(flag) {					
						flag = false;
						hash = line.substring(32).hashCode();
						System.out.println(line);
						cont++;						
					}else {
						
						if(line.substring(32).hashCode() != hash) {
							
							System.out.println(line);
							cont++;
						}
				}
			}
					line=reader.readLine();				
				}
			if(reader.readLine()==null&&cont==0) 
				System.out.println("non è stata trovata nessuna canzone");
	}
}


