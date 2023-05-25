package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Usuario;
import modelo.Veterinario;

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
    
    public boolean validarUsuario(Usuario usuario) throws SQLException{
        boolean autenticado = false;
        String sql = "SELECT nomeusu, senha FROM usuario WHERE nomeusu = ? AND senha = ? ";
        ps = getConnection().prepareStatement(sql);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getSenha());
        rs = ps.executeQuery();
        if (rs.next()){
           String login = rs.getString("nomeusu");
           String senha = rs.getString("senha");
           autenticado = true;
        }
        ps.close();
        return autenticado;
    }
    
    public boolean validarNomeUsuario(Usuario usuario) throws SQLException{
        boolean cadastrado = false;
        String sql = "SELECT nomeusu FROM usuario WHERE nomeusu = ? ";
        ps = getConnection().prepareStatement(sql);
        ps.setString(1, usuario.getUsuario());
        rs = ps.executeQuery();
        if (rs.next()){
           String login = rs.getString("nomeusu");        
           cadastrado = true;
        }
        ps.close();
        return cadastrado;
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
    
    public String getPermissao(String usuario) throws SQLException{
        String sql = " SELECT permissao FROM usuario WHERE nomeusu = ? ";
        String permissao = "";
        try{
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setPermissao(rs.getString("permissao"));
                permissao = usu.getPermissao();                           
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return permissao;
    }    
    
    public Date getDtLimAcesso(String usuario) throws SQLException{
        String sql = " SELECT dtlimacesso FROM usuario WHERE nomeusu = ? ";
        Date data = null;
        try{
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setDtLimAcesso(rs.getDate("dtlimacesso"));
                data = usu.getDtLimAcesso();                           
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    
    public List<Usuario> listarUsuariosPorFuncionario(String funcionario) throws SQLException{
              
        String sql = "SELECT "
                +    "      func.id_funcionario, "
                + "         func.nome, "
                + "         usu.nomeusu, "
                + "         usu.senha, "
                + "         usu.permissao, "
                + "         usu.dtlimacesso "
                + "FROM funcionario func "
                + "     INNER JOIN usuario usu ON func.id_funcionario = usu.id_funcionario "
                + "WHERE upper(func.nome) ilike concat (?,'%') ";
        
        List<Usuario> usuarios = new ArrayList();
        
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, ((Normalizer.normalize(funcionario,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""))) + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();   
                Veterinario funcionario1 = new Veterinario();
                funcionario1.setCodigoFunc(rs.getInt("id_funcionario"));
                funcionario1.setNome(rs.getString("nome"));
                usuario.setFuncionario(funcionario1);
                usuario.setUsuario(rs.getString("nomeusu"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPermissao(rs.getString("permissao"));
                
                Date data = rs.getDate("dtlimacesso");
                if (data != null){
                    usuario.setDtLimAcesso(data);
                }
                usuarios.add(usuario);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }
}