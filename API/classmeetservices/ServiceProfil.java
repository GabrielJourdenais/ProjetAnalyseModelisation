package classmeetservices;

import java.util.List;

import classmeetdao.IProfilDAO;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCoursUtilisateur;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;

public class ServiceProfil implements IServiceProfil {

	private IProfilDAO dao;

	public ServiceProfil(IProfilDAO dao) {
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
	public Utilisateur getProfilParId(String codeUtilisateur) {
		try {
			return dao.getProfilParId(codeUtilisateur);
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
	
	@Override
	public List<GroupeCoursUtilisateur> getListeGroupeCoursParProfil(String codeUtilisateur) {
		try {
			return dao.getListeGroupeCoursParProfil(codeUtilisateur);

		} catch (Exception e) {
			return null;
		}
	}

	

	@Override
	public int addGroupeCoursParProfil(GroupeCoursUtilisateur nouvGroupeCours,String codeUtilisateur) {
		try {
			int nbLigne = dao.addGroupeCoursParProfil(nouvGroupeCours,codeUtilisateur);
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
	public List<Equipe> getListeEquipesParProfil(String codeUtilisateur) {
		try {
			return dao.getListeEquipesParProfil(codeUtilisateur);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addEquipeParProfil(Equipe nouvEquipe, String codeUtilisateur) {
		try {
			int nbLigne = dao.addEquipeParProfil(nouvEquipe,codeUtilisateur);
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
	public Equipe getEquipeParSigle(String codeUtilisateur, String sigleCours) {
		try {
			return dao.getEquipeParSigle(codeUtilisateur,sigleCours);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Message> getListeMessagesParProfil(String codeUtilisateur) {
		try {
			return dao.getListeMessagesParProfil(codeUtilisateur);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Message> getListeMessagesEnvoyesParProfil(String codeUtilisateur) {
		try {
			return dao.getListeMessagesEnvoyesParProfil(codeUtilisateur);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addMessageParProfil(Message nouvMessage,String codeUtilisateur) {
		try {
			int nbLigne = dao.addMessageParProfil(nouvMessage,codeUtilisateur);
			if (nbLigne > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 0;
		}
	}
}
