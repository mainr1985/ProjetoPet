package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Veterinario;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra
 */
public class DaoFuncionario extends DaoFactory{
            
    private PreparedStatement ps;
    private ResultSet rs;
       
    public void salvarFuncionario(Veterinario veterinario) throws SQLException{
        
        String insert = "INSERT INTO funcionario "
                     + " (cpf, rg, nome, cargo, endereco, complemento, cidade, dtnascimento, dtcadastro, dtadmissao,email,telefone,celular) "
                     + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
       salvar (insert, 
               veterinario.getCpf(),               
               veterinario.getRg(),               
               veterinario.getNome(),
               veterinario.getCargo().toString(),
               veterinario.getEndereco(),
               veterinario.getComplemento(),
               veterinario.getCidade(),
               veterinario.getDataNasc(),
               veterinario.getDtCadastro(),
               veterinario.getDtAdmissao(),
               veterinario.getEmail(),
               veterinario.getTelefone(),
               veterinario.getCelular()
               );               
    }    
        
    public void apagarFuncionario(Veterinario funcionario) throws SQLException{
        String delete = "DELETE FROM funcionario WHERE id_funcionario = ? ";
        apagar(delete,
               funcionario.getCodigoFunc());
    }
    
    public void alterar(Veterinario v) throws SQLException {
        /*String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());*/
    }
    
    public int getCodigoFuncionario() throws SQLException{
        int i=0;
        String sql = "SELECT max(id_funcionario) FROM funcionario";
        try{
            ps = getConnection().prepareStatement(sql);
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
        
    public String getNomeFunc() throws SQLException{
        String nome="";
        String sql = "SELECT nome FROM funcionario WHERE id_funcionario = ?";
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, getCodigoFuncionario());
            rs = ps.executeQuery();
            while (rs.next()){
                nome = rs.getString(1);                                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return nome;
    }
        
    public String getCargo() throws SQLException{
        String cargo="";
        String sql = "SELECT cargo FROM funcionario WHERE id_funcionario = ?";
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, getCodigoFuncionario());
            rs = ps.executeQuery();
            while (rs.next()){
                cargo = rs.getString(1);                                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return cargo;
    }
       
    public List<Veterinario> listarFuncionarioPorNome(String nome) throws SQLException{
              
        String sql = "SELECT "
                + "         id_funcionario, "
                + "         nome, "
                + "         endereco, "
                + "         telefone, "
                + "         celular, "
                + "         email, "
                + "         cargo, "
                + "         dtAdmissao "
                + "FROM funcionario WHERE upper(nome) ilike concat (?,'%') ";
        
        String cargo = "";
        List<Veterinario> funcionarios = new ArrayList();
        
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, "%" + nome.trim() + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                Veterinario funcionario = new Veterinario();   
                funcionario.setCodigoFunc(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setEmail(rs.getString("email"));
                
                cargo = rs.getString("cargo");
                switch(cargo){
                    case "Administrador":
                        funcionario.setCargo(TipoFuncionario.ADMINISTRADOR);
                        break;
                    case "Assistente":
                        funcionario.setCargo(TipoFuncionario.ASSISTENTE);
                        break;
                    case "Veterinario":
                        funcionario.setCargo(TipoFuncionario.VETERINARIO);
                        break;
                }
                
                funcionario.setDtAdmissao(rs.getDate("dtadmissao"));
                
                funcionarios.add(funcionario);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return funcionarios;
    }
}    
