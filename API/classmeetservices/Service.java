package classmeetservices;

import java.util.List;

import classmeetdao.IProfilDAO;
import classmeetmodels.Cours;
import classmeetmodels.CoursTemp;
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
	public List<CoursTemp> getListeCoursParProfil(String codeUtilisateur) {
		try {
			return dao.getListeCoursParProfil(codeUtilisateur);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addProfil(Utilisateur nouvUtilisateur) {
		try {
			int nbLigne = dao.addProfil(nouvUtilisateur);
			if (nbLigne > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int addCours(Cours nouvCours, String codeUtilisateur) {
		try {
					int nbLigne = dao.addCours(nouvCours, codeUtilisateur);
			if (nbLigne > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Message> getListeMessageParProfil(String codeUtilisateur) {
		try {
			return dao.getListeMessageParProfil(codeUtilisateur);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur) {
		try {
			int nbLighe = dao.updateProfil(nouvUtilisateur, codeUtilisateur);
			if (nbLighe > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 0;
		}
	}

}
