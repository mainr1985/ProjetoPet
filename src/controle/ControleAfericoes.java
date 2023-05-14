package controle;

import dao.DaoAfericao;;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Afericao;
import modelo.Veterinario;


/**
 *
 * @author Maíra
 */
public class ControleAfericoes {
    
    DaoAfericao daoAfericao = new DaoAfericao();
   
    public void salvarAfericao (String nomeResponsavel, Double tempMin, Double tempMax, String equipamento, String observacoes) throws SQLException, ParseException{
        Afericao afericao = new Afericao();
        Veterinario veterinario = new Veterinario();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");         
        
        veterinario.setNome((Normalizer.normalize(nomeResponsavel, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        veterinario.setCrmv(new DaoAfericao().getCrmvResponsavel(veterinario.getNome()));
        afericao.setVeterinario(veterinario);
        
        afericao.setCodigo(new DaoAfericao().getCodigoAfericao()+1);
        afericao.setTempMin(tempMin);
        afericao.setTempMax(tempMax);
        afericao.setEquipamento(equipamento);
        afericao.setObservacoes(observacoes);
    
        //pegando a data/hora atual        
       String dataAtual = formato.format(new Date());
       java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());        
       afericao.setDhAfericao(dataCadastro);
        
        daoAfericao.salvarAfericao(afericao);
    }
}    