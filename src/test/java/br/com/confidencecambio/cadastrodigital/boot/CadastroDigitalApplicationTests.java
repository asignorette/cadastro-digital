package br.com.confidencecambio.cadastrodigital.boot;

import br.com.confidencecambio.cadastrodigital.seguranca.ApiToken;
import br.com.confidencecambio.cadastrodigital.vo.BancoVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("br.com.confidencecambio")
@ActiveProfiles("tst")
public class CadastroDigitalApplicationTests {

	@Autowired
	private ApiToken apiToken;

	@Value( "${ip.api.ib}" )
	private String ipApiIb;

	@Test
	public void testBancos() {

		StringBuilder url = new StringBuilder();
		url.append(ipApiIb);
		url.append("/api-ib/v1/bancos");

		HttpHeaders headers = apiToken.getHeaderComToken();

		HttpEntity entity = new HttpEntity(headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<BancoVO>> bancos = restTemplate.exchange(
				url.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<BancoVO>>() {});

		 Assert.assertNotEquals(bancos.getBody().size(), 0);
	}

}
