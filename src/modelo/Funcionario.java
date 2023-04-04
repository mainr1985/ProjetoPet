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
    private String cargo;
    private String permissao;
    private String nomeUsuario;
    private String senha;    
    private Date dtAdmissao;
    private Date dtLimiteLogin;
    private TipoFuncionario tipoFuncionario;
        
    public Funcionario (){}

    public Funcionario(Integer codigoFunc, String cargo, String permissao, String nomeUsuario, String senha, Date dtAdmissao, Date dtLimiteLogin, 
                       TipoFuncionario tipoFuncionario, String rg, String cpf, String nome, Date dataNasc, String email, String endereco, String complemento, 
                       String bairro, String cidade, String telefone) {
        
        super(rg, cpf, nome, dataNasc, email, endereco, complemento, bairro, cidade, telefone);
        this.codigoFunc = codigoFunc;
        this.cargo = cargo;
        this.permissao = permissao;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dtAdmissao = dtAdmissao;
        this.dtLimiteLogin = dtLimiteLogin;
        this.tipoFuncionario = tipoFuncionario;
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

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigoFunc=" + codigoFunc + ", cargo=" + cargo + ", permissao=" + permissao + 
                            ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", dtAdmissao=" + dtAdmissao + 
                            ", dtLimiteLogin=" + dtLimiteLogin + ", tipoFuncionario=" + tipoFuncionario + '}';
    }    
}