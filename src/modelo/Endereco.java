package modelo;

import java.io.Serializable;

/**
 *
 * @author Maíra
 */
public class Endereco implements Serializable{
    
    private static final long serialVersionUID = 1L;  
    String logradouro;
    Integer numero;
    String complemento;
    String cidade;
    String bairro;    

    public Endereco() {
    }

    public Endereco(String logradouro, Integer numero, String complemento, String cidade, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.bairro = bairro;        
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Contato{" + "logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + ", bairro=" + bairro + '}';
    }   
}