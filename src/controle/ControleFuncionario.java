package controle;
import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoVeterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra
 */
public class ControleFuncionario{

    private Connection c;
    private PreparedStatement ps;
    private ResultSet r;
    DaoFuncionario daoFuncionario = new DaoFuncionario();
    
    public ControleFuncionario() {}
    
    public void salvarVeterinario (String nome, String rg, String cpf, String dtNasc, String dtAdmissao, String endereco, 
                                   String complemento, String bairro, String cidade, String telefone, String celular, String email, 
                                   TipoFuncionario cargo, Integer crmv, String especialidade) throws SQLException, ParseException{
        
        Veterinario veterinario = new Veterinario(); 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        
        veterinario.setCodigoFunc(new DaoFuncionario().getCodigoFuncionario()+1);
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

        daoFuncionario.salvarFuncionario(veterinario);
        new DaoVeterinario().salvar(veterinario);
    }             
         
    //INCLUIR ASSISTENTE
    public void salvarAssistente (String nome,String rg, String cpf,  String dtNasc,String dtAdmissao,TipoFuncionario cargo, String endereco, 
                                  String complemento, String bairro, String cidade, String telefone, String celular, String email) throws SQLException, ParseException{
       
        Veterinario assistente = new Veterinario();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        
        assistente.setCodigoFunc(new DaoFuncionario().getCodigoFuncionario()+1);
        assistente.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setRg(rg);
        assistente.setCpf(cpf);
        
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        assistente.setDataNasc(dtNascimento);
        java.sql.Date dtAdmissao1 = new java.sql.Date(formato.parse(dtAdmissao).getTime());
        assistente.setDtAdmissao(dtAdmissao1);
        assistente.setCargo(TipoFuncionario.ASSISTENTE);
            
        //pegando a data atual
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        assistente.setDtCadastro(dataCadastro);
        
        assistente.setEndereco(Normalizer.normalize(endereco,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setComplemento(Normalizer.normalize(complemento,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setBairro(Normalizer.normalize(bairro,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        assistente.setTelefone(telefone);
        assistente.setCelular(celular);
        assistente.setEmail(email);
            
        daoFuncionario.salvarFuncionario(assistente);
    }    
    
    //INCLUIR ADMINISTRADOR
    public void salvarAdministrador (String nome, String rg, String cpf, String dtNasc, String dtAdmissao,  TipoFuncionario cargo, String endereco, 
                                     String complemento, String bairro, String cidade, String telefone, String celular, String email) throws SQLException, ParseException{
       
        Veterinario administrador = new Veterinario();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
    
        administrador.setCodigoFunc(new DaoFuncionario().getCodigoFuncionario()+1);
        administrador.setNome(Normalizer.normalize(nome,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setRg(rg);
        administrador.setCpf(cpf);
        
        java.sql.Date dtNascimento = new java.sql.Date(formato.parse(dtNasc).getTime());
        administrador.setDataNasc(dtNascimento);
        java.sql.Date dtAdmissao1 = new java.sql.Date(formato.parse(dtAdmissao).getTime());
        administrador.setDtAdmissao(dtAdmissao1);
        administrador.setCargo(TipoFuncionario.ADMINISTRADOR);
        
        String dataAtual = formato.format(new Date());
        java.sql.Date dataCadastro = new java.sql.Date(formato.parse(dataAtual).getTime());
        administrador.setDtCadastro(dataCadastro);
        
        administrador.setEndereco(Normalizer.normalize(endereco,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setComplemento(Normalizer.normalize(complemento,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setBairro(Normalizer.normalize(bairro,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        administrador.setTelefone(telefone);
        administrador.setCelular(celular);
        administrador.setEmail(email);
            
        daoFuncionario.salvarFuncionario(administrador);    
    }       
    
    public void salvarLogin(String usuario, String senha, String permissao) throws SQLException, ParseException {
        
        Veterinario usuarioFunc = new Veterinario();
                
        usuarioFunc.setNomeUsuario(usuario);
        usuarioFunc.setSenha(senha);
        usuarioFunc.setPermissao(permissao);
        
        new DaoFuncionario().salvarUsuario(usuarioFunc);
    }
    
    //transforma a senha em String.
    /*public String converteSenha(Veterinario veterinario){
        String senha_decode = new String (veterinario.getSenha());
        return senha_decode;
    }*/
    
    public List<Veterinario> pegarVeterinarios(){
        DaoVeterinario vet = new DaoVeterinario();
        return vet.listarVeterinarios();
    }    
}    
