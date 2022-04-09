package com.unidade12.projetopi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Escolher a Persistence	
@Entity
public class Evento implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	//Escolher a Persistence	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private String Turno;
	private String Produto;
	private String Quantidade;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public String getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}
}
