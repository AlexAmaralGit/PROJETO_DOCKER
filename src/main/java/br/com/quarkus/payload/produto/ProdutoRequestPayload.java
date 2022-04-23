package br.com.quarkus.payload.produto;

import java.math.BigDecimal;

public class ProdutoRequestPayload {

	private Long id;
    private String nome;
    private BigDecimal valor;

	public ProdutoRequestPayload(Long id, String nome, BigDecimal valor) {
		this.nome = nome;
		this.id = id;
		this.valor = valor;
		System.out.println("ProdutoRequestPayload(Long id, String nome, BigDecimal valor");
	}

	public ProdutoRequestPayload() {
		super();
		System.out.println("ProdutoRequestPayload()");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ProdutoRequestPayload [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}		
}