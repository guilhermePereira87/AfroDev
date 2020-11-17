import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudContaAgua {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stm = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contaagua?serverTimezone=UTC","root","870325");

			con.setAutoCommit(false);

			stm = con.createStatement();

			System.out.println("Acrescentando...");

			String sqlInsere = "insert into cliente (cpf, name)\r\n"
					+ "values ('666.666.666-66', 'Tania Moreira');";

			int resultadoB = stm.executeUpdate(sqlInsere);
			System.out.println("Linhas Afetadas:" + resultadoB);


			System.out.println("Recuperando...");

			String sqlRecupera = "select*from cliente;";
			ResultSet resultado = stm.executeQuery(sqlRecupera);

			while(resultado.next()) {
				System.out.println(resultado.getString("cpf") + "\t"+
						resultado.getString("name"));
			}
			
			System.out.println("Atualizando...");
			String sqlAtualiza = "update cliente\r\n"
					+ "set cpf='777.777.777-77', name='Marlos Teixeira'\r\n"
					+ "where cpf='666.666.666-66';";
			
			int resultadoC = stm.executeUpdate(sqlAtualiza);
			System.out.println("Linhas Afetadas:" + resultadoC);

			System.out.println("Removendo...");
			String sqlDeleta = "delete from cliente\r\n"
					+ "where cpf='777.777.777-77';";
			
			int resultadoD = stm.executeUpdate(sqlDeleta);
			System.out.println("Linhas Afetadas:" + resultadoD);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
