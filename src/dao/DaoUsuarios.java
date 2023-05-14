package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Usuario> listarUsuarios(){
        String sql = "SELECT nomeusu,senha "
                + "   FROM funcionario func "
                + "     INNER JOIN usuario usu ON func.id_funcionario = usu.id_funcionario ";    
        
        List<Usuario> usuarios = new ArrayList();
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setUsuario(rs.getString("nomeusu"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);                
            }
            return usuarios;            
        }
        
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }        
    }
}