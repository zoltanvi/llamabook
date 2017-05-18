package llamabook.controller;

import java.util.List;

import javax.swing.ImageIcon;

import llamabook.model.ModelDao;
import llamabook.model.bean.Csatlakozik;
import llamabook.model.bean.Group;
import llamabook.model.bean.Jelol;
import llamabook.model.bean.Kommentel;
import llamabook.model.bean.Poszt;
import llamabook.model.bean.Profil;
import llamabook.model.bean.Uzen;
import llamabook.view.LoginScreen;

public class Controller {

	private ModelDao model;

	public Controller() {
		this.model = new ModelDao();
	}

	public void startDesktop() {
		new LoginScreen(this);

	}

	public ModelDao getDao() {
		return this.model;
	}

	public boolean userRegis(Profil user) {
		return model.userRegis(user);
	}

	public Profil userLoggingIn(Profil user) {
		return model.userLoggingIn(user);
	}

	public int userGroupNumber(String email) {
		return model.userGroupNumber(email);
	}

	public int userFriendsnumber(String email) {
		return model.userFriendsnumber(email);
	}

	public List<Profil> userFriends(Profil user) {
		return model.userFriends(user);
	}

	public List<Profil> userSeek(Profil user) {
		return model.userSeek(user);
	}

	public List<Profil> userseekFirst(Profil user) {
		return model.userseekFirst(user);
	}

	public List<Profil> userseekSecond(Profil user) {
		return model.userseekSecond(user);
	}

	public boolean friendSign(Jelol jelol) {
		return model.friendSign(jelol);
	}

	public List<Profil> listSigns(Profil profil) {
		return model.listSigns(profil);
	}

	public boolean signAccept(Jelol sign) {
		return model.signAccept(sign);
	}

	public boolean signDelete(Jelol sign) {
		return model.signDelete(sign);
	}

	public boolean createGroup(String nev) {
		return model.createGroup(nev);
	}

	public boolean joinGroup(Csatlakozik join) {
		return model.joinGroup(join);
	}

	public List<Group> listGroup() {
		return model.listGroup();
	}

	public List<Group> groupsmemberNumber(Group group) {
		return model.groupsmemberNumber(group);
	}

	public void sendMessage(Uzen message) {
	}


	public List<Poszt> listPoszt(Profil p) {
		return model.getPosts(p);
	}

	public boolean createCommment(Kommentel comment) {
		return model.createCommment(comment);
	}

	public List<Kommentel> listComment(Kommentel comment) {
		return model.listComment(comment);
	}

	public boolean regYetUser(String email) {
		return model.regYetUser(email);
	}

	public List<Profil> getAllUser() {
		return model.allProfil();
	}

	public ImageIcon imgShow(String email) {
		return model.imgShow(email);

	}

	public List<String> sajatKepek(String email) {
		return model.sajatKepek(email);
	}

	public ImageIcon imageNezzem(int id) {
		return model.imageNezzem(id);
	}
	
	public void kepfeltolt(String email, String where){
	}


}
