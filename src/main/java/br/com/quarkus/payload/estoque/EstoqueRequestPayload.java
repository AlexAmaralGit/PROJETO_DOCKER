package br.com.quarkus.payload.estoque;

public class EstoqueRequestPayload {

    private Long id;
    private int qtd;
    private Long Produto_id;

	public EstoqueRequestPayload(Long id, int qtd, Long Produto_id) {
		this.id = id;
		this.qtd = qtd;
		this.Produto_id = Produto_id;
	}
	
	public EstoqueRequestPayload() {
		super();
		System.out.println("EstoqueRequestPayload()");
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
