
package classmeetdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import apps.config.AppSpringConfigDatabase;
import classmeetmodels.Cours;
import classmeetmodels.Message;
import classmeetmodels.SessionCours;
import classmeetmodels.Utilisateur;

public class ProfilDAO implements IProfilDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public ProfilDAO() {
		AppSpringConfigDatabase db = new AppSpringConfigDatabase();
		this.jdbcTemplate = db.createNamedParameterJdbcTemplate();
	}

	public ProfilDAO(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Utilisateur> getListeProfil() {
		String query = "select * from Utilisateur";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query,namedParameters,new UtilisateurMapper());
	}
	@Override
	public Utilisateur getProfilParId(String codeUtilisateur){
		String query = "select * from Utilisateur where codeUtilisateur=:codeUtilisateur";
		SqlParameterSource namedParameters = new MapSqlParameterSource("codeUtilisateur",
				codeUtilisateur);
		return this.jdbcTemplate.queryForObject(query,namedParameters,new UtilisateurMapper());
	}

	@Override
	public List<Cours> getListeCoursParProfil(String codeUtilisateur) {
		String query = "select Cours.sigle, Cours.titre, GroupeCours.session, GroupeCours.annee from EtudiantGroupeCours,GroupeCours,Cours where GroupeCours.noGroupeCours = EtudiantGroupeCours.noGroupeCours and Cours.sigle = EtudiantGroupeCours.sigle and EtudiantGroupeCours.codePermanent = "+codeUtilisateur;
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query,namedParameters,new CoursMapper());
	}
	
	@Override
	public int addProfil(Utilisateur nouvUtilisateur){
		String query = "insert into Utilisateur values("+
				"'"+nouvUtilisateur.getCodeUtilisateur()+"',"+
				"'"+nouvUtilisateur.getMotDePasse()+"',"+
				"'"+nouvUtilisateur.getPrenom()+"',"+
				"'"+nouvUtilisateur.getNom()+"',"+
				"'"+nouvUtilisateur.getCourriel()+"'"+
				")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query,namedParameters);
	}

	/*
	 * @Override public List<Message> getListeMessageParProfil(String
	 * codeUtilisateur) { String query =
	 * "select * from Message where Message.codeUtilisateur = codeUtilisateur";
	 * return this.jdbcTemplate.query(query, new MessageMapper()); }
	 */
	public static final class UtilisateurMapper implements RowMapper<Utilisateur> {

		@Override
		public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {

			Utilisateur utilisateur = new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));

			return utilisateur;
		}
	}

	public static final class CoursMapper implements RowMapper<Cours> {

		@Override
		public Cours mapRow(ResultSet rs, int rowNum) throws SQLException {

			Cours unCours = new Cours(rs.getString(1), rs.getString(2), SessionCours.valueOf(rs.getString(3)),
					rs.getInt(4));

			return unCours;
		}
	}

	/*
	 * public static final class MessageMapper implements RowMapper<Message> {
	 * 
	 * @Override public Message mapRow(ResultSet rs, int rowNum) throws
	 * SQLException {
	 * 
	 * Message unMessage = new Message(rs.getInt(1), rs.getString(2),
	 * rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	 * 
	 * return unMessage; } }
	 */
}
