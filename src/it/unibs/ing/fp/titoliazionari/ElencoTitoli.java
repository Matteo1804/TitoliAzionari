package it.unibs.ing.fp.titoliazionari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;


public class ElencoTitoli implements Serializable{

	private ArrayList<Titolo> titoli = new ArrayList<>();
	
	public void aggiungiTitolo(Titolo a)
	{
		titoli.add(a);
	}
	
	public ArrayList<Titolo> getTitoli()
	{
		return titoli;
	}
	
	public Optional<Titolo> getTitoloByNome (String nome)
	{
		
		return titoli.stream()
		      .filter(t -> t.getNome().equalsIgnoreCase(nome))
		      .findFirst();

	}
	
	public void rimuoviTitolo(Titolo a)
	{
		titoli.remove(a);
	}
	
	
	public void simulaGiorno() {
		titoli.forEach(Titolo::variazGiornaliera);
	}
	
	public void printTitoli() {
		titoli.forEach(System.out::println);
	}
}
