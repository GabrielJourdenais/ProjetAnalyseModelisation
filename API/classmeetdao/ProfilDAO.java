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
import classmeetmodels.CoursTemp;
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
		return this.jdbcTemplate.query(query, namedParameters, new UtilisateurMapper());
	}

	@Override
	public Utilisateur getProfilParId(String codeUtilisateur) {
		String query = "select * from Utilisateur where codeUtilisateur=:codeUtilisateur";
		SqlParameterSource namedParameters = new MapSqlParameterSource("codeUtilisateur", codeUtilisateur);
		return this.jdbcTemplate.queryForObject(query, namedParameters, new UtilisateurMapper());
	}

	@Override
	public List<CoursTemp> getListeCoursParProfil(String codeUtilisateur) {
		String query = "select Cours.sigle, Cours.titre, GroupeCours.session,"
				+ " GroupeCours.annee, GroupeCours.noGroupeCours, GroupeCours.enseignant"
				+ " from UtilisateurGroupeCours,GroupeCours,Cours"
				+ " where GroupeCours.noGroupeCours = UtilisateurGroupeCours.noGroupeCours"
				+ " and Cours.sigle = UtilisateurGroupeCours.sigle" + " and UtilisateurGroupeCours.codePermanent = '"
				+ codeUtilisateur +"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new CoursMapper());
	}

	@Override
	public int addProfil(Utilisateur nouvUtilisateur) {
		String query = "insert into Utilisateur values(" + "'" + nouvUtilisateur.getCodeUtilisateur() + "'," + "'"
				+ nouvUtilisateur.getMotDePasse() + "'," + "'" + nouvUtilisateur.getPrenom() + "'," + "'"
				+ nouvUtilisateur.getNom() + "'," + "'" + nouvUtilisateur.getCourriel() + "'," + "'" + nouvUtilisateur.getTypeUtilisateur() + "'" + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public int addCours(Cours nouvCours, String codeUtilisateur) {
		String queryCours = "insert into Cours values(" + "'" + nouvCours.getSigle() + "'," + "'" + nouvCours.getTitre()
				+ "'" + ")";

		String queryGroupeCours = "insert into GroupeCours values(" + nouvCours.getNoGroupeCours() + "," + "'"
				+ nouvCours.getSession() + "'," + nouvCours.getAnnee() + "," + "'" + nouvCours.getCodeEnseignant()
				+ "'," + "'" + nouvCours.getSigle() + "'" + ")";

		String queryUtilisateurGroupeCours = "insert into UtilisateurGroupeCours values(" + "'" + codeUtilisateur + "',"
				+ nouvCours.getNoGroupeCours() + "," + "'" + nouvCours.getSigle() + "'" + ")";

		String transaction = "begin;" + queryCours + ";" + queryGroupeCours + ";" + queryUtilisateurGroupeCours + "; commit";
		
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(transaction, namedParameters);
	}

	@Override
	public List<Message> getListeMessageParProfil(String codeUtilisateur) {
		String query = "select * from Message where Message.codeUtilisateur = codeUtilisateur";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new MessageMapper());
	}

	@Override
	public int updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur) {
		String query = "update Utilisateur " + "set motDePasse = '" + nouvUtilisateur.getMotDePasse() + "',"
				+ " courriel = '" + nouvUtilisateur.getCourriel() + "'" + " where codeUtilisateur = '" + codeUtilisateur
				+ "'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	public static final class UtilisateurMapper implements RowMapper<Utilisateur> {

		@Override
		public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {

			Utilisateur utilisateur = new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6));

			return utilisateur;
		}
	}

	public static final class CoursMapper implements RowMapper<CoursTemp> {

		@Override
		public CoursTemp mapRow(ResultSet rs, int rowNum) throws SQLException {

			CoursTemp unCours = new CoursTemp(rs.getString(1), rs.getString(2), ""/*SessionCours.AvalueOf(rs.getString(3))*/,
					rs.getInt(4), rs.getInt(5), rs.getString(6));

			return unCours;
		}
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
