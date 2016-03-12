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
	public Utilisateur getListeProfilParId(String codeUtilisateur) {

		List<Utilisateur> listeUtilisateur = dao.getListeProfil();
		Utilisateur utilisateur;
		try {
			for (int i = 0; i < listeUtilisateur.size(); i++) {
				if (listeUtilisateur.get(i).getCodeUtilisateur() == codeUtilisateur) {
					utilisateur = new Utilisateur(listeUtilisateur.get(i).getCodeUtilisateur(),
							listeUtilisateur.get(i).getMotDePasse(), listeUtilisateur.get(i).getPrenom(),
							listeUtilisateur.get(i).getNom(), listeUtilisateur.get(i).getCourriel());
					return utilisateur;
				}
			}
			return null;
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

	@Override
	public List<Message> getListeMessageParProfil(String codeUtilisateur) {
		try {
			return dao.getListeMessageParProfil(codeUtilisateur);
		} catch (Exception e) {
			return null;
		}
	}

}
