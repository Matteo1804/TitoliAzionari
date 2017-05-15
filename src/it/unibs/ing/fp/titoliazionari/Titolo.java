package it.unibs.ing.fp.titoliazionari;

import java.util.Random;

public class Titolo {
	private String nome;
	private double valore;
	private static int MAX_RIALZO = 20;
	private static int MAX_RIBASSO = 30;
	private StringBuffer percentuale;

	public Titolo(String _nome, double _valore) 
	{
		nome=_nome;
		valore=_valore;
	}
	
	public double getValore()
	{
		return valore;
	}
	
	public String getPercentuale()
	{
		return percentuale.toString();
	}
	
	public String getNome()
	{
		return nome;
	}
	

	public void aggiornaValore()
	{
		Random rand= new Random();
//		valore =  ((valore) * ((rand.nextGaussian()*100) % ( MAX_RIALZO + MAX_RIBASSO)) - MAX_RIBASSO/100) ;
//		double n = (Math.pow(-1,rand.nextInt()) * rand.nextDouble());
//		System.out.println(n);
//		valore += valore*n;
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
		
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s %nValore: %.2f",nome,valore);
	}

}
