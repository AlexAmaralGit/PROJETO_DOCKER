package br.com.quarkus.payload.estoque;

import br.com.quarkus.model.Estoque;

public class EstoqueResponsePayload {

    private Long id;
    private int qtd;
    private Long Produto_id;

    public EstoqueResponsePayload(final Estoque estoque) {
        this.id = estoque.getId();
        this.qtd = estoque.getQtd();
        this.Produto_id = estoque.getProduto_id();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Long getProduto_id() {
		return Produto_id;
	}

	public void setProduto_id(Long produto_id) {
		Produto_id = produto_id;
	}

 
}
