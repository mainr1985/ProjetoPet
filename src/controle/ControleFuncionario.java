package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoVeterinario;

/**
 *
 * @author Maíra
 */
public class ControleFuncionario{

    public ControleFuncionario() {}
    
    public void salvarVeterinario (Integer crmv, String especialidade, /*Integer codFuncionario,*/ 
                                   String nome, String cpf, String rg, String cargo
                                   
                                   /*String dtcadastro,*/ /*String logradouro, 
                                   Integer numero, String complemento, String bairro, String cidade,/*String ddd, String telefone, String dddcel, 
                                   String celular, String email*/
                                   ) throws SQLException, ParseException{
        
        Veterinario v = new Veterinario(); 
               
            v.setCrmv(crmv);
            v.setEspecialidade(especialidade);        
            //v.setCodFuncionario(codFuncionario);
            //v.setCodFuncionario(new DaoFuncionario().getCodigoFuncionario(v));
            v.setNome(nome);
            v.setCpf(cpf);
            v.setRg(rg);
            v.setCargo(cargo);
            
            //v.getEndereco().setLogradouro(logradouro);
            //v.getEndereco().setNumero(numero);
            //v.getEndereco().setComplemento(complemento);
            //v.getEndereco().setBairro(bairro);
            //v.getEndereco().setCidade(cidade);  
            //v.getContato().setEmail(email);
           
            
            //v.getContato().setDdd(ddd);
            //v.getContato().setNumero(telefone);
            
            //consertar daovet e testar
        
            new DaoFuncionario().salvarFuncionario(v);            
            new DaoVeterinario().salvar(v);
        }        
     
         
    //INCLUIR ASSISTENTE
    public void salvarAssistente (String rg, String cpf, String nome, String cargo, String logradouro) throws SQLException{
        Veterinario v = new Veterinario();
         
            //v.setCodFuncionario(codFuncionario);
            v.setRg(rg);
            v.setCpf(cpf);
            v.setNome(nome);
            v.setCargo(cargo);
            v.getEndereco().setLogradouro(logradouro);
            
            new DaoFuncionario().salvarFuncionario(v);
         }
    
                                   /*String endereco,
                                   String complemento,
                                   String bairro,
                                   String cidade,
                                   String telefone,
                                   String celular,
                                   String email) throws SQLException, ParseException{
        
        /*v.setEndereco(endereco);
        v.setComplemento(complemento);
        v.setBairro(bairro);
        v.setCidade(cidade);
        v.setTelefone(telefone);
        
        new DaoFuncionario().salvarFuncionario(v);
        new DaoFuncionario().salvar(v);
    }    */
    
    //INCLUIR ADMINISTRADOR
    /*public void salvarAdm (Integer codFuncionario, String rg, String cpf, String nome, String cargo) throws SQLException{
        Veterinario v = new Veterinario();
            
            v.setCodFuncionario(codFuncionario);
            v.setRg(rg);
            v.setCpf(cpf);
            v.setNome(nome);
            v.setCargo("Administrador");
        
            new DaoFuncionario().salvarFuncionario(v);
         }
    }*/
    
}