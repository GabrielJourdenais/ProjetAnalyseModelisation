package classmeetservices;

import java.util.List;

import classmeetmodels.Equipe;
import classmeetmodels.GroupeCoursUtilisateur;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;

public interface IServiceProfil {

	/**
	 * Fonction qui retourne la liste des profil de tous les utilisateurs.
	 */
	public List<Utilisateur> getListeProfil();

	/**
	 * Fonction qui ajoute un nouveau profil utilisateur puis retourne le status
	 * de la requête.
	 * 
	 * @param nouvUtilisateur
	 */
	public int addProfil(Utilisateur nouvUtilisateur);
	
	/**
	 * Cette fonction retourne le profil de l'utilisateur dont le ID est passé
	 * en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return L'utilisateur sélectionné
	 */
	public Utilisateur getProfilParId(String codeUtilisateur);

	
	/**
	 * Fonction qui met à jour un profil utilisateur puis retourne le status
	 * de la requête.
	 * 
	 * @param nouvUtilisateur
	 * @param codeUtilisateur
	 */
	public int updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur);
	
	/**
	 * Cette fonction retourne la liste des groupeCours d'un utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des cours de l'utilisateur sélectionné
	 */
	public List<GroupeCoursUtilisateur> getListeGroupeCoursParProfil(String codeUtilisateur);

	/**
	 * Fonction qui ajoute un nouveau groupeCours associé à un utilisateur puis retourne le status
	 * de la requête.
	 * 
	 * @param nouvGroupeCours
	 * @param codeUtilisateur
	 * 
	 */
	public int addGroupeCoursParProfil(GroupeCoursUtilisateur nouvGroupeCours,String codeUtilisateur);

	/**
	 * Fonction qui liste les équipes d'un utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return la liste des équipes de l'utilisateur
	 */
	public List<Equipe> getListeEquipesParProfil(String codeUtilisateur);

	
	/**
	 * Fonction qui ajouter une équipe à un utilisateur et retourne le résultat de la requête
	 * 
	 * @param nouvEquipe
	 * @param codeUtilisateur
	 */
	public int addEquipeParProfil(Equipe nouvEquipe,String codeUtilisateur);
	
	/**
	 * Fonction qui retourne l'équipe séléctionner pour un cours de l'utilisateur courant
	 * 
	 * @param codeUtilisateur
	 * @param sigleCours
	 */
	public Equipe getEquipeParSigle(String codeUtilisateur,String sigleCours);
	
	/**
	 * Fonction qui retourne la liste des messages de l'utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur sélectionné.
	 */
	public List<Message> getListeMessagesParProfil(String codeUtilisateur);
	
	/**
	 * Fonction qui retourne la liste des messages envoyées par l'utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur sélectionné.
	 */
	public List<Message> getListeMessagesEnvoyesParProfil(String codeUtilisateur);
	
	/**
	 * Fonction qui ajoute un nouveau message à l'utilisateur et retourne le resulat de la requête
	 * 
	 * @param nouvMessage
	 * @param codeUtilisateur
	 */
	public int addMessageParProfil(Message nouvMessage,String codeUtilisateur);
	
	/**
	 * Fonction qui supprime un message en fonction de son id et retourne le resulat de la requête
	 * 
	 * @param codeUtilisateur
	 * @param idMessage
	 */
	public int supprimerMessage(String codeUtilisateur,int idMessage);

	
}
