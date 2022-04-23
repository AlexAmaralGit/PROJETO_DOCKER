package br.com.quarkus.resource.estoque;

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

import br.com.quarkus.model.Estoque;
import br.com.quarkus.payload.estoque.EstoqueRequestPayload;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;

@Path("/bancaestoque")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstoqueResource {

//@Transactional QUANDO SENSIBILIZA O DB	

	@GET
	public List<Estoque> findAll() {
		System.out.println("PESQUISA TUDO");
		return Estoque.find("select p.id, p.nome from Estoque p").list();
	}

	@GET
	@Path("/{id}")
	public List<Estoque> findUnit(@PathParam("id") Long id) {
		return Estoque.find("select p.id, p.nome from Estoque p where p.id = :id", Parameters.with("id", id)).list();
	}

	//
	
	//@POST JSON INFORMADO SEM O ID
	@POST
	@Transactional
	public void criar(Estoque estoque) {
		estoque.persist();
	}

//    @Transactional
//    @POST
//    public Response criar(final EstoqueRequestPayload estoquePayload, @Context UriInfo uriInfo) {
//        final var novoEstoque = new Estoque(estoquePayload);
//        novoEstoque.persistAndFlush();
//        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(novoEstoque.id));
//        return Response.created(uriBuilder.build()).build();
//    }

    @PUT
    @Path("/atualiza/{id}")
    @Transactional
    public void atualizar(@PathParam("id") final Long id, final EstoqueRequestPayload estoquetoPayload) {
        final Optional<Estoque> possivelEstoque = Estoque.findByIdOptional(id);
        possivelEstoque.map(estoque -> {
                    estoque.qtd = estoquetoPayload.getQtd();
                    estoque.Produto_id = estoquetoPayload.getProduto_id();
                    estoque.persist();
                    return estoque;
                })
                .orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/apagar/{id}")
    @Transactional   
    public void deletar(@PathParam("id") final Long id) {
        Estoque.findByIdOptional(id)
            .ifPresentOrElse(PanacheEntityBase::delete, () -> {
                throw new NotFoundException();
            });
    }
}
