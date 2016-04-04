package classmeetwebservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import classmeetdao.ProfilDAO;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCoursUtilisateur;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;
import classmeetmodels.MessageStatus;
import classmeetservices.IServiceProfil;
import classmeetservices.ServiceProfil;

@Path("profils")
public class RessourceProfil implements IRessourceProfil {

	private final IServiceProfil service;

	public RessourceProfil() {
		this(new ServiceProfil(new ProfilDAO()));
	}

	public RessourceProfil(IServiceProfil service) {
		this.service = service;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeProfil() {
		List<Utilisateur> utilisateurs;
		try {
			utilisateurs = service.getListeProfil();
			if ((utilisateurs == null) || (utilisateurs.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(utilisateurs).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@OPTIONS
	public Response addProfilPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addProfil(Utilisateur nouvUtilisateur) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addProfil(nouvUtilisateur));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}


	@GET
	@Path("/{codeUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getProfilParId(@PathParam("codeUtilisateur") String codeUtilisateur) {
		try {
			Utilisateur utilisateur = service.getProfilParId(codeUtilisateur);

			if (utilisateur == null) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(utilisateur).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@OPTIONS
	@Path("/{codeUtilisateur}")
	public Response updateProfilPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}

	@POST
	@Path("/{codeUtilisateur}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response updateProfil(Utilisateur nouvUtilisateur, @PathParam("codeUtilisateur") String codeUtilisateur) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.updateProfil(nouvUtilisateur, codeUtilisateur));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	

	@GET
	@Path("{codeUtilisateur}/groupesCours")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeGroupeCoursParProfil(@PathParam("codeUtilisateur") String codeUtilisateur) {
		List<GroupeCoursUtilisateur> listeGroupeCours;
		try {
			listeGroupeCours = service.getListeGroupeCoursParProfil(codeUtilisateur);

			if ((listeGroupeCours == null) || (listeGroupeCours.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(listeGroupeCours).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	
	@OPTIONS
	@Path("{codeUtilisateur}/groupesCours")
	public Response addGroupeCoursParProfilPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}

	
	@POST
	@Path("{codeUtilisateur}/groupesCours")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addGroupeCoursParProfil(GroupeCoursUtilisateur nouvGroupeCours,@PathParam("codeUtilisateur") String codeUtilisateur) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addGroupeCoursParProfil(nouvGroupeCours,codeUtilisateur));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("{codeUtilisateur}/equipes")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeEquipesParProfil(@PathParam("codeUtilisateur") String codeUtilisateur) {
		List<Equipe> listeEquipes;
		try {
			listeEquipes = service.getListeEquipesParProfil(codeUtilisateur);

			if ((listeEquipes == null) || (listeEquipes.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(listeEquipes).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@OPTIONS
	@Path("{codeUtilisateur}/equipes")
	public Response addEquipeParProfilPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}
	
	@POST
	@Path("{codeUtilisateur}/equipes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addEquipeParProfil(Equipe nouvEquipe,@PathParam("codeUtilisateur")  String codeUtilisateur) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addEquipeParProfil(nouvEquipe,codeUtilisateur));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@GET
	@Path("{codeUtilisateur}/equipes/{sigleCours}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getEquipeParSigle(@PathParam("codeUtilisateur") String codeUtilisateur,@PathParam("sigleCours")  String sigleCours) {
		try {
			Equipe equipe = service.getEquipeParSigle(codeUtilisateur,sigleCours);

			if (equipe == null) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(equipe).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("{codeUtilisateur}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeMessagesParProfil(@PathParam("codeUtilisateur") String codeUtilisateur) {
		List<Message> listeMessage;
		try {
			listeMessage = service.getListeMessagesParProfil(codeUtilisateur);

			if ((listeMessage == null) || (listeMessage.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(listeMessage).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("{codeUtilisateur}/messagesEnvoyes")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeMessagesEnvoyesParProfil(@PathParam("codeUtilisateur") String codeUtilisateur) {
		List<Message> listeMessage;
		try {
			listeMessage = service.getListeMessagesEnvoyesParProfil(codeUtilisateur);

			if ((listeMessage == null) || (listeMessage.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(listeMessage).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@OPTIONS
	@Path("{codeUtilisateur}/messages")
	public Response addMessageParProfilPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}

	@POST
	@Path("{codeUtilisateur}/messages")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addMessageParProfil(Message nouvMessage,@PathParam("codeUtilisateur") String codeUtilisateur){
		MessageStatus status=new MessageStatus(0);
		try {
			status = new MessageStatus(service.addMessageParProfil(nouvMessage, codeUtilisateur));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@OPTIONS
	@Path("{codeUtilisateur}/messages/{idMessage}")
	public Response supprimerMessagePreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,DELETE")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}
	
	@DELETE
	@Path("{codeUtilisateur}/messages/{idMessage}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response supprimerMessage(@PathParam("codeUtilisateur") String codeUtilisateur,@PathParam("idMessage") int idMessage){
		MessageStatus status=new MessageStatus(0);
		try {
			status = new MessageStatus(service.supprimerMessage(codeUtilisateur,idMessage));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}


	/*@DELETE
	@Path("{codeUtilisateur}/messagesEnvoyes/{idMessage}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response supprimerMessageEnvoyes(@PathParam("codeUtilisateur") String codeUtilisateur,@PathParam("idMessage") int idMessage){
		MessageStatus status=new MessageStatus(0);
		try {
			status = new MessageStatus(service.supprimerMessage(codeUtilisateur,idMessage));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}*/
	

}
