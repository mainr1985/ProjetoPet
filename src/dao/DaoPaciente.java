package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Tutor;
import modelo.Paciente;

/**
 *
 * @author Didi
 */
public class DaoPaciente {
 
    private Connection c;
    private PreparedStatement ps;
    private ResultSet r;
        
    public void salvar(Paciente paciente, Tutor tutor) throws SQLException{
        
       String insert = " INSERT INTO paciente (nome, apelido, sexo, dtnasc, idade, raca, especie, cor, esterelizado, porte, codtutor) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";       
       
       salvar (insert,
               /*tutor.getCodigoTutor(),*/
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
    }
}
