package br.com.quarkus.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.quarkus.payload.produto.ProdutoRequestPayload;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


//TABELA DEVE SER INFORMADA COM LETRA MINUSCULA
@Entity
@Table(name = "produto", schema = "banca")
@SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq", initialValue = 1, allocationSize=1)
public class Produto extends PanacheEntity {

//PANACHE NAO ESPECIFICA ID
//PANACHE NAO E NECESSARIO INFORMAR @Column(name = "id")	
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ctry_seq")
	//@SequenceGenerator(name = "ctry_seq", sequenceName = "ctry_seq", initialValue = 1, allocationSize=1)

	//@SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id_seq")
	public Long id;
	public String nome;
	public BigDecimal valor;

	public Produto(ProdutoRequestPayload produtoPayload) {
        this.nome = produtoPayload.getNome();
        System.out.println("Passou no construtor Produto(ProdutoRequestPayload produtoPayload)");
	}
	
	public Produto() {
		super();
		System.out.println("Passou no construtor Produto()");
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
}
