package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Tutor;

/**
 *
 * @author Maíra
 */
public class DaoBuscaTutor extends DaoFactory{

    public Tutor findByName(String nome) throws SQLException {
        String select = "SELECT * FROM tutor WHERE nome like ?";
        Tutor tutor = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            tutor = new Tutor();
            tutor.setCodigoTutor(rs.getInt("codtutor"));
            tutor.setNome(rs.getString("nome"));
            tutor.setEndereco(rs.getString("endereco"));
            tutor.setTelefone(rs.getString("telefone"));
            tutor.setEmail(rs.getString("email"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return tutor;
    }
}
