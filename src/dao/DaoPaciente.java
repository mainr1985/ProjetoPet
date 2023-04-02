
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
public class DaoPaciente extends DaoFactory{
            
    public void salvarFuncionario(Veterinario v) throws SQLException{
        
       String insert = "INSERT INTO funcionario "
                     + " (cpf, rg, nome, cargo, endereco /*, email, endereco, numero, complemento, cidade, dtnascimento, dtdemissao*/) "
                     + " VALUES (?,?,?,?,?/*,?,?,?,?,?,?*/)";
       
       salvar (insert, 
               v.getCpf(),               
               v.getRg(),               
               v.getNome(),
               v.getCargo(),
               v.getEndereco().getLogradouro());//,
               //v.getEndereco().getLogradouro(),
               //v.getEndereco().getNumero(),
               //v.getEndereco().getComplemento());
               //v.getEndereco().getBairro(),
               //v.getEndereco().getCidade(),
//               v.getContato().getEmail());       
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