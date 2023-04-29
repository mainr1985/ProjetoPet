package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
   
}