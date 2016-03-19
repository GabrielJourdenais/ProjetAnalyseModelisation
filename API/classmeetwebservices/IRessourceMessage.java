package classmeetwebservices;

import javax.ws.rs.core.Response;

public interface IRessourceMessage {

	/**
	 * url: localhost:7001/ClassMeet/v1/profils/{codeUtilisateur}/messages
	 */
	public Response getListeMessageParProfil(String codeUtilisateur);

}
