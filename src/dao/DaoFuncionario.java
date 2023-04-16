
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoFuncionario extends DaoFactory{
            
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet r;
        
    public void salvarFuncionario(Veterinario veterinario) throws SQLException{
        
        String insert = "INSERT INTO funcionario "
                     + " (cpf, rg, nome, cargo, endereco, complemento, cidade, dtnascimento, dtcadastro, dtadmissao,email,telefone,celular) "
                     + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
       salvar (insert, 
               veterinario.getCpf(),               
               veterinario.getRg(),               
               veterinario.getNome(),
               veterinario.getCargo().toString(),
               veterinario.getEndereco(),
               veterinario.getComplemento(),
               veterinario.getCidade(),
               veterinario.getDataNasc(),
               veterinario.getDtCadastro(),
               veterinario.getDtAdmissao(),
               veterinario.getEmail(),
               veterinario.getTelefone(),
               veterinario.getCelular());               
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
    
    public int getCodigoFuncionario(Veterinario veterinario) throws SQLException{
        int i=0;
        try{
            ps = conexao.prepareStatement("SELECT max(id_funcionario) FROM funcionario");
            r = ps.executeQuery();
            if (r.next()){
                i = r.getInt(1);
                veterinario.setCodigoFunc(i);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Operação não realizada. Motivo : " + e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        return i;
     }    
}