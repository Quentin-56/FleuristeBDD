package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.view.AjouterCommandeControllerView1;
import controller.view.AjouterFournitureControllerView1;
import controller.view.table.FournisseurTableTemplate;

public class AjouterFournitureView1 extends JFrame
{
	private static JTable table;
	private static FournisseurTableTemplate modele = new FournisseurTableTemplate();
	private static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modele);
	private static JButton valider, filter, clearFilter;
	private JFrame thisFrame = this;
	
	public AjouterFournitureView1()
	{
		//Creation du panel principale
		this.setLayout(new BorderLayout(0, 0));
		
		//Creation panel de gauche pour mettre les boutons
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.WEST);
		
		//Creation boite verticale pour inserer les composants du panel de gauche
		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);
		
		//Creation bouton ajouter 
		valider = new JButton ("Valider");
		verticalBox.add(valider);
		
		//Creation bouton filtre 
		filter = new JButton ("Filtre");
		verticalBox.add(filter);
				
		//Creation bouton clearFilter 
		clearFilter = new JButton ("Enlever Filtre");
		verticalBox.add(clearFilter);
		
	    JPanel depPanel = new JPanel();
		depPanel.setLayout(new BorderLayout(0, 0));
		this.add(depPanel);
		
		//Creation du tableau façonné à partir du modele, le tableau dans un scrollPane
		table = new JTable(modele);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		depPanel.add(scrollPane);
		
		///////////////COLOR//////////////////////////				
		panel.setForeground(new Color(16, 41, 46));
		panel.setBackground(new Color(16, 41, 46));
		
		
		JTableHeader headt = table.getTableHeader();
		headt.setBackground(new Color(204, 44, 111 ));
		headt.setForeground(new Color(255, 255, 255));
		
		scrollPane.getViewport().setBackground(new Color(213, 213, 213));
		table.setBackground(new Color(197, 230, 229 ));
		table.setAutoCreateRowSorter(true);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//APPEL ACTION LISTENER
		new AjouterFournitureControllerView1(thisFrame); 
	}

	//ACTION LISTENER
	public static void validerFournisseurListener(ActionListener listenValiderFournisseur)
	{
		valider.addActionListener(listenValiderFournisseur);
	}
	public static void filterListener(ActionListener listenFilter)
	{
		filter.addActionListener(listenFilter);
	}
	public static void clearFilterListener(ActionListener listenClearFilter)
	{
		clearFilter.addActionListener(listenClearFilter);
	}

	//GETTERS ET SETTERS
	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		AjouterFournitureView1.table = table;
	}

	public static FournisseurTableTemplate getModele() {
		return modele;
	}

	public static void setModele(FournisseurTableTemplate modele) {
		AjouterFournitureView1.modele = modele;
	}

	public static TableRowSorter<TableModel> getSorter() {
		return sorter;
	}

	public static void setSorter(TableRowSorter<TableModel> sorter) {
		AjouterFournitureView1.sorter = sorter;
	}
}
