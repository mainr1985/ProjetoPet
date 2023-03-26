package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @authors Maíra & Rafael
 */
public class ConnectionFactory 
{
    public static Connection getConnection()
    {
        try
        {
            String url = "jdbc:postgresql://localhost:5432/petfree";
            String user = "postgres"; //preencher qdo for usar
            String password = "mairabd"; //preencher qdo for usar
            return DriverManager.getConnection(url, user, password);
        }
        
        catch (SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
            throw new RuntimeException();
        }
    }
}