package it.unibs.ing.fp.titoliazionari;

public class Lotto {
	private Titolo azione;
	private int quantita;
	
	public Lotto(Titolo _azione, int _quantita)
	{
		azione=_azione;
		quantita=_quantita;
	}
	
	public double getTotalValue()
	{
		return azione.getValore()*quantita;
	}
	
	@Override
	public String toString() {
		return String.format("Azione: %s %nQuantità:%d %n");
	}
}
