package controle;

import java.sql.SQLException;
import java.text.ParseException;
import modelo.Veterinario;
import dao.DaoFuncionario;

public class ControleLogin{

    public ControleLogin() {}
    
    public void salvarLogin(String usuario, String senha, String permissao) throws SQLException, ParseException {
        
        Veterinario v = new Veterinario();
        
        v.setNomeUsuario(usuario);
        v.setSenha(senha);
        v.setPermissao(permissao);
        
        new DaoFuncionario().salvarUsuario(v);
    }
    
    
    

    //método para efetuar o login
    private void fazerLogon() {
        
    }
    
}      
	
	
	



