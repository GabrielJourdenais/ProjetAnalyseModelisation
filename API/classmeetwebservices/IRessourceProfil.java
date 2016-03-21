package classmeetwebservices;

import javax.ws.rs.core.Response;

public interface IRessourceProfil {

	/**
	 * url: localhost:7001/ClassMeet/v1/profils
	 */
	public Response getListeProfil();

	/**
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}
	 * 
	 * @pathParam codeUtilisateur
	 */
	public Response getProfilParId(String codeUtilisateur);

	/**
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilsateur}/cours
	 * 
	 * @pathParam codeUtilsateur
	 */
	public Response getListeCoursParProfil(String codeUtilisateur);

	/**
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messages
	 */
/*	public Response getListeMessageParProfil(String codeUtilisateur); */

}
