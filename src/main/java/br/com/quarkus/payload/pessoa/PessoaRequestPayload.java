package br.com.quarkus.payload.pessoa;

public class PessoaRequestPayload {

	private Long id;
    private String nome;

	public PessoaRequestPayload(Long id, String nome) {
		this.nome = nome;
		this.id = id;
		System.out.println("PessoaRequestPayload(Long id, String nome");
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public PessoaRequestPayload() {
		super();
		System.out.println("PessoaRequestPayload()");
	}
}