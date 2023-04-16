package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoVeterinario extends DaoFactory{
   
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet r;
        
    public void salvar(Veterinario veterinario) throws SQLException{
              
       //int codigoFuncionario;
       String sql = "SELECT MAX(id_funcionario) FROM funcionario WHERE cargo = 'Veterinario'"; //descobrir como pegar o codigo do funcionário q está sendo incluído.
       try{
           ps = conexao.prepareStatement(sql);
           r = ps.executeQuery();
           while (r.next()){
               veterinario.setCodigoFunc(r.getInt("id_funcionario"));
           }
           r.close();
           ps.close();
           conexao.close();
       }
       catch(SQLException e){
           e.printStackTrace();
       }
       
       String insert = "INSERT INTO veterinario (crmv,especialidade,id_funcionario) VALUES (?,?,?)";
       salvar (insert,veterinario.getCrmv(),veterinario.getEspecialidade(),veterinario.getCodigoFunc());
    }    
      
    public void alterar(Veterinario v) throws SQLException {
        String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());
    }
    
    
    //pegando o código do funcionario da tabela de funcionarios 
   /* public int getCodigoVeterinario(Veterinario v) throws SQLException{
        int i=0;
        try{
            ps = c.prepareStatement("SELECT max(id_funcionario) FROM funcionario");
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
    
    /*public String buscaVet (Veterinario v) throws SQLException {
        String query = " SELECT id_funcionario FROM funcionario WHERE cpf = ? ";
        
        selecionar(query,v.getCpf());
        
        return query;
    }*/
}