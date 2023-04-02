package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maíra
 */
public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;  
    private Endereco endereco;
    private Contato contato;
    private String rg;
    private String cpf;
    private String nome;
    private Date dataNasc;

    public Pessoa() {
    }

    public Pessoa(Endereco endereco, Contato contato, String rg, String cpf, String nome, Date dataNasc) {
        this.endereco = endereco;
        this.contato = contato;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }   

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
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
    
    @Override
    public String toString() {
        return "Pessoa{" + "endereco=" + endereco + ", contato=" + contato + '}';
    }
}