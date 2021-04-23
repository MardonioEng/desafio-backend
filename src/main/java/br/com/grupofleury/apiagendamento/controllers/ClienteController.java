package br.com.grupofleury.apiagendamento.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
		Optional<Cliente> obj = clienteService.findById(id);
		if(obj.isPresent())
			return ResponseEntity.ok().body(obj.get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/cpf")
	public ResponseEntity<Cliente> getCliente(@RequestBody String cpf) {
		Optional<Cliente> obj = clienteService.findByCpf(cpf);
		if(obj.isPresent())
			return ResponseEntity.ok().body(obj.get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		
		Optional<Cliente> obj = clienteService.findByCpf(cliente.getCpf());
		
		if(obj.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		cliente = clienteService.inserir(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
}
