package it.unibs.ing.fp.titoliazionari;

import java.util.ArrayList;


public class Portafoglio {
	
	private String nomePersona;
	private double valoreTotale;
	ArrayList<Lotto> lottiPosseduti;
	
	public Portafoglio(String _nomePersona)
	{
		nomePersona=_nomePersona;
		valoreTotale=0;
		lottiPosseduti=new ArrayList<>();
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

}
