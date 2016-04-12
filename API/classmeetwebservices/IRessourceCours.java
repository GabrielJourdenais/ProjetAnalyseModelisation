package classmeetwebservices;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCours;
import classmeetmodels.Evenements;
public interface IRessourceCours {

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/cours
	 */
	public Response getListeCours();

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/cours
	 */
	public Response addCours(Cours nouvCours);

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/cours/{sigleCours}
	 * 
	 * @pathParam sigleCours
	 */
	public Response getCoursParSigle(String sigleCours);

	/**
	 * @GET url: localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes
	 * 
	 * @pathParam sigleCours
	 */
	public Response getListeGroupesParCours(String sigleCours);

	/**
	 * @POST url: localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes
	 * 
	 * @pathParam sigleCours
	 */
	public Response addGroupeParCours(GroupeCours nouvGroupeCours, String sigleCours);

	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 */
	public Response getGroupeParNumero(String sigleCours, String noGroupe);

	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/
	 *      equipes
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 */
	public Response getListeEquipesParGroupeCours(String sigleCours, int noGroupe);

	/**
	 * @POST url:
	 *       localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/
	 *       equipes
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 */
	public Response addEquipeParGroupeCours(Equipe nouvEquipe, String sigleCours, int noGroupe);

/**
 * @POST url: localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupesCours/{noGroupe}/equipes/{noEquipe}/evenements
 *  
 * @pathParam nouvEvenement
 * @pathParam sigleCours
 * @pathParam noGroupe
 * @pathParam noEquipe
 */
	public Response addEvenement(Evenements nouvEvenement, @PathParam("sigleCours") String sigleCours, @PathParam("noGroupe") int noGroupe, @PathParam("noEquipe") int noEquipe);

}
