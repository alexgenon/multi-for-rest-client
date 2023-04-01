package be.genon

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import io.smallrye.mutiny.Multi

@Path("/hello")
class GreetingResource {

    private val names =
        listOf("Jeff Bezos", "Bill Gates", "Joe Biden", "Donald Trump", "Elon Musk", "Ada Lovelace", "Pikachu","Kathy Perry","Comtesse de la baronne avec un nom long","Jennifer Anniston")
        .map{"Hello $it"}

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    fun hello() = 
        Multi.createFrom().iterable(names)
}