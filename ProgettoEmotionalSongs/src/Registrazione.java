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
	
	public static void main(String[] args) throws IOException {
		
		Registrazione();
	

	}
	
	  		private static final Pattern EmailValido = 
	  		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	  public static boolean validamail(String email) {
          Matcher matcher = EmailValido .matcher(email);
          return matcher.find();
      }
public static void Registrazione() throws IOException {	
		ConsoleInputManager in = new ConsoleInputManager ();
		String nome= in.readLine("nome ");
		String cognome = in.readLine("cognome ");
		String codicefiscale = in.readLine("codice fiscale ");
		boolean codfiscale=true;
		boolean inesistente=true;
        boolean primacond=false;
		  while(primacond!=true) {
			 	        	primacond=true;
	        	if(codicefiscale.length()!=16||Character.isDigit(codicefiscale.charAt(6))==false||Character.isDigit(codicefiscale.charAt(7))==false||Character.isDigit(codicefiscale.charAt(9))==false||Character.isDigit(codicefiscale.charAt(10))==false||Character.isDigit(codicefiscale.charAt(12))==false||Character.isDigit(codicefiscale.charAt(13))==false||Character.isDigit(codicefiscale.charAt(14))==false) {
	            	primacond=false;     	
	            }
	           for(int i=0;i<6;i++) {
	        	   if(codicefiscale.length()!=16||Character.isLetter(codicefiscale.charAt(i))==false||codicefiscale.length()!=16) {
	        		   primacond=false;    		   
	        	   }
	           }
	           if(codicefiscale.length()!=16||Character.isLetter(codicefiscale.charAt(8))==false||Character.isLetter(codicefiscale.charAt(11))==false||Character.isLetter(codicefiscale.charAt(15))==false||codicefiscale.length()!=16) {
	        	   primacond=false;        
	           }
	        	if(primacond==false) {
	        	System.out.println("inserire il codice fiscale correttamente");
	        	codicefiscale=in.readLine();  	
	        	}      	
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
		String password = in.readLine("password ");

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
		}
			
		if(inesistente==true) {
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
	            } else {
	            	System.out.println("username già esistente");
	            }
	} 
	}