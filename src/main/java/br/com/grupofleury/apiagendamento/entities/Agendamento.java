package br.com.grupofleury.apiagendamento.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Instant dataAgendamento;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
	private Long idExame;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Agendamento() {
	}

	public Agendamento(Long id, Instant dataAgendamento, Long idExame, Cliente cliente) {
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.idExame = idExame;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Instant dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Long getIdExame() {
		return idExame;
	}

	public void setIdExame(Long idExame) {
		this.idExame = idExame;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
