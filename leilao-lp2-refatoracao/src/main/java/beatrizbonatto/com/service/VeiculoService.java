package beatrizbonatto.com.service;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import beatrizbonatto.com.model.Veiculo;
import beatrizbonatto.com.repository.VeiculoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/veiculos")
@ApplicationScoped
public class VeiculoService {

    @Inject
    VeiculoRepository veiculoRepository;

    @POST
    @Operation(summary = "Criar um novo veículo")
    @APIResponse(responseCode = "201", description = "Veículo criado com sucesso.")
    public Response reVeiculo(Veiculo veiculo) {
        veiculoRepository.registroVeiculo(veiculo);
        return Response.status(Response.Status.CREATED).entity(veiculo).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar veículo por ID")
    @APIResponse(responseCode = "200", description = "Veículo encontrado.")
    @APIResponse(responseCode = "404", description = "Veículo não encontrado.")
    public Response consultaVeiculo(@PathParam("id") Long id) {
        Veiculo veiculo = veiculoRepository.consultaVeiculo(id);
        if (veiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(veiculo).build();
    }

    @GET
    @Operation(summary = "Listar todos os veículos")
    @APIResponse(responseCode = "200", description = "Lista de veículos.")
    public List<Veiculo> listaDeVeiculos() {
        return veiculoRepository.listaDeVeiculos();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um veículo existente")
    @APIResponse(responseCode = "200", description = "Veículo atualizado com sucesso.")
    @APIResponse(responseCode = "404", description = "Veículo não encontrado.")
    public Response atualizarVeiculo(@PathParam("id") Long id, Veiculo veiculo) {
        Veiculo veiculoExistente = veiculoRepository.consultaVeiculo(id);
        if (veiculoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        veiculoExistente.setTipo(veiculo.getTipo());
        veiculoExistente.setComplemento(veiculo.getComplemento());
        veiculoExistente.setPrecoInicial(veiculo.getPrecoInicial());
        veiculoRepository.atualizar(veiculoExistente);
        return Response.ok(veiculoExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remover um veículo existente")
    @APIResponse(responseCode = "204", description = "Veículo removido com sucesso.")
    @APIResponse(responseCode = "404", description = "Veículo não encontrado.")
    public Response removerVeiculo(@PathParam("id") Long id) {
        Veiculo veiculo = veiculoRepository.consultaVeiculo(id);
        if (veiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        veiculoRepository.remocao(id);
        return Response.noContent().build();
    }
}
