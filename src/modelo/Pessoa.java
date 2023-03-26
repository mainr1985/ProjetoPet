package modelo;

import java.io.Serializable;
import modelo.enums.TipoPessoa;

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
    private Date dtNascimento;


    public Pessoa() {
    }

    public Pessoa(Endereco endereco, Contato contato, TipoPessoa tipoPessoa) {
        this.endereco = endereco;
        this.contato = contato;
        this.tipoPessoa = tipoPessoa;
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "endereco=" + endereco + ", contato=" + contato + ", tipoPessoa=" + tipoPessoa + '}';
    }
}