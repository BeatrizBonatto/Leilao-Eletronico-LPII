package beatrizbonatto.com.service;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.repository.LeilaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/leilaos")
@ApplicationScoped
public class LeilaoService {

    @Inject
    LeilaoRepository leilaoRepository;

    @POST
    @Operation(summary = "Criar um novo leilão")
    @APIResponse(responseCode = "201", description = "Leilão criado com sucesso.")
    public Response reLeilao(Leilao leilao) {
        leilaoRepository.registroLeilao(leilao);
        return Response.status(Response.Status.CREATED).entity(leilao).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar leilão por ID")
    @APIResponse(responseCode = "200", description = "Leilão encontrado.")
    @APIResponse(responseCode = "404", description = "Leilão não encontrado.")
    public Response consultaLeilao(@PathParam("id") Long id) {
        Leilao leilao = leilaoRepository.consultaLeilao(id);
        if (leilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilao).build();
    }

    @GET
    @Operation(summary = "Listar todos os leilões")
    @APIResponse(responseCode = "200", description = "Lista de leilões.")
    public List<Leilao> listaDeLeiloes() {
        return leilaoRepository.listaDeLeiloes();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um leilão existente")
    @APIResponse(responseCode = "200", description = "Leilão atualizado com sucesso.")
    @APIResponse(responseCode = "404", description = "Leilão não encontrado.")
    public Response atualizarLeilao(@PathParam("id") Long id, Leilao leilao) {
        Leilao leilaoExistente = leilaoRepository.consultaLeilao(id);
        if (leilaoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        leilaoExistente.setDataInicio(leilao.getDataInicio());
        leilaoExistente.setDataFim(leilao.getDataFim());
        leilaoExistente.setDataVisitacao(leilao.getDataVisitacao());
        leilaoExistente.setDominioLeilaoEletronico(leilao.getDominioLeilaoEletronico());
        leilao.setEndereco(leilao.getEndereco());
        leilao.setCidade(leilao.getCidade());
        leilao.setEstado(leilao.getEstado());
        leilao.setStatus(leilao.getStatus());
        leilaoRepository.atualizar(leilaoExistente);
        return Response.ok(leilaoExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remover um leilão existente")
    @APIResponse(responseCode = "204", description = "Leilão removido com sucesso.")
    @APIResponse(responseCode = "404", description = "Leilão não encontrado.")
    public Response removerLeilao(@PathParam("id") Long id) {
        Leilao leilao = leilaoRepository.consultaLeilao(id);
        if (leilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        leilaoRepository.remocao(id);
        return Response.noContent().build();
    }
}
