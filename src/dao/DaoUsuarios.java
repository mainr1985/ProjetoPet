package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author Maíra
 */
public class DaoUsuarios extends DaoFactory {

    private PreparedStatement ps;
    private ResultSet rs;
    
    public void salvar(Usuario usuario) throws SQLException {
        String insert = "INSERT INTO usuario (nomeusu,senha,permissao,id_funcionario) VALUES (?,?,?,?)";
        salvar (insert, 
                usuario.getUsuario(), 
                usuario.getSenha(),
                usuario.getPermissao(), 
                usuario.getFuncionario().getCodigoFunc());
    }
    
    
    /*public boolean consultarLogin(Veterinario usuario){
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
    }*/
}