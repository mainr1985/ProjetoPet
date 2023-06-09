package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Maíra
 */
public abstract class DaoFactory {
    
    private Connection connection;
    
    protected DaoFactory(){
        this.connection = ConnectionFactory.getConnection();
    }
    
    protected Connection getConnection(){
        return connection;
    }
    
    protected void salvar(String insertSql, Object... parametros) throws SQLException{
        
        PreparedStatement ps = getConnection().prepareStatement(insertSql);
        for (int i=0; i<parametros.length;i++){
            ps.setObject(i+1, parametros[i]);
        }
        
        ps.execute();
        ps.close();
        connection.close();
    }
    
     protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement(updateSql);
			
        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i+1, parametros[i]);
        }
        ps.setObject(parametros.length + 1, id);
        ps.execute();
        ps.close();
        connection.close();
    }

    protected void apagar(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i+1, parametros[i]);
        }
        
        ps.execute();
        ps.close();
        connection.close();
    }  
}