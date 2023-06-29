package vue;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import controleur.ConvertCSV;

public class TableauStat3 extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	//TODO Créer les attributs
	private final String[] entetes = {"Departements", "NO2", "PM10", "PM25"};
	private final HashMap<String, Double> moyenneDepartementsNO2;
	private final HashMap<String, Double> moyenneDepartementsPM10;
	private final HashMap<String, Double> moyenneDepartementsPM25;
	
	//TODO Créer le constructeur
	public TableauStat3(HashMap<String, Double> moyenneDepartementsNO2, HashMap<String, Double>moyenneDepartementsPM10, HashMap<String, Double>moyenneDepartementsPM25) {
		this.moyenneDepartementsNO2 	= moyenneDepartementsNO2;
		this.moyenneDepartementsPM10 	= moyenneDepartementsPM10;
		this.moyenneDepartementsPM25 	= moyenneDepartementsPM25;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Compléter getColumnCount
		return entetes.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		// TODO Compléter getColumnName
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Compléter getRowCount
		return ConvertCSV.listeDepartements.size();
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Compléter getValueAt
		switch (columnIndex) {
		case 0:
			return ConvertCSV.listeDepartements.get(rowIndex);
			
		case 1:
			return moyenneDepartementsNO2.get(ConvertCSV.listeDepartements.get(rowIndex));
			
		case 2:
			return moyenneDepartementsPM10.get(ConvertCSV.listeDepartements.get(rowIndex));
			
		case 3:
			return moyenneDepartementsPM25.get(ConvertCSV.listeDepartements.get(rowIndex));
			
		default:
			throw new IllegalArgumentException();
		}
	}
}
