package modelo;

import java.io.Serializable;

/**
 *
 * @author Maíra & Rafael
 */
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;      
    private String usuario;
    private String senha;	 
    private String permissao;	 
    private Funcionario funcionario;

    public Usuario() {
    }
        
    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Usuario(String usuario, String senha, String permissao, Funcionario funcionario) {
        this.usuario = usuario;
        this.senha = senha;
        this.permissao = permissao;
        this.funcionario = funcionario;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void validarUsuario(String nomeUsuario, char senha){
        
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", senha=" + senha + ", permissao=" + permissao + ", funcionario=" + funcionario + '}';
    }
}