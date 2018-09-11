package br.com.confidencecambio.cadastrodigital.boot;


import br.com.confidencecambio.cadastrodigital.configuracao.CamelConfiguration;
import br.com.confidencecambio.cadastrodigital.configuracao.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CamelConfiguration.class, SwaggerConfiguration.class})
@ComponentScan("br.com.confidencecambio")
public class CadastroDigitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastroDigitalApplication.class, args);
    }



}
