package model;

import java.time.LocalDate;

public class Ordem {
	
	private int id;
	private String nomeProduto;
	private int quantidade;
	private LocalDate dataEntrega;
	private String descricao;
	private boolean concluido;
	
	public Ordem(int id, String nomeProduto, int quantidade, LocalDate dataEntrega, String descricao, boolean concluido) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.dataEntrega = dataEntrega;
		this.descricao = descricao;
		this.concluido = concluido;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public boolean isConcluido() {
		return concluido;
	}


	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}


	public void atualizarStatus() {
		concluido = true;
	}

	@Override
	public String toString() {
		return "Ordem [nomeProduto=" + nomeProduto + ", quantidade=" + quantidade + ", dataEntrega=" + dataEntrega
				+ ", descricao=" + descricao + "status=" + concluido + "]";
	}
	
	
	
	
}
