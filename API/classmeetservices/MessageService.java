package classmeetservices;

import java.util.List;
import classmeetdao.IMessageDAO;
import classmeetmodels.Message;

public class MessageService implements IMessageService {



		private IMessageDAO dao;

		public MessageService(IMessageDAO dao) {
			this.dao = dao;
		}

		@Override
		public List<Message> getListeMessageParProfil(String codeUtilisateur) {
			try {
				return dao.getListeMessageParProfil(codeUtilisateur);
			} catch (Exception e) {
				return null;
			}
		}

	}


