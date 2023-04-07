package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoVeterinario;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra
 */
public class ControleFuncionario{

    public ControleFuncionario() {}
    
    public void salvarVeterinario (/*Integer codFuncionario, */String nome, String rg, String cpf, /*String dtNasc,Date dtCadastro, Date dtAdmissao,*/ 
                                   String endereco, String complemento, String bairro, String cidade, 
                                   //String telefone, String celular, String email, 
                                   TipoFuncionario cargo, Integer crmv, String especialidade) throws SQLException, ParseException{
        
        Veterinario veterinario = new Veterinario(); 
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
                
        //veterinario.setCodigoFunc(codFuncionario);
        veterinario.setNome(nome);
        veterinario.setRg(rg);
        veterinario.setCpf(cpf);
        //veterinario.setDataNasc(dtNasc);
        //veterinario.setDtCadastro(dtCadastro);
        //veterinario.setDtAdmissao(dtAdmissao);
        veterinario.setEndereco(endereco);
        veterinario.setComplemento(complemento);
        veterinario.setBairro(bairro);
/*        veterinario.setTelefone(telefone);
        veterinario.setCelular(celular);
        veterinario.setEmail(email);*/
        veterinario.setCrmv(crmv);
        veterinario.setEspecialidade(especialidade);        
        veterinario.setCargo(TipoFuncionario.valueOf("VETERINARIO"));
        
            //v.setCodFuncionario(codFuncionario);
            //v.setCodFuncionario(new DaoFuncionario().getCodigoFuncionario(v));
        
        new DaoFuncionario().salvarFuncionario(veterinario);            
        new DaoVeterinario().salvar(veterinario);
    }        
     
         
    //INCLUIR ASSISTENTE
    public void salvarAssistente (String rg, String cpf, String nome, TipoFuncionario cargo, String endereco) throws SQLException{
        Veterinario assistente = new Veterinario();
         
            //v.setCodFuncionario(codFuncionario);
            assistente.setRg(rg);
            assistente.setCpf(cpf);
            assistente.setNome(nome);
            assistente.setCargo(TipoFuncionario.ASSISTENTE);
            
            
            new DaoFuncionario().salvarFuncionario(assistente);
        
    
    }    
    
    //INCLUIR ADMINISTRADOR
    public void salvarAdministrador (String rg, String cpf, String nome, TipoFuncionario cargo, String endereco) throws SQLException{
        Veterinario administrador = new Veterinario();
         
            //v.setCodFuncionario(codFuncionario);
            administrador.setRg(rg);
            administrador.setCpf(cpf);
            administrador.setNome(nome);
            administrador.setCargo(TipoFuncionario.ADMINISTRADOR);
            
            
            new DaoFuncionario().salvarFuncionario(administrador);
    }
}    
