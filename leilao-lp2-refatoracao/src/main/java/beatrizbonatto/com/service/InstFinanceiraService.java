package beatrizbonatto.com.service;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import beatrizbonatto.com.model.InstFinanceira;
import beatrizbonatto.com.repository.InstFinanceiraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/instFinanceiras")
@ApplicationScoped
public class InstFinanceiraService {
    
    @Inject
    InstFinanceiraRepository InstFinanceiraRepository;

    @POST
    @Operation(summary = "Criar uma nova Instituição Financeira")
    @APIResponse(responseCode = "201", description = "Instituição Financeira criada com sucesso.")
    public Response reInstFinanceira(InstFinanceira instFinanceira) {
        InstFinanceiraRepository.registroInstFinanceira(instFinanceira);
        return Response.status(Response.Status.CREATED).entity(instFinanceira).build();  
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar Instituição Financeira por ID")
    @APIResponse(responseCode = "200", description = "Instituição Financeira encontrada.")
    @APIResponse(responseCode = "404", description = "Instituição Financeira não encontrada.")
    public Response consultaInstFinanceira(@PathParam("id") Long id) {
        InstFinanceira instFinanceira = InstFinanceiraRepository.consultaInstFinanceira(id);
        if (instFinanceira == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(instFinanceira).build(); 
    }

    @GET
    @Operation(summary = "Listar todas as Instituições Financeiras")
    @APIResponse(responseCode = "200", description = "Lista de InstFinanceiras.")
    public List<InstFinanceira> listaDeInstFinanceiras() {
        return InstFinanceiraRepository.listaDeInstFinanceiras();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar uma Instituição Financeira existente")
    @APIResponse(responseCode = "200", description = "Instituição Financeira atualizada com sucesso.")
    @APIResponse(responseCode = "404", description = "Instituição Financeira não encontrada.")
    public Response atualizarInstFinanceira(@PathParam("id") Long id, InstFinanceira instFinanceira) {
        InstFinanceira instFinanceiraExistente = InstFinanceiraRepository.consultaInstFinanceira(id);
        if (instFinanceiraExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        instFinanceiraExistente.setCnpj(instFinanceira.getCnpj());
        instFinanceiraExistente.setCodigo(instFinanceira.getCodigo());
        instFinanceiraExistente.setNome(instFinanceira.getNome());
        InstFinanceiraRepository.atualizar(instFinanceiraExistente);
        return Response.ok(instFinanceiraExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remover uma Instituição Financeira existente")
    @APIResponse(responseCode = "204", description = "Instituição Financeira removida com sucesso.")
    @APIResponse(responseCode = "404", description = "Instituição Financeira não encontrada.")
    public Response removerInstFinanceira(@PathParam("id") Long id) {
        InstFinanceira instFinanceira = InstFinanceiraRepository.consultaInstFinanceira(id);
        if (instFinanceira == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        InstFinanceiraRepository.remocao(id);
        return Response.noContent().build();
    }
}
