package classmeetdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import apps.config.AppSpringConfigDatabase;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCoursUtilisateur;
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
	public int addProfil(Utilisateur nouvUtilisateur) {
		String query = "insert into Utilisateur values(" + "'" + nouvUtilisateur.getCodeUtilisateur() + "'," + "'"
				+ nouvUtilisateur.getMotDePasse() + "'," + "'" + nouvUtilisateur.getPrenom() + "'," + "'"
				+ nouvUtilisateur.getNom() + "'," + "'" + nouvUtilisateur.getCourriel() + "'," + "'" + nouvUtilisateur.getTypeUtilisateur() + "'" + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public Utilisateur getProfilParId(String codeUtilisateur) {
		String query = "select * from Utilisateur where codeUtilisateur=:codeUtilisateur";
		SqlParameterSource namedParameters = new MapSqlParameterSource("codeUtilisateur", codeUtilisateur);
		return this.jdbcTemplate.queryForObject(query, namedParameters, new UtilisateurMapper());
	}
	
	@Override
	public int updateProfil(Utilisateur nouvUtilisateur, String codeUtilisateur) {
		String query = "update Utilisateur " + "set nom = '" + nouvUtilisateur.getNom() + "',"
				+ " prenom = '" + nouvUtilisateur.getPrenom() + "',"
				+ " courriel = '" + nouvUtilisateur.getCourriel() + "'" + " where codeUtilisateur = '" + codeUtilisateur
				+ "'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}
	
	@Override
	public List<GroupeCoursUtilisateur> getListeGroupeCoursParProfil(String codeUtilisateur) {
		String query = "select Cours.sigle,Cours.titre,GroupeCours.noGroupeCours, GroupeCours.session,"
				+ " GroupeCours.annee,  GroupeCours.enseignant"
				+ " from UtilisateurGroupeCours,GroupeCours,Cours"
				+ " where GroupeCours.sigle = Cours.sigle"
				+ " and GroupeCours.noGroupeCours = UtilisateurGroupeCours.noGroupeCours"
				+ " and GroupeCours.sigle = UtilisateurGroupeCours.sigle"
				+ " and UtilisateurGroupeCours.codePermanent = '"+ codeUtilisateur +"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new GroupeCoursUtilisateurMapper());
	}
	
	@Override
	public int addGroupeCoursParProfil(GroupeCoursUtilisateur nouvGroupeCours,String codeUtilisateur) {
		String query = "insert into UtilisateurGroupeCours values(" + "'" + codeUtilisateur + "',"
				+ nouvGroupeCours.getNoGroupeCours() + "," + "'" + nouvGroupeCours.getSigle() + "'" + ")";
		
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public List<Equipe> getListeEquipesParProfil(String codeUtilisateur) {
		String query = "select Equipe.noEquipe,Equipe.nomEquipe,Equipe.chefEquipe,Equipe.sigle,Equipe.noGroupeCours "
				+ "from Equipe,EtudiantEquipe where Equipe.sigle = EtudiantEquipe.sigle"
				+ " and Equipe.noGroupeCours = EtudiantEquipe.noGroupeCours"
				+ " and Equipe.noEquipe = EtudiantEquipe.noEquipe"
				+ " and EtudiantEquipe.codePermanent = '"+codeUtilisateur+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new EquipeMapper());
	}

	@Override
	public int addEquipeParProfil(Equipe nouvEquipe, String codeUtilisateur) {
		String query = "insert into EtudiantEquipe values(" + "'" + nouvEquipe.getSigleCours() + "',"
				+ nouvEquipe.getNoGroupeCours() + "," + nouvEquipe.getNoEquipe() +  "," +
				"'"+codeUtilisateur+"'"+
				")";
		
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public Equipe getEquipeParSigle(String codeUtilisateur, String sigleCours) {
		String query = "select Equipe.noEquipe,Equipe.nomEquipe,Equipe.chefEquipe,Equipe.sigle,Equipe.noGroupeCours "
				+ "from Equipe,EtudiantEquipe where Equipe.sigle = EtudiantEquipe.sigle"
				+ " and Equipe.noGroupeCours = EtudiantEquipe.noGroupeCours"
				+ " and Equipe.noEquipe = EtudiantEquipe.noEquipe"
				+ " and EtudiantEquipe.codePermanent = '"+codeUtilisateur+"'"
				+ " and EtudiantEquipe.sigle = '"+sigleCours+"'"
				;
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.queryForObject(query, namedParameters, new EquipeMapper());
	}
	
	@Override
	public List<Message> getListeMessagesParProfil(String codeUtilisateur) {
		String query = "select * from Message where a = '"+codeUtilisateur+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new MessageMapper());
	}
	
	@Override
	public List<Message> getListeMessagesEnvoyesParProfil(String codeUtilisateur) {
		String query = "select * from Message where de = '"+codeUtilisateur+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new MessageMapper());
	}

	@Override
	public int addMessageParProfil(Message nouvMessage, String codeUtilisateur) {
		String query = "insert into Message values(" + null + ","+
				"'" + codeUtilisateur + "'," +
				"'" + nouvMessage.getA()+ "'," +
				"'" + nouvMessage.getObjet()+ "'," +
				"'" + nouvMessage.getTexte() + "'," + 
				"now()" + ")";
		
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}
	
	@Override
	public int supprimerMessage(String codeUtilisateur,int idMessage) {
		String query = "delete from Message where idMessage="+idMessage;
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
	

	public static final class GroupeCoursUtilisateurMapper implements RowMapper<GroupeCoursUtilisateur> {

		@Override
		public GroupeCoursUtilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {

			GroupeCoursUtilisateur unGroupeCours = new GroupeCoursUtilisateur(rs.getString(1),rs.getString(2),rs.getInt(3),
					SessionCours.valueOf(rs.getString(4)),rs.getInt(5),rs.getString(6));

			return unGroupeCours;
		}
	}

	public static final class MessageMapper implements RowMapper<Message> {

		@Override
		public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

			Message unMessage = new Message(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),
					rs.getString(5),rs.getString(6));

			return unMessage;
		}
	}

	public static final class EquipeMapper implements RowMapper<Equipe> {

		@Override
		public Equipe mapRow(ResultSet rs, int rowNum) throws SQLException {

			Equipe uneEquipe = new Equipe(rs.getInt(1),rs.getString(2),
					rs.getString(3),rs.getString(4),rs.getInt(5));

			return uneEquipe;
		}
	}

}
