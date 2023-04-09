
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
public class DaoFuncionario extends DaoFactory{
            
    public void salvarFuncionario(Veterinario veterinario) throws SQLException{
        
       String insert = "INSERT INTO funcionario "
                     + " (cpf, rg, nome, cargo, endereco , email, endereco, complemento, cidade, dtnascimento, dtcadastro, dtadmissao) "
                     + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
       
       salvar (insert, 
               veterinario.getCpf(),               
               veterinario.getRg(),               
               veterinario.getNome(),
               veterinario.getCargo(),
               veterinario.getEndereco(),
               veterinario.getComplemento(),
               veterinario.getCidade(),
               veterinario.getDataNasc(),
               veterinario.getDtCadastro(),
               veterinario.getDtAdmissao());               
    }    
        
    //DESCOBRIR COMO PEGAR O ID DO USUARIO CLICADO PARA PASSAR PRO UPDATE -> NÃO É INSERT!
    public void salvarUsuario(Veterinario v) throws SQLException{
        
        //select pra pegar o funcionário salvo
        //String busca = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        
        //fazer o sistema atribuir o código pro funcionario cadastrado, sem mostrar na tela.
        
        String update = " UPDATE funcionario SET nomeusuario = ?, senha = ?, permissao = ? where id_funcionario = ? "; 
        
        //String insert = "INSERT INTO funcionario (nomeusuario, senha, permissao) VALUES (?,?,?) ";
                        
        salvar (update, v.getNomeUsuario(),
                        v.getSenha(),
                        v.getPermissao()
       );  
    }    
    
    public void alterar(Veterinario v) throws SQLException {
        /*String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());*/
    }
    
    public void alterarUsuario(Veterinario v) throws SQLException {
        /*String update = " UPDATE veterinario " +
                        " SET nomeusuario = ?, "
                        + "  senha = ?, " 
                        + "  permissao = ? "
                        + " WHERE id_funcionario = ? ";
        update(update, v.getNomeUsuario(),v.getSenha(), v.getPermissao());*/
    }    
}