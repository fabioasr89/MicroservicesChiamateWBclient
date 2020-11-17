package com.fabio.rest.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;

import reactor.core.publisher.Mono;

public class WebClientAdapter implements WebClientInterface{
	
	private WebClient client;
	private String uri;
	private Mono<RispostaBean> response;
	public WebClientAdapter(String uri) {
		this.client=WebClient.create();
		this.uri=uri;
	}
	
	@Override
	public RispostaBean ordinaListaServices(List<String> lista) {
		RispostaBean bean=null;
		//String uri=this.uri+"/OrderByService/orderList/{lista}";
		boolean esito=false;
		bean=new RispostaBean();
		try {
			response=this.client.get().uri(this.uri+"/OrderByService/orderList/{lista}",lista).exchange().flatMap(clientResponse->clientResponse.bodyToMono(RispostaBean.class));
			if(response!=null) {
				esito=true;
				bean=response.block();
			}
		}catch(Exception e) {
			esito=false;
			e.printStackTrace();
		}
		bean.setEsito(esito);
		if(!esito) {
			bean=new RispostaBean();
			bean.setEsito(esito);
			bean.setMessage("Non è stato possibile processare i dati dels ervizio");
			bean.setDati(new ArrayList<String>());
		}
		return bean;
	}
	

}
