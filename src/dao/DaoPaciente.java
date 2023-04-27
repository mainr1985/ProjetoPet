package dao;

import static dao.ConnectionFactory.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Paciente;
import modelo.Tutor;

/**
 *
 * @author Didi
 */
public class DaoPaciente extends DaoFactory{
 
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;
        
    public void salvar(Paciente paciente) throws SQLException {
        String insert = " INSERT INTO paciente (nome, sexo, dtnasc, idade, raca, especie, cor, esterelizado, porte, codtutor, dtcadastro) "
                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?) ";    
        
        salvar (insert,
                paciente.getNome(), 
                paciente.getSexo(),
                paciente.getDtNascimento(), 
                paciente.getIdade(),
                paciente.getRaca(),
                paciente.getEspecie().toString(),
                paciente.getCor(),
                paciente.getEsterelizado(),
                paciente.getPorte(),
                paciente.getTutor().getCodigoTutor(),
                paciente.getDtCadastro()
               );  
    }
    
    public int getCodigoPaciente() throws SQLException{
        int i=0;
        String sql = "SELECT max(codpaciente) FROM paciente";
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

    public String getNomeTutor(Tutor tutor) throws SQLException{
        String nome="";
        String sql = "SELECT nome FROM tutor WHERE cpf = " + tutor.getCpf();
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                nome = rs.getString(4);
            }
        }   
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Operação não realizada. Motivo : " + e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }        
        return nome;
    }
    
}
