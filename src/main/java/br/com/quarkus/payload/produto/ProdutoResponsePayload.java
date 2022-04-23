package br.com.quarkus.payload.produto;

import java.math.BigDecimal;

import br.com.quarkus.model.Produto;

public class ProdutoResponsePayload {

    private Long id;
    private String nome;
    private BigDecimal valor;

    public ProdutoResponsePayload(final Produto produto) {
        this.id = produto.id;
        this.nome = produto.nome;
        this.valor = produto.valor;
        System.out.println("ProdutoResponsePayload(final Produto produto)");
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
		return "ProdutoResponsePayload [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}
}