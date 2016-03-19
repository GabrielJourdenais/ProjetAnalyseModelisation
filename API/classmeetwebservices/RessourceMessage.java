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

import classmeetdao.MessageDAO;
import classmeetmodels.Message;
import classmeetservices.IMessageService;
import classmeetservices.MessageService;

@Path("profils")
public class RessourceMessage implements IRessourceMessage {

	private final IMessageService service;

	public RessourceMessage() {
		this(new MessageService(new MessageDAO()));
	}

	public RessourceMessage(IMessageService service) {
		this.service = service;
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
