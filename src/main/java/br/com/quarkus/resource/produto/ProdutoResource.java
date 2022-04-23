package br.com.quarkus.resource.produto;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.quarkus.model.Produto;
import br.com.quarkus.payload.produto.ProdutoRequestPayload;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;

@Path("/bancaproduto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

//@Transactional QUANDO SENSIBILIZA O DB	

	@GET
	public List<Produto> findAll() {
		System.out.println("PESQUISA TUDO");
		return Produto.find("select p.id, p.nome from Produto p").list();
	}

	@GET
	@Path("/{id}")
	public List<Produto> findUnit(@PathParam("id") Long id) {
		return Produto.find("select p.id, p.nome from Produto p where p.id = :id", Parameters.with("id", id)).list();
	}

	//
	
	//@POST JSON INFORMADO SEM O ID
	@POST
	@Transactional
	public void criar(Produto produto) {
		produto.persist();
	}

//    @Transactional
//    @POST
//    public Response criar(final ProdutoRequestPayload produtoPayload, @Context UriInfo uriInfo) {
//        final var novoProduto = new Produto(produtoPayload);
//        novoProduto.persistAndFlush();
//        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(novoProduto.id));
//        return Response.created(uriBuilder.build()).build();
//    }

    @PUT
    @Path("/atualiza/{id}")
    @Transactional
    public void atualizar(@PathParam("id") final Long id, final ProdutoRequestPayload produtotoPayload) {
        final Optional<Produto> possivelProduto = Produto.findByIdOptional(id);
        possivelProduto.map(produto -> {
                    produto.nome = produtotoPayload.getNome();
                    produto.valor = produtotoPayload.getValor();
                    produto.persist();
                    return produto;
                })
                .orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/apagar/{id}")
    @Transactional   
    public void deletar(@PathParam("id") final Long id) {
        Produto.findByIdOptional(id)
            .ifPresentOrElse(PanacheEntityBase::delete, () -> {
                throw new NotFoundException();
            });
    }
}
