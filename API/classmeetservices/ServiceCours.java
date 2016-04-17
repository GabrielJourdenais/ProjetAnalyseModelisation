package classmeetservices;


import java.util.List;

import classmeetdao.ICoursDAO;
import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.Evenement;
import classmeetmodels.GroupeCours;
import classmeetmodels.Utilisateur;

public class ServiceCours implements IServiceCours {

	private ICoursDAO dao;

	public ServiceCours(ICoursDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Cours> getListeCours() {
		try {
			return dao.getListeCours();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addCours(Cours nouvCours) {
		try {
			int nbLignes = dao.addCours(nouvCours);
			if (nbLignes > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Cours getCoursParSigle(String sigleCours) {
		try {
			return dao.getCoursParSigle(sigleCours);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<GroupeCours> getListeGroupesParCours(String sigleCours) {
		try {
			return dao.getListeGroupesParCours(sigleCours);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addGroupeParCours(GroupeCours nouvGroupeCours, String sigleCours) {
		try {
			int nbLignes = dao.addGroupeParCours(nouvGroupeCours, sigleCours);
			if (nbLignes > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public GroupeCours getGroupeParNumero(String sigleCours, int noGroupe) {
		try {
			return dao.getGroupeParNumero(sigleCours, noGroupe);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Utilisateur> getListeMembresParGroupeCours(String sigleCours, int noGroupe) {
		try {
			return dao.getListeMembresParGroupeCours(sigleCours, noGroupe);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Equipe> getListeEquipesParGroupeCours(String sigleCours, int noGroupe) {
		try {
			return dao.getListeEquipesParGroupeCours(sigleCours, noGroupe);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addEquipeParGroupeCours(Equipe nouvEquipe, String sigleCours, int noGroupe) {
		try {
			int nbLignes = dao.addEquipeParGroupeCours(nouvEquipe, sigleCours, noGroupe);
			if (nbLignes > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Equipe getEquipeParNoEquipe(String sigleCours, int noGroupe, int noEquipe) {
		try {
			return dao.getEquipeParNoEquipe(sigleCours, noGroupe, noEquipe);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Utilisateur> getListeMembresParEquipe(String sigleCours, int noGroupe, int noEquipe) {
		try {
			return dao.getListeMembresParEquipe(sigleCours, noGroupe, noEquipe);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int addEvenement(Evenement nouvEvenement, String sigleCours, int noGroupe, int noEquipe) {
		try {
			int nbLignes = dao.addEvenement(nouvEvenement, sigleCours, noGroupe, noEquipe);
			if (nbLignes > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	

	

}
