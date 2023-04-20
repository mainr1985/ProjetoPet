package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Tutor;

/**
 *
 * @author Maíra
 */
public class DaoTutor extends DaoFactory{
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;
        
    public void salvar(Tutor tutor) throws SQLException{
        
       String insert = " INSERT INTO tutor (cpf, rg, nome, dtnasc, endereco, complemento, bairro, cidade, telefone, celular, email, dtcadastro) "
               + "                   VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";       
       
       salvar (insert,
               tutor.getCpf(), 
               tutor.getRg(), 
               tutor.getNome(), 
               tutor.getDataNasc(), 
               tutor.getEndereco(),
               tutor.getComplemento(), 
               tutor.getBairro(), 
               tutor.getCidade(), 
               tutor.getTelefone(),
               tutor.getCelular(), 
               tutor.getEmail(),
               tutor.getDtCadastro()
               );  
    }    
      
    /*public void alterar(Veterinario v) throws SQLException {
        String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());
    }
*/    
    public int getCodigoTutor() throws SQLException{
        int i=0;
        String sql = "SELECT max(codtutor) FROM tutor";
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                i = rs.getInt(1);                                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Operação não realizada. Motivo : " + e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        return i;
     }    
    
    public String getNomeTutor() throws SQLException{
        String i="";
        String sql = "SELECT nome FROM tutor WHERE codtutor = ?"; //+ getCodigoTutor()+1;
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                i = rs.getString(1);                                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return i;
    }
}
