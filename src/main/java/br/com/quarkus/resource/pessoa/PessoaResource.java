package br.com.quarkus.resource.pessoa;

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

import br.com.quarkus.model.Pessoa;
import br.com.quarkus.payload.pessoa.PessoaRequestPayload;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;

@Path("/bancapessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

//@Transactional QUANDO SENSIBILIZA O DB	

	@GET
	public List<Pessoa> findAll() {
		System.out.println("PESQUISA TUDO");
		return Pessoa.find("select p.id, p.nome from Pessoa p").list();
	}

	@GET
	@Path("/{id}")
	public List<Pessoa> findUnit(@PathParam("id") Long id) {
		return Pessoa.find("select p.id, p.nome from Pessoa p where p.id = :id", Parameters.with("id", id)).list();
	}

	//
	
	//@POST JSON INFORMADO SEM O ID
	@POST
	@Transactional
	public void criar(Pessoa pessoa) {
		pessoa.persist();
	}

//    @Transactional
//    @POST
//    public Response criar(final PessoaRequestPayload produtoPayload, @Context UriInfo uriInfo) {
//        final var novoPessoa = new Pessoa(produtoPayload);
//        novoPessoa.persistAndFlush();
//        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(novoPessoa.id));
//        return Response.created(uriBuilder.build()).build();
//    }

    @PUT
    @Path("/atualiza/{id}")
    @Transactional
    public void atualizar(@PathParam("id") final Long id, final PessoaRequestPayload pessoatoPayload) {
        final Optional<Pessoa> possivelPessoa = Pessoa.findByIdOptional(id);
        possivelPessoa.map(pessoa -> {
                    pessoa.nome = pessoatoPayload.getNome();
                    pessoa.persist();
                    return pessoa;
                })
                .orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/apagar/{id}")
    @Transactional   
    public void deletar(@PathParam("id") final Long id) {
        Pessoa.findByIdOptional(id)
            .ifPresentOrElse(PanacheEntityBase::delete, () -> {
                throw new NotFoundException();
            });
    }

}