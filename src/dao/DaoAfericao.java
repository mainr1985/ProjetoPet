
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Afericao;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoAfericao extends DaoFactory{
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;
            
    public void salvarAfericao(Afericao afericao) throws SQLException{
        
       String insert = "INSERT INTO afericao "
                     + " (responsavel, crmv_responsavel, temp_min, temp_max, equipamento, observacoes, dhafericao) "
                     + " VALUES (?,?,?,?,?,?,?) ";
       
       salvar (insert, 
               afericao.getVeterinario().getNome(),
               afericao.getVeterinario().getCrmv(),
               afericao.getTempMin(),
               afericao.getTempMax(),
               afericao.getEquipamento(),
               afericao.getObservacoes(),
               afericao.getDhAfericao());               
    }    
        
    public void alterar(Veterinario veterinario, Afericao afericao) throws SQLException {
        /*String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());*/
    }
    
    public void alterarUsuario(Veterinario veterinario, Afericao afericao) throws SQLException {
        /*String update = " UPDATE veterinario " +
                        " SET nomeusuario = ?, "
                        + "  senha = ?, " 
                        + "  permissao = ? "
                        + " WHERE id_funcionario = ? ";
        update(update, v.getNomeUsuario(),v.getSenha(), v.getPermissao());*/
    }    

    public int getCodigoAfericao() throws SQLException{
        int i=0;
        String sql = "SELECT max(cod_afericao) FROM afericao";
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                i = rs.getInt(1);                                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Operação não realizada. Motivo : " + e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        return i;
    }
    
    public int getCrmvResponsavel(String nome){
        String sql = " SELECT crmv FROM funcionario f INNER JOIN veterinario v ON f.id_funcionario = v.id_funcionario WHERE nome = ? ";
        int crmv = 0;
        try{
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while(rs.next()){
                Veterinario veterinario = new Veterinario();
                veterinario.setCrmv(rs.getInt("crmv"));                
                crmv = veterinario.getCrmv();                 
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return crmv;
    }    
}