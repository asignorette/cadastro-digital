package br.com.confidencecambio.cadastrodigital.rotas;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

@Component
public class RestConfiguration extends RouteBuilder {

    @Autowired
    ServerProperties serverProperties;

    @Override
    public void configure() throws Exception {
        /************************
         * Rest configuration. There should be only one in a CamelContext
         ************************/
        restConfiguration().component("servlet") //Requires "CamelServlet" to be registered
                .bindingMode(RestBindingMode.json)

                //Enable swagger endpoint. It's actually served by a Camel route
                .apiContextPath("/swagger") //swagger endpoint path; Final URL: Camel path + apiContextPath: /api/swagger
                .apiContextRouteId("swagger") //id of route providing the swagger endpoint

                .contextPath("/api") //base.path swagger property; use the mapping URL set for CamelServlet camel.component.servlet.mapping.contextPath
                .apiProperty("api.title", "Example REST api")
                .apiProperty("api.version", "1.0")
                //.apiProperty("schemes", "" ) //Setting empty string as scheme to support relative urls
                .apiProperty("schemes", serverProperties.getSsl() != null && serverProperties.getSsl().isEnabled() ? "https" : "http" )
                .apiProperty("host", "") //Setting empty string as host so swagger-ui make relative url calls. By default 0.0.0.0 is used
        ;
    }

}
