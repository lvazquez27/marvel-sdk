package mx.openpay.marvel_sdk.client;

import mx.openpay.marvel_sdk.model.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
        "marvel.private_key=${PRIVATE_KEY}",
        "marvel.public_key=${PUBLIC_KEY}"
})
class MarvelClientTest {
    @Value("${marvel.public_key}")
    private  String PUBLIC_KEY;
    @Value(("${marvel.private_key}"))
    private String PRIVATE_KEY;
    private MarvelClient mc;

    @BeforeEach
    void setUp(){
        mc = new MarvelClient(PUBLIC_KEY, PRIVATE_KEY);
    }

    @Test
    void listCharacters() {
        ApiResponse response = mc.listCharacters();

        assertNotNull(response);
        assertNotNull(response.getData());
        assertEquals(200, response.getCode());
        assertTrue(response.getData().getResults().size() > 0);
    }

    @Test
    void getCharacterById() {

        ApiResponse response = mc.getCharacterById(1010699);
        assertNotNull(response);
        assertNotNull(response.getData());
        assertEquals(200, response.getCode());
        assertEquals(1, response.getData().getResults().size());
    }
}