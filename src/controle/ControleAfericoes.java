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
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra
 */
public class ControleAfericoes {
   
    public void salvarAfericao (String responsavel, String crmv, Double tempMin, Double tempMax, String equipamento, String observacoes) throws SQLException, ParseException{
        Afericao afericao = new Afericao();
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        
        
        afericao.setCodigo(new DaoAfericao().getCodigoAfericao()+1);
        /*afericao.setResponsavel(afericao.getResponsavel()); //descobrir como fazer a composição.
        veterinario.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        afericao.getResponsavel().getCrmv();*/
        afericao.setTempMin(tempMin);
        afericao.setTempMax(tempMax);
        afericao.setEquipamento(equipamento);
        afericao.setObservacoes(observacoes);
    
        /*//pegando a data atual
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        veterinario.setDtCadastro(dataCadastro);
        
        //pegando a data de nascimento e de admissão
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        java.sql.Date dtAdmissao1 = new java.sql.Date(formato.parse(dtAdmissao).getTime());
        
        veterinario.setDataNasc(dtNascimento);
        veterinario.setDtAdmissao(dtAdmissao1);
        */
        
        //daoAfericao.salvarAfericao(afericao); //descobrir como fazer a composição.
        
    }
}           
                
        
        
            
        
        
        
    


