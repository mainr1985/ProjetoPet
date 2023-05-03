package dao;
import controle.ControleLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
    
    /*public void salvar(Veterinario veterinario, Usuario usuario) throws SQLException {
        String insert = "INSERT INTO usuario (nome_usuario,senha,permissao,id_funcionario) VALUES (?,?,?,?)";
        salvar (insert, usuario.getUsuario(), controleLogin.pegaSenha(usuario),usuario.getPermissao(), veterinario.getCodigoFunc());
    }
    */
    
    public boolean consultarLogin(Veterinario usuario){
        boolean achou=false;
            try{
		ps = conexao.prepareStatement("select permissao,nome from funcionario where nomeusuario = ? and senha = ?");
		ps.setString(1, usuario.getNomeUsuario());
		ps.setString(2, usuario.getSenha());
			
		rs = ps.executeQuery();			
			
		if(rs.next()){
                    usuario.setPermissao(rs.getString("permissao"));
		    usuario.setNome(rs.getString("nome"));
		    achou = true;			
		}
                else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado.Entre em contato com o administrador!","Aviso",JOptionPane.WARNING_MESSAGE);
		    achou = false;
		}
	    }
            catch(SQLException ex){
		JOptionPane.showMessageDialog(null, "Operação não realizada"+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE);
            }
	    return achou;
    }
}