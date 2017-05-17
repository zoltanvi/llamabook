package llamabook.view;

import java.util.List;

import javax.swing.AbstractListModel;

import llamabook.model.bean.Profil;

public class AcceptListModel extends AbstractListModel {
	private List<Profil> profilok;

	public AcceptListModel(List<Profil> profilok) {
		this.profilok = profilok;
	}

	public void setProfilok(List<Profil> profs) {
		this.profilok = profs;
	}

	@Override
	public int getSize() {
		return this.profilok.size();
	}

	@Override
	public Object getElementAt(int index) {
		return this.profilok.get(index).getVezeteknev() + " " + this.profilok.get(index).getKeresztnev();
	}

	public void refresh(List<Profil> profs) {
		setProfilok(profs);
		fireContentsChanged(this, 0, profs.size());
	}

	public String getEmailByName(String name) {
		for (Profil p : this.profilok) {
			if (name.equals(p.getVezeteknev() + " " + p.getKeresztnev())) {
				return p.getEmail();
			}
		}
		return null;
	}
}
