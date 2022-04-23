package br.com.quarkus.payload.pessoa;

import br.com.quarkus.model.Pessoa;

public class PessoaResponsePayload {

    private Long id;
    private String nome;

    public PessoaResponsePayload(final Pessoa pessoa) {
        this.id = pessoa.id;
        this.nome = pessoa.nome;
        System.out.println("PessoaResponsePayload(final Pessoa pessoa)");
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


}