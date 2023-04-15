package controle;
import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoVeterinario;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra
 */
public class ControleFuncionario{

    public ControleFuncionario() {}
    
    public void salvarVeterinario (/*Integer codFuncionario, */String nome, String rg, String cpf, String dtNasc, String dtAdmissao, 
                                   String endereco, String complemento, String bairro, String cidade, String telefone, String celular, String email, 
                                   TipoFuncionario cargo, Integer crmv, String especialidade) throws SQLException, ParseException{
        
        Veterinario veterinario = new Veterinario(); 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        
        //veterinario.setCodigoFunc(codFuncionario);
        veterinario.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        veterinario.setRg(rg);
        veterinario.setCpf(cpf);
        
        //pegando a data atual
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        veterinario.setDtCadastro(dataCadastro);
        
        //pegando a data de nascimento e de admissão
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        java.sql.Date dtAdmissao1 = new java.sql.Date(formato.parse(dtAdmissao).getTime());
        
        veterinario.setDataNasc(dtNascimento);
        veterinario.setDtAdmissao(dtAdmissao1);
        
        veterinario.setEndereco(Normalizer.normalize(endereco,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        veterinario.setComplemento(Normalizer.normalize(complemento,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        veterinario.setBairro(Normalizer.normalize(bairro,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        veterinario.setTelefone(telefone);
        veterinario.setCelular(celular);
        veterinario.setEmail(email);
        veterinario.setCrmv(crmv);
        veterinario.setEspecialidade(Normalizer.normalize(especialidade,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));        
        veterinario.setCargo(TipoFuncionario.VETERINARIO);
        //veterinario.setCargo(TipoFuncionario.valueOf("VETERINARIO"));
        
            //v.setCodFuncionario(codFuncionario);
            //v.setCodFuncionario(new DaoFuncionario().getCodigoFuncionario(v));
        
        new DaoFuncionario().salvarFuncionario(veterinario);            
        new DaoVeterinario().salvar(veterinario);
    }             
         
    //INCLUIR ASSISTENTE
    public void salvarAssistente (String rg, String cpf, String nome, TipoFuncionario cargo, String dtNasc,String dtCadastro, String dtAdmissao,
                                  String endereco, String complemento, String bairro, String cidade, String telefone, String celular, String email) throws SQLException, ParseException{
       
        Veterinario assistente = new Veterinario();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        
        //v.setCodFuncionario(codFuncionario);
        assistente.setRg(rg);
        assistente.setCpf(cpf);
        assistente.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setCargo(TipoFuncionario.ASSISTENTE);
            
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        assistente.setDtCadastro(dataCadastro);
        
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        java.sql.Date dtAdmissao1 = new java.sql.Date(formato.parse(dtAdmissao).getTime());
        
        assistente.setDataNasc(dtNascimento);
        assistente.setDtAdmissao(dtAdmissao1);
            
        assistente.setEndereco(Normalizer.normalize(endereco,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setComplemento(Normalizer.normalize(complemento,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setBairro(Normalizer.normalize(bairro,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setTelefone(telefone);
        assistente.setCelular(celular);
        assistente.setEmail(email);
            
        new DaoFuncionario().salvarFuncionario(assistente);    
    }    
    
    //INCLUIR ADMINISTRADOR
    public void salvarAdministrador (String rg, String cpf, String nome, TipoFuncionario cargo, String dtNasc,String dtCadastro, String dtAdmissao,
                                  String endereco, String complemento, String bairro, String cidade, String telefone, String celular, String email) throws SQLException, ParseException{
       
        Veterinario administrador = new Veterinario();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        
        //v.setCodFuncionario(codFuncionario);
        administrador.setRg(rg);
        administrador.setCpf(cpf);
        administrador.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setCargo(TipoFuncionario.ADMINISTRADOR);
            
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        administrador.setDtCadastro(dataCadastro);
        
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        java.sql.Date dtAdmissao1 = new java.sql.Date(formato.parse(dtAdmissao).getTime());
        
        administrador.setDataNasc(dtNascimento);
        administrador.setDtAdmissao(dtAdmissao1);
            
        administrador.setEndereco(Normalizer.normalize(endereco,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setComplemento(Normalizer.normalize(complemento,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setBairro(Normalizer.normalize(bairro,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setTelefone(telefone);
        administrador.setCelular(celular);
        administrador.setEmail(email);
            
        new DaoFuncionario().salvarFuncionario(administrador);    
    }       
    


}    
