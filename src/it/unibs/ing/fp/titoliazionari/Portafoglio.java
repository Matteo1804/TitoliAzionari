package it.unibs.ing.fp.titoliazionari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


public class Portafoglio implements Serializable{
	
	private String nomePersona;
	private double valoreTotale;
	ArrayList<Lotto> lottiPosseduti;
	
	public Portafoglio(String _nomePersona) {
		nomePersona = _nomePersona;
		valoreTotale = 0;
		lottiPosseduti = new ArrayList<>();
	}

	public Optional<Lotto> containsLotto(String nomeTitolo) {

		return lottiPosseduti.stream()
					  .filter(lotto -> lotto.getNomeTitolo().equalsIgnoreCase(nomeTitolo))
					  .findFirst();
	}
	
	public void addLotto(Lotto a) {
		lottiPosseduti.add(a);
	}
	
	public void calcolaValoreTotale() {
		
		valoreTotale = lottiPosseduti.stream()
					  .mapToDouble(Lotto::getTotalValue)
					  .sum();
	}
	
	public double getValoreTotale() {
		calcolaValoreTotale();
		return valoreTotale;
	}

	public ArrayList<Lotto> getLottiPosseduti() {
		return lottiPosseduti;
	}
	
	@Override
	public String toString() {
		
		 return nomePersona +"\n" + lottiPosseduti.stream()
					  .map(Lotto::toString)
					  .reduce((str,toappend) -> str.concat(toappend+"\n"))
					  .get();

	}
	
	public void removeVuoti() {
		lottiPosseduti = (ArrayList<Lotto>) lottiPosseduti.stream()
					  .filter(l -> l.getQuantita() != 0)
					  .collect(Collectors.toList());
	}

}
