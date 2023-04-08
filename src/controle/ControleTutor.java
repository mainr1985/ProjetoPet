package controle;
import dao.DaoTutor;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.Tutor;

/**
 *
 * @author Maíra
 */
public class ControleTutor {
 
    public void salvarTutor(String nome, String rg, String cpf, String endereco, String complemento, String bairro, String cidade, 
                            String telefone, String celular, String email, String dtNasc) throws SQLException, ParseException{

        Tutor tutor = new Tutor();
        tutor.setNome(nome);
        tutor.setCpf(cpf);
        tutor.setRg(rg);
        tutor.setEndereco(endereco);
        tutor.setComplemento(complemento);
        tutor.setBairro(bairro);
        tutor.setCidade(cidade);
        tutor.setTelefone(telefone);
        tutor.setCelular(celular);
        tutor.setEmail(email);
        
         
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        java.sql.Date dataNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        tutor.setDataNasc(dataNascimento);
                
       new DaoTutor().salvar(tutor);                
        
    }
}
