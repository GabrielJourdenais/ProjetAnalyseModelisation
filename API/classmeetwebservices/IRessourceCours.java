package classmeetwebservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCours;
import classmeetmodels.Utilisateur;
import classmeetmodels.Evenement;
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
	public Response getGroupeParNumero(String sigleCours, int noGroupe);
	
	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/membres
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 */
	public Response getListeMembresParGroupeCours(String sigleCours, int noGroupe);

	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 */
	public Response getListeEquipesParGroupeCours(String sigleCours, int noGroupe);

	/**
	 * @POST url:
	 *       localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 */
	public Response addEquipeParGroupeCours(Equipe nouvEquipe, String sigleCours, int noGroupe);

	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 */
	public Response getEquipeParNoEquipe(String sigleCours,int noGroupe,int noEquipe);
	
	
	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}/membres
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 */
	public Response getListeMembresParEquipe(String sigleCours,int noGroupe,int noEquipe);
		
	
	/**
	 * @GET url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}/requetesMembre
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 */
	public Response getListeRequetesMembreParEquipe(String sigleCours,int noGroupe,int noEquipe);
	
	/**
	 * @POST url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}/requetesMembre
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 */
	public Response addRequetesMembreParEquipe(Utilisateur requeteMembre,String sigleCours,int noGroupe,int noEquipe);
	
	/**
	 * @DELETE url:
	 *      localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}/requetesMembre/{codeUtilisateur}
	 * 
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 * @pathParam codeUtilisateur
	 */
	public Response removeRequetesMembreParEquipe(String sigleCours,int noGroupe,int noEquipe,String codeUtilisateur);
	
	/**
	 * @GET url: localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupesCours/{noGroupe}/equipes/{noEquipe}/evenements
	 *  
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 */
	public Response getListeEvenementParEquipe(String sigleCours, int noGroupe, int noEquipe);
	
	/**
	 * @POST url: localhost:7001/ClassMeet/v1/cours/{sigleCours}/groupesCours/{noGroupe}/equipes/{noEquipe}/evenements
	 *  
	 * @pathParam sigleCours
	 * @pathParam noGroupe
	 * @pathParam noEquipe
	 */
	public Response addEvenementParEquipe(Evenement nouvEvenement, String sigleCours, int noGroupe, int noEquipe);

}
