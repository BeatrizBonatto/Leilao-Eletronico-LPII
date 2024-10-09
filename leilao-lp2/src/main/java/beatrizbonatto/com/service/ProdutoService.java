package beatrizbonatto.com.service;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/produtos")
@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    @POST
    @Operation(summary = "Criar um novo produto")
    @APIResponse(responseCode = "201", description = "Produto criado com sucesso.")
    public Response reProduto(Produto produto) {
        produtoRepository.registroProduto(produto);
        return Response.status(Response.Status.CREATED).entity(produto).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar produto por ID")
    @APIResponse(responseCode = "200", description = "Produto encontrado.")
    @APIResponse(responseCode = "404", description = "Produto não encontrado.")
    public Response consultaProduto(@PathParam("id") Long id) {
        Produto produto = produtoRepository.consultaProduto(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto).build();
    }

    @GET
    @Operation(summary = "Listar todos os produtos")
    @APIResponse(responseCode = "200", description = "Lista de produtos.")
    public List<Produto> listaDeProdutos() {
        return produtoRepository.listaDeProdutos();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um produto existente")
    @APIResponse(responseCode = "200", description = "Produto atualizado com sucesso.")
    @APIResponse(responseCode = "404", description = "Produto não encontrado.")
    public Response atualizarProduto(@PathParam("id") Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.consultaProduto(id);
        if (produtoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoExistente.setTipo(produto.getTipo());
        produtoExistente.setComplemento(produto.getComplemento());
        produtoExistente.setPrecoInicial(produto.getPrecoInicial());
        produtoRepository.atualizar(produtoExistente);
        return Response.ok(produtoExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remover um produto existente")
    @APIResponse(responseCode = "204", description = "Produto removido com sucesso.")
    @APIResponse(responseCode = "404", description = "Produto não encontrado.")
    public Response removerProduto(@PathParam("id") Long id) {
        Produto produto = produtoRepository.consultaProduto(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoRepository.remocao(id);
        return Response.noContent().build();
    }
}
