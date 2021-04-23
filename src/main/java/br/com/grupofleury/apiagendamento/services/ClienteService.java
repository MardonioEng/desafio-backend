package br.com.grupofleury.apiagendamento.services;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Cliente> findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj;
	}
	
	public Optional<Cliente> findByCpf(String cpf) {
		Optional<Cliente> obj = clienteRepository.findByCpf(cpf);
		return obj;
	}
	
}
