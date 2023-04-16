package controle;
import visao.Menu;
/**
 *
 * @author Maíra
 */
public class ControleAfericoes {
    Menu temperatura = new Menu();
    
    public boolean cadastrarMedicao (int codigo, double tempMin, double tempMax, String responsavel, ){
        //validacao para ver se os campos foram preenchidos no formulario
        
        if ((temperatura.getTxtTempMin()!=null) && (temperatura.getTxtTempMax()!=null) 
             && (temperatura.getTxtTempMomento()!=null) && (temperatura.getTxtResp()!= null)){
            Afericao t = new Afericao(codigo, tempMin, tempMax, tempMomento, responsavel);
            t.cadastrarMedicao(t);
            return true;
        }
        
        else
            return false;
    }
}           
                
        
        
            
        
        
        
    


