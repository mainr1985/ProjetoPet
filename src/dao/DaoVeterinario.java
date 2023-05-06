package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoVeterinario extends DaoFactory{
   
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
        
    public void salvar(Veterinario veterinario) throws SQLException{

        
       String insert = "INSERT INTO veterinario (crmv,especialidade,id_funcionario) VALUES (?,?,?)";
       salvar (insert,veterinario.getCrmv(),veterinario.getEspecialidade(),veterinario.getCodigoFunc());
    }    
      
    public void alterar(Veterinario v) throws SQLException {
        String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());
    }
    
    public List<String> listarVeterinarios(){
        String sql = "SELECT nome "
                + "   FROM funcionario func "
                + "     INNER JOIN veterinario vet ON func.id_funcionario = vet.id_funcionario "
                + "   WHERE cargo LIKE 'VET%' ";    
        String nome ="";
        List<String> veterinarios = new ArrayList<>();
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Veterinario v = new Veterinario();
                v.setNome(rs.getString("nome"));
                veterinarios.add(v.toString());
            }
            return veterinarios;
        }
        
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
}