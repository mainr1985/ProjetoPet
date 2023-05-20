package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoUsuarios;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;
import visao.Menu;
import visao.TelaLogin;

public class ControleLogin{

    public ControleLogin() {}
    
    public void salvarLogin(String usuario, String senha, String permissao) throws SQLException, ParseException {
        
        Veterinario funcionario = new Veterinario();
        Usuario usuarios = new Usuario();
        
        usuarios.setUsuario(usuario);
        usuarios.setSenha(senha);
        usuarios.setPermissao(permissao);
        
        funcionario.setCodigoFunc(new DaoFuncionario().getCodigoFuncionario());
        usuarios.setFuncionario(funcionario);
        
        new DaoUsuarios().salvar(usuarios);                
    }
    
    //método para validar se inserção de nome de usuário já existente
    public boolean validaUsuario(String usuario) throws SQLException{
        Usuario usuarios = new Usuario();
        usuarios.setUsuario(usuario);
        DaoUsuarios dao = new DaoUsuarios();
        boolean check = dao.validarNomeUsuario(usuarios);
        if (check){
            JOptionPane.showMessageDialog(null, "Usuário já existente."); 
            check = false;
        }
        else{
            check = true;
        }
        return check;
    }
    
    public List<Usuario> listarUsuarios(){
        DaoUsuarios usuario = new DaoUsuarios();
        return usuario.listarUsuarios();
    }  
    
    //método para validar se o usuário está expirado ou não
    public boolean validarLimAcesso(String usuario) throws SQLException, ParseException{
        boolean check = false;
        Usuario usuarios = new Usuario();
        DaoUsuarios dao = new DaoUsuarios();
        
        usuarios.setUsuario(usuario);
        
        Date dataLimite = dao.getDtLimAcesso(usuario);           
                
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        String data = formato.format(new Date());
        java.sql.Date dataAtual1 = new java.sql.Date(formato.parse(data).getTime());
        
        if (dataLimite==null || dataLimite.before(dataAtual1)){
            check = true;   
        }
        
        else if ((dataLimite.equals(dataAtual1))|| (dataLimite.after(dataAtual1))) {
            check=false;
        }
        
       return check;
    }
    
    //método para validar se o usuário pode realizar o login no sistema
    public void validarLogin(String usuario, String senha) throws SQLException, ParseException{
        Usuario usuarios = new Usuario();
        usuarios.setUsuario(usuario);
        usuarios.setSenha(senha);
                
        DaoUsuarios dao = new DaoUsuarios();
        boolean check = dao.validarUsuario(usuarios);
        Menu telaPrincipal = new Menu();
        TelaLogin telaLogin = new TelaLogin();
        
        if (check){
            String permissao = dao.getPermissao(usuario);
            boolean check1 = validarLimAcesso(usuario);
            if (!check1){
                JOptionPane.showMessageDialog(null,"Impossível realizar login. Usuário expirado.","Aviso",JOptionPane.WARNING_MESSAGE);                       
            }
            else {
                telaLogin.setVisible(false);
                telaPrincipal.setVisible(true);
                switch(permissao){
                    case "Veterinario":
                        telaPrincipal.modoInicialVet();
                        break;                   
                    case "Administrador":
                        telaPrincipal.modoInicialAdm();
                        break;                   
                    case "Assistente":
                        telaPrincipal.modoInicialAssistente();
                        break;            
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuário e/ou Senha inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}      
