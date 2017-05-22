package it.unibs.ing.fp.titoliazionari;

import java.io.Serializable;

public class Contenitore implements Serializable{

	Portafoglio portafoglio;
	ElencoTitoli elencotitoli;
	
	public Contenitore(Portafoglio portafoglio, ElencoTitoli elencotitoli) {
		this.portafoglio = portafoglio;
		this.elencotitoli = elencotitoli;
	}
	
	public Portafoglio getPortafoglio() {
		return portafoglio;
	}
	public ElencoTitoli getElencotitoli() {
		return elencotitoli;
	}
	
	
}
