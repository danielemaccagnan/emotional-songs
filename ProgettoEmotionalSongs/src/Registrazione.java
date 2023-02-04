import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.io.FileWriter;
import java.io.BufferedReader;
import prog.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Registrazione extends RegistraPlaylist{

	 private static final Pattern EmailValido = 
	 Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	 public static boolean validamail(String email) {
     Matcher matcher = EmailValido .matcher(email);
     return matcher.find();
      }
		public static boolean codicefiscaleValido(String codiceFiscale) {

			String codRegex = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";

			Pattern codPat = Pattern.compile(codRegex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = codPat.matcher(codiceFiscale);
			return matcher.find();
		}
	  	public static void Registrazione() throws IOException {	
		ConsoleInputManager in = new ConsoleInputManager ();
		String nome= in.readLine("nome ");
		String cognome = in.readLine("cognome ");
		String codicefiscale = in.readLine("codice fiscale ");
		boolean inesistente=false;
		while(codicefiscaleValido(codicefiscale)==false) {
			codicefiscale=in.readLine("inserire il codicefiscale correttamente ");
		}
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
		while(inesistente!=true) {
		String path = "C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\UtentiRegistrati.dati.txt";
		BufferedReader reader;
			File file = new File(path);
			FileReader fr = new FileReader(file);
			reader = new BufferedReader(fr);	
			String line = reader.readLine();
			int lettereuguali=0;
			inesistente=true;
			while(line!=null&&inesistente==true) {
			lettereuguali=0;
			int contalettere=1;
			char c = '<';
			int i=0;
				while(c!=line.charAt(i)) {
					contalettere++;
					i++;
			}
				int inizio=line.indexOf("<");
				int fine=line.indexOf(">");
				int finale=fine-inizio-1;
				for(int k=0;k<user.length();k++, contalettere++) {
					if(user.charAt(k)==line.charAt(contalettere)) {
						lettereuguali++;
					}
				}
				if(lettereuguali==user.length()&&user.length()==finale) {
					inesistente=false;			
				}
						line=reader.readLine();
						 if(inesistente==false){
							user=in.readLine("username già esistente, reinserire ");
						}
		}
		}

			String password = in.readLine("password ");
			int contanumeri=0;
			int contamaiuscole=0;
			int contaminuscole=0;
			boolean pass=false;
			while(pass!=true) {
			contanumeri=0;
			contamaiuscole=0;
			contaminuscole=0;
			for(int i=0;i<password.length();i++) {
				if(Character.isDigit(password.charAt(i))) {
					contanumeri++;
				} else if (Character.isUpperCase(password.charAt(i))) {
					contamaiuscole++;
				} else if (Character.isLowerCase(password.charAt(i))) {
					contaminuscole++;
				}
			} if(contanumeri==0 || contamaiuscole==0 || contaminuscole==0) {
				password=in.readLine("inserire almeno un carattere maiuscolo, minusolo e un numero ");
				pass=false;
			} else if(contanumeri>0 && contamaiuscole>0 && contaminuscole>0)
			pass=true;
			}
			FileWriter fw = new FileWriter("C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\UtentiRegistrati.dati.txt", true);
	            fw.write(nome.toUpperCase());
	            fw.write("/"+ cognome.toUpperCase());
	            fw.write("/"+codicefiscale.toUpperCase());
	            fw.write("/"+indirizzo.toUpperCase());
	            fw.write("/"+numerocivico);
	            fw.write("/"+cap);
	            fw.write("/"+comune.toUpperCase());
	            fw.write("/"+provincia.toUpperCase());
	            fw.write("/"+email.toUpperCase());
	            fw.write("<"+user);
	            fw.write(">"+password);
	            fw.write("\n");
	            fw.close();      
	            System.out.println("registrazione effettuata correttamente ");
	            }
	} 
	