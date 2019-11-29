package controller.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Commande;

public class CommanderController {

	public static void ajouterCommander(int idCommande, int idProduit, int quantite){
		Connection con=ConnexionController.connexion();
		String sql ="INSERT INTO commander (IdCommande, IdProduit, quantite) VALUES (?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, idCommande);
			pst.setInt(2, idProduit);
			pst.setInt(3, quantite);
			pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionController.Deconnexion(con);
	}
	public static void supprimerCommander(int idCommande, int idProduit){
		Connection con=ConnexionController.connexion();
		String sql="DELETE FROM commander WHERE commander.IdCommande=? AND commander.idProduit=? ";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, idCommande);
			pst.setInt(2, idProduit);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		ConnexionController.Deconnexion(con);
	}
}
