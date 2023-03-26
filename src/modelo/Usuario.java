package modelo;

import java.io.Serializable;

/**
 *
 * @author Maíra & Rafael
 */
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;      
    private String usuario;
    private char[] senha;	 
    private String permissao;	 
    private Funcionario funcionario;

    public Usuario() {
    }
        
    public Usuario(String usuario, char[] senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Usuario(String usuario, char[] senha, String permissao, Funcionario funcionario) {
        this.usuario = usuario;
        this.senha = senha;
        this.permissao = permissao;
        this.funcionario = funcionario;
    }
    
    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
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

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void cadastrarUsuario(Usuario user) {
       
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", senha=" + senha + ", permissao=" + permissao + ", funcionario=" + funcionario + '}';
    }
}