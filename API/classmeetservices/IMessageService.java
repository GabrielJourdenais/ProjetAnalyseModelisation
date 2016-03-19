package classmeetservices;

import java.util.List;
import classmeetmodels.Message;

public interface IMessageService {

	/**
	 * Fonction qui retourne la liste des message de l'utilisateur dont le ID
	 * est pass� en param�tre.
	 * 
	 * @param codeUtilisateur
	 * @return La liste des messages de l'utilisateur s�lectionn�.
	 */
	public List<Message> getListeMessageParProfil(String codeUtilisateur);

}
