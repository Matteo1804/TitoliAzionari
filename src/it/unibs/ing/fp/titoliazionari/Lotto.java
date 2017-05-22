package it.unibs.ing.fp.titoliazionari;

import java.io.Serializable;

public class Lotto implements Serializable{
	private Titolo azione;
	private int quantita;
	
	public Lotto(Titolo _azione, int _quantita)
	{
		azione=_azione;
		quantita=_quantita;
	}
	
	public String getNomeTitolo() {
		return azione.getNome();
	}
	
	public Titolo getAzione() {
		return azione;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getTotalValue()
	{
		return azione.getValore()*quantita;
	}
	
	@Override
	public String toString() {
		return String.format("Azione: %s %nQuantità:%d %nValore: %.2f%n",azione.getNome(), quantita, getTotalValue());
	}
}
