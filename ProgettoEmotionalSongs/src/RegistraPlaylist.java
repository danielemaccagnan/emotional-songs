import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import prog.io.ConsoleInputManager;
public class RegistraPlaylist extends InserisciEmozioni{
		public static void RegistraPlaylist() throws IOException {	
		FileWriter fw = new FileWriter("C:\\Users\\danym\\Desktop\\ProgettoEmotionalMaps\\Playlist.dati.txt", true);      
        ConsoleInputManager in = new ConsoleInputManager();
				System.out.println("inserisci il titolo della playlist");
				String nomeplaylist = in.readLine();
				fw.write(nomeplaylist + "\n" + "\n");				
				boolean continua=true;	        
				while(continua!=false) {					
		        String titolo = in.readLine("inserisci il titolo della canzone");
		        fw.write(titolo + "\n");	        
		       continua= in.readSiNo("vuoi inserire un'altra canzone?");
		        if(continua==false) {	        
		        fw.write("_ _ _ _ _ _" + "\n" + "\n");
		        fw.close();	        
		        	}
				}
			}
		}