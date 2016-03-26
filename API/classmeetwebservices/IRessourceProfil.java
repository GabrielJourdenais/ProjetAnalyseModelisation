package classmeetwebservices;

import javax.ws.rs.core.Response;

import classmeetmodels.Cours;
import classmeetmodels.Utilisateur;

public interface IRessourceProfil {

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils
	 */
	public Response getListeProfil();

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getProfilParId(String codeUtilisateur);

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}/cours
	 * 
	 * @pathParam codeUtilsateur
	 */
	public Response getListeCoursParProfil(String codeUtilisateur);

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils
	 * @return Response
	 */
	public Response addProfil(Utilisateur nouvUtilisateur);

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/{codeUtilisateur}/cours
	 * @return Response
	 */
	public Response addCoursTableCours(Cours nouvCours, String codeUtilisateur);

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/{codeUtilisateur}/cours
	 * @return Response
	 */
	public Response addCoursTableGroupeCours(Cours nouvCours, String codeUtilisateur);

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/{codeUtilisateur}/cours
	 * @return Response
	 */
	public Response addCoursTableEtudiantGroupeCours(Cours nouvCours, String codeUtilisateur);

	/**
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messages
	 */
	public Response getListeMessageParProfil(String codeUtilisateur);

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/profils
	 * @return Response
	 */
	public Response updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur);

}
