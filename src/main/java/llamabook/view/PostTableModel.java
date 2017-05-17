package llamabook.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import llamabook.controller.PropertiesController;
import llamabook.model.bean.Poszt;

public class PostTableModel extends AbstractTableModel {

	private PropertiesController props;
	private List<Poszt> posztok;
	private String[] oszlopok;

	public void setPosztok(List<Poszt> posztok){
		this.posztok = posztok;
		fireTableDataChanged();
	}

	public PostTableModel(List<Poszt> posztok) {
		this.props = new PropertiesController();
		this.oszlopok = new String[]
				{props.getProperty("tableID"), props.getProperty("tableName"), props.getProperty("tablePost")};
		this.setPosztok(posztok);
	}

	@Override
	public int getRowCount() {
		return this.posztok.size();
	}

	@Override
	public String getColumnName(int column) {
		return oszlopok[column];
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.posztok.get(rowIndex).getPosztID();
		case 1:
			return this.posztok.get(rowIndex).getNev();
		case 2:
			return this.posztok.get(rowIndex).getBejegyzes();
		default:
			return null;
		}
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}
