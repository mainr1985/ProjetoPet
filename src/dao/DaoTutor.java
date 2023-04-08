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
        
    public void salvar(Tutor tutor) throws SQLException{
        
       String insert = "INSERT INTO tutor (cpf, rg, nome, dtnasc, endereco, complemento, bairro, cidade, "
               + "/*dtcadastro,*/"
               + " telefone, "
               + " celular, "
               + " email ) "
               + "     VALUES (?,?,?,?,?,?,?,?,?,?,?)";
       
       salvar (insert,
               /*tutor.getCodigoTutor(),*/
               tutor.getCpf(), tutor.getRg(), tutor.getNome(), tutor.getDataNasc(), tutor.getEndereco(),
               tutor.getComplemento(), tutor.getBairro(), tutor.getCidade(), tutor.getTelefone(),
               tutor.getCelular(), tutor.getEmail()
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
