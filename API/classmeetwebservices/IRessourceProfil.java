package classmeetwebservices;

import javax.ws.rs.core.Response;

import classmeetmodels.Equipe;
import classmeetmodels.GroupeCoursUtilisateur;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;

public interface IRessourceProfil {

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils
	 */
	public Response getListeProfil();

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils
	 * 
	 * @body nouvUtilisateur
	 */
	public Response addProfil(Utilisateur nouvUtilisateur);
	
	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getProfilParId(String codeUtilisateur);
	
	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}
	 * 
	 * @body nouvUtilisateur
	 * @pathParam codeUtilisateur
	 */
	public Response updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur);
	
	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}/groupesCours
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getListeGroupeCoursParProfil(String codeUtilisateur);

	
	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/groupesCours
	 * 
	 * @body nouvGroupeCours
	 * @pathParam codeUtilisateur
	 */
	public Response addGroupeCoursParProfil(GroupeCoursUtilisateur nouvGroupeCours,String codeUtilisateur);
	
	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}/groupesCours
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getListeEquipesParProfil(String codeUtilisateur);

	
	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/equipes
	 * 
	 * @body nouvEquipe
	 * @pathParam codeUtilisateur
	 */
	public Response addEquipeParProfil(Equipe nouvEquipe,String codeUtilisateur);
	
	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}/equipes/{sigleCours}
	 * 
	 * @pathParam codeUtilisateur
	 * @pathParam sigleCours
	 */
	public Response getEquipeParSigle(String codeUtilisateur,String sigleCours);

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messages
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getListeMessagesParProfil(String codeUtilisateur);
	
	/**
	 * 
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messagesEnvoyes
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getListeMessagesEnvoyesParProfil(String codeUtilisateur);
	
	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messages
	 * 
	 * @body nouvMessage
	 * @pathParam codeUtilisateur
	 */
	public Response addMessageParProfil(Message nouvMessage,String codeUtilisateur);

	

}
