package it.unibs.ing.fp.titoliazionari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


public class Portafoglio implements Serializable{
	
	private String nomePersona;
	private double valoreTotale;
	ArrayList<Lotto> lottiPosseduti;
	
	public Portafoglio(String _nomePersona)
	{
		nomePersona=_nomePersona;
		valoreTotale=0;
		lottiPosseduti=new ArrayList<>();
	}
	
	public Optional<Lotto> containsLotto(String nomeTitolo) {
	  
		
		return lottiPosseduti.stream()
					  .filter(lotto -> lotto.getNomeTitolo().equalsIgnoreCase(nomeTitolo))
					  .findFirst();
	}
	
	public void addLotto(Lotto a)
	{
		lottiPosseduti.add(a);
	}
	
	public void calcolaValoreTotale()
	{
		for(Lotto b: lottiPosseduti)
		{
			valoreTotale=valoreTotale+b.getTotalValue();
		}
	}
	
	public double getValoreTotale()
	{
		calcolaValoreTotale();
		return valoreTotale;
	}
	
	public ArrayList<Lotto> getLottiPosseduti()
	{
		return lottiPosseduti;
	}
	
	@Override
	public String toString() {
		StringBuffer str= new StringBuffer(nomePersona+"\n");
		for(Lotto a: lottiPosseduti)
		{
			str.append(a);
		}
		return str.toString();	
	}
	
	public void removeVuoti() {
		lottiPosseduti = (ArrayList<Lotto>) lottiPosseduti.stream()
					  .filter(l -> l.getQuantita() != 0)
					  .collect(Collectors.toList());
	}

}
