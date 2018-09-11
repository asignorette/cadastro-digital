package br.com.confidencecambio.cadastrodigital.rotas;

import br.com.confidencecambio.cadastrodigital.seguranca.ApiToken;
import br.com.confidencecambio.cadastrodigital.vo.BancoVO;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BancoRota extends RouteBuilder {

    @Autowired
    private ApiToken apiToken;

    @Value( "${ip.api.ib}" )
    private String ipApiIb;

    @Override
    public void configure() {

        StringBuilder url = new StringBuilder();
        url.append(ipApiIb);
        url.append("/api-ib/v1/bancos");

        HttpHeaders headers = apiToken.getHeaderComToken();

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<BancoVO>> bancos = restTemplate.exchange(
                url.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<BancoVO>>() {});

        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/bancos").get().outType(BancoVO.class)
                .to("direct:talk");
        from("direct:talk")
                .process(exchange -> {
                    exchange.getIn().setBody(bancos.getBody());
                });
    }
}
