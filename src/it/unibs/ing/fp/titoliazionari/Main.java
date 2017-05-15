package it.unibs.ing.fp.titoliazionari;

import it.unibs.fp.mylib.InputDati;

public class Main {

	public static void main(String[] args) {
		
		
		Portafoglio portafoglio= new Portafoglio(InputDati.leggiStringaNonVuota("Inserisci il tuo nome: "));
		
		Elencotitoli listino= new Elencotitoli();
		
		listino.aggiungiTitolo(new Titolo("Lasagne", 12));
		listino.aggiungiTitolo(new Titolo("Polenta", 22));
		listino.aggiungiTitolo(new Titolo("Tonno", 5));
		listino.aggiungiTitolo(new Titolo("Asparagi", 34));
		
		for (Titolo a: listino.getTitoli())
			a.aggiornaValore();
		
		for (Titolo a: listino.getTitoli())
		{
			System.out.println(a);
			int nAzioni=InputDati.leggiInteroNonNegativo("Quante azioni vuoi comprare? ");
			portafoglio.addLotto(new Lotto(a,nAzioni));
			
		}
		
		
		

	}

}
