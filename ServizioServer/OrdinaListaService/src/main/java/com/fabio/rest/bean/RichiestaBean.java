package com.fabio.rest.bean;

import java.util.List;

public class RichiestaBean {
	
	private List<String> dati;
	private String ordine;
	
	public RichiestaBean() {
		
	}

	public List<String> getDati() {
		return dati;
	}

	public void setDati(List<String> dati) {
		this.dati = dati;
	}

	public String getOrdine() {
		return ordine;
	}

	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	
	
	
}
