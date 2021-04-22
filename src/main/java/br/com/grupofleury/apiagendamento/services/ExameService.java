package br.com.grupofleury.apiagendamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.grupofleury.apiagendamento.entities.Exame;

@Service
public class ExameService {

	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "http://www.mocky.io/v2/5d681ede33000054e7e65c3f";
	
	public List<Exame> getExames() {
		
		ResponseEntity<Object> object = restTemplate.getForEntity(url, Object.class);
		
		Object obj = ((HttpEntity<Object>) object).getBody();
		
		@SuppressWarnings("unchecked")
		Map<String, List<Object>> objs = (Map<String, List<Object>>) obj;
		
		List<Exame> exames = mapearObjExame(objs.get("exams")); 
		
		return exames;
	}

	private List<Exame> mapearObjExame(List<Object> lista) {
		List<Exame> exames = new ArrayList<>();
		
		for (Object exameObj : lista) {
			@SuppressWarnings("unchecked")
			Map<String, ?> mapObj = (Map<String, String>) exameObj;
			Exame exame = new Exame();
			exame.setId(mapObj.get("id").toString());
			exame.setName(mapObj.get("name").toString());
			exame.setValue(mapObj.get("value").toString());
			exames.add(exame);
		}
		return exames;
	}
	
}
