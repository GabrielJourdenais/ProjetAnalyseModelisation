package classmeetwebservices;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import classmeetmodels.Utilisateur;

public interface IRessourceProfil {

	/**
	 * @GET
	 * url: localhost:7001/ClassMeet/v1/profils
	 */
	public Response getListeProfil();

	/**
	 * @GET
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getProfilParId(String codeUtilisateur);

	/**
	 * @GET
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}/cours
	 * 
	 * @pathParam codeUtilsateur
	 */
	public Response getListeCoursParProfil(String codeUtilisateur);

	/**
	 * @POST
	 * url: localhost:7001/ClassMeet/v1/profils
	 * @return Response
	 */
	public Response addProfil(Utilisateur nouvUtilisateur);
	
	/**
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messages
	 */
/*	public Response getListeMessageParProfil(String codeUtilisateur); */

}
