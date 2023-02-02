import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import prog.io.ConsoleInputManager;

public class Login extends VisualizzaEmozioni{
	public static void main(String[] args) throws IOException {
			Login();		
	}
	
		
	
		public static boolean Login() throws IOException {
		ConsoleInputManager in = new ConsoleInputManager();
		String username=in.readLine("inserisci user");
		String password = in.readLine("inserisci password");
		String path = "C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\UtentiRegistrati.dati.txt";
		BufferedReader reader;
		File file = new File(path);
		FileReader fr = new FileReader(file);
		reader = new BufferedReader(fr);
		String line = reader.readLine();
		String all = username+ "/" + password;
	
		boolean login=false;
		while(line!=null&&login==false) {
			 login=true;
				for(int i=0; i<all.length();i++) {
				
					if(line.charAt(line.length()-1-i)!=all.charAt(all.length()-1-i)) {
						login=false;
					
					}
				}
				
				
			
				line=reader.readLine();
			} if(login==true) {
				System.out.println("accesso effettuato");
			} else {
				System.out.println("credenziali errate");
			}
		return login;
			
	}
}