package classmeetwebservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import classmeetdao.ProfilDAO;
import classmeetmodels.Cours;
import classmeetmodels.Message;
import classmeetmodels.Utilisateur;
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
		//	utilisateurs = service.getListeProfil();
			 utilisateurs = new ArrayList<Utilisateur>();
			 utilisateurs.add(new Utilisateur("", "", "", "", ""));
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

	@GET
	@Path("/{idUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeProfilParId(@QueryParam("codeUtilisateur") String codeUtilisateur) {
		try {
			Utilisateur utilisateur = service.getListeProfilParId(codeUtilisateur);
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
	@Path("Cours/{idUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeCoursParProfil(@QueryParam("codeUtilisateur") String codeUtilisateur) {
		List<Cours> listeCours;
		try {
			listeCours = service.getListeCoursParProfil(codeUtilisateur);
			// listeCours = new ArrayList<Cours>();
			// listeCours.add(new Cours("", "", SessionCours.H, 0));

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

}
