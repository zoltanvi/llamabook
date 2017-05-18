package llamabook.view;

import java.util.List;

import javax.swing.AbstractListModel;

public class PictureListModel extends AbstractListModel{

	private List<String> kepek;
	
	public PictureListModel(List<String> sajatKepek) {
		this.kepek = sajatKepek;
	}

	@Override
	public Object getElementAt(int i) {
		return this.kepek.get(i);
	}

	@Override
	public int getSize() {
		return this.kepek.size();
	} 

}
