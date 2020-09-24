package br.com.car.rent.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOFactory {
	
	private static final String URL  = "jdbc:mysql://localhost:3306/carrent_db?useTimezone=true&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "senh@";
	
	private static JdbcTemplate INSTANCE;
	
	public static JdbcTemplate getConnection() throws SQLException {
		return INSTANCE == null ? new JdbcTemplate(getDataSource()) : INSTANCE;
	}
	
	@SuppressWarnings("rawtypes")
	public static DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(URL);
        dataSourceBuilder.username(USERNAME);
        dataSourceBuilder.password(PASSWORD);
        return dataSourceBuilder.build();
	}
}