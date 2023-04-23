package dao;

import static dao.ConnectionFactory.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Paciente;

/**
 *
 * @author Didi
 */
public class DaoPaciente extends DaoFactory{
 
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;
        
    /*public void salvarPaciente(Paciente paciente, Tutor tutor) throws SQLException{
        
       String insert = " INSERT INTO paciente (nome, apelido, sexo, dtnasc, idade, raca, especie, cor, esterelizado, porte, codtutor) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";       
       
       salvar (insert,
               /*tutor.getCodigoTutor(),
               paciente.getNome(), 
               paciente.getApelido(),
               paciente.getDtNascimento(), 
               paciente.getIdade(),
               paciente.getRaca(),
               paciente.getEspecie(),
               paciente.getCor(),
               paciente.getEsterelizado(),
               paciente.getPorte(),
               paciente.getDtCadastro()
               );  
    }*/
    
    public void salvar(Paciente paciente) throws SQLException {
        String insert = " INSERT INTO paciente (nome, sexo, dtnasc, idade, raca, especie, cor, esterelizado, porte, codtutor) "
                       + "VALUES (?,?,?,?,?,?,?,?,?,?) ";    
        
        salvar (insert,
                paciente.getCodigoPaciente(),
                paciente.getNome(), 
                paciente.getDtNascimento(), 
                paciente.getIdade(),
                paciente.getRaca(),
                //paciente.getEspecie(),
                paciente.getCor(),
                //paciente.getEsterelizado(),
                //paciente.getPorte(),
                paciente.getDtCadastro()
               );  
    }
    
    public int getCodigoPaciente() throws SQLException{
        int i=0;
        String sql = "SELECT max(cod_paciente) FROM paciente";
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

    
}
