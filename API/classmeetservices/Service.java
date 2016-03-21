package classmeetservices;

import java.util.List;

import classmeetdao.IProfilDAO;
import classmeetmodels.Cours;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;

public class Service implements IClassMeetService {

	private IProfilDAO dao;

	public Service(IProfilDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Utilisateur> getListeProfil() {
		try {
			return dao.getListeProfil();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Utilisateur getProfilParId(String codeUtilisateur) {
		try {
			return dao.getProfilParId(codeUtilisateur);
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Cours> getListeCoursParProfil(String codeUtilisateur) {
		try {
			return dao.getListeCoursParProfil(codeUtilisateur);

		} catch (Exception e) {
			return null;
		}
	}
/*
	@Override
	public List<Message> getListeMessageParProfil(String codeUtilisateur) {
		try {
			return dao.getListeMessageParProfil(codeUtilisateur);
		} catch (Exception e) {
			return null;
		}
	}
*/
}
