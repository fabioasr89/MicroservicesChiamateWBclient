package com.fabio.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;
import com.fabio.rest.servizio.ClientService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/ClientRequestOrderListAPI/")
public class ClientRestController {
	
	@Autowired
	private ClientService service;
	


	@RequestMapping(value="ordina",method=RequestMethod.GET)
	public RispostaBean getResponseBean(@RequestParam List<String> lista) {
		RispostaBean bean=null;
		RichiestaBean richiesta=null;
		boolean esitoRichiesta=false;
		try {
			if(lista!=null && !lista.isEmpty()) {
				esitoRichiesta=true;
				richiesta=new RichiestaBean();
				richiesta.setDati(lista);
				bean=service.getResponse(richiesta);
			}
		}catch(Exception e) {
			esitoRichiesta=false;
			e.printStackTrace();
		}
		if(!esitoRichiesta) {
			bean=new RispostaBean();
			bean.setMessage("Parametro richiesto assente o invalido");
			bean.setEsito(false);
			bean.setDati(new ArrayList<String>());
		}
		return bean;
	}
	
}
