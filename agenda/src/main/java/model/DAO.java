package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "admin123";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome , fone , email) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(create);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getPhone());
			ps.setString(3, contato.getEmail());
			ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Listar contato.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContato() {
		// Objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<JavaBeans>();

		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(read);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return contatos;
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read = "select * from contatos where id =?";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(read);
			ps.setString(1, contato.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setPhone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome=?,fone=?,email=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getPhone());
			ps.setString(3, contato.getEmail());
			ps.setString(4, contato.getId());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(delete);

			ps.setString(1, contato.getId());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
