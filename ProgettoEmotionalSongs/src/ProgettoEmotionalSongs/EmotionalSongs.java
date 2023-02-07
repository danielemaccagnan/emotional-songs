package ProgettoEmotionalSongs;

import java.io.IOException;
import prog.io.*;
/**
 * 
 * @author daniele maccagnan 749722
 * classe che fornisce il menu principale per l'utilizzo del programma
 * 
 *
 */
public class EmotionalSongs {
	/**
	 * 
	 * @param args main
	 * @throws IOException per i metodi 
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * boolean per verificare se un utente � loggato
		 */
		boolean loggato=false;
		/**
		 * boolean necessario per verificare fin quando l'utente vuole utilizzare il programma
		 */
		boolean continua=true;
		
		/**
		 * oggeto ConsoleInputManager necessario per leggere i dati inseriti in input dall'utente
		 */
		ConsoleInputManager in = new ConsoleInputManager();
		
		while(continua!=false) {
			
			System.out.println("cerca brano musicale --->  1");
			System.out.println("visualizza emozioni --->2");
			System.out.println("registrazione ---> 3");
			System.out.println("login ---> 4");
			System.out.println("crea una playlist ---> 5");
			System.out.println("inserisci emozioni ---> 6");
			/**
			 * intero necessario per selezionare le differenti funzionalit� del programma
			 */
			int numero = in.readInt();
				
			while (numero>6||numero<1) {
				
				System.out.println("� stato inserito un numero non valido, riprova");
				numero = in.readInt();
			}
				
			//RICERCA BRANO
			if (numero==1) {
				System.out.println("ricerca tramite titolo ---> 1");
				System.out.println("ricerca tramite autore e anno ---> 2");
				int n1 = in.readInt();
				
				while(n1<1||n1>2) {
					
					System.out.println("� stato inserito un numero non valido, riprova");
					n1=in.readInt();
				}
				
				//Ricerca per titolo
				if(n1==1) {
					String titolo=in.readLine("inserisci il titolo della canzone");
					Ricerca.cercaBranoMusicale(titolo);
				}
				
				//Ricerca per autore e anno
				else if(n1==2) {
					
					String autore=in.readLine("inserisci l'autore della canzone");
					int anno = in.readInt("inserisci l'anno di pubblicazione della canzone");
					Ricerca.cercaBranoMusicale(anno, autore);	
				}	
			}
			
			//VISUALIZZA EMOZIONI
			if (numero==2) 
				VisualizzaEmozioni.Visualizzaemozioni();
			
			
			//REGISTRAZIONE
			if (numero==3) 	
				Registrazione.registrazione();
			
			
			//LOGIN
			if (numero==4 && loggato==false) {
				
				loggato= Login.login();
					
			} else if (numero==4&&loggato==true){
				
				System.out.println("hai gi� effettuato il login");
			}
			
			//CREAZIONE PLAYLIST
			if(numero==5) {
	
				if(loggato==true) 
					
					RegistraPlaylist.registraPlaylist();
					
				else if (loggato!=true) 
					
					System.out.println("� necessario effettuare il login");
			}
			
			//INSERIMENTO EMOZIONI
			if(numero==6) {
		
				if(loggato==true) 
					
					InserisciEmozioni.inserisciEmozioniBrano();
				
				else if (loggato!=true) 
					
					System.out.println("� necessario effettuare il login");
			}
		continua=in.readSiNo("vuoi tornare al menu principale?(S/N)");	
		} 
	}
}