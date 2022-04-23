package br.com.quarkus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.quarkus.payload.pessoa.PessoaRequestPayload;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


//TABELA DEVE SER INFORMADA COM LETRA MINUSCULA
@Entity
@Table(name = "pessoa", schema = "banca")
public class Pessoa extends PanacheEntity {

//PANACHE NAO ESPECIFICA ID
//PANACHE NAO E NECESSARIO INFORMAR @Column(name = "id")	
	
	//@GeneratedValue(strategy = GenerationType.AUTO)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
	@SequenceGenerator(name = "pessoa_id_seq", sequenceName = "pessoa_id_seq", initialValue = 1, allocationSize=1)
	public Long id;
	public String nome;

	public Pessoa(PessoaRequestPayload pessoaPayload) {
        this.nome = pessoaPayload.getNome();
        System.out.println("Passou no construtor Pessoa(PessoaRequestPayload pessoaPayload)");
	}
	
	public Pessoa() {
		super();
		System.out.println("Passou no construtor Pessoa()");
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
