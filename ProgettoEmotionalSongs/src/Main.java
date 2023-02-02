import java.io.IOException;
import prog.io.*;
public class Main extends cercaBranoMusicale {
public static void main(String[] args) {
boolean loggato=false;
boolean continua=true;
while(continua!=false) {
System.out.println("cerca brano musicale --->  1");
System.out.println("visualizza emozioni --->2");
System.out.println("registrazione ---> 3");
System.out.println("login ---> 4");
System.out.println("crea una playlist ---> 5");
System.out.println("inserisci emozioni ---> 6");
ConsoleInputManager in = new ConsoleInputManager();
int numero = in.readInt();
while (numero>6||numero<1) {
	System.out.println("è stato inserito un numero non valido, riprova");
	numero = in.readInt();
}
if (numero==1) {
	System.out.println("ricerca tramite titolo ---> 1");
	System.out.println("ricerca tramite autore e anno ---> 2");
	int n1 = in.readInt();
	while(n1<1||n1>2) {
		System.out.println("è stato inserito un numero non valido, riprova");
		n1=in.readInt();
	}
	if(n1==1) {
		String titolo=in.readLine("inserisci il titolo della canzone");
		cercaBranoMusicale(titolo);
	}
	else if(n1==2) {
		String autore=in.readLine("inserisci l'autore della canzone");
		int anno = in.readInt("inserisci l'anno di pubblicazione della canzone");
		cercaBranoMusicaleAnno(anno, autore);	
	}	
}
if (numero==2) {
	Visualizzaemozioni();
}
if (numero==3) {
	Registrazione();
}
if (numero==4 && loggato==false) {
	try {
		loggato=Login();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} else if (numero==4&&loggato==true){
	System.out.println("hai già effettuato il login");
}
if(numero==5) {
	try {
		if(loggato==true) {
			RegistraPlaylist();
		} else if (loggato!=true) {
			System.out.println("è necessario effettuare il login");
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
if(numero==6) {
	try {		
		if(loggato==true) {
			inserisciEmozioniBrano();
		} else if (loggato!=true) {
			System.out.println("è necessario effettuare il login");
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
continua=in.readSiNo("vuoi tornare al menu principale?");	
} 
	}
}
