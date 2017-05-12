package llamabook.controller;



import java.util.List;
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

	private ModelDao model = new ModelDao();

	public void startDesktop(){
		new LoginScreen(this);
	
	}
		
        public ModelDao getDao(){
            return this.model;
        }
        
	public boolean userRegis(Profil user){	
		return model.userRegis(user);
	}

	public Profil userLoggingIn(Profil user){
		return model.userLoggingIn(user);
	}
	
	public boolean userName(Profil user){
		return model.userName(user);
	}
	
	public boolean userBirthdate (Profil user){
		return model.userBirthdate(user);
	}
	
	public boolean userGroupNumber(Csatlakozik join){
		return model.userGroupNumber(join);
	}
	
	public boolean userJob(Profil user){
		return model.userJob(user);
	}	
	
	public boolean userSchool(Profil user){
		return model.userSchool(user);
	}
	
	public boolean userFriendsnumber(Jelol sign){
		return model.userFriendsnumber(sign);
	}

	public List<Profil> userFriends(Profil user){
		return model.userFriends(user);
	}

	public List<Profil> userSeek(Profil user){
		return model.userSeek(user);
	}

	public List<Profil> userseekFirst(Profil user){
		return model.userseekFirst(user);
	}

	public List<Profil> userseekSecond(Profil user){
		return model.userseekSecond(user);
	}

	public boolean friendSign(Jelol jelol){
		return model.friendSign(jelol);
	}

	public List<Jelol> listSigns(Jelol jelol){
		return model.listSigns(jelol);
	}

	public boolean signAccept(Jelol sign){
		return model.signAccept(sign);
	}

	public boolean signDelete(Jelol sign){
		return model.signDelete(sign);
	}

	public boolean createGroup(Group group){
		return model.createGroup(group);
	}

	public boolean joinGroup(Csatlakozik join){
		return model.joinGroup(join);
	}

	public List<Group> listGroup(){
		return model.listGroup();
	}

	public List<Group> groupsmemberNumber(Group group){
		return model.groupsmemberNumber(group);
	}

	public boolean sendMessage(Uzen message){
		return model.sendMessage(message);
	}

	public List<Uzen> listMessage(Uzen message){
		return model.listMessage(message);
	}

	public boolean posztCreate(Poszt post){
		return model.posztCreate(post);
	}

	public List<Poszt> listPoszt(Poszt post){
		return model.listPoszt(post);
	}

	public boolean createCommment(Kommentel comment){
		return model.createCommment(comment);
	}
	
	public List<Kommentel> listComment(Kommentel comment){
		return model.listComment(comment);
	}
        
        
        
        
        public boolean regYetUser(String email){
            return model.regYetUser(email);
        }

}
