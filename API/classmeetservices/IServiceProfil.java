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
	 * de la requ�te.
	 * 
	 * @param nouvUtilisateur
	 */
	public int addProfil(Utilisateur nouvUtilisateur);
	
	/**
	 * Cette fonction retourne le profil de l'utilisateur dont le ID est pass�
	 * en param�tre.
	 * 
	 * @param codeUtilisateur
	 * @return L'utilisateur s�lectionn�
	 */
	public Utilisateur getProfilParId(String codeUtilisateur);

	
	/**
	 * Fonction qui met � jour un profil utilisateur puis retourne le status
	 * de la requ�te.
	 * 
	 * @param nouvUtilisateur
	 * @param codeUtilisateur
	 */
	public int updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur);
	
	/**
	 * Cette fonction retourne la liste des groupeCours d'un utilisateur dont le ID
	 * est pass� en param�tre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des cours de l'utilisateur s�lectionn�
	 */
	public List<GroupeCoursUtilisateur> getListeGroupeCoursParProfil(String codeUtilisateur);

	/**
	 * Fonction qui ajoute un nouveau groupeCours associ� � un utilisateur puis retourne le status
	 * de la requ�te.
	 * 
	 * @param nouvGroupeCours
	 * @param codeUtilisateur
	 * 
	 */
	public int addGroupeCoursParProfil(GroupeCoursUtilisateur nouvGroupeCours,String codeUtilisateur);

	/**
	 * Fonction qui liste les �quipes d'un utilisateur dont le ID
	 * est pass� en param�tre.
	 * 
	 * @param codeUtilisateur
	 * @return la liste des �quipes de l'utilisateur
	 */
	public List<Equipe> getListeEquipesParProfil(String codeUtilisateur);

	
	/**
	 * Fonction qui ajouter une �quipe � un utilisateur et retourne le r�sultat de la requ�te
	 * 
	 * @param nouvEquipe
	 * @param codeUtilisateur
	 */
	public int addEquipeParProfil(Equipe nouvEquipe,String codeUtilisateur);
	
	/**
	 * Fonction qui retourne l'�quipe s�l�ctionner pour un cours de l'utilisateur courant
	 * 
	 * @param codeUtilisateur
	 * @param sigleCours
	 */
	public Equipe getEquipeParSigle(String codeUtilisateur,String sigleCours);
	
	/**
	 * Fonction qui retourne la liste des messages de l'utilisateur dont le ID
	 * est pass� en param�tre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur s�lectionn�.
	 */
	public List<Message> getListeMessagesParProfil(String codeUtilisateur);
	
	/**
	 * Fonction qui retourne la liste des messages envoy�es par l'utilisateur dont le ID
	 * est pass� en param�tre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur s�lectionn�.
	 */
	public List<Message> getListeMessagesEnvoyesParProfil(String codeUtilisateur);
	
	/**
	 * Fonction qui ajoute un nouveau message � l'utilisateur et retourne le resulat de la requ�te
	 * 
	 * @param nouvMessage
	 * @param codeUtilisateur
	 */
	public int addMessageParProfil(Message nouvMessage,String codeUtilisateur);
	
	/**
	 * Fonction qui supprime un message en fonction de son id et retourne le resulat de la requ�te
	 * 
	 * @param codeUtilisateur
	 * @param idMessage
	 */
	public int supprimerMessage(String codeUtilisateur,int idMessage);

	
}
