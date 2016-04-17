package classmeetwebservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import classmeetdao.CoursDAO;
import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCours;
import classmeetmodels.MessageStatus;
import classmeetmodels.Utilisateur;
import classmeetmodels.Evenement;
import classmeetservices.IServiceCours;
import classmeetservices.ServiceCours;

@Path("cours")
public class RessourceCours implements IRessourceCours{

	private final IServiceCours service;

	public RessourceCours() {
		this(new ServiceCours(new CoursDAO()));
	}

	public RessourceCours(IServiceCours service) {
		this.service = service;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeCours() {
		List<Cours> cours;
		try {
			cours = service.getListeCours();
			if ((cours == null) || (cours.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(cours).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@OPTIONS
	public Response addCoursPreflight() {
		return Response.noContent().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET,POST")
				.header("Access-Control-Allow-Headers", "accept,content-type").header("Access-Control-Max-Age", 600)
				.build();
	}
	
	@POST
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
	@Path("/{sigleCours}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getCoursParSigle(@PathParam("sigleCours") String sigleCours) {
		try {
			Cours cours = service.getCoursParSigle(sigleCours);

			if (cours == null) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(cours).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@GET
	@Path("/{sigleCours}/groupes")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeGroupesParCours(@PathParam("sigleCours") String sigleCours) {
		List<GroupeCours> groupes;
		try {
			groupes = service.getListeGroupesParCours(sigleCours);
			if ((groupes == null) || (groupes.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(groupes).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@POST
	@Path("/{sigleCours}/groupes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addGroupeParCours(GroupeCours nouvGroupeCours,@PathParam("sigleCours") String sigleCours) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addGroupeParCours(nouvGroupeCours,sigleCours));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("/{sigleCours}/groupes/{noGroupe}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getGroupeParNumero(@PathParam("sigleCours") String sigleCours,@PathParam("noGroupe") int noGroupe) {
		try {
			GroupeCours groupe = service.getGroupeParNumero(sigleCours,noGroupe);

			if (groupe == null) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(groupe).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("/{sigleCours}/groupes/{noGroupe}/membres")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeMembresParGroupeCours(@PathParam("sigleCours") String sigleCours,@PathParam("noGroupe") int noGroupe){
		List<Utilisateur> membres;
		try {
			membres = service.getListeMembresParGroupeCours(sigleCours,noGroupe);
			if ((membres == null) || (membres.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(membres).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@GET
	@Path("/{sigleCours}/groupes/{noGroupe}/equipes")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeEquipesParGroupeCours(@PathParam("sigleCours") String sigleCours,@PathParam("noGroupe") int noGroupe) {
		List<Equipe> equipes;
		try {
			equipes = service.getListeEquipesParGroupeCours(sigleCours,noGroupe);
			if ((equipes == null) || (equipes.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(equipes).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@POST
	@Path("/{sigleCours}/groupes/{noGroupe}/equipes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addEquipeParGroupeCours(Equipe nouvEquipe,@PathParam("sigleCours") String sigleCours,@PathParam("noGroupe") int noGroupe) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addEquipeParGroupeCours(nouvEquipe,sigleCours,noGroupe));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getEquipeParNoEquipe(@PathParam("sigleCours") String sigleCours,@PathParam("noGroupe") int noGroupe,@PathParam("noEquipe") int noEquipe) {
		Equipe equipe;
		try {
			equipe = service.getEquipeParNoEquipe(sigleCours,noGroupe,noEquipe);
			if ((equipe == null)) {
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
	@Path("/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}/membres")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getListeMembresParEquipe(@PathParam("sigleCours") String sigleCours,@PathParam("noGroupe") int noGroupe, @PathParam("noEquipe") int noEquipe) {
		List<Utilisateur> membres;
		try {
			membres = service.getListeMembresParEquipe(sigleCours,noGroupe,noEquipe);
			if ((membres == null) || (membres.isEmpty())) {
				return Response.noContent().status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*")
						.build();
			}
			return Response.ok(Status.ACCEPTED).entity(membres).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@POST
	@Path("/{sigleCours}/groupes/{noGroupe}/equipes/{noEquipe}/evenements")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response addEvenement(Evenement nouvEvenement, @PathParam("sigleCours") String sigleCours, @PathParam("noGroupe") int noGroupe, @PathParam("noEquipe") int noEquipe) {
		MessageStatus status;
		try {
			status = new MessageStatus(service.addEvenement(nouvEvenement, sigleCours, noGroupe, noEquipe));
			return Response.ok(Status.ACCEPTED).entity(status).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity("error 500")
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}

}
