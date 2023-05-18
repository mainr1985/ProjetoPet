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
        
        DaoUsuarios dao = new DaoUsuarios();
        boolean check = dao.validarNomeUsuario(usuarios);
        if (check){
            JOptionPane.showMessageDialog(null, "Usuário já existente.");
        }
        else{
            new DaoUsuarios().salvar(usuarios);    
        }
    }
    
    public List<Usuario> listarUsuarios(){
        DaoUsuarios usuario = new DaoUsuarios();
        return usuario.listarUsuarios();
    }  
    
    public void validarLogin(String usuario, String senha) throws SQLException, ParseException{
        Usuario usuarios = new Usuario();
        usuarios.setUsuario(usuario);
        usuarios.setSenha(senha);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");         
        String dataAtual = formato.format(new Date());
        java.sql.Date data = new java.sql.Date(formato.parse(dataAtual).getTime());
        
        String data1 = data.toString();
        
        
        DaoUsuarios dao = new DaoUsuarios();
        boolean check = dao.validarUsuario(usuarios);
        Menu telaPrincipal = new Menu();
        TelaLogin telaLogin = new TelaLogin();
        
          //descobrir como validar data limite de acesso do usu    
        if (check){
            String permissao = dao.getPermissao(usuario);
            /*Date dataLimite = dao.getDtLimAcesso(usuario);
            
            
            if ((check)
                 &&((dataLimite == null) || (dataLimite > data)))            {
                */
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
        else{
            JOptionPane.showMessageDialog(null, "Usuário e/ou Senha inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}      