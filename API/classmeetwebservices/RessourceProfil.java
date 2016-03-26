package classmeetwebservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import classmeetdao.ProfilDAO;
import classmeetmodels.Cours;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;
import classmeetmodels.MessageStatus;
import classmeetservices.IClassMeetService;
import classmeetservices.Service;

@Path("profils")
public class RessourceProfil implements IRessourceProfil {

	private final IClassMeetService service;

	public RessourceProfil() {
		this(new Service(new ProfilDAO()));
	}

	public RessourceProfil(IClassMeetService service) {
		this.service = service;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeProfil() {
		List<Utilisateur> utilisateurs;
		try {
			utilisateurs = service.getListeProfil();
			// utilisateurs = new ArrayList<Utilisateur>();
			// utilisateurs.add(new Utilisateur("", "", "", "", ""));
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

	@OPTIONS
	@Path("/cours")
	public Response addCoursPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}

	@POST
	@Path("/cours")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addCours(Cours nouvCours) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addCours(nouvCours));
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
			// utilisateur = new Utilisateur("", "", "", "", ""));

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

	@GET
	@Path("{codeUtilisateur}/cours")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeCoursParProfil(@PathParam("codeUtilisateur") String codeUtilisateur) {
		List<Cours> listeCours;
		try {
			listeCours = service.getListeCoursParProfil(codeUtilisateur);
			// listeCours = new ArrayList<Cours>();
			// listeCours.add(new Cours("", "", SessionCours.H, 0, 0, ""));

			if ((listeCours == null) || (listeCours.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(listeCours).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@GET
	@Path("Messages/{idUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeMessageParProfil(@QueryParam("codeUtilisateur") String codeUtilisateur) {
		List<Message> listeMessage;
		try {
			listeMessage = service.getListeMessageParProfil(codeUtilisateur);
			// listeMessage = new ArrayList<Message>();
			// listeMessage.add(new Message(0, "", "", "", "", ""));

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

}
