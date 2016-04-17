package classmeetdao;

import java.util.List;

import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.Evenement;
import classmeetmodels.GroupeCours;
import classmeetmodels.Utilisateur;

public interface ICoursDAO {

	/**
	 * Fonction qui retourne la liste des cours
	 */
	public List<Cours> getListeCours();

	/**
	 * Fonction qui ajoute un cours et retourne le status de la requête
	 */
	public int addCours(Cours nouvCours);

	/**
	 * Fonction qui retourne un cours par son sigle
	 */
	public Cours getCoursParSigle(String sigleCours);

	/**
	 * Fonction qui retourne la liste des groupes par cours
	 */
	public List<GroupeCours> getListeGroupesParCours(String sigleCours);

	/**
	 * Fonction qui ajoute un groupeCours et retourne le status de la requête
	 */
	public int addGroupeParCours(GroupeCours nouvGroupeCours, String sigleCours);

	/**
	 * Fonction qui retourne un groupe par son numero
	 */
	public GroupeCours getGroupeParNumero(String sigleCours, int noGroupe);

	/**
	 * Fonction qui retourne la liste des utilisateurs par groupeCours
	 */
	public List<Utilisateur> getListeMembresParGroupeCours(String sigleCours, int noGroupe);
	
	/**
	 * Fonction qui retourne la liste des equipes par groupeCours
	 */
	public List<Equipe> getListeEquipesParGroupeCours(String sigleCours, int noGroupe);

	/**
	 * Fonction qui ajoute une equipe et retourne le status de la requête
	 */
	public int addEquipeParGroupeCours(Equipe nouvEquipe, String sigleCours, int noGroupe);
	
	/**
	 * Fonction qui retourne une equipe par son numero
	 */
	public Equipe getEquipeParNoEquipe(String sigleCours, int noGroupe, int noEquipe);

	/**
	 * Fonction qui retourne la liste des membres d'une équipe
	 */
	public List<Utilisateur> getListeMembresParEquipe(String sigleCours, int noGroupe,int noEquipe);
	
	/**
	 * Fonction qui ajoute un événement et retourne le status de la requête
	 */
	public int addEvenement(Evenement nouvEvenement, String sigleCours, int noGroupe, int noEquipe);

}
