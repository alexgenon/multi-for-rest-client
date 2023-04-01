import io.quarkus.test.junit.QuarkusTest
import io.smallrye.mutiny.helpers.test.AssertSubscriber
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.net.URLEncoder
import javax.inject.Inject

@QuarkusTest
class VideoStreamTest {
    private val LOG=Logger.getLogger(javaClass)
    
    @Inject
    @RestClient
    lateinit var greetingClient: GreetingClient

    @Test
    fun testVideoStream(){
        val greetings = this.greetingClient.getGreetings()
        val subscriber = greetings
            .subscribe()
            .withSubscriber(AssertSubscriber.create(10))

        val result = subscriber
            .awaitCompletion()
            .assertCompleted()
            .items

        assertAll("Greetings retrieval",
            { assertEquals(10,result.size)}
        )
    }
}