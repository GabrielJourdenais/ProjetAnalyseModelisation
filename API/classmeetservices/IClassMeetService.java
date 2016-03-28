package classmeetservices;

import java.util.List;

import classmeetmodels.Cours;
import classmeetmodels.CoursTemp;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;

public interface IClassMeetService {

	/**
	 * Fonction qui retourne la liste des profil de tous les utilisateurs.
	 */
	public List<Utilisateur> getListeProfil();

	/**
	 * Cette fonction retourne le profil de l'utilisateur dont le ID est passé
	 * en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return L'utilisateur sélectionné
	 */
	public Utilisateur getProfilParId(String codeUtilisateur);

	/**
	 * Cette fonction retourne la liste des cours d'un utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des cours de l'utilisateur sélectionné
	 */
	public List<CoursTemp> getListeCoursParProfil(String codeUtilisateur);

	/**
	 * Fonction qui ajoute un nouveau profil utilisateur puis retourne le status
	 * de la requête.
	 */
	public int addProfil(Utilisateur nouvUtilisateur);

	/**
	 * Fonction qui ajoute un nouveau cours dans la table Cours puis retourne le status
	 * de la requête.
	 */
	public int addCours(Cours nouvCours, String codeUtilisateur);

	
	/**
	 * Fonction qui retourne la liste des message de l'utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur sélectionné.
	 */
	public List<Message> getListeMessageParProfil(String codeUtilisateur);

	/**
	 * Fonction qui met à jour un profil utilisateur puis retourne le status
	 * de la requête.
	 */
	public int updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur);
}
