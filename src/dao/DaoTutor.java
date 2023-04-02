package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Tutor;

/**
 *
 * @author Maíra
 */
public class DaoTutor extends DaoFactory{
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet r;
        
    public void salvar(Tutor t) throws SQLException{
        
       String insert = "INSERT INTO tutor (codtutor,cpf,rg,nome,endereco,numero,complemento,bairro,cidade,dtcadastro) VALUES (?,?,?,?,?,?,?,?,?,sysdate)";
       salvar (insert,
               t.getCodigoTutor(),
               t.getCpf(),
               t.getRg(),
               t.getNome(),
               t.getEndereco()
               /*t.getNumero(),
               t.getComplemento(),
               t.getBairro(),
               t.getCidade()   */
               
               );  
    }    
      
    /*public void alterar(Veterinario v) throws SQLException {
        String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());
    }
    
    public int getCodigoVeterinario(Veterinario v) throws SQLException{
        int i=0;
        try{
            ps = c.prepareStatement("SELECT max(id_funcionario) FROM funcionario");
            r = ps.executeQuery();
            if (r.next()){
                i = r.getInt(1);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Operação não realizada. Motivo : " + e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        return i;
    }*/
}
