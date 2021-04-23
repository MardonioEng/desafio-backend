package br.com.grupofleury.apiagendamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupofleury.apiagendamento.entities.Cliente;
import br.com.grupofleury.apiagendamento.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes = clienteService.getClientes();
		
		return ResponseEntity.ok().body(clientes);
	}
	
}
