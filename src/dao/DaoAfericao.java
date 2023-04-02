
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Afericao;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoAfericao extends DaoFactory{
            
    public void salvarAfericao(Afericao afericao, Veterinario veterinario) throws SQLException{
        
       String insert = "INSERT INTO afericao "
                     + " (responsavel, crmv, dhafericao, temp_min, temp_max, equipamento, observacoes) "
                     + " VALUES (?,?,?,?,?,?,?) ";
       
       salvar (insert, 
               veterinario.getNome(),
               veterinario.getCrmv(),
               
               afericao.getTempMin(),
               afericao.getTempMax(),
               afericao.getEquipamento(),
               afericao.getObservacoes());               
               
    }    
        
    public void alterar(Veterinario veterinario, Afericao afericao) throws SQLException {
        /*String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());*/
    }
    
    public void alterarUsuario(Veterinario veterinario, Afericao afericao) throws SQLException {
        /*String update = " UPDATE veterinario " +
                        " SET nomeusuario = ?, "
                        + "  senha = ?, " 
                        + "  permissao = ? "
                        + " WHERE id_funcionario = ? ";
        update(update, v.getNomeUsuario(),v.getSenha(), v.getPermissao());*/
    }    
}