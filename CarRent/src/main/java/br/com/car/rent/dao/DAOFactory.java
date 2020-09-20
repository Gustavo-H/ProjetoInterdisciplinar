package br.com.car.rent.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOFactory {
	
	private static final String url  = "jdbc:h2:file:~/test";
	private static final String username = "carrentU";
	private static final String password = "senh@";
	
	private static JdbcTemplate INSTANCE;
	
	public static JdbcTemplate getConnection() throws SQLException {
		return INSTANCE == null ? new JdbcTemplate(getDataSource()) : INSTANCE;
	}
	
	@SuppressWarnings("rawtypes")
	public static DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
	}
}