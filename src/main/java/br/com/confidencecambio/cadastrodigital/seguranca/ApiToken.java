package br.com.confidencecambio.cadastrodigital.seguranca;

import br.com.confidencecambio.cadastrodigital.entidade.Autenticacao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource("classpath:application.properties")
public class ApiToken {

    private static final String CONTEXT_API_SOCC = "/api";
    private static final String CONTEXT_API_IB_AUTH = "/api-ib/v1/auth";

    @Value( "${ip.api.ib}" )
    private String ipApiIb;

    public HttpHeaders getHeaderComToken(){
        StringBuilder url = new StringBuilder();
        url.append(ipApiIb);
        url.append(CONTEXT_API_IB_AUTH);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(this.criarUsuarioJson(), headers);

        ResponseEntity<Autenticacao> response = restTemplate.exchange(
                url.toString(), HttpMethod.POST, entity, Autenticacao.class);

        headers = new HttpHeaders();
        headers.set("auth", response.getBody().getAuth());

        return headers;
    }

    private String criarUsuarioJson() {
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> myMap = new HashMap<>();
        myMap.put("usuario", "asignorette");
        myMap.put("senha", "zx32$%deNN");
        return gson.toJson(myMap);

    }


}
