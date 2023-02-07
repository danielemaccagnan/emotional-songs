package ProgettoEmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author bugno alessandro 749716
 * classe che fornisce il brano ricercato tramite i due metodi statici cercaBranoMusicale in overloading, 
 * per differenziare la ricerca per titolo o anno e autore
 *
 */
public class Ricerca{
	
	//FIELDS
	/**
	 * campo statico e non modificabile , contente il separatore tra i dati del file Canzoni.txt
	 */
	final static String separatore = "<SEP>";
	
	//METHODS
	/**
	 * 
	 * @param titolo : titolo del brano da ricercare di tipo String non cap sensitive
	 * @throws IOException
	 * @return void 
	 * il metodo ritorna a schermo la lista dei brani musicali con il titolo dato in input,senza mostrare i brani con lo stesso 
	 * titolo e autore
	 */
	public static void cercaBranoMusicale(String titolo) throws IOException {
		
		//Apertura stream
		File canzoni = new File("Canzoni.txt");
		BufferedReader br = new BufferedReader(new FileReader(canzoni.getAbsolutePath()));
		
		//normalizzazione parametro attuale
		titolo = titolo.toLowerCase();
		
		//flag è false se non avvengono stampe, true altrimenti
		boolean flag = false;
		int hash = 0;
		
		String line = br.readLine();
		
		//Struttura dati contenente hash di canzoni già stampate
		ArrayList<Integer> hashArr = new ArrayList<Integer>();
		
		while(line != null) {

			String [] result = line.split("<SEP>");
			String brano = result[3].toLowerCase(); 
			
			if(titolo.equals(brano)) {
				
				if(!flag) {
					
					flag  = true;
					hash = line.substring(32).hashCode();
					hashArr.add(hash);
					System.out.println(line);
					
				}else {
					
					if(!hashEqual(hashArr,line.substring(32).hashCode())) 
						System.out.println(line);
					
				}
		}
			line = br.readLine();	
	}	
			
		if(!flag)
			System.out.println("canzone non trovata");
		
		br.close();
}
	
	/**
	 * 
	 * @param anno : intero che indica l'anno di produzione dell'anno da ricercare
	 * @param autore : String che indica l'autore del brano da ricercare
	 * @throws IOException
	 * @return void 
	 * il metodo ritorna a schermo la lista dei brani musicali con l'anno e autore in input,senza mostrare i brani con lo stesso 
	 * titolo,autore e anno
	 */
	 
	 
	public static void cercaBranoMusicale(int anno , String autore) throws IOException{
		
		
		
		//Apertura streamblues
		File canzoni = new File ("Canzoni.txt");
		BufferedReader br = new BufferedReader(new FileReader(canzoni.getAbsolutePath()));
		
		//normalizzazione parametri attuali
		autore = autore.toLowerCase();
		String year = String.valueOf(anno);
		
		
		String line = br.readLine();
		
		//flag è false se non avvengono stampe, true altrimenti
		boolean flag = false;
		int hash = 0;
				
		//Struttura dati contenente hash di canzoni già stampate
		ArrayList<Integer> hashArr = new ArrayList<Integer>();
		
		while(line != null) {
			
			String [] result = line.split("<SEP>");
			String cantante = result[2].toLowerCase();
			
			if(cantante.equals(autore) && result[0].equals(year)) {
				
				if(!flag) {					
					flag = true;
					hash = line.substring(32).hashCode();
					hashArr.add(hash);
					System.out.println(line);
				}else {
					
					if(!hashEqual(hashArr,line.substring(32).hashCode())) 
						
						System.out.println(line);
						
				}
			}
			
			line = br.readLine();
			
		}
		
		if(!flag)
			
			System.out.println("canzone non trovata");
		
		br.close();
	}
		/**
		 * metodo per la rimozione dei duplicati dalla stampa delmetodo ricercaBranoMusicale()
		 * @param arr : arraylist contenente gli hash dei brano già trovati durante la ricerca del brano
		 * @param h : intero che indica l'hash della canzone ,l'hash è comporto da autore,separatore e titolo
		 * @return true se esiste un intero nell'arraylist uguale al parametro h
		 * 			false altrimenti
		 */
		public static boolean hashEqual(ArrayList<Integer> arr, int h){
			
			for(Integer hash : arr){
				if(h == hash)
					return true;
				}
			arr.add(h);
			return false;
				
		}
	

}
