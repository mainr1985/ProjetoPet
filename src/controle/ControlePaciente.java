package controle;
import dao.DaoPaciente;
import dao.DaoTutor;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Paciente;
import modelo.Tutor;
import modelo.enums.TipoEspecie;
import visao.Menu;

/**
 *
 * @author Didi
 */
public class ControlePaciente {

    public ControlePaciente() {
    }
    
    public void salvarPaciente(String nome, String idade, String cor, String dataNascimento, String raca, String especie,
                               String sexo, String porte, String esterelizado) throws SQLException, ParseException{
     
        Paciente paciente = new Paciente();
        paciente.setCodigoPaciente(new DaoPaciente().getCodigoPaciente()+1);
        paciente.setNome((Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        paciente.setIdade((Normalizer.normalize(idade,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        paciente.setCor((Normalizer.normalize(cor,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
                
        Tutor tutor = new Tutor();
        tutor.setCodigoTutor(new DaoTutor().getCodigoTutor());
        paciente.setTutor(tutor);
        
        //convertendo a data digitada para inserção no banco de dados
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dataNascimento).getTime());
        paciente.setDtNascimento(dtNascimento);
        
        paciente.setRaca((Normalizer.normalize(raca,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        paciente.setSexo(sexo);
        setTipoEspecie(paciente);        
        paciente.setPorte((Normalizer.normalize(porte,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        paciente.setEsterelizado(esterelizado);
        
         //pegando a data atual
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        paciente.setDtCadastro(dataCadastro);
        
        new DaoPaciente().salvar(paciente);  
    }
    
    public void setTipoEspecie(Paciente paciente){
        
        Menu tela = new Menu();       
        String especie = tela.getEspeciePet(paciente);
        if (especie.equals("Canina")) {
            paciente.setEspecie(TipoEspecie.CANINA);
        }
        else if (especie.equals("Felina")){
            paciente.setEspecie(TipoEspecie.FELINA);
        }
    }
}