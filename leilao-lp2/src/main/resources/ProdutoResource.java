import jakarta.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
public class ProdutoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        return "[{\"id\":1,\"nome\":\"Produto A\"}, {\"id\":2,\"nome\":\"Produto B\"}]";
    }
}
