package com.fabio.rest.service;

import org.springframework.stereotype.Service;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;
import com.fabio.rest.mapper.UtilMethodMapper;

@Service
public class OrdinaListaService {
	
	
	public RispostaBean getResponse(RichiestaBean richiesta){
		RispostaBean risposta=null;
		boolean esito=false;
		try {
			esito=UtilMethodMapper.orderBy(richiesta.getDati());
			risposta=new RispostaBean();
			if(esito) {
				risposta.setMessage("Dati correttamenti processati");
				risposta.setEsito(esito);
				risposta.setDati(richiesta.getDati());
			}else {
				risposta.setMessage("Errore nella fase di processamento del dato");
				risposta.setEsito(esito);
				risposta.setDati(richiesta.getDati());
			}
		}catch(Exception e) {
			e.printStackTrace();
			risposta.setMessage("Errore nella fase di processamento del dato");
			risposta.setEsito(esito);
			risposta.setDati(richiesta.getDati());
		}
		return risposta;
		
		
	}
}
