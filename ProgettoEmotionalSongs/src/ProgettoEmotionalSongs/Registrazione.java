package ProgettoEmotionalSongs;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import prog.io.*;

/**
 * 
 * @author daniele maccagnan 749722
 * Classe che fornisce il servizio di registrazione al programma , tramite il metodo registrazione()
 *
 */
public class Registrazione{
		
	//FIELDS
	/**
	 * pattern per controllare la correttezza della sintassi della mail dell'utente in registrazione
	 * 
	 */
  	private static final Pattern EmailValido = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	  
  	
  	//METHODS
	
  	/**
  	 * @autor danym
  	 * metodo statico che fornisce il servizio di registrazione al programma
  	 * ritorna una stampa nel caso la registrazione sia eseguita correttamente
  	 * inserisce nel file UtentiRegistrati.dati.txt i dati dell'utente , forniti attraverso l'oggetto ConsoleInputManager da tastiera
  	 * @return void
  	 * @throws IOException
  	 */
	public static void registrazione() throws IOException {	
	
		ConsoleInputManager in = new ConsoleInputManager ();
		File file = new File("UtentiRegistrati.dati.txt");
		if(!file.exists())
			file.createNewFile();
		String path = file.getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String nome= in.readLine("nome ");
		String cognome = in.readLine("cognome ");
		String codicefiscale = in.readLine("codice fiscale ");
		
		//check sulla validità del codice fiscale
		while(!codicefiscaleValido(codicefiscale))
			codicefiscale = in.readLine("codice fiscale non corretto, reinserire : ");
        
		 
		String indirizzo = in.readLine("indirizzo");
		int numerocivico = in.readInt("numero civico ");
		int cap = in.readInt("cap ");
		String comune = in.readLine("comune ");
		String provincia = in.readLine("provincia ");
		String email = in.readLine("email ");
		while(validamail(email)==false) {
			
	    	   email=in.readLine("inserisci la mail correttamente ");
	    	   
		}
		String user = in.readLine("user ");
		
		//check su user
		while(alreadyExists(user, new BufferedReader(new FileReader(path)))) 
				user = in.readLine("reinserire: ");
	
		String password = in.readLine("inserire password : ");
		//check su password
		while(!passwordIsValid(password))
			password = in.readLine("reinserire password : ");
		
		FileWriter fw = new FileWriter(path, true);
	
        fw.write(nome.toUpperCase());
        fw.write("/"+ cognome.toUpperCase());
        fw.write("/"+codicefiscale.toUpperCase());
        fw.write("/"+indirizzo.toUpperCase());
        fw.write("/"+numerocivico);
        fw.write("/"+cap);
        fw.write("/"+comune.toUpperCase());
        fw.write("/"+provincia.toUpperCase());
        fw.write("/"+email.toUpperCase());
        fw.write("/"+user);
        fw.write("/"+password);
        fw.write("\n");
        fw.close();      
        
        System.out.println("registrazione effettuata correttamente");
        br.close();
        }
         
	
	
	 /**
	  * 
	  * @param email, stringa contenete l'email data in ingresso da tastiera dall'utente
	  * @return true se la sintassi della mail è corretta, false altrimenti
	  * utilizzando l'oggetto della classe matcher controlla l'email fornita in ingresso con l'attributo della classe "pattern"
	  */
	private static boolean validamail(String email) {
		
        Matcher matcher = EmailValido .matcher(email);
        return matcher.find();
    }
	
	/**
	 *
	 * @param username,string contenete l'username dato in ingresso da tastiera dall'utente
	 * @param br , BufferedReader che permette l'apertura dello stream in lettura sul file UtentiRegistrati.dati.txt
	 * @return true se esiste nel file UtentiRegistrati.txt lo stesso valore del parametro in ingresso,false altrimenti
	 * @throws IOException
	 */
	
	private static boolean alreadyExists(String username,BufferedReader br) throws IOException {
		
		String line = br.readLine();
		while(line != null) {
			
			String [] result = line.split("/");
			 if(result[9].equals(username)) {
				 
				System.out.println("utente gia esistente, reinserire: ");
				br.close();
				return true;
			 }
			 
			line = br.readLine();
		} br.close();
		
		return false;
	}
	/**
	 * @param s, string contenete la password data in ingresso da tastiera dall'utente
	 * @return true se s contiene almeno un carattere minuscolo uno maiuscolo e un intero, di lunghezza minimo 8 caratteri
	 */
	
	private static boolean passwordIsValid(String s) {
		
		int maiuscole = 0;
		int minuscole = 0;
		int numeri = 0;
		
		if(s.length() < 8) {
			System.out.println("password troppo corta");
			return false;
		}
		
		for(int i = 0; i< s.length();i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c))
				
				numeri++;	
			else if(Character.isUpperCase(c))
				maiuscole++;
			
			else if(Character.isLowerCase(c))
				minuscole ++;
	}
		if(numeri > 0 && maiuscole > 0 && minuscole > 0)
			return true;
		else {
			System.out.println("password non valida , deve contenere minimo un numero, una lettera maiuscola e una minuscola");
			return false;
		}
	}
	
	/**
	 * 
	 * 
	 * @param codiceFiscale, string contenete il codice fiscale dato in ingresso da tastiera dall'utente
	 * @return true se il codice fiscale è di sintassi corretta, false altrimenti
	 * 
	 */
	public static boolean codicefiscaleValido(String codiceFiscale) {

		String codRegex = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";

		Pattern codPat = Pattern.compile(codRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = codPat.matcher(codiceFiscale);
		return matcher.find();
		
	}
}