package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoPessoa;

/**
 *
 * @author Maíra & Rafael
 */
public abstract class Funcionario extends PessoaFisica implements Serializable {
    
    private static final long serialVersionUID = 1L;  
    private Integer codFunc;
    private String cargo;
    private String permissao;
    private String nomeUsuario;
    private String senha;    
    private Date dtAdmissao;
    private Date dtDemissao;
        
    public Funcionario (){}

    public Funcionario(Integer codFunc,String cargo, String permissao, String nomeUsuario, String senha, 
                       Date dtAdmissao, Date dtDemissao, String rg, String cpf, String nome, 
                       Endereco endereco, Contato contato, TipoPessoa tipoPessoa) {
        
        super(rg, cpf, nome, endereco, contato, tipoPessoa);
        this.codFunc = codFunc;
        this.cargo = cargo;
        this.permissao = permissao;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dtAdmissao = dtAdmissao;
        this.dtDemissao = dtDemissao;
    }
   
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Date getDtDemissao() {
        return dtDemissao;
    }

    public void setDtDemissao(Date dtDemissao) {
        this.dtDemissao = dtDemissao;
    }

    public Integer getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(Integer codFunc) {
        this.codFunc = codFunc;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codFunc=" + codFunc + ", cargo=" + cargo + ", permissao=" + permissao + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", dtAdmissao=" + dtAdmissao + ", dtDemissao=" + dtDemissao + '}';
    }
}