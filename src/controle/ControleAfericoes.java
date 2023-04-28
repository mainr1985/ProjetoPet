package controle;

import dao.DaoAfericao;
import dao.DaoFuncionario;
import dao.DaoVeterinario;
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
   
    public void salvarAfericao (String nomeResponsavel, Integer crmv, Double tempMin, Double tempMax, String equipamento, String observacoes) throws SQLException, ParseException{
        Afericao afericao = new Afericao();
        Veterinario veterinario = new Veterinario();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");        
        
        veterinario.setCrmv(crmv);
        veterinario.setNome((Normalizer.normalize(nomeResponsavel, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
        afericao.setVeterinario(veterinario);
        
        afericao.setCodigo(new DaoAfericao().getCodigoAfericao()+1);
        afericao.setTempMin(tempMin);
        afericao.setTempMax(tempMax);
        afericao.setEquipamento(equipamento);
        afericao.setObservacoes(observacoes);
    
        //pegando a data/hora atual
        String dataAtual = formato.format(new Date());
        afericao.setDhAfericao(dataAtual);
        
        daoAfericao.salvarAfericao(afericao);
    }
}           
                
        
        
            
        
        
        
    


