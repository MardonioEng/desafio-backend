package br.com.grupofleury.apiagendamento.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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

	public Cliente inserir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente atualizar(Long id, Cliente cliente) {
		try {
			Cliente entidade = clienteRepository.getOne(id);
			atualizaDados(entidade, cliente);
			return clienteRepository.save(entidade);
		} catch(EntityNotFoundException e) {
			return null;
		}
	}

	private void atualizaDados(Cliente entidade, Cliente cliente) {
		entidade.setCpf(cliente.getCpf());
		String data = cliente.getDataNascimento().toString().substring(0, 10);
		entidade.setDataNascimento(data);
		entidade.setNome(cliente.getNome());
		
	}
	
}
