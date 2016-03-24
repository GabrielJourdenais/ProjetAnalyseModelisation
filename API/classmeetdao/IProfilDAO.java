package classmeetdao;

import java.util.List;

import classmeetmodels.Cours;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;

public interface IProfilDAO {

	/**
	 * Fonction qui retourne la liste des profil de tous les utilisateur.
	 */
	public List<Utilisateur> getListeProfil();
	
	/**
	 * Fonction qui retourne la liste un profil utilisateur en fonction de son code utilisateur.
	 */
	public Utilisateur getProfilParId(String codeUtilisateur);

	/**
	 * Fonction qui retourne la liste des cours de l'utilisateur dont le ID est
	 * passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des cours de l'utilisateur sélectionné
	 */
	public List<Cours> getListeCoursParProfil(String codeUtilisateur);

	/**
	 * Fonction qui ajoute un nouveau profil utilisateur puis retourne le nombre de ligne affectées.
	 */
	public int addProfil(Utilisateur nouvUtilisateur);
	
	/**
	 * Fonction qui retourne la liste des messages de l'utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur sélectionné
	 */
	/* public List<Message> getListeMessageParProfil(String codeUtilisateur); */

}
