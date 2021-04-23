package br.com.grupofleury.apiagendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupofleury.apiagendamento.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
