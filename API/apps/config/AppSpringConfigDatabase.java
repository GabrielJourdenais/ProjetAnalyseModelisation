package apps.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiTemplate;

import apps.AppConstants;

public class AppSpringConfigDatabase {

	@Bean(destroyMethod = "")
	public DataSource createDataSource() {
		DataSource dataSource = null;
		try {
			JndiTemplate jndiTemplate = new JndiTemplate();
			dataSource = (DataSource) jndiTemplate
					.lookup(AppConstants.JNDI_NAME_JDBC_BD);

		} catch (Exception ex) {
		}
		return dataSource;
	}

	@Bean
	public NamedParameterJdbcTemplate createNamedParameterJdbcTemplate() {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				createDataSource());
		return namedParameterJdbcTemplate;
	}
}
