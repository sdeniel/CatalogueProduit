package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import metier.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		Connection connection = (Connection) SingletonConnection.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement("INSERT INTO PRODUITS (designation, prix, quantite) VALUES (?, ?, ?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate(); // executeUpdate pour INSERT ET DELETE

			PreparedStatement ps2 = (PreparedStatement) connection
					.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS  "); // FROM
			// CATALOGUE
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Produit> rechercheParMC(String mc) {
		List<Produit> produits = new ArrayList<>();

		Connection connection = (Connection) SingletonConnection.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement("SELECT * FROM produits WHERE designation LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("ID"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				produits.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public Produit update(Produit p, int id) {
		Connection connection = (Connection) SingletonConnection.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement("UPDATE PRODUITS SET designation=?, prix=?, quantite=? WHERE id = ?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, id);
			ps.executeUpdate(); // executeUpdate pour INSERT ET DELETE
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	// La méthode DELETE est proche de la méthode INSERT -> copie/colle
	public void deleteProduit(int id) {
		Connection connection = (Connection) SingletonConnection.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("DELETE FROM produits WHERE ID = ?");
			ps.setInt(1, id);
			ps.executeUpdate(); // executeUpdate pour INSERT ET DELETE
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Produit getProduit(int id) {
		Produit p = null;
		Connection connection = (Connection) SingletonConnection.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) connection
					.prepareStatement("SELECT * FROM produits WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Produit();
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				p.setId(rs.getInt("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
