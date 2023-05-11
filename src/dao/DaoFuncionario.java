package dao;

import controle.ControleFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Veterinario;

/**
 *
 * @author Maíra
 */
public class DaoFuncionario extends DaoFactory{
            
    private Connection conexao;
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
        
    public void salvarUsuario(Veterinario veterinario) throws SQLException{
        
        String update = " UPDATE funcionario SET nomeusuario = ?, senha = ?, permissao = ? WHERE id_funcionario = " ; 
        
        update (update, 
                //veterinario.getCodigoFunc(),
                veterinario.getNomeUsuario(),
                veterinario.getSenha(),
                //new ControleFuncionario().pegaSenha(veterinario),
                veterinario.getPermissao());          
    }    
    
    public void alterar(Veterinario v) throws SQLException {
        /*String update = "UPDATE veterinario " +
                        "SET crmv = ?, especialidade = ? " +
                        "WHERE id_funcionario = ? ";
        update(update, v.getCrmv(),v.getEspecialidade());*/
    }
    
    public void alterarUsuario(Veterinario v) throws SQLException {
        /*String update = " UPDATE veterinario " +
                        " SET nomeusuario = ?, "
                        + "  senha = ?, " 
                        + "  permissao = ? "
                        + " WHERE id_funcionario = ? ";
        update(update, v.getNomeUsuario(),v.getSenha(), v.getPermissao());*/
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
    
/*    public boolean verificaCpf(Dentista funcionario)
	{
		Veterinario funcionario  = new Veterinario();
		String cpf = "";
		boolean achou = false;
		
		try
		{
			ps = c.prepareStatement("select cpf from funcionario where cpf = ?");
			ps.setString(1, funcionario.getCpf());
			String cpfRecebido = funcionario.getCpf();
			
			r = ps.executeQuery();
						
			if(r.next())
			{
				func.setCpf(r.getString("cpf"));
				cpfConsulta = func.getCpf();
			}
		
				if(cpfRecebido.equals(cpfConsulta))
					{
						JOptionPane.showMessageDialog(null, "CPF já existente! Inclusão inválida.",
								"Aviso",JOptionPane.WARNING_MESSAGE);
						achou = true;
					}
					else
					
							
							achou = false;
					
			}
		catch(SQLException ex)
		{
			
			JOptionPane.showMessageDialog(null, "Operação não realizada.Motivo: "+"\n"+ex.getMessage(),
					"Aviso",JOptionPane.WARNING_MESSAGE);
			
		}
		return achou;
	}*/
    
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
}