package controle;
import dao.DaoPaciente;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Paciente;
import visao.Menu;
//import modelo.enums.TipoEspecie;

/**
 *
 * @author Didi
 */
public class ControlePaciente {

    Menu tela = new Menu();
    public ControlePaciente() {
    }
    
    public void salvarPaciente(String nome, String idade, String cor, String dataNascimento, String raca, String especie,
                               String sexo, String porte, Boolean esterelizado) throws SQLException, ParseException{
     
        Paciente paciente = new Paciente();
        paciente.setCodigoPaciente(new DaoPaciente().getCodigoPaciente()+1);
        paciente.setNome((Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        paciente.setIdade(idade);
        paciente.setCor(cor);
        
        
        //convertendo a data digitada para inserção no banco de dados
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dataNascimento).getTime());
        paciente.setDtNascimento(dtNascimento);
        
        paciente.setRaca(raca);
        paciente.setSexo(sexo);
        paciente.setEspecie(tela.getEspeciePet());

        //descobr ir como pegar o enum sem saber qual a opção marcada.
        paciente.setPorte(porte);
        paciente.setEsterelizado(esterelizado);
        
         //pegando a data atual
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        paciente.setDtCadastro(dataCadastro);
        
        new DaoPaciente().salvar(paciente);  
    }
    
    
}