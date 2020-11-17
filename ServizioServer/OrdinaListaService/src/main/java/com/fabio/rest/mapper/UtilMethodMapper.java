package com.fabio.rest.mapper;

import java.util.Collections;
import java.util.List;

public class UtilMethodMapper {

	public UtilMethodMapper() {
	}
	
	
	public static boolean orderBy(List<String> datiDaOrdinare) {
		try {
			if(datiDaOrdinare!=null && !datiDaOrdinare.isEmpty()) {
				Collections.sort(datiDaOrdinare);
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
