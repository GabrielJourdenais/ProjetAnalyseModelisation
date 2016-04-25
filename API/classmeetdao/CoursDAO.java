package classmeetdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import apps.config.AppSpringConfigDatabase;
import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.Evenement;
import classmeetmodels.GroupeCours;
import classmeetmodels.SessionCours;
import classmeetmodels.Utilisateur;

public class CoursDAO implements ICoursDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public CoursDAO() {
		AppSpringConfigDatabase db = new AppSpringConfigDatabase();
		this.jdbcTemplate = db.createNamedParameterJdbcTemplate();
	}

	public CoursDAO(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Cours> getListeCours() {
		String query = "select * from Cours";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new CoursMapper());
	}

	@Override
	public int addCours(Cours nouvCours) {
		String query = "insert into Cours values(" + "'" + nouvCours.getSigle() + "','" + nouvCours.getTitre() + "'"
				+ ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public Cours getCoursParSigle(String sigleCours) {
		String query = "select * from Cours where sigle='" + sigleCours + "'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.queryForObject(query, namedParameters, new CoursMapper());
	}

	@Override
	public List<GroupeCours> getListeGroupesParCours(String sigleCours) {
		String query = "select * from GroupeCours where sigle='" + sigleCours + "'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new GroupeCoursMapper());
	}

	@Override
	public int addGroupeParCours(GroupeCours nouvGroupeCours, String sigleCours) {
		String query = "insert into GroupeCours values(" + nouvGroupeCours.getNoGroupeCours() + "," + "'"
				+ nouvGroupeCours.getSession() + "'," + "'" + nouvGroupeCours.getAnnee() + "'," + "'"
				+ nouvGroupeCours.getCodeEnseignant() + "'," + "'" + sigleCours + "'" + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public GroupeCours getGroupeParNumero(String sigleCours, int noGroupe) {
		String query = "select * from GroupeCours where sigle='" + sigleCours + "' and noGroupeCours=" + noGroupe;
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.queryForObject(query, namedParameters, new GroupeCoursMapper());
	}
	
	@Override
	public List<Utilisateur> getListeMembresParGroupeCours(String sigleCours, int noGroupe) {
		String query = "select Utilisateur.codeUtilisateur,Utilisateur.motDePasse,Utilisateur.prenom,"
		+"Utilisateur.nom,Utilisateur.courriel,Utilisateur.typeUtilisateur from Utilisateur,UtilisateurGroupeCours"
				+" where UtilisateurGroupeCours.sigle='" 
				+ sigleCours + "' and UtilisateurGroupeCours.noGroupeCours=" + noGroupe +
				" and Utilisateur.codeUtilisateur = UtilisateurGroupeCours.codePermanent";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new UtilisateurMapper());
	}

	@Override
	public List<Equipe> getListeEquipesParGroupeCours(String sigleCours, int noGroupe) {
		String query = "select * from Equipe where sigle='" + sigleCours + "' and noGroupeCours=" + noGroupe ;
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new EquipeMapper());
	}
	
	@Override
	public int addEquipeParGroupeCours(Equipe nouvEquipe, String sigleCours, int noGroupe) {
		String query = "insert into Equipe values(" + nouvEquipe.getNoEquipe() + "," + "'"
				+ nouvEquipe.getNomEquipe() + "'," + "'" + nouvEquipe.getChefEquipe() + "'," + "'" + sigleCours + "',"
				+  noGroupe  + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public Equipe getEquipeParNoEquipe(String sigleCours, int noGroupe, int noEquipe){
		String query = "select * from Equipe where sigle='" + sigleCours + "' and noGroupeCours=" + noGroupe
				+ " and noEquipe = " + noEquipe;
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.queryForObject(query, namedParameters, new EquipeMapper());
	}
	
	@Override
	public List<Utilisateur> getListeRequetesMembreParEquipe(String sigleCours, int noGroupe, int noEquipe) {
		String query = "select Utilisateur.codeUtilisateur,Utilisateur.motDePasse,Utilisateur.prenom,"
				+"Utilisateur.nom,Utilisateur.courriel,Utilisateur.typeUtilisateur from Utilisateur,RequeteMembreEquipe "
						+" where RequeteMembreEquipe.sigle='" 
						+ sigleCours + "' and RequeteMembreEquipe.noGroupeCours=" + noGroupe
						+ " and RequeteMembreEquipe.noEquipe=" + noEquipe +
						" and Utilisateur.codeUtilisateur = RequeteMembreEquipe.codePermanent";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new UtilisateurMapper());
	}

	@Override
	public int addRequetesMembreParEquipe(Utilisateur requeteMembre, String sigleCours, int noGroupe, int noEquipe) {
		String query = "insert into RequeteMembreEquipe values(" + "'" + sigleCours + "'," + noGroupe + "," 
				+ noEquipe + ",'" + requeteMembre.getCodeUtilisateur() + "')";

		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public int removeRequetesMembreParEquipe(String sigleCours, int noGroupe, int noEquipe, String codeUtilisateur) {
		String query = "delete from RequeteMembreEquipe where codePermanent='"+codeUtilisateur+"'";

		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}
	
	@Override
	public List<Utilisateur> getListeMembresParEquipe(String sigleCours, int noGroupe,int noEquipe) {
		String query = "select Utilisateur.codeUtilisateur,Utilisateur.motDePasse,Utilisateur.prenom,"
				+"Utilisateur.nom,Utilisateur.courriel,Utilisateur.typeUtilisateur from Utilisateur,EtudiantEquipe "
						+" where EtudiantEquipe.sigle='" 
						+ sigleCours + "' and EtudiantEquipe.noGroupeCours=" + noGroupe
						+ " and EtudiantEquipe.noEquipe=" + noEquipe +
						" and Utilisateur.codeUtilisateur = EtudiantEquipe.codePermanent";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new UtilisateurMapper());
	}
	
	@Override
	public List<Evenement> getListeEvenementParEquipe(String sigleCours, int noGroupe, int noEquipe) {
		String query = "select * from Evenement"
				+" where sigle='" + sigleCours + "' and noGroupeCours=" + noGroupe
						+ " and noEquipe=" + noEquipe;
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters,new EvenementMapper());
	}
	
	@Override
	public int addEvenementParEquipe(Evenement nouvEvenement, String sigleCours, int noGroupe, int noEquipe) {
		String query = "insert into Evenement values(" + "'" + sigleCours + "'," + noGroupe + "," 
				+ noEquipe + ",'" + nouvEvenement.getNom() + "'," + "'" + nouvEvenement.getDescription() + "','"
				+ nouvEvenement.getDateHeureEvenement() + "'," + nouvEvenement.getDureeM() + ",'" + nouvEvenement.getLieu() + "'" + ")";

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
	
	public static final class CoursMapper implements RowMapper<Cours> {

		@Override
		public Cours mapRow(ResultSet rs, int rowNum) throws SQLException {

			Cours unCours = new Cours(rs.getString(1), rs.getString(2));

			return unCours;
		}
	}

	public static final class GroupeCoursMapper implements RowMapper<GroupeCours> {

		@Override
		public GroupeCours mapRow(ResultSet rs, int rowNum) throws SQLException {

			GroupeCours unGroupeCours = new GroupeCours(rs.getInt(1), SessionCours.valueOf(rs.getString(2)),
					rs.getInt(3), rs.getString(4));

			return unGroupeCours;
		}
	}

	public static final class EquipeMapper implements RowMapper<Equipe> {

		@Override
		public Equipe mapRow(ResultSet rs, int rowNum) throws SQLException {

			Equipe uneEquipe = new Equipe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5));

			return uneEquipe;
		}
	}
	
	public static final class EvenementMapper implements RowMapper<Evenement> {

		@Override
		public Evenement mapRow(ResultSet rs, int rowNum) throws SQLException {

			Evenement unEvenement=new Evenement();
				unEvenement = new Evenement(rs.getString(4),
						rs.getString(5),rs.getTimestamp(6),rs.getInt(7),rs.getString(8));

			return unEvenement;
		}
	}

	
}
