package br.com.grupofleury.apiagendamento.entities;

import java.io.Serializable;

public class Exame implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Double value;

	public Exame() {
	}

	public Exame(String id, String name, Double value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = Double.valueOf(value);
	}

}
