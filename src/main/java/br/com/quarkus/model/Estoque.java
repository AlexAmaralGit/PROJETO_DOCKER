package br.com.quarkus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.quarkus.payload.estoque.EstoqueRequestPayload;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


//TABELA DEVE SER INFORMADA COM LETRA MINUSCULA
@Entity
@Table(name = "estoque", schema = "banca")
@SequenceGenerator(name = "estoque_id_seq", sequenceName = "estoque_id_seq", initialValue = 1, allocationSize=1)
public class Estoque extends PanacheEntity {

//PANACHE NAO ESPECIFICA ID
//PANACHE NAO E NECESSARIO INFORMAR @Column(name = "id")	
	
//	@GeneratedValue(strategy = GenerationType.AUTO)

	//@SequenceGenerator(name = "estoque_id_seq", sequenceName = "estoque_id_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_id_seq")
	public Long id;
    
	public int qtd;
    
    public Long Produto_id;

	public Estoque(EstoqueRequestPayload estoquePayload) {
        this.qtd = estoquePayload.getQtd();
        System.out.println("Passou no construtor Estoque(EstoqueRequestPayload estoquePayload)");
	}
	
	public Estoque() {
		super();
		System.out.println("Passou no construtor Estoque()");
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
