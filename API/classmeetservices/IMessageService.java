package classmeetservices;

import java.util.List;
import classmeetmodels.Message;

public interface IMessageService {

	/**
	 * Fonction qui retourne la liste des message de l'utilisateur dont le ID
	 * est passé en paramètre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur sélectionné.
	 */
	public List<Message> getListeMessageParProfil(String codeUtilisateur);

}
