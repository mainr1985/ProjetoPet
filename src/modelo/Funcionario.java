package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra & Rafael
 */
public abstract class Funcionario extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;  
    private Integer codigoFunc;
    private String permissao;
    private String nomeUsuario;
    private String senha;    
    private Date dtAdmissao;
    private Date dtLimiteLogin;
    private TipoFuncionario cargo;
        
    public Funcionario (){}

    public Funcionario(Integer codigoFunc, String permissao, String nomeUsuario, String senha, Date dtAdmissao, Date dtLimiteLogin, TipoFuncionario cargo, 
                       String rg, String cpf, String nome, Date dataNasc, String email, String endereco, String complemento, String bairro, String cidade, 
                       String telefone, String celular, Date dtCadastro) {
        
        super(rg, cpf, nome, dataNasc, email, endereco, complemento, bairro, cidade, telefone, celular, dtCadastro);
        this.codigoFunc = codigoFunc;
        this.permissao = permissao;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dtAdmissao = dtAdmissao;
        this.dtLimiteLogin = dtLimiteLogin;
        this.cargo = cargo;
    }

    public TipoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(TipoFuncionario cargo) {
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

    public Date getDtLimiteLogin() {
        return dtLimiteLogin;
    }

    public void setDtLimiteLogin(Date dtLimiteLogin) {
        this.dtLimiteLogin = dtLimiteLogin;
    }

    public Integer getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(Integer codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigoFunc=" + codigoFunc + ", permissao=" + permissao + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha 
                            + ", dtAdmissao=" + dtAdmissao + ", dtLimiteLogin=" + dtLimiteLogin + ", cargo=" + cargo + '}';
    }
}