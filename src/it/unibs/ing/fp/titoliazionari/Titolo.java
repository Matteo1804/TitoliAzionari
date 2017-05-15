package it.unibs.ing.fp.titoliazionari;

import java.util.Random;

public class Titolo {
	private String nome;
	private double valore;
	private static double MAX_RIALZO = 10;
	private static double MAX_RIBASSO = -10;
	

	public double getValore()
	{
		return valore;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	
	public Titolo(String _nome, double _valore) 
	{
		nome=_nome;
		valore=_valore;
	}
	
	public void aggiornaValore()
	{
		Random rand= new Random();
//		valore =  ((valore) * ((rand.nextGaussian()*100) % ( MAX_RIALZO + MAX_RIBASSO)) - MAX_RIBASSO/100) ;
		double n = (Math.pow(-1,rand.nextInt()) * rand.nextDouble());
		System.out.println(n);
		valore += valore*n;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s %nValore: %.2f",nome,valore);
	}

}
