import io.smallrye.mutiny.Multi
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/hello")
@RegisterRestClient
interface GreetingClient{
    @GET
    fun getGreetings(): Multi<String>
}