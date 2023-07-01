package mx.openpay.marvel_sdk.client;

import lombok.NoArgsConstructor;
import mx.openpay.marvel_sdk.model.ApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@NoArgsConstructor
public class MarvelClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private  String PUBLIC_KEY;
    private String PRIVATE_KEY;

    public MarvelClient(String PUBLIC_KEY, String PRIVATE_KEY){
        this.PUBLIC_KEY=PUBLIC_KEY;
        this.PRIVATE_KEY=PRIVATE_KEY;
    }

    public ApiResponse listCharacters(){
        String endPoint = this.buildUrl("/characters");
        return restTemplate.getForObject(endPoint,ApiResponse.class);
    }

    public ApiResponse getCharacterById(Integer characterId){
        String endPoint = this.buildUrl("/characters/" + characterId);
        return restTemplate.getForObject(endPoint,ApiResponse.class);
    }

    private String buildUrl(String path){
        Long ts = new Date().getTime();
        String hash = this.generateHash(ts);
        String BASE_URL ="https://gateway.marvel.com:443/v1/public";
        String KEYS= "?apikey=" + PUBLIC_KEY + "&ts="+ ts + "&hash=" + hash;
        return BASE_URL + path + KEYS;
    }

    private String generateHash(Long ts){
        String textHash = ts + PRIVATE_KEY + PUBLIC_KEY;
        return DigestUtils.md5DigestAsHex(textHash.getBytes());
    }

}
