package vue;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;
import controleur.ConvertCSV;
public class TableauStat4 extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {"", "Départements", "NO2", "PM10", "PM25"};
	private final HashMap<String, Double> TauxDepartementsNO2;
	private final HashMap<String, Double> TauxDepartementsPM10;
	private final HashMap<String, Double> TauxDepartementsPM25;
		
	public TableauStat4(HashMap<String, Double> TauxDepartementsNO2, HashMap<String, Double> TauxDepartementsPM10, HashMap<String, Double> TauxDepartementsPM25, int annee) {
		this.TauxDepartementsNO2 = TauxDepartementsNO2;
		this.TauxDepartementsPM10 = TauxDepartementsPM10;
		this.TauxDepartementsPM25 = TauxDepartementsPM25;
		entetes[0]=String.valueOf(annee);
		}

	@Override
	public int getColumnCount() {
		return entetes.length;
		}
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return ConvertCSV.listeDepartements.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex){
		switch (columnIndex){
		case 0:
			return "";
		case 1:
			return ConvertCSV.listeDepartements.get(rowIndex);
		case 2:
			return TauxDepartementsNO2.get(ConvertCSV.listeDepartements.get(rowIndex));
		case 3:
			return TauxDepartementsPM10.get(ConvertCSV.listeDepartements.get(rowIndex));
		case 4:
			return TauxDepartementsPM25.get(ConvertCSV.listeDepartements.get(rowIndex));
		default:
			throw new IllegalArgumentException();
		}
	}
}
