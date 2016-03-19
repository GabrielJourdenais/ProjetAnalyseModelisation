package classmeetdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import apps.config.AppSpringConfigDatabase;
import classmeetmodels.Message;

public class MessageDAO implements IMessageDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public MessageDAO() {
		AppSpringConfigDatabase db = new AppSpringConfigDatabase();
		this.jdbcTemplate = db.createNamedParameterJdbcTemplate();
	}

	public MessageDAO(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Message> getListeMessageParProfil(String codeUtilisateur) {
		String query = "select * from Message where Message.codeUtilisateur = codeUtilisateur";
		return this.jdbcTemplate.query(query, new MessageMapper());
	}

	public static final class MessageMapper implements RowMapper<Message> {

		@Override
		public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

			Message unMessage = new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6));

			return unMessage;
		}
	}

}
