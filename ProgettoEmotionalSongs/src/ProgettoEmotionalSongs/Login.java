package ProgettoEmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import prog.io.ConsoleInputManager;
/** 
* @author daniele maccagnan 749722
* Classe che fornisce il servizio di login al programma , tramite il metodo login()
*
*/
public class Login {
	/**
	 * campo statico, contente il separatore tra i dati del file UtentiRegistrati.dati.txt
	 * 
	 */
	
	private static String separatore = "/";
	
	
	/**
  	 * 
  	 * metodo statico che fornisce il servizio di login tramite la ricerca di utente e password contenuti nel file UtentiRegistrati.dati.txt
  	 * ritorna, in caso di credenziali errate una stampa apposita e il valore false, true altrimenti
  	 * @throws IOException
  	 */
	public static boolean login() throws IOException {
			
			
		ConsoleInputManager in = new ConsoleInputManager();
		String username=in.readLine("inserisci user");
		String password = in.readLine("inserisci password");
		
		//creazione oggetto file
		File file = new File("UtentiRegistrati.dati.txt");
		if(!file.exists())
			file.createNewFile();
		
		//apertura stream in lettura
		String path = file.getAbsolutePath();
		BufferedReader br= new BufferedReader(new FileReader(path));
		String line = br.readLine();
		
		boolean login=false;
		
		while(line!=null&&login==false) {
			
			 login=true;
			 String[] result = line.split(separatore);
			 
			 if(!(result[9].equals(username) && result[10].equals(password)))
				 
				 login = false;
			
			line=br.readLine();
						   
				
			} if(login==true) 
				
				System.out.println("accesso effettuato");
			
			else 
				
				System.out.println("credenziali errate");
			
		br.close();
		return login;
				
	}
}
