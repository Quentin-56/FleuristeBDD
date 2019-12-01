package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import model.Produit;
import controller.queries.ProduitController;
import controller.view.table.AlerteTableTemplate;

public class AlerteView extends JFrame
{
	private JTable table;
	private ArrayList<Produit> listeProduit = ProduitController.voirProduitSansStock();
	private AlerteTableTemplate modele = new AlerteTableTemplate();
	
	public AlerteView(){
		this.setTitle("Alerte");
		table = new JTable(modele);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JTableHeader headt = table.getTableHeader();
		headt.setBackground(new Color(204, 44, 111 ));
		headt.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(197, 230, 229 ));

		JScrollPane pane = new JScrollPane(table);

		this.add(pane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
