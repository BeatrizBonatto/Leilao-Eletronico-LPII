package beatrizbonatto.com.service;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.repository.DispInformaticaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/dispInformatica")
@ApplicationScoped
public class DispInformaticaService {

    @Inject
    DispInformaticaRepository dispInformaticaRepository;

    @POST
    @Operation(summary = "Criar um novo dispositivo de informática")
    @APIResponse(responseCode = "201", description = "Dispositivo de Informática criado com sucesso.")
    public Response reDispInformatica(DispInformatica dispInformatica) {
        dispInformaticaRepository.registroDispInformatica(dispInformatica);
        return Response.status(Response.Status.CREATED).entity(dispInformatica).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar dispositivo de informática por ID")
    @APIResponse(responseCode = "200", description = "Dispositivo de Informática encontrado.")
    @APIResponse(responseCode = "404", description = "Dispositivo de Informática não encontrado.")
    public Response consultaDispInformatica(@PathParam("id") Long id) {
        DispInformatica dispInformatica = dispInformaticaRepository.consultaDispInformatica(id);
        if (dispInformatica == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(dispInformatica).build();
    }

    @GET
    @Operation(summary = "Listar todos os dispositivos de informática")
    @APIResponse(responseCode = "200", description = "Lista de dispositivos de informática.")
    public List<DispInformatica> listaDeDispInformaticas() {
        return dispInformaticaRepository.listaDeDispInformaticas();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um dispositivo de informática existente")
    @APIResponse(responseCode = "200", description = "Dispositivo de Informática atualizado com sucesso.")
    @APIResponse(responseCode = "404", description = "Dispositivo de Informática não encontrado.")
    public Response atualizarDispInformatica(@PathParam("id") Long id, DispInformatica dispInformatica) {
        DispInformatica dispInformaticaExistente = dispInformaticaRepository.consultaDispInformatica(id);
        if (dispInformaticaExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        dispInformaticaExistente.setTipo(dispInformatica.getTipo());
        dispInformaticaExistente.setComplemento(dispInformatica.getComplemento());
        dispInformaticaExistente.setPrecoInicial(dispInformatica.getPrecoInicial());
        dispInformaticaRepository.atualizar(dispInformaticaExistente);
        return Response.ok(dispInformaticaExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remover um dispositivo de informática existente")
    @APIResponse(responseCode = "204", description = "Dispositivo de Informática removido com sucesso.")
    @APIResponse(responseCode = "404", description = "Dispositivo de Informática não encontrado.")
    public Response removerDispInformatica(@PathParam("id") Long id) {
        DispInformatica dispInformatica = dispInformaticaRepository.consultaDispInformatica(id);
        if (dispInformatica == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        dispInformaticaRepository.remocao(id);
        return Response.noContent().build();
    }
}
