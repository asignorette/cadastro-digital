
package br.com.confidencecambio.cadastrodigital.entidade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "nomeCurto",
    "documentoCliente",
    "empresa",
    "auth",
    "necessitaAlterarSenha",
    "permissoes",
    "contas"
})
public class Autenticacao {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nomeCurto")
    private String nomeCurto;
    @JsonProperty("documentoCliente")
    private String documentoCliente;
    @JsonProperty("empresa")
    private Empresa empresa;
    @JsonProperty("auth")
    private String auth;
    @JsonProperty("necessitaAlterarSenha")
    private Boolean necessitaAlterarSenha;
    @JsonProperty("permissoes")
    private List<String> permissoes = null;
    @JsonProperty("contas")
    private List<Object> contas = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nomeCurto")
    public String getNomeCurto() {
        return nomeCurto;
    }

    @JsonProperty("nomeCurto")
    public void setNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    @JsonProperty("documentoCliente")
    public String getDocumentoCliente() {
        return documentoCliente;
    }

    @JsonProperty("documentoCliente")
    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    @JsonProperty("empresa")
    public Empresa getEmpresa() {
        return empresa;
    }

    @JsonProperty("empresa")
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @JsonProperty("auth")
    public String getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(String auth) {
        this.auth = auth;
    }

    @JsonProperty("necessitaAlterarSenha")
    public Boolean getNecessitaAlterarSenha() {
        return necessitaAlterarSenha;
    }

    @JsonProperty("necessitaAlterarSenha")
    public void setNecessitaAlterarSenha(Boolean necessitaAlterarSenha) {
        this.necessitaAlterarSenha = necessitaAlterarSenha;
    }

    @JsonProperty("permissoes")
    public List<String> getPermissoes() {
        return permissoes;
    }

    @JsonProperty("permissoes")
    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }

    @JsonProperty("contas")
    public List<Object> getContas() {
        return contas;
    }

    @JsonProperty("contas")
    public void setContas(List<Object> contas) {
        this.contas = contas;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
