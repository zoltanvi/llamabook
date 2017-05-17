/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.model.bean;

import java.util.List;

import javax.swing.AbstractListModel;

// DeleteListModel extends AbstractListModel
// public DeleteListModel(List<String> nevek, HashMap<String, String> delete)

public class DeleteListModel extends AbstractListModel {
	private List<Profil> profilok;

	public DeleteListModel(List<Profil> userFriends) {
		this.profilok = userFriends;
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

	public String getEmailByName(String name){
		for(Profil p : this.profilok){
			if(name.equals(p.getVezeteknev() + " " + p.getKeresztnev())){
				return p.getEmail();
			}
		}
		return null;
	}

}
