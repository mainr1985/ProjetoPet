package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;
import modelo.Usuario;

public class ControleLogin{

    public ControleLogin() {}
    
    public void salvarLogin(String usuario, char[] senha, String permissao) throws SQLException, ParseException {
        
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
    
    //transforma a senha em String.
    public String pegaSenha(Usuario usuario){
        String senha_decode = new String (usuario.getSenha());
        return senha_decode;
    }
    
    //método para efetuar o login
    private void fazerLogon() {
        
    }
    
    //descobrir como validar data limite de acesso do usu
    
}      
	
	
	



