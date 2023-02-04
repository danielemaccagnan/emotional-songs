import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import prog.io.ConsoleInputManager;
public class RegistraPlaylist extends InserisciEmozioni{
		public static void RegistraPlaylist() throws IOException {	
		FileWriter fw = new FileWriter("C:\\Users\\danym\\eclipse-workspace\\ProgettoEmotionalSongs\\src\\Playlist.dati.txt", true);      
        ConsoleInputManager in = new ConsoleInputManager();
				System.out.println("inserisci il titolo della playlist");
				String nomeplaylist = in.readLine();
				for(int i=0;i<nomeplaylist.length()+4;i++) {
					fw.write("_");
				}
				fw.write("\n" + "|_" +nomeplaylist + "_|" + "\n" + "\n");	

				boolean continua=true;	        
				while(continua!=false) {					
		        String titolo = in.readLine("inserisci il titolo della canzone");
		        fw.write(titolo + "\n");	        
		       continua= in.readSiNo("vuoi inserire un'altra canzone?");
		        if(continua==false) {
		        	for(int i=0;i<(nomeplaylist.length()+4)/2;i++) {
		        		  fw.write("_ ");
		        	}
		      fw.write("\n");
		        fw.close();	        
		        	}
				}
			}
		}