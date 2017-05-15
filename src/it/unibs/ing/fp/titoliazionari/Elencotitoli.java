package it.unibs.ing.fp.titoliazionari;

import java.util.ArrayList;


public class Elencotitoli {

	private ArrayList<Titolo> titoli=new ArrayList<>();
	
	public void aggiungiTitolo(Titolo a)
	{
		titoli.add(a);
	}
	
	public ArrayList<Titolo> getTitoli()
	{
		return titoli;
	}
	
	public Titolo getTitoloByNome (String nome)
	{
		for (Titolo tit: titoli)
		{
			if (tit.getNome().equals(nome))
				return tit;
			
		}
		return null;
	}
	
	public void rimuoviTitolo(Titolo a)
	{
		titoli.remove(a);
	}
}
