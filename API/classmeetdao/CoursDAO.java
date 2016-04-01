package classmeetdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import apps.config.AppSpringConfigDatabase;
import classmeetmodels.Cours;
import classmeetmodels.Equipe;
import classmeetmodels.GroupeCours;
import classmeetmodels.SessionCours;

public class CoursDAO implements ICoursDAO{
	
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
		String query = "insert into Cours values(" + "'" + nouvCours.getSigle() + "','"+ 
				nouvCours.getTitre() + "'" + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public Cours getCoursParSigle(String sigleCours) {
		String query = "select * from Cours where sigle='"+sigleCours+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.queryForObject(query, namedParameters, new CoursMapper());
	}

	@Override
	public List<GroupeCours> getListeGroupesParCours(String sigleCours) {
		String query = "select * from GroupeCours where sigle='"+sigleCours+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new GroupeCoursMapper());
	}

	@Override
	public int addGroupeParCours(GroupeCours nouvGroupeCours, String sigleCours) {
		String query = "insert into GroupeCours values(" + "'" + nouvGroupeCours.getNoGroupeCours() + "',"
				+ "'" + nouvGroupeCours.getSession() + "'," + "'"
				+ nouvGroupeCours.getAnnee() + "'," + "'" + nouvGroupeCours.getCodeEnseignant() + "'," 
				+ "'" + sigleCours + "'" + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
	}

	@Override
	public GroupeCours getGroupeParNumero(String sigleCours, String noGroupe) {
		String query = "select * from GroupeCours where sigle='"+sigleCours+"' and noGroupeCours='"+noGroupe+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.queryForObject(query, namedParameters, new GroupeCoursMapper());
	}

	@Override
	public List<Equipe> getListeEquipesParGroupeCours(String sigleCours, int noGroupe) {
		String query = "select * from Equipe where sigle='"+sigleCours+"' and noGroupeCours='"+noGroupe+"'";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.query(query, namedParameters, new EquipeMapper());
	}

	@Override
	public int addEquipeParGroupeCours(Equipe nouvEquipe, String sigleCours, int noGroupe) {
		String query = "insert into Equipe values(" + "'" + nouvEquipe.getNoEquipe() + "',"
				+ "'" + nouvEquipe.getNomEquipe() + "'," + "'"
				+ nouvEquipe.getChefEquipe() + "'," + "'" + sigleCours + "'," 
				+ "'" + noGroupe + "'" + ")";
		SqlParameterSource namedParameters = null;
		return this.jdbcTemplate.update(query, namedParameters);
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

			GroupeCours unGroupeCours = new GroupeCours(rs.getInt(1),SessionCours.valueOf(rs.getString(2)),
					rs.getInt(3),rs.getString(4));

			return unGroupeCours;
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
