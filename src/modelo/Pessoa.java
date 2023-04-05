package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maíra
 */
public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    private String rg;
    private String cpf;
    private String nome;
    private Date dataNasc;
    private String email ;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String telefone;
    private String celular;
    

    public Pessoa() {
    }

    public Pessoa(String rg, String cpf, String nome, Date dataNasc, String email, String endereco, String complemento, String bairro, String cidade, String telefone, String celular) {
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.endereco = endereco;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
        this.celular = celular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "rg=" + rg + ", cpf=" + cpf + ", nome=" + nome + ", dataNasc=" + dataNasc + ", email=" + email + ", endereco=" + endereco + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", telefone=" + telefone + ", celular=" + celular + '}';
    }
}