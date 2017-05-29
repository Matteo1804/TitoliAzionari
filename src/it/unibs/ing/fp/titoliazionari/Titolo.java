package it.unibs.ing.fp.titoliazionari;

import java.io.Serializable;
import java.util.Random;

public class Titolo implements Serializable{
	private String nome;
	private double valore;
	private static int MAX_RIALZO = 15;
	private static int MAX_RIBASSO = 25;
	private StringBuffer percentuale;

	public Titolo(String _nome, double _valore) 
	{
		nome=_nome;
		valore=_valore;
	}
	
	public double getPrezzo()
	{
		return valore;
	}
		
	public String getNome()
	{
		return nome;
	}
	

	public void variazGiornaliera()
	{
		Random rand= new Random();
		double perc=0;
		if (rand.nextBoolean())
		{
			perc= rand.nextInt(MAX_RIALZO*100);
			perc=perc/100;
			percentuale= new StringBuffer("+"+perc+"%");
		}
		
		else
		{
			perc= rand.nextInt(MAX_RIBASSO*100);
			perc=perc/100;
			perc=perc*-1;
			percentuale= new StringBuffer(perc+"%");
		}
		
		valore += (valore*perc/100);
		
		System.out.printf("Nome: %s\nVariazione percentuale: %s  \nValore: %.2f\n\n",nome,percentuale,valore);
		
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s  %nValore: %.2f\n\n",nome,valore);
	}

}
