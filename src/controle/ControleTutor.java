package controle;
import dao.DaoTutor;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Tutor;

/**
 *
 * @author Maíra
 */
public class ControleTutor {
 
    public void salvarTutor(String nome, String rg, String cpf, String endereco, String complemento, String bairro, String cidade, 
                            String telefone, String celular, String email, String dtNasc) throws SQLException, ParseException{

        Tutor tutor = new Tutor();
        
        tutor.setCodigoTutor(new DaoTutor().getCodigoTutor()+1);
        tutor.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        tutor.setCpf(cpf);
        tutor.setRg(rg);
        tutor.setEndereco(Normalizer.normalize(endereco,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        tutor.setComplemento(Normalizer.normalize(complemento,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        tutor.setBairro(Normalizer.normalize(bairro,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        tutor.setCidade(Normalizer.normalize(cidade,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        tutor.setTelefone(telefone);
        tutor.setCelular(celular);
        tutor.setEmail(email);
                
        //convertendo a data digitada para inserção no banco de dados
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        java.sql.Date dataNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        tutor.setDataNasc(dataNascimento);
        
        //pegando a data atual
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        tutor.setDtCadastro(dataCadastro);
                
       new DaoTutor().salvar(tutor);  
    }
}
