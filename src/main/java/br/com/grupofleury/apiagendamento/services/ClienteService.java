package br.com.grupofleury.apiagendamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupofleury.apiagendamento.entities.Cliente;
import br.com.grupofleury.apiagendamento.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}
	
}
