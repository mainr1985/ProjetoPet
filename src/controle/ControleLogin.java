package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoUsuarios;
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
    
    public List<Usuario> listarUsuarios(){
        DaoUsuarios usuario = new DaoUsuarios();
        return usuario.listarUsuarios();
    }  
    
    public void validarLogin(String usuario, String senha) throws SQLException{
        Usuario usuarios = new Usuario();
        usuarios.setUsuario(usuario);
        usuarios.setSenha(senha);
        
        DaoUsuarios dao = new DaoUsuarios();
        boolean check = dao.validarUsuario(usuarios);
        if (check){
            Menu telaPrincipal = new Menu();
            telaPrincipal.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuário e/ou Senha inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(check);
    }


//método para efetuar o login
    /*public void fazerLogon() {
        TelaLogin telaLogin = new TelaLogin();
        Veterinario permissao = telaLogin.lerLogin();
        Veterinario usuario;
        DaoUsuarios daoUsuario = null;
        boolean check = false;
        
        if (permissao != null){
            
            check = daoUsuario.consultarLogin(permissao);
            if (check==true){
                JOptionPane.showMessageDialog(null, "Entrei no logon");    
            }
        }
    }*/
    
    //descobrir como validar data limite de acesso do usu
    
}      
	
	
	



