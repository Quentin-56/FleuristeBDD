package controller.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Fourniture;

public class FournitureController {
	public static void ajouterFourniture(Fourniture fourniture){
		Connection con=ConnexionController.connexion();
		String sql = "INSERT INTO fourniture(Date , IdFournisseur) VALUES(?,?)";
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDate(1,java.sql.Date.valueOf(fourniture.getDate().toString()));
			pst.setInt(2, fourniture.getIdFournisseur());
			pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionController.Deconnexion(con);
	}
	public static void supprimerFourniture(int idFourniture){
		Connection con=ConnexionController.connexion();
		String sql= "DELETE FROM fourniture WHERE fourniture.IdFourniture=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, idFourniture);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionController.Deconnexion(con);
	}
	public static void modifierFourniture(Fourniture fourniture, int idFournitureAModifier){
		Connection con=ConnexionController.connexion();
		String sql="UPDATE fourniture SET Date= ?, IdFournisseur =? WHERE fourniture.IdFourniture =?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDate(1,java.sql.Date.valueOf(fourniture.getDate().toString()));
			pst.setInt(2, fourniture.getIdFournisseur());
			pst.setInt(3, idFournitureAModifier);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionController.Deconnexion(con);
	}
}