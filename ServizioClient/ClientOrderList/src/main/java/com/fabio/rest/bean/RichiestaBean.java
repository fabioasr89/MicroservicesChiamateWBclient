package com.fabio.rest.bean;

import java.util.List;

public class RichiestaBean {
	private List<String> dati;
	
	public RichiestaBean() {
		
	}
	public RichiestaBean(List<String> dati) {
		this.dati=dati;
	}
	public List<String> getDati() {
		return dati;
	}

	public void setDati(List<String> dati) {
		this.dati = dati;
	}
	
}
