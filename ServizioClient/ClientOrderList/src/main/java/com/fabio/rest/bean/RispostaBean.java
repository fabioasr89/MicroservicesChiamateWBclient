package com.fabio.rest.bean;

import java.util.List;

public class RispostaBean {
	private List<String> dati;
	private boolean esito;
	private String message;
	public List<String> getDati() {
		return dati;
	}
	public void setDati(List<String> dati) {
		this.dati = dati;
	}
	public boolean isEsito() {
		return esito;
	}
	public void setEsito(boolean esito) {
		this.esito = esito;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
