package it.unibs.ing.fp.titoliazionari;

import java.io.File;
import java.io.Serializable;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.ServizioFile;

//Per salvare su file una classe, devo implementare per ogni classe l'interfaccia Serializable

public class Main implements Serializable{


	public static void main(String[] args) {
		
		File file = new File("secretpltps.dat");
		
		Portafoglio portafoglio = null;
		
		ElencoTitoli elencoTitoli=  null;
		
		Contenitore contenitore = null;
		
		boolean caricamento = false;
		
		if(file.exists()) {
			try {
				contenitore = (Contenitore) ServizioFile.caricaSingoloOggetto(file);
				elencoTitoli = contenitore.getElencotitoli();
				portafoglio = contenitore.getPortafoglio();
			} catch (ClassCastException e) {
				System.err.println("Il file non è letto un contenitore!!");
			} finally {
				if(portafoglio != null && elencoTitoli != null) {
					caricamento = true;
					System.out.println("Ho caricato strabene il file");
				}
			}
		}
		
		if(!caricamento) {
			System.out.println("Creo il file da zero");
			portafoglio = new Portafoglio(InputDati.leggiStringaNonVuota("Inserisci il nome: "));
			elencoTitoli = new ElencoTitoli();
		}
		
		String[] vociMenu = new String[]{"Aggiungi titolo", "Compra azioni", "Vendi azioni", "Stampa titoli", "Stampa Azioni", "Guadagno attuale", "Simula giorno", "Salva su file"};
		MyMenu menu = new MyMenu("Titoli", vociMenu);
		boolean esci = false;
		
	
		
		while(!esci) {
			switch (menu.scegli()) {
			case 1:
				elencoTitoli.aggiungiTitolo(new Titolo("Cotex", 15.50));
				break;
			case 2:
				elencoTitoli.printTitoli();
				String nomeTitolo = InputDati.leggiStringaNonVuota("Inserisci il nome del titolo: ");
				if(elencoTitoli.getTitoloByNome(nomeTitolo).isPresent()) {
					Titolo t = elencoTitoli.getTitoloByNome(nomeTitolo).get();
					
					if(portafoglio.containsLotto(t.getNome()).isPresent()) {
						Lotto l = portafoglio.containsLotto(t.getNome()).get();
						System.out.println("Hai già comprato azioni "+ l.getQuantita() +" di questo titolo");
						
						int q = InputDati.leggiInteroNonNegativo("Quante azioni vuoi acquistare? ");
						l.setQuantita(l.getQuantita() + q);
						
						
					}
					else {
						int q = InputDati.leggiInteroNonNegativo("Quante azioni vuoi acquistare? ");
						portafoglio.addLotto(new Lotto(t,q));
					}
					
				}
				else {
					System.out.println("Hai inserito un titolo inesistente!");
				}
				break;
			case 3:
				if(portafoglio.getLottiPosseduti().isEmpty()) {
					System.out.println("Non hai azioni");
					break;
				}
					
				System.out.println(portafoglio);
				String nomeAzione = InputDati.leggiStringaNonVuota("Inserisci il nome del titolo da vendere: ");

					if(portafoglio.containsLotto(nomeAzione).isPresent()) {
						Lotto l = portafoglio.containsLotto(nomeAzione).get();
						System.out.println("Hai già comprato azioni "+ l.getQuantita() +" di questo titolo");
						
						int q = InputDati.leggiIntero("Quante azioni vuoi vendere? ", 0, l.getQuantita());
						l.setQuantita(l.getQuantita() - q);
						portafoglio.removeVuoti();
						
						
					}
					else {
						System.out.println("Non hai acquistato nessun azione di questo titolo");
					}
					
				
				break;
			case 4:
				elencoTitoli.printTitoli();
				break;
			case 5:
				System.out.println(portafoglio);
				break;
			case 6:
				System.out.println(portafoglio.getValoreTotale() + "€");
				break;
			case 7:
				elencoTitoli.simulaGiorno();
				break;
			case 8:
				contenitore = new Contenitore(portafoglio, elencoTitoli);
				ServizioFile.salvaSingoloOggetto(file, contenitore);
				System.out.println("Ho salvato");
				break;
			case 0:
				esci = true;
				break;
			default:
				break;
			}
		}
		
		
		

	}

}
