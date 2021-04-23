package br.com.grupofleury.apiagendamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupofleury.apiagendamento.entities.ExameDTO;
import br.com.grupofleury.apiagendamento.services.ExameService;

@RestController
@RequestMapping("/exames")
public class ExameController {

	@Autowired
	private ExameService exameService;

	@GetMapping
	public ResponseEntity<List<ExameDTO>> getExames() {

		List<ExameDTO> exames = exameService.getExamesDTO();

		System.out.println(exames);

		return ResponseEntity.ok().body(exames);

	}

}
