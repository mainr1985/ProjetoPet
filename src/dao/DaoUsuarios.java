package dao;
import controle.ControleLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoUsuarios extends DaoFactory {
    
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    ControleLogin controleLogin = new ControleLogin();
    
    public void salvar(Veterinario veterinario, Usuario usuario) throws SQLException {
        String insert = "INSERT INTO usuario (nome_usuario,senha,permissao,id_funcionario) VALUES (?,?,?,?)";
        salvar (insert, usuario.getUsuario(), controleLogin.pegaSenha(usuario),usuario.getPermissao(), veterinario.getCodigoFunc());
    }
    
}
