package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import dao.DaoUsuarios;
import javax.swing.JOptionPane;
import modelo.Usuario;
import visao.TelaLogin;

public class ControleLogin{

    public ControleLogin() {}
    
    public void salvarLogin(String usuario, String senha, String permissao) throws SQLException, ParseException {
        
        Veterinario veterinario = new Veterinario();
        //Usuario usuarios = new Usuario();
        
        veterinario.setNomeUsuario(usuario);
        veterinario.setSenha(senha);
        veterinario.setPermissao(permissao);
        
        
        /*usuarios.setUsuario(usuario);
        usuarios.setSenha(senha);
        usuarios.setPermissao(permissao);        
        //new DaoUsuarios().salvar(veterinario,usuarios);*/
        
        new DaoFuncionario().salvarUsuario(veterinario);
    }
    
    
    //método para efetuar o login
    public void fazerLogon() {
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
    }
    
    //descobrir como validar data limite de acesso do usu
    
}      
	
	
	



