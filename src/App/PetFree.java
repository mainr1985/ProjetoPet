
package App;
import dao.DaoFuncionario;
import dao.DaoVeterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import modelo.Veterinario;
import visao.Menu;
import visao.TelaLogin;
//import visao.Menu;


/**
 *
 * @author Didi
 */
public class PetFree {

    /**
     * @param args the command line arguments
     */

    
    /*public static int getCodigoFuncionario() throws SQLException{
        int i=0;
        
        Connection c = null;
        PreparedStatement ps;
        ResultSet r;
            
        try{
            ps = c.prepareStatement(" SELECT MAX(id_funcionario) FROM funcionario ");
            r = ps.executeQuery();
            if (r.next()){
                i = r.getInt(1);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Operação não realizada. Motivo : " + e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        return i;

    }*/

    public static void main(String[] args) throws SQLException{
        
        //chamando a tela de login
        //TelaLogin telaLogin = new TelaLogin(); 
        //telaLogin.setVisible(true);
         
      // Menu menu = new Menu();
       //menu.setVisible(true);
        //menu.modoInicialVet();
        //menu.modoInicialAdm();
       // System.out.println(getCodigoFuncionario());
        
        //System.out.println("Código:" + new DaoFuncionario().getCodigoFuncionario());
        //Veterinario vet = new Veterinario();
        //vet.setCodigoFunc(new DaoFuncionario().getCodigoFuncionario());
        //System.out.println("Código do getter: " + new DaoFuncionario().getCodigoFuncionario());
        
    }
 }
    

