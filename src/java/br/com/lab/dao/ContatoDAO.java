package br.com.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.lab.bean.Contato;
import br.com.lab.util.DbUtil;
import java.util.List;

public class ContatoDAO {
	private static final String EXCLUIR_CONTATO = 
			"delete from contato where idcontato= ?";
	
	private static final String INSERIR_CONTATO =
			"insert into contato(nome, email,telefone) "+
			" values (?,?,?)";
	
	private static final String ATUALIZAR_CONTATO =
			"update contato set " +
			"nome = ?, " +
			"email= ?, " +
			"telefone = ? " +
			"where idcontato = ? ";
	
	private static final  String CONSULTA_CONTATO =
			"select * from contato order by nome";
	
    public List<Contato> consultarContatos() {		
            Connection conn = DbUtil.getConnection();
            PreparedStatement statement = null;
            ResultSet result = null;
            List<Contato> listaContato = new ArrayList<Contato>();
            try {
                    statement = conn.prepareStatement(CONSULTA_CONTATO);
                    result = statement.executeQuery();
                    while (result.next()) {
                            Contato objContato = new Contato();
                            objContato.setIdcontato(String.valueOf(result.getInt(1)));
                            objContato.setNome(result.getString(2));
                            objContato.setEmail(result.getString(3));
                            objContato.setTelefone(result.getString(4));
                            listaContato.add(objContato);
                    }
            } catch (SQLException e) {
                    e.getMessage();
            } finally {
                    DbUtil.close(conn, statement, result);
            }
            return listaContato;		
    }
   
    public boolean inserir(Contato contato){
	Connection conn = DbUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
            try {
                statement = conn.prepareStatement(INSERIR_CONTATO);
                statement.setString(1, contato.getNome());
                statement.setString(2, contato.getEmail());
                statement.setString(3, contato.getTelefone());
                statement.executeUpdate();
            } catch (SQLException e) {
                    e.getMessage();
            } finally {
                    DbUtil.close(conn, statement, result);
            }
        return true;		
    }

    public boolean alterar(Contato contato) {
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(ATUALIZAR_CONTATO);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3,contato.getTelefone());
			statement.setString(4,contato.getIdcontato());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;
    }

    public boolean remover(Contato contato) {
        Connection conn = DbUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
            try {
                statement = conn.prepareStatement(EXCLUIR_CONTATO);
                statement.setString(1, contato.getIdcontato());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.getMessage();
            } finally {
                DbUtil.close(conn, statement, result);
            }
        return true;		
    }

}